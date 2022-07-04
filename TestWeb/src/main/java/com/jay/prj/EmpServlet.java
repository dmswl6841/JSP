package com.jay.prj;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet(urlPatterns = {"/EmpServlet","/EmpSV"})
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
//		out.print("<html><body><table><thead><tr><th>사번</th><th>이름</th><th>급여</th></thead>");
//		out.print("<tbody>");
//		ArrayList<EmpVO> list = new ArrayList<>();
//		list.add(new EmpVO("100", "백청렴", "35000"));
//		list.add(new EmpVO("101", "전서구", "25000"));
//		list.add(new EmpVO("102", "전동구", "28000"));
//		list.add(new EmpVO("103", "은행차", "40000"));
		
		EmpDAO dao = new EmpDAO();
		
		
		request.setAttribute("list", dao.selectAll());
		request.getRequestDispatcher("/WEB-INF/jsp/empList.jsp").forward(request, response);
		
//		for (EmpVO vo : list) {
//			out.print("<tr>");
//			out.printf("<td>%s</td>", vo.getEmployeeId());
//			out.printf("<td>%s</td>", vo.getFirstName());
//			out.printf("<td>%s</td>", vo.getSalary());
//			out.printf("</tr>");
//		}
//		out.print("</tbody></table></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
