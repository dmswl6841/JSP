package com.jay.prj.dept;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeptInsertServ
 */
@WebServlet("/DeptInsert")
public class DeptInsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//등록 페이지 (이동)요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("dept", new DeptDAO().selectDept());
		
		request.getRequestDispatcher("/WEB-INF/jsp/Dept/deptInsert.jsp").forward(request,response);
		
	}
	
	//DB등록 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); 	//jps 맨 위의 ContextType 복붙
		request.setCharacterEncoding("UTF-8");
		//파라미터를 vo 담고
		String id = request.getParameter("departmentId");
		String name = request.getParameter("departmentName");
		
		DeptVO vo = new DeptVO();
		vo.setDepartmentId(id);
		vo.setDepartmentName(name); 
		//DB처리
		DeptDAO dao = new DeptDAO();
		int cnt = dao.deptInsert(vo);
		//결과 출력
		response.getWriter()
		.append(cnt+"건이 등록됨");
	}

}
