<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>로 그 인</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="memberLogin.do" method="post">
				<div>
					<table border="1">
						<tr>
							<th>아이디</th>
							<!-- id는 자바스크립트가 사용 name은 자바가 사용 -->
							<td><input type="text" id="memberId" name="memberId"
								required="required" placeholder="아이디를 입력해주세요"></td>
						</tr>
						<tr>
							<th>패스워드</th>
							<td><input type="text" id="memberPassword"
								name="memberPassword" required="required"
								placeholder="패스워드를 입력해주세요"></td>
						</tr>
					</table>
				</div><br>
				<input type="submit" value="로그인">
				<input type="reset" value="취 소">
				<input type="button" value="메인으로" onclick="location.href='main.do'">
			</form>
		</div>
	</div>
</body>
</html>