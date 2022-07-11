package com.jay.prj.member.command;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

public class MemberLoginForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//로그인 폼 호출
		return "member/memberLoginForm";
	}
}
