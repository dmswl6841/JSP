<%@page import="com.jay.prj.dept.DeptVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>부서등록</title>
<script>
 function validateForm(){
	 if(frm.departmentId.value==""){
		 alert("부서번호를 입력하여주십시오")
		 return ;
	 }
	 frm.submit();	//=form 전송 일반 submit 버튼 눌렀을때와 같음.
 }
</script>
</head>
<body>
<%-- <%@ include file="/WEB-INF/jsp/header.jsp" %> --%>
<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
	<form name="frm" action="DeptInsert" method="post">
		부서번호<input name="departmentId" >
		부서명<input name="departmentName" >
			
		<button type="button" onclick="validateForm()">부서등록</button>
	</form>
</body>
</html>