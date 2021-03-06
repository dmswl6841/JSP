package com.jay.prj.dept;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeptUpdate")
public class DeptUpdateServ extends HttpServlet { 
	private static final long serialVersionUID = 1L;
	//수정 페이지 (이동)요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터
		String departmentId = request.getParameter("departmentId");
		//부서번호로 단건 조회
		DeptDAO dao = new DeptDAO();
		request.setAttribute("dept", new DeptDAO().selectOne(departmentId));
		
		request.getRequestDispatcher("/WEB-INF/jsp/Dept/deptUpdate.jsp").forward(request,response);
		
	}
	
	//DB 수정 처리
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
		int cnt = dao.deptUpdate(vo);
		//결과 출력
		response.getWriter()
		.append(cnt+"건이 등록되었습니다.");
	}

}
