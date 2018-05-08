<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#historyback").click(function() {
			window.history.back();
		})
	})
</script>
</head>
<body>
	<form method="post"
		action="${pageContext.request.contextPath}/mumi?command=userUpdate">
		<table>
			<tr>
				<th>아이디</th>
				<th><input type="text" name="id" id="id"
					value="${dto.memberID}" readonly="readonly"></th>
			</tr>
			<tr>
				<th>비밀번호</th>
				<th><input type="password" name="pwd" id="pwd"
					value="${dto.pwd }"></th>
			</tr>
			<tr>
				<th>이름</th>
				<th><input type="text" name="name" id="name"
					value="${dto.name }"></th>
			</tr>
			<tr>
				<th>핸드폰번호</th>
				<th><input type="text" name="phone" id="phone"
					value="${dto.phone }"></th>
			</tr>
			<tr>
				<th>주소</th>
				<th><input type="text" name="addr" id="addr"
					value="${dto.addr }"></th>
			</tr>
			<tr>
				<th><button type="submit">회원정보 수정</button></th>
				<th><button type="button" name="historyback" id="historyback">뒤로가기</button></th>
			</tr>
		</table>
	</form>
</body>
</html>