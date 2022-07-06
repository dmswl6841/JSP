package com.jay.prj.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class boardDeleteServ
 */
@WebServlet("/boardDelete")
public class boardDeleteServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		//피라미터
		String id = request.getParameter("id");
		
		BoardDAO dao = new BoardDAO();
		int cnt = dao.boardDelete(id);
		
		response.getWriter()
		.append("<script>")
		.append("alert("+cnt+"'건이 삭제되었습니다.')")
		.append("location.href='BoardInsert';")
		.append("</script>");
	}
}
