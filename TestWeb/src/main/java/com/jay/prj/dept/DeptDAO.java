package com.jay.prj.dept;

import java.util.ArrayList;

import com.jay.prj.common.DAO;

public class DeptDAO extends DAO{

	//조회
	public ArrayList<DeptVO> selectDept(){
		ArrayList<DeptVO> list = new ArrayList<DeptVO>(); 
		
		try {
			getConnect();
			
			String sql="select * from departments order by department_id";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				DeptVO vo = new DeptVO();
				vo.setDepartmentId(rs.getString("department_id"));
				vo.setDepartmentName(rs.getString("department_name"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return list;
	}
	
	//단건 조회
	public DeptVO selectOne(String department_id){
		DeptVO vo = new DeptVO();
		
		try {
			getConnect();
			
			String sql="select * from departments where department_id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, department_id);
			rs = psmt.executeQuery();
			
			if(rs.next()) {	//다음 레코드로 이동
				vo.setDepartmentId(rs.getString("department_id"));
				vo.setDepartmentName(rs.getString("department_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return vo;
	}
	
	//등록
	public int deptInsert(DeptVO vo) {
		int cnt = 0;
		
		try {
			getConnect();
			String sql = "insert into departments (?,?)";	//+ ""일때 ""맨 앞에 공백 처리 하지않으면 둘이 붙어서 나옴
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getDepartmentId());
			psmt.setString(2, vo.getDepartmentName());
			cnt = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return cnt;
	}
	
	//수정
	public int update(DeptVO vo) {
		int r= 0;
		try {
			getConnect();
			
			String sql = "update departments set department_id=? where departmentId=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getDepartmentId());
			psmt.setString(2, vo.getDepartmentName());
			r = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return r;
	}
	
	//삭제
	
}
