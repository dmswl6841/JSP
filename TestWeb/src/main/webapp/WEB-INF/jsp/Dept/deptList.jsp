<%@page import="com.jay.prj.dept.DeptVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서조회</title>
</head>
<body>
<%-- <%@ include file="/WEB-INF/jsp/header.jsp" %> --%>
<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
	
<h3>부서목록</h3>
	<a href="DeptInsert">부서등록</a>

	<table border="1">
		<thead>
			<tr>
				<th>부서번호</th>
				<th>부서명</th>
			</tr>
		</thead>
		<tbody>
			<% ArrayList<DeptVO> list = (ArrayList<DeptVO>)request.getAttribute("list");
			for (DeptVO dept : list) {
			%>
			<tr><td><%=dept.getDepartmentId()%></td>
				<td><a href= "DeptUpdate?departmentId=<%=dept.getDepartmentId()%>"><%=dept.getDepartmentName()%></a></td></tr>
				<% } %>
			
		
		
			<c:forEach var="vo" items="${list}">
				<tr>
					<td><a href= "DeptUpdate?departmentId=${vo.getDepartmentId()}">${vo.departmentId}</td>
					<td>${vo.departmentName}</td>
				</tr>
			</c:forEach>
	 		</tbody>
	</table>

</body>
</html>