<%@page import="com.jay.prj.board.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
<table border="1">
	<thead>
		<tr>
			<th>ID</th>
			<th>제목</th>
			<th>내용</th>
			<th>글쓴이</th>
			<th>작성일자</th>
			<th>hit</th>
		</tr>
	</thead>
	<tbody>
		<%
		ArrayList<BoardVO> list = (ArrayList<BoardVO>)request.getAttribute("list"); 
		for(BoardVO vo : list) {
		%>
		<tr><td><%=vo.getId() %></td>
		<td><%=vo.getTitle() %></td>
		<td><%=vo.getContent() %></td>
		<td><%=vo.getWriter() %></td>
		<td><%=vo.getrDate() %></td>
		<td><%=vo.getHit() %></td></tr>
		<% } %>
	</tbody>
</table>
</body>
</html>