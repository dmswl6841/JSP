package com.jay.prj.emp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.jay.prj.common.DAO;

public class EmpDAO extends DAO {
	// job 전체조회
	public ArrayList<JobsVO> selectJobs() {
		ArrayList<JobsVO> list = new ArrayList<JobsVO>();

		try {
			getConnect();

			String sql = "select * from jobs order by job_id";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				JobsVO vo = new JobsVO();
				vo.setJobId(rs.getString("job_id"));
				vo.setJobTitle(rs.getString("job_title"));
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}

	// 전체조회
	public ArrayList<EmpVO> selectAll(String departmentId) {
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		try {
			// 1. DB연결
			getConnect();

			// 2. SQL구문 준비
			String sql = "select * from employees";
			if (departmentId != null && !departmentId.isEmpty()) {
				sql += " where department_id=? ";
			}
			sql += " order by employee_id";

			PreparedStatement stmt = conn.prepareStatement(sql);
			if (departmentId != null && !departmentId.isEmpty()) {
				stmt.setString(1, departmentId);
			}
			// 실행
			ResultSet rs = stmt.executeQuery();
			// 조회결과 list에 담기
			while (rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEmployeeId(rs.getString("employee_id"));
				vo.setLastName(rs.getString("last_name"));
				vo.setEmail(rs.getString("email"));
				vo.setHireDate(rs.getString("hire_date"));
				vo.setJobId(rs.getString("job_id"));
				vo.setDepartmentId(rs.getString("department_id"));
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4. DB연결 해제
			disConnect();
		}
		return list;
	}

	// 단건 조회
	public EmpVO selectOne(String id) {
		EmpVO vo = new EmpVO();

		try {
			// 1. DB연결
			getConnect();

			// 2. SQL구문 준비
			String sql = "select * from employees where employee_id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			// 실행
			rs = psmt.executeQuery();
			// 조회결과 list에 담기
			if (rs.next()) {
				vo.setEmployeeId(rs.getString("employee_id"));
				vo.setLastName(rs.getString("last_name"));
				vo.setEmail(rs.getString("email"));
				vo.setHireDate(rs.getString("hire_date"));
				vo.setJobId(rs.getString("job_id"));
				vo.setDepartmentId(rs.getString("department_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return vo;
	}

	// 등록
	public int empInsert(EmpVO vo) {
		int cnt = 0;
		try {
			getConnect();

			String sql = "insert into employees (employee_id, last_name, email, hire_date, job_id, department_id)"
					+ " values ((select max(employee_id)+1 from employees),?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, vo.getEmployeeId());
			psmt.setString(1, vo.getLastName());
			psmt.setString(2, vo.getEmail());
			psmt.setString(3, vo.getHireDate());
			psmt.setString(4, vo.getJobId());
			psmt.setString(5, vo.getDepartmentId());

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return cnt;
	}

	// 수정
	public int empUpdate(EmpVO vo) {
		int cnt = 0;
		try {
			getConnect();

			String sql = "update set employees (employee_id, last_name, email, hire_date, job_id, department_id)"
					+ " values (?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getEmployeeId());
			psmt.setString(2, vo.getLastName());
			psmt.setString(3, vo.getEmail());
			psmt.setString(4, vo.getHireDate());
			psmt.setString(5, vo.getJobId());
			psmt.setString(6, vo.getDepartmentId());

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return cnt;
	}
	// 삭제
	public int empDelete(String employeeId) {
		int r= 0;
		
		try {
			getConnect();
			
			String sql = "delete * from employees where employee_id=?";
			psmt= conn.prepareStatement(sql);
			psmt.setString(1,employeeId);
			r = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		
		return r;
	}
}
