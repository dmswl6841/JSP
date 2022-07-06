package com.jay.prj.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmpDelete")
public class EmpDeleteServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		//파라미터
		String empId=request.getParameter("employeeId");
		//dao -> delete 메소드
		EmpDAO dao = new EmpDAO();
		int r = dao.empDelete(empId);
		
		response.getWriter()
			.append("<script>")
			.append("alert("+r+"'건이 삭제되었습니다.')")
			.append("location.href='EmpServlet';")
			.append("</script>")
			.append("")
			.append(r+"건이 삭제되었습니다.");
		//request.setAttribute("msg", r+"건이 삭제되었습니다.");
		//request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}
}
