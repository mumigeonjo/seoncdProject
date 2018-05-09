<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<HEAD>
<link rel="stylesheet" href="css/style.css">

<SCRIPT language=javascript>

function sendUpdate(){//수정하기
	document.requestForm.command.value ="adminProductUpdateForm";
	document.requestForm.submit();
}

function sendDelete(){//삭제하기
	document.requestForm.command.value ="adminProductDelete";
	document.requestForm.submit();
}
</script>


</HEAD>

<table align="center" cellpadding="5" cellspacing="2" width="600" border='1'>
    <tr>
        <td width="1220" height="20" colspan="4" bgcolor="#e9ecef">
            <p align="center"><font color="black" size="3"><b>
             상품 자세히보기</b></font></p>
        </td>
    </tr>
    <tr>
        <td width="100" height="20" >
            <p align="right"><b><span style="font-size:9pt;">상품코드</span></b></p>
        </td>
        <td width="450" height="20" colspan="3">
        	<span style="font-size:9pt;"><b>${proDto.pCode}</b></span>
        </td>
    </tr>
    <tr>
        <td width="100" height="20" >
            <p align="right"><b><span style="font-size:9pt;">상품명</span></b></p>
        </td>
        <td width="300" height="20">
        	<span style="font-size:9pt;"><b>${proDto.pName}</b></span>
        </td>
    </tr>
    <tr>    
        <td width="100" height="20" >
			<p align="right"><b><span style="font-size:9pt;">가격</span></b></p>
		</td>
        <td width="100" height="20">
			<p><b><span style="font-size:9pt;"></span>
			<fmt:formatNumber value="${requestScope.proDto.pPrice}"/>
			</b></p>
		</td>
    </tr>
    <tr>
        <td width="100" height="20">
            <p align="right"><b><span style="font-size:9pt;">사이즈</span></b></p>
        </td>
        <td width="450" height="20" colspan="3">
        	<span style="font-size:9pt;"><b>${requestScope.proDto.pSize}</b></span>
        </td>
    </tr>
    <tr>    
        <td width="100" height="20" >
			<p align="right"><b><span style="font-size:9pt;">입고일</span></b></p>
		</td>
        <td width="100" height="20">
			<p><b><span style="font-size:9pt;"></span>${requestScope.proDto.pDate}</b></p>
		</td>        
    </tr>
    <tr>    
        <td width="100" height="20" >
			<p align="right"><b><span style="font-size:9pt;">잔여수량</span></b></p>
		</td>
        <td width="100" height="20">
			<p><b><span style="font-size:9pt;"></span>
			<fmt:formatNumber value="${requestScope.proDto.pEA}"/>
			</b></p>
		</td>        
 	</tr>
    <c:if test="${proDto.pImage!=null}">
    <tr>
        <td width="100" height="20">
            <p align="right"><b><span style="font-size:9pt;">메인이미지 다운로드</span></b></p>
        </td>
        <td width="450" height="20" colspan="3">
        	<span style="font-size:9pt;"><b>
        	<a href='downLoad?fileName=${proDto.pImage}'>
    			${proDto.pImage}
      		</a>
        </b></span>
        </td> 
    </tr>
    </c:if>
    <c:if test="${proDto.pDetailImage!=null}">
    <tr>
        <td width="100" height="20">
            <p align="right"><b><span style="font-size:9pt;">디테일이미지 다운로드</span></b></p>
        </td>
        <td width="450" height="20" colspan="3">
        	<span style="font-size:9pt;"><b>
        	<a href='downLoad?fileName=${proDto.pDetailImage}'>
    			${proDto.pDetailImage}
      		</a>
        </b></span>
        </td> 
    </tr>
    </c:if> 
    
    <form name="requestForm" method=post action="${path}/mumi">
    <tr>
        <td height="20" colspan="4" align="center" valign="middle">
			<!-- 수정시 필요한 데이터들을 hidden으로 숨겨놓고 폼 데이터로 보내준다. -->
				<input type=hidden name="pCode" value="${proDto.pCode}">
				<input type=hidden name="command" value="">
				<input type=button value="수정하기" onClick="sendUpdate()">
				<input type=button value="삭제하기" onClick="sendDelete()">
		</td>
    </tr>
    </form>
			

</table>
<hr>
<div align=right><span style="font-size:9pt;">&lt;<a href="${path}/mumi?command=adminProductAllRead">리스트로 돌아가기</a>&gt;</span></div>








