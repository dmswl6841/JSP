<%@page import="com.jay.prj.EmpVO"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 목록</title>
</head>
<body>
<h3>사원목록</h3>
<a href="/TestWeb/EmpInsert">사원등록</a>
	<table border="1">
		<thead>
			<tr>
				<th>사번</th>
				<th>이름</th>
				<th>급여</th>
			</tr>
		</thead>
		<tbody>
<c:forEach var="vo" items="${list}">
<%-- 			<%
			ArrayList<EmpVO> list = (ArrayList<EmpVO>) request.getAttribute("list");
			 			list.add(new EmpVO("100", "백청렴", "35000"));
				list.add(new EmpVO("101", "전서구", "25000"));
				list.add(new EmpVO("102", "전동구", "28000"));
				list.add(new EmpVO("103", "은행차", "40000")); 
			%> --%>
			<tr>
				<td>${vo.employeeId}</td>
				<td>${vo.firstName}</td>
				<td>${vo.salary}</td>
				
<%-- 				<td><%=vo.getEmployeeId()%></td>
				<td><%=vo.getFirstName()%></td>
				<td><%=vo.getSalary()%></td> --%>
<%-- 			<%
			}
			%> --%>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>