package com.jay.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jay.prj.common.Command;
import com.jay.prj.member.service.MemberService;
import com.jay.prj.member.serviceImpl.MemberSerivceImpl;

public class AjaxMemberIdCheck implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		MemberService memberDAO = new MemberSerivceImpl();
		String id = request.getParameter("id");
		boolean b = memberDAO.isMemberIdCheck(id);	//true 사용가능
		String result = "Used";
		if(!b) {
			result = "Unused";
		}
		return "ajax:"+result; //결과가 ajax호출이라는걸 view resolve에게 알려주기위해.
	}

}
