<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<form method="post" action="./mumi?command=userJoin">
		<table>
			<tr>
				<th>아이디</th>
				<th><input type="text" name="id" id="id"></th>
			</tr>

			<tr>
				<th>비밀번호</th>
				<th><input type="text" name="pwd" id="pwd"></th>
			</tr>

			<tr>
				<th>이름</th>
				<th><input type="text" name="name" id="name"></th>
			</tr>

			<tr>
				<th>핸드폰번호</th>
				<th><input type="text" name="phone" id="phone"></th>
			</tr>

			<tr>
				<th>주소</th>
				<th><input type="text" name="addr" id="addr"></th>
			</tr>
			<tr>
				<th><button>제출</button></th>
				<th><button type="button">뒤로가기</button></th>
			</tr>
		</table>
	</form>
</body>
</html>