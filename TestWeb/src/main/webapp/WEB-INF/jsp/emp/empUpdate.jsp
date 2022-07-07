<%@page import="com.jay.prj.emp.EmpVO"%>
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
<%
 EmpVO vo = (EmpVO)request.getAttribute("emp");
%>
<form name="frm" action="EmpInsert" method="post" onsubmit="return validateForm()">
	<body>
	<%-- <%@ include file="/WEB-INF/jsp/header.jsp" %> --%>
	<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
		<h3>사원등록</h3>
		사원번호
		<input name="employeeId" readonly="readonly" value="<%=vo.getEmployeeId() %>"><br>
		<label>이름</label><input name="lastName" value="<%=vo.getLastName()%>"><br>
		<label>E-mail</label><input name="email" value="<%=vo.getEmail()%>"><br>
		<label>입사일</label><input type="date" name="hireDate" value="<%=vo.getHireDate()%>"><br>
		<label>부서등록</label>
		<c:foreach items="list1" var="dept">
			<input type="radio" name="departmentId"value="${dept.getDepartmentId()}"
			<c:if test="dept.getDepartmentId()==vo.getDepartmentId()"> checked="checked" </c:if>>
				${dept.getDepartmentName()}
		</c:foreach>
				
<%-- 				<% ArrayList<DeptVO> list1 = (ArrayList<DeptVO>)request.getAttribute("dept");
			for(DeptVO dept : list1) {%>
			<input type="radio" name="departmentId"value="<%=dept.getDepartmentId()%>"
					<%if (dept.getDepartmentId().equals(vo.getDepartmentId())) {%>
					checked="checked" <%}%>>
				<%=dept.getDepartmentName()%>
				<% } %> --%>
			<br>
		<label>직무</label><select name="jobId" ><br>
			<%
			ArrayList<JobsVO> list = (ArrayList<JobsVO>) request.getAttribute("jobs");
			for (JobsVO job : list) {
			%>
			<option value="<%=job.getJobId()%>"
			<%-- <% if(job.getJobId().equals(vo.getJobId()) ){%>selected="selected"<%} %> --%>
			
			><%=job.getJobTitle()%>
			<% } %>
			</select>
		<button>사원수정</button>
		<button type="button" onclick="empdelete()">사원삭제</button>
	</body>
</form>
<script>
	document.getElementsByName("jobId")[0].value = "<%=vo.getJobId()%>";
	function empdelete(){
		location.href="EmpDelete?employeeId=<%=vo.getEmployeeId()%>";
	}
</script>
</html>