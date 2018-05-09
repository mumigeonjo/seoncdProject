<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script>
	$(function(){
		var price = ${requestScope.order.pPrice};
		$(":button").click(function(){
			if($(this).val()=="+"){
				$("#oEA").val(parseInt($("#oEA").val())+1);
			}
			else{
				if($("#oEA").val()!=1)
					$("#oEA").val(parseInt($("#oEA").val())-1);
			}
			$("#pPrice").val(parseInt(price)*parseInt($("#oEA").val()));
		});
		
		$("#selectbox").click(function(){ 
			if($(this).val()=="S"){
				price = ${requestScope.order.pPrice}-10000;
				$("#pPrice").val((parseInt(price))*parseInt($("#oEA").val()));
				$("#hiddensize").val("S");
			}
			else if($(this).val()=="L"){
				price = ${requestScope.order.pPrice}+10000;
				$("#pPrice").val((parseInt(price))*parseInt($("#oEA").val()));
				$("#hiddensize").val("L");
			}
			else{
				price = ${requestScope.order.pPrice};
				$("#pPrice").val(parseInt(price)*parseInt($("#oEA").val()));
				$("#hiddensize").val("M");
			}
		});
	});
</script>
</head>
<body>
<!-- 
구매 페이지.
 o_indexno, p_code, p_name, p_price, o_addr, o_phone, o_ea
 -->
 <h3>주문 상품 : ${requestScope.order.pName }</h3><p><p>
 <form id="form" method="post" action="${pageContext.request.contextPath}/mumi?command=userOrderInsert&oIndexNo=${order.oIndexNo}&pCode=${order.pCode}">
 	<h3>사이즈</h3><p>
 	<select form="form" id="selectbox">
 		<option value='S' >S</option>
 		<option value='M' selected="selected">M</option>
 		<option value='L' >L</option>
 	</select>
 	<input type="hidden" value="M" name="size" id="hiddensize"/><p><p>
 	<h3>수량</h3><p>
 	<input type="button" value="+"/>
 	<input type="text" value="1" readonly="readonly" name="oEA" id="oEA"/>
 	<input type="button" value="-"/>
 	<tb><input type="text" readonly="readonly" name="pPrice" id="pPrice" value="${requestScope.order.pPrice }"/>
 	<p><p>
 	<h3>주소</h3><p>
 	<input type="text" value="${requestScope.order.oAddr }" name="oAddr"/><p><p>
 	<h3>연락처</h3><p>
 	<input type="text" value="${requestScope.order.oPhone }" name="oPhone"/><p><p>
 	<hr><input type="submit" value="주문하기"/>
 </form>
</body>
</html>