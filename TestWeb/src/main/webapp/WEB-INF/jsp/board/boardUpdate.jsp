<%@page import="com.jay.prj.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력</title>
<script>
	function edit(){
		if(window.document.frm.title.value==""){
			alert("제목을 입력하여주십시오")
			frm.title.focus();
			return false;
		}
		if(window.document.frm.content.value==""){
			alert("내용을 입력하여주십시오")
			frm.content.focus();
			return false;
		}
		if(window.document.frm.writer.value==""){
			alert("글쓴이를 입력하여주십시오")
			frm.writer.focus();
			return false;
		}
		if(window.document.frm.rdt.value==""){
			alert("작성일을 입력하여주십시오")
			frm.rdt.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<%
 BoardVO vo = (BoardVO)request.getAttribute("brd");
%>
<form action="BoardInsert" name="frm" method="post">
<body>
	<label>제목</label><input type="text" name="title" value="${vo.getTitle()}"><br>
	<label>내용</label><input type="text" name="content" value="${vo.getContent()}"><br>
	<label>글쓴이</label><input type="text" name="writer" value="${vo.getWriter()}"><br>
	<label>작성일</label><input type="date" name="rdt" value="${vo.getrDate()}"><br>
	<label>조회수</label><input type="text" name="hit" value="${vo.getHit()}"><br>
	<button type="button" onclick="edit()">수정</button>
	<button type="button" onclick="boardDelete()">삭제</button>
</body>
	</form>
	<script>
	document.getElementsByName("id")[0].value = "<%=vo.getId()%>";
	function boardDelete(){
		location.href="BoardDelete?id=<%=vo.getId()%>";
	}
</script>
</html>