<%@page import="com.jay.prj.emp.EmpVO"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 목록</title>
</head>
<body> 
	<h3>사원목록</h3>
	<a href="/TestWeb/EmpInsert">사원등록</a><br>
	<form>
	<input name="departmentId">
	<button>검색</button>
	</form>	
	<table border="1">
		<thead>
			<tr>
				<th>사번</th>
				<th>이름</th>
				<th>Email</th>
				<th>입사일</th>
				<th>직무</th>
				<th>부서</th>
			</tr>
		</thead>
		<tbody>
			<% ArrayList<EmpVO> list = (ArrayList<EmpVO>)request.getAttribute("list");
			for(EmpVO emp : list) {	%>
			<tr><td><%=emp.getEmployeeId() %></td>
			<td><%=emp.getLastName() %></td>
			<td><%=emp.getEmail() %></td>
			<td><%=emp.getHireDate() %></td>
			<td><%=emp.getJobId() %></td>
			<td><%=emp.getDepartmentId() %></td></tr>
			<% } %>
<%-- 			<c:forEach var="vo" items="${list}">
								<tr>
					<td>${vo.employeeId}</td>
					<td>${vo.firstName}</td>
					<td>${vo.salary}</td>

					<td><%=vo.getEmployeeId()%></td>
				<td><%=vo.getFirstName()%></td>
				<td><%=vo.getSalary()%></td>
		
			}
					</tr>
			</c:forEach> --%>
		</tbody>
	</table>
</body>
</html>