<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<div align="center">
	<h1>회원가입</h1>
	<div>
	<form id="frm" action="memberJoin.do" onsubmit="return formchecked()" method="post">
		<div>
			<table border="1">
				<tr>
					<th>아이디</th>
					<th><input type="text" id="memberId" name="memberId" size="20">
						<input type="hidden" value="No">
						<button type="button" id="btn" onclick="idCheck()">중복체크</button>
					</th>
				</tr>
				<tr>
					<th>패스워드</th>
					<th><input type="password" id="memberPassword" name="memberPassword" size="20">
					</th>
				</tr>
				<tr>
					<th>패스워드 확인</th>
					<th><input type="password" id="password" name="password" size="20">
						<button type="button" onclick="idCheck">중복체크</button>
					</th>
				</tr>
				<tr>
					<th>이름</th>
					<th><input type="text" id="memberName" name="memberNam" size="20">
					</th>
				</tr>
			</table>		
		</div><br>
		<div>
			<input type="submit" value="회원가입">
			<input type="reset" value="취소">
			<input type="button" value="메인으로">
			
		</div>
	</form>
	</div>
</div>
<script type="text/javascript">
function formCheck(){
		 if(frm.memberId.value == ""){
			alert("사용자 아이디를 입력해주세요.")
			frm.memberId.focus();
			return false;
		} 
		if(frm.checkId.value == "No"){
			alert("아이디 중복체크를 해야합니다.");
			return false;
		}
		if(frm.memberPassword.value != frm.password.value){
			alert("비밀번호가 일치하지 않습니다.");
			frm.memberPassword.value = "";
			frm.password.value ="";
			frm.memberPassword.focus();
			return false;
		}
/* 		if(frm.memberName.value == ""){
			alert("이름을 입력해주세요.")
			frm.memberName.focus();
			return false;
		} */
		return true;
	}
	
	function idCheck(){
		let id = frm.memberId.value;
		if(id ==""){
			alert("아이디 중복체크를 해야합니다.");
			frm.memberId.focus();
		} else{
			//ajax를 이용하여 아이디 중복체크를 수행한다.
			const xhttp = new XMLHttpRequest();
			xhttp.onload = function() {	//콜백함수 : 결과를 받아 처리하는 함수
				if(this.readyState==4 && this.status==200){
					htmlConvertAjax(this.responseText);	//성공했을때 수행하는 함수
				}else{
					errorAjaxCall(); //실패했을때 수행하는 함수
				}
				//console.log(this.responseText);
			}
			xhttp.open("GET", "ajaxMemberIdCheck.do?id="+id); //호출할 주소와 방식설정
			xhttp.send(); //호출
		}
	}
	
	function htmlConvertAjax(str){
		if(str=="Used"){
			alert("사용 가능한 아이디입니다.");
			frm.memberId.value="Yes";
			frm.btn.disabled = false;
			frm.memberPassword.focus();
		}else{
			alert("이미 사용중인 아이디입니다.")
			frm.memberId.value="";
			frm.memberId.focus();
		}
	}
	
	function errorAjaxCall(){
		alert("네트워크 통신 장애로 인해 처리 할 수 없습니다 \n 잠시 후 다시 시도해주세요.");
		
	}
	
</script>
</body>
</html>