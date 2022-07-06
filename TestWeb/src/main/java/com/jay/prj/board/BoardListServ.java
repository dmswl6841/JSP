package com.jay.prj.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardListServ
 */
@WebServlet("/BoardList")
public class BoardListServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		BoardDAO dao = new BoardDAO();
		
		request.setAttribute("list", dao.boardSelectAll());
		request.getRequestDispatcher("/WEB-INF/jsp/board/boardList.jsp").forward(request, response);
	}
}