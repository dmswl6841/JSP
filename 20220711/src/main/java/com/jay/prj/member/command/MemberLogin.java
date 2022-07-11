package com.jay.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jay.prj.common.Command;
import com.jay.prj.member.service.MemberService;
import com.jay.prj.member.serviceImpl.MemberSerivceImpl;
import com.jay.prj.member.vo.MemberVO;

public class MemberLogin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//로그인 처리
		HttpSession session = request.getSession();	//서버가 만들어 놓은 세션을 가져온다.
		MemberService memberDAO = new MemberSerivceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberID(request.getParameter("memberId"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		
		vo = memberDAO.memberLogin(vo);
		System.out.println(vo.getMemberID());
		if(vo.getMemberName() != null) {
			session.setAttribute("id", vo.getMemberID());	//세션에 담는다
			session.setAttribute("author", vo.getMemberAuthor());
			session.setAttribute("name", vo.getMemberName());
			
			request.setAttribute("message", vo.getMemberName()+"님, 로그인 되었습니다."); 	//넘겨줄 페이지에
			
		}else {
			request.setAttribute("message", "ID 또는 패스워드가 일치하지 않습니다."); 
		}
		return "member/memberLogin";
	}
}
