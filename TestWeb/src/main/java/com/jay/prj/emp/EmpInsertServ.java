package com.jay.prj.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jay.prj.dept.DeptDAO;


@WebServlet("/EmpInsert")
public class EmpInsertServ extends HttpServlet{

	//등록페이지로 이동
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DB조회
		//jobs,부서, 사원
		request.setAttribute("jobs", new EmpDAO().selectJobs());
		request.setAttribute("dept", new DeptDAO().selectDept());
		
		request.getRequestDispatcher("/WEB-INF/jsp/emp/empInsert.jsp").forward(request, response);
	}	
	
	//등록처리
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		//파라미터를 vo 담고
		String id = request.getParameter("employeeId");
		String name = request.getParameter("lastName");
		String email = request.getParameter("email");
		String hireDate = request.getParameter("hireDate");
		String jonId = request.getParameter("jobId");
		String deptId = request.getParameter("departmentId");
		
		EmpVO vo = new EmpVO();
		vo.setEmployeeId(id);
		vo.setLastName(name);
		vo.setEmail(email);
		vo.setHireDate(hireDate);
		vo.setJobId(jonId);
		vo.setDepartmentId(deptId);
		
		//DB처리
		EmpDAO dao = new EmpDAO();
		int cnt = dao.empInsert(vo);
		//결과 출력
		response.getWriter().append(cnt+"건이 등록됨");
	}
}
