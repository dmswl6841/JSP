package com.jay.prj.member.service;

import java.util.List;

import com.jay.prj.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberSelectList();	//멤버 전체조회 R
	MemberVO memberSelectOne(MemberVO vo);	//멤버 단건조회 R
	int memberInsert(MemberVO vo);	//멤버 등록 C
	int memberUpdate(MemberVO vo);	//멤버 수정 U
	int memberDelete(MemberVO vo);	//멤버 삭제 D

	boolean isMemberIdCheck(String id);	//아이디 중복체크 
	MemberVO memberLogin(MemberVO vo);	//로그인 처리 R
	boolean isMemberPasswordCheck(String password);	//비밀번호 재확인

}
