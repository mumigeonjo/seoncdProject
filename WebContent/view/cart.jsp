<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script>		
	$(function(){
		$(document).on("click", ":button[value='삭제']", function(){
			//$.ajax({})
			$.ajax({
				type:"get",
				url:"${pageContext.request.contextPath}/mumi",
				data:"command=cartDelete&oIndexNo="+$(this).attr("class"),
				success:function(){
					//$(this:parent:parent)
				},
				error:function(){
					alert("error");
				}
			});
		});
		
		$(document).on("click", ":button[value='구매']", function(){
			//페이지 이동, oIndexNo값을 어떻게 가지고 가지? attr() 함수
			alert();
			//$("form").attr("action", "${pageContext.request.contextPath}/mumi?command=userOrderRead&oIndexNo"+$(this).attr("class"));
			//$("form").submit();
			location.href="${pageContext.request.contextPath}/mumi?command=userOrderRead&oIndexNo="+$(this).attr("class");
		});
	});
	
</script>
</head>
<body>
<h1>장바구니 페이지, read와 delete</h1>
<!-- 삭제 버튼은 각 레코드마다, 오른쪽에
체크박스는 각 레코드 왼쪽에
삭제는 하나씩, 구입은 한꺼번에 체크박스로 가능하도록
맨 아래에 구매 버튼 있음 
삭제-ajax 처리?

사용자가 장바구니 버튼 클릭하면 바로 액션으로 가야 함
그래야 값을 가져와서 뿌릴 수 있음
-->
<hr>
<form>
<h1>삭제, 구매 한 번에 한 개 씩만 되도록</h1>
<table id='cartTable'>
 
<c:forEach items="${requestScope.list }" var="cart" varStatus="state" >
	<tr>
		<td><input type="button" value="삭제" class="${cart.oIndexNo }" id="${state.index }"/></td>
		<td>${cart.pName }</td>
		<td>${cart.pPrice }</td>
		<td><input type="button" value="구매" class="${cart.oIndexNo }"/></td>
	</tr>
</c:forEach>

</table>
</form>
</body>
</html>