package com.jay.prj.member.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jay.prj.common.DataSource;
import com.jay.prj.member.service.MemberService;
import com.jay.prj.member.vo.MemberVO;

public class MemberSerivceImpl implements MemberService {

	private DataSource dao = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<MemberVO> memberSelectList() {
		List<MemberVO> list = new ArrayList<MemberVO>(); // 결과를 담을 객체
		MemberVO vo;
		String sql = "select * from member";
		
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				vo = new MemberVO();
				vo.setMemberID(rs.getString("member_id"));
				vo.setMemberPassword(rs.getString("member_password"));
				vo.setMemberName(rs.getString("member_name"));
				vo.setMemberAuthor(rs.getString("member_author"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}

	
	@Override
	public MemberVO memberSelectOne(MemberVO vo) {
		String sql = "SELECT * FROM MEMBER WHRER MEMBER_ID =?";
		
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberID());
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new MemberVO();
				vo.setMemberID(rs.getString("member_id"));
				vo.setMemberPassword(rs.getString("member_password"));
				vo.setMemberName(rs.getString("member_name"));
				vo.setMemberAuthor(rs.getString("member_author"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return vo;
	}


	@Override
	public int memberInsert(MemberVO vo) {
		int cnt = 0;
		String sql = "insert into member (member_id, member_password, member_name, member_author)"
				+(" values (?,?,?,?)");
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberID());
			psmt.setString(2, vo.getMemberPassword());
			psmt.setString(3, vo.getMemberName());
			psmt.setString(4, vo.getMemberAuthor());
			
			cnt = psmt.executeUpdate();
			
			if(rs.next()) {
				vo = new MemberVO();
				vo.setMemberID(rs.getString("member_id"));
				vo.setMemberPassword(rs.getString("member_password"));
				vo.setMemberName(rs.getString("member_name"));
				vo.setMemberAuthor(rs.getString("member_author"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		int cnt = 0;
		String sql = "update member set (member_id, member_password, member_name, member_author)"
				+(" values (?,?,?,?)");
		
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberID());
			psmt.setString(2, vo.getMemberPassword());
			psmt.setString(3, vo.getMemberName());
			psmt.setString(4, vo.getMemberAuthor());
			cnt = psmt.executeUpdate();
			
			if(rs.next()) {
				vo = new MemberVO();
				vo.setMemberID(rs.getString("member_id"));
				vo.setMemberPassword(rs.getString("member_password"));
				vo.setMemberName(rs.getString("member_name"));
				vo.setMemberAuthor(rs.getString("member_author"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		int cnt = 0;
		String sql = "delete from member where member_id =?";
		
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberID());
			cnt = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;
	}

	@Override
	public boolean isMemberIdCheck(String id) {
		boolean b = false;
		
		String sql = "select member_id from member where member_id=?";
		
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			if(!rs.next()) {
				b =true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return b;
	}

	@Override
	public MemberVO memberLogin(MemberVO vo) {
		String sql = "select * from member where member_id=? and member_password =?";
		
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberID());
			psmt.setString(2, vo.getMemberPassword());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setMemberID(rs.getString("member_id"));
				vo.setMemberPassword(rs.getString("member_password"));
				vo.setMemberAuthor(rs.getString("member_author"));
				vo.setMemberName(rs.getString("member_name"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}

	@Override
	public boolean isMemberPasswordCheck(String password) {
		// TODO Auto-generated method stub
		return false;
	}

	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt !=null) psmt.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
}
