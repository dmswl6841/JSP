package com.jay.prj.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BoardInsert")
public class BoardInsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//등록페이지로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
//		BoardDAO dao = new BoardDAO();
//		BoardVO vo = new BoardVO();
		
//		request.setAttribute("board", dao.boardSelectAll());
		request.getRequestDispatcher("/WEB-INF/jsp/board/boardInsert.jsp").forward(request, response);
	}

	//등록 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		//파라미터를 vo담는다.
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		String rDate = request.getParameter("rdt");
		String hit = request.getParameter("hit");
		
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		vo.setrDate(rDate);
		vo.setHit(hit);
		
		//DB처리 
		BoardDAO dao = new BoardDAO();
		int cnt = dao.boardInsert(vo);
		
		response.getWriter()
//		.append("<script>")
//		.append("alert(")
		.append(cnt+"건이 등록됨");
//		.append("</script>");
		//response.sendRedirect("BoardList");
	}
}
