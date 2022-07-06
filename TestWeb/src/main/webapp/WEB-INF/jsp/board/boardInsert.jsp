<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력</title>
<script>
	function save(){
		if(frm.title.value==""){
			alert("제목을 입력하여주십시오")
			return;
		}
		if(frm.content.value==""){
			alert("내용을 입력하여주십시오")
			return;
		}

		if(frm.writer.value==""){
			alert("글쓴이를 입력하여주십시오")
			return;
		}

		if(frm.rdt.value==""){
			alert("작성일을 입력하여주십시오")
			return;
		}
		frm.submit();
	}
	function edit(){
		if(frm.title.value==""){
			alert("제목을 입력하여주십시오")
			return;
		}
		if(frm.content.value==""){
			alert("내용을 입력하여주십시오")
			return;
		}
		if(frm.writer.value==""){
			alert("글쓴이를 입력하여주십시오")
			return;
		}
		if(frm.rdt.value==""){
			alert("작성일을 입력하여주십시오")
			return;
		}
		frm.submit();
	}
</script>
</head>
<body>
<form action="BoardInsert" name="frm" method="post">
	<label>제목</label><input type="text" name="title"><br>
	<label>내용</label><input type="text" name="content"><br>
	<label>글쓴이</label><input type="text" name="writer"><br>
	<label>작성일</label><input type="date" name="rdt"><br>
	<label>조회수</label><input type="text" name="hit"><br>
	<button type="button" onclick="save()">저장</button>
	<button type="button" onclick="edit()">수정</button>
	</form>
</body>
</html>