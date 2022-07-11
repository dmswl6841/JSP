package com.jay.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jay.prj.common.Command;
import com.jay.prj.member.service.MemberService;
import com.jay.prj.member.serviceImpl.MemberSerivceImpl;
import com.jay.prj.member.vo.MemberVO;

public class MemberJoin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//회원가입처리
		MemberService memberDAO = new MemberSerivceImpl();
		MemberVO vo  = new MemberVO();
		vo.setMemberID(request.getParameter("memberId"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		vo.setMemberName(request.getParameter("memberName"));
		vo.setMemberAuthor("User");
		int n = memberDAO.memberInsert(vo);
		if(n!=0) {
			request.setAttribute("message", "성공적으로 회원가입이 되었습니다");
		}else {
			request.setAttribute("message", "회원가입에 실패하였습니다");
		}
		
		return "memberList.do";	//가입 후 목록으로 바로 감
	}

}
