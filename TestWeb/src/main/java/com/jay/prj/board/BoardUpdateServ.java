package com.jay.prj.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BoardUpdate")
public class BoardUpdateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//수정페이지 요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터
		String id = request.getParameter("id");
		
		BoardDAO dao = new BoardDAO();
		request.setAttribute("board", dao.selectOne(id));
		request.getRequestDispatcher("/WEB-INF/jsp/board/boardInsert.jsp").forward(request, response);
	}

	//DB 수정 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); 	//jps 맨 위의 ContextType 복붙
		request.setCharacterEncoding("UTF-8");
		//파라미터를 vo 담고
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		String rDate = request.getParameter("rdt");
		String hit = request.getParameter("hit");
		
		BoardVO vo = new BoardVO();
		vo.setId(id);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		vo.setrDate(rDate);
		vo.setHit(hit);
		
		//DB 처리
		BoardDAO dao = new BoardDAO();
		int cnt = dao.boardUpdate(vo);
		//결과 출력
		response.getWriter().append(cnt+"건이 수정되었습니다.");
		
	}

}
