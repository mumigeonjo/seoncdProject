<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<c:forEach items="${requestScope.list}" var="review">
		    <tr onmouseover="this.style.background='#eaeaea'"
		        onmouseout="this.style.background='white'">
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${review.rIndexNo}</span></p>
		        </td>
		        <td bgcolor="">
					<p><span style="font-size:9pt;">
					${review.pCode}
					</span></p>
		        </td>
				 <td bgcolor="">
					<p><span style="font-size:9pt;">					
					${review.rDate}					
					</span></p>
		        </td>
		         <td bgcolor="">
					<p><span style="font-size:9pt;">					
					${review.rContent}					
					</span></p>
		        </td>
		    </tr>
    </c:forEach>
</body>
</html>