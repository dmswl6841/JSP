package com.jay.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jay.prj.common.Command;

public class MemberLogout implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//로그아웃
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("name");	//세션 객체에 담아둔 name값을 가져옴
		request.setAttribute("message", name+"님, 정상적으로 로그아웃 되었습니다.");
		session.invalidate(); //invalidate 보관하고 있던 세션을 완전히 삭제
		return "member/memberLogout";
	}
}
