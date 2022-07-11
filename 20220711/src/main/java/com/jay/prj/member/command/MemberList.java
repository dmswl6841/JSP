package com.jay.prj.member.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jay.prj.common.Command;
import com.jay.prj.member.service.MemberService;
import com.jay.prj.member.serviceImpl.MemberSerivceImpl;
import com.jay.prj.member.vo.MemberVO;

public class MemberList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//회원목록 보기
		MemberService memberDAO = new MemberSerivceImpl();
		List<MemberVO> list = new ArrayList<MemberVO>();
		list = memberDAO.memberSelectList();
		request.setAttribute("list", list);
		
		return "member/memberList";
	}

}
