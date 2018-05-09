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
<!-- 
member_id, p_code, o_ea, o_date
 -->
<table>
<c:forEach items="${requestScope.orderList }" var="cart" varStatus="state">
	<tr>
	<td>${requestScope.orderList.oDate }</td>
	<td>${requestScope.orderList.memberId }</td>
	<td>${requestScope.orderList.pCode }</td>
	<td>${requestScope.orderList.oEA }</td>
	</tr>
</c:forEach>
</table>
</body>
</html>