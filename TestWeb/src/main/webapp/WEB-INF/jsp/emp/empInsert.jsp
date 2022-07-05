<%@page import="com.jay.prj.dept.DeptVO"%>
<%@page import="com.jay.prj.emp.JobsVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title>사원등록</title>
<script>
	function validateForm() {
		if (window.document.frm.employeeId.value == "") {
			alert("사원번호를 입력하여 주십시오")
			frm.employeeId.focus();
			return false;
		}
		if (window.document.frm.lastName.value == "") {
			alert("이름을 입력하여 주십시오")
			frm.employeeId.focus();
			return false;
		}
		if (window.document.frm.email.value == "") {
			alert("E-mail을 입력하여 주십시오")
			frm.employeeId.focus();
			return false;
		}
		var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		if(regExp.test(frm.email.value) == false){
			alert("잘못된 E-mail 형식입니다.")
			frm.employeeId.focus();
			return false;
		}
		if (window.document.frm.hireDate.value == "") {
			alert("입사일을 입력하여 주십시오")
			frm.employeeId.focus();
			return false;
		}
		if (window.document.frm.jobId.value == "") {
			alert("jobId를 입력하여 주십시오")
			frm.employeeId.focus();
			return false;
		}
		return true;
	}
</script>
<form name="frm" action="EmpInsert" method="post" onsubmit="return validateForm()">
	<body>
		<h3>사원등록</h3>
		사원번호
		<input name="employeeId"><br>
		이름<input name="lastName"><br>
		E-mail<input name="email"><br>
		입사일<input type="date" name="hireDate"><br>
		jobId<select name="jobId">
				<% ArrayList<JobsVO> list = (ArrayList<JobsVO>)request.getAttribute("jobs");
				for(JobsVO vo: list ){%>
			<option value="<%=vo.getJobId()%>"><%=vo.getJobTitle() %>
			<% } %>
		부서등록
			<% ArrayList<DeptVO> list1 = (ArrayList<DeptVO>)request.getAttribute("dept");
			for(DeptVO vo : list1) {%>
			<input type="radio" name="departmentId" value="<%=vo.getDepartmentId()%>"><%=vo.getDepartmentName() %>
			<% } %><br>
			</select>
		<button>사원등록</button>
	</body>
</form>
</html>