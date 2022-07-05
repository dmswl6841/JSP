package com.jay.prj.dept;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeptList")
public class DeptListServ extends HttpServlet {
	private static final long serialVersionUID = 1L; 
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
//		PrintWriter out = response.getWriter();
		
		DeptDAO dao = new DeptDAO();
		
		request.setAttribute("list", dao.selectDept());
		request.getRequestDispatcher("/WEB-INF/jsp/Dept/deptList.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
