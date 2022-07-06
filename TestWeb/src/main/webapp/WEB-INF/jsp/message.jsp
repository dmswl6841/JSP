<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div {
	background-color: gray;
	fonr-size: 30px
}
</style>
</head>
<body>
<script>
alert('<%=request.getAttribute("msg")%>')
location.href='EmpServlet'
</script>
	<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
	<div><%=request.getAttribute("msg") %></div>
</body>
</html>