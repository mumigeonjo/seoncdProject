<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#historyback").click(function(){
		window.history.back();
	})
})
</script>
</head>
<body>
	<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>핸드폰번호</th>
			<th>주소</th>
			<th>회원삭제</th>
		</tr>
		<c:forEach var="dto" items="${requestScope.list}">
			<tr>
				<th>${dto.memberID}</th>
				<th>${dto.pwd }</th>
				<th>${dto.name }</th>
				<th>${dto.phone }</th>
				<th>${dto.addr }</th>
				<th><button type="button" id="deleteUser" name="deleteUser">
						<a
							href="${pageContext.request.contextPath}/mumi?command=adminUserDelete&memberID=${dto.memberID}">회원삭제</a>
					</button></th>
			</tr>
		</c:forEach>
	</table>
	<button type="button" id="historyback" name="historyback">뒤로가기</button>
</body>
</html>