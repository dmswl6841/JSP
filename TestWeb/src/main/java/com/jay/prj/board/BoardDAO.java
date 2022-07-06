package com.jay.prj.board;

import java.util.ArrayList;

import com.jay.prj.common.DAO;

public class BoardDAO extends DAO{

	//전체조회
	public ArrayList<BoardVO> boardSelectAll(){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
			getConnect();
			
			String sql = "select * from board order by rdt DESC";
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setId(rs.getString("id"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setrDate(rs.getString("rdt"));
				vo.setHit(rs.getString("hit"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			disConnect();
		}
		return list;
	}
	
	//등록
	public int boardInsert(BoardVO vo) {
		int cnt = 0;
		try {
			getConnect();
			
			String sql= "insert into board (id, title, content, writer, rdt, hit)"
					+ " values((select max(id)+1 from board),?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setString(3, vo.getWriter());
			psmt.setString(4, vo.getrDate());
			psmt.setString(5, vo.getHit());
			
			cnt = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return cnt;
	}
	
	//수정
	public int boardUpdate(BoardVO vo) {
		int cnt = 0;
		try {
			getConnect();
			
			String sql= "update set board (title, content, writer, rdt, hit"
					+ " values (?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setString(3, vo.getWriter());
			psmt.setString(4, vo.getrDate());
			psmt.setString(5, vo.getHit());
			
			cnt = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return cnt; 
	}
	
	//삭제
	public int boardDelete(String id) {
		int cnt = 0;
		
		try {
			getConnect();
			
			String sql = "delete * from board where id=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			cnt = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return cnt;
	}
}
