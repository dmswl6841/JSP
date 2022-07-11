package com.jay.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jay.prj.MainCommand;
import com.jay.prj.commom.Command;
import com.jay.prj.member.command.AjaxMemberIdCheck;
import com.jay.prj.member.command.MemberJoin;
import com.jay.prj.member.command.MemberJoinForm;
import com.jay.prj.member.command.MemberList;
import com.jay.prj.member.command.MemberLogin;
import com.jay.prj.member.command.MemberLoginForm;
import com.jay.prj.member.command.MemberLogout;

@WebServlet("/*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<>();

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		// 요청과 수행할 command연결 (초기 맵이 들어가는 부분)
		map.put("/main.do", new MainCommand()); // 처름 접근하는 곳
		map.put("/memberLoginForm.do", new MemberLoginForm());	//로그인 폼 호출
		map.put("/memberLogin.do", new MemberLogin()); //로그인
		map.put("/memberLogoutForm.do", new MemberLogout()); //로그아웃
		map.put("/memberList.do", new MemberList());
		map.put("/memberJoinForm.do", new MemberJoinForm()); //회원가입
		map.put("/ajaxMemberIdCheck.do", new AjaxMemberIdCheck()); //ajax를 이용한
		map.put("/memberJoin", new MemberJoin());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청을 분석, 실행하고 결과를 돌려줌
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());

		Command command = map.get(page);
		String viewPage = command.exec(request, response);

		if (!viewPage.endsWith(".do")) {
			if (viewPage.startsWith("ajax:")) {
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}
			viewPage = viewPage+".tiles";	//tiles를 이용한 composition view pattern 사용 시
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);	//원하는 페이지를 호출에서 전달함
		}else {
			response.sendRedirect(viewPage); // .do로 권한 위임 처리
	
		}
	}
}
