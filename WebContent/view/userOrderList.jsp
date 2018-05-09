<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 유저 마이페이지에서 역대 주문 내역 확인하기 
o_date, p_name, o_ea, p_price, o_addr -->
<table>
<c:forEach items="${requestScope.list }" var="cart" varStatus="state">
	<tr>
	<td>${requestScope.list.oDate }</td>
	<td>${requestScope.list.pName }</td>
	<td>${requestScope.list.oEA }</td>
	<td>${requestScope.list.pPrice }</td>
	<td>${requestScope.list.oAddr }</td>
	</tr>
</c:forEach>
</table>
</body>
</html>