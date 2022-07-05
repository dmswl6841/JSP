package com.jay.prj;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Hello2")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		System.err.println("제거되었습니다.");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("생성되었습니다.");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서비스가 실행되었습니다.");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}



	
	
	
}
