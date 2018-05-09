<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- 
\${pageContext.request.contextPath} = ${pageContext.request.contextPath}
 --%>
<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>

<link rel="stylesheet" href="${path}/css/style.css">

<div align=right>
<span style="font-size:12pt;">&lt;<a href="${path}/adminProductInsert.html">상품 등록하기</a>&gt;</span></div>
<hr>
<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
<caption>상품 LIST</caption>
	<colgroup>
		<col width="12%"/>
		<col width="12%"/>
		<col width="12%"/>
		<col width="12%"/>
		<col width="12%"/>
		<col width="12%"/>
		<col width="12%"/>
		<col width="10%"/>
	</colgroup>
	<tr>
        <td bgcolor="#e9ecef">
            <p align="center">
            <font color="black"><b><span style="font-size:9pt;">상품코드</span></b></font></p>
        </td>
        <td bgcolor="#e9ecef">
            <p align="center"><font color="black"><b><span style="font-size:9pt;">상품명</span></b></font></p>
        </td>
        <td bgcolor="#e9ecef">
            <p align="center"><font color="black"><b><span style="font-size:9pt;">가격</span></b></font></p>
        </td>
        <td bgcolor="#e9ecef">
            <p align="center"><font color="black"><b><span style="font-size:9pt;">사이즈</span></b></font></p>
        </td>
        <td bgcolor="#e9ecef">
            <p align="center"><font color="black"><b><span style="font-size:9pt;">입고일</span></b></font></p>
        </td>
        <td bgcolor="#e9ecef">
            <p align="center"><font color="black"><b><span style="font-size:9pt;">잔여수량</span></b></font></p>
        </td>
        <td bgcolor="#e9ecef">
            <p align="center"><font color="black"><b><span style="font-size:9pt;">메인이미지</span></b></font></p>
        </td>
        <td bgcolor="#e9ecef">
            <p align="center"><font color="black"><b><span style="font-size:9pt;">디테일이미지</span></b></font></p>
        </td>                
    </tr>
    
    <c:choose>
    <c:when test="${empty requestScope.list}">
	   <tr>
        <td colspan="8">
            <p align="center"><b><span style="font-size:9pt;">등록된 상품이 없습니다.</span></b></p>
        </td>
    </tr>
    </c:when>
    <c:otherwise>
	<c:forEach items="${requestScope.list}" var="proDto">
		    <tr onmouseover="this.style.background='#eaeaea'"
		        onmouseout="this.style.background='white'">
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
					<a href="mumi?command=userProductRead&pCode=${proDto.pCode}">		            
		              ${proDto.pCode}
		            </a>
		            </span></p>
		        </td>
		        <td bgcolor="">
					<p align="center"><span style="font-size:9pt;">
					${proDto.pName}</span></p>
		        </td>
		        
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            <fmt:formatNumber value="${proDto.pPrice}"/></span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${proDto.pSize}</span></p>
		        </td>
		         
		         <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${proDto.pDate}</span></p>
		        </td>
		         <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            <fmt:formatNumber value="${proDto.pEA}"/></span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${proDto.pImage}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${proDto.pDetailImage}</span></p>
		        </td>			        		        
		    </tr>
    </c:forEach>
	</c:otherwise>
    </c:choose>
</table>















