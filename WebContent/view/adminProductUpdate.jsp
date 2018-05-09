<%@ page info="게시판 수정하기" contentType="text/html;charset=UTF-8" %>
<HTML>
<HEAD>
<link rel="stylesheet" href="css/style.css">

<SCRIPT >
function checkValid() {
	var f = window.document.updateForm;
	
	if ( f.pCode.value == "" ) {
		alert( "가격을 입력해 주세요." );
		f.pCode.focus();
		return false;
	}
	if ( f.pPrice.value == "" ) {
		alert( "수량을 입력해 주세요." );
		f.pPrice.focus();
		return false;
	}
/* 	if ( f.pImage.value == "" ) {
        alert( "메인이미지를 입력해 주세요." );
        f.pImage.focus();
        return false;
    }
	if ( f.pDetailImage.value == "" ) {
        alert( "디테일이미지를 입력해 주세요" );
        f.pDetailImage.focus();
        return false;
    } */
	
    
}

</SCRIPT>

</HEAD>

<BODY>


<form name=updateForm method=post action="${path}/mumi" onSubmit="return checkValid()">
    <input type="hidden" name="command" value="adminProductUpdate" >
    <input type='hidden' name='pCode' value="${proDto.pCode}">
	<table align="center" cellpadding="5" cellspacing="1" width="600" border="1">
    <tr>
        <td width="1220" height="20" colspan="2" bgcolor="#e9ecef">
            <p align="center"><font color="black" size="3"><b>  상품정보 수정하기</b></font></p>
        </td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">가격</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="pPrice" size="30"
		 value="${proDto.pPrice}"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">수량</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<input type=text name="pEA" size="30"
		 value="${proDto.pEA}"></span></b></td>
    </tr>
  <!--  
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">메인이미지</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<textarea name="description" cols="50" rows="10">${proDto.pImage}</textarea></span></b></td>
    </tr>
	<tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">디테일이미지</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<textarea name="description" cols="50" rows="10">${proDto.pDetailImage}</textarea></span></b></td>
    </tr>    
     <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">비밀번호</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;"><input type=password name="password" size="12"> 
            (비밀번호가 맞아야 수정이 가능합니다.)</span></b></td>
    </tr> -->
    <tr>
        <td width="450" height="20" colspan="2" align="center"><b><span style="font-size:9pt;">
		<input type="submit" value="수정하기"> <input type="reset" value="다시쓰기"></span></b></td>
    </tr>
</table>
</form>
<hr>
<div align=right><span style="font-size:9pt;">&lt;<a href="${path}/mumi?command=adminProductAllRead">리스트로 돌아가기</a>&gt;</span></div>
</BODY>
</HTML>







