<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<form method="post" action="./mumi?command=userLogin">
<table>
<tr>
	<th>아이디</th>
	<th><input type="text" id="id" name="id"></th>
</tr>
<tr>
	<th>비밀번호</th>
	<th><input type="text" id="pwd" name="pwd"></th>
</tr>
<tr>
	<th><button>로그인</button></th>
	<th><button type="button" id="historyback" name="historyback">뒤로 가기</button></th>
</tr>
</table>
</form>
</body>
</html>
