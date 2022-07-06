<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header.jsp</title>
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #04AA6D;
  color: white;
}
</style>
</head>
<body>
<div class="topnav">
<%-- <%=request.getRequestURL() %> --%>
<!-- http://localhost 뒤부터 /  (Servlet은 localhost뒤에 ContextPath가 있지만 jsp는 없음)-->
	<a <%if(request.getRequestURI().endsWith("empInsert.jsp")){%>class="active"<% } %> href="<%=request.getContextPath()%>/EmpInsert">사원등록</a>	<!--  %% 안의 내용은 ContextPath 경로를 가지고 오는것 (주소가 바뀔 수도 있으니까!)-->
	<a <%if(request.getRequestURI().endsWith("empList.jsp")){%>class="active"<% } %> href="<%=request.getContextPath()%>/EmpServlet">사원목록</a>
	<a <%if(request.getRequestURI().endsWith("deptInsert.jsp")){%>class="active"<% } %> href="<%=request.getContextPath()%>/DeptInsert">부서등록</a>
	<a <%if(request.getRequestURI().endsWith("deptList.jsp")){%>class="active"<% } %> href="<%=request.getContextPath()%>/DeptList">부서목록</a>
</div>	
</body>
</html>