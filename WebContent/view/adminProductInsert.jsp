<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Modern Business - Start Bootstrap Template</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <link href="${path}/css/modern-business.css"  rel="stylesheet">
	
	<style>
	table {
	    border-collapse: collapse;
	    width: 100%;
	}
	
	th, td {
	    padding: 8px;
	    text-align: left;
	    border-bottom: 1px solid #ddd;
	    font-size: 15px;
	}
	
	tr:hover {background-color:#f5f5f5;}
	</style>
	
	<script language=javascript>
	function checkValid() {
	    var f = window.document.writeForm;
			
		if (f.pCode.value=="") {
		    alert( "상품코드를 입력해 주세요." );
		    f.pCode.focus();
			return false;
	    }
		if (f.pName.value=="") {
			alert( "상품명을 입력해 주세요." );
			f.pName.focus();
			return false;
		}
		if (f.pPrice.value=="") {
			alert( "가격을 입력해 주세요." );
			f.pPrice.focus();
			return false;
		}
		if (f.pSize.value=="") {
	        alert( "사이즈를 입력해 주세요." );
	        f.pSize.focus();
	        return false;
	    }
		if (f.pDate.value=="") {
	        alert( "입고일을 입력해 주세요" );
	        f.pDate.focus();
	        return false;
	    }
		if (f.pEA.value=="") {
	        alert( "입고수량을 입력해 주세요" );
	        f.pEA.focus();
	        return false;
	    }
		if (f.pImage.value=="") {
	        alert( "메인이미지를 등록해 주세요" );
	        f.pImage.focus();
	        return false;
	    }
		if (f.pDetailImage.value=="") {
	        alert( "디테일이미지를 등록해 주세요" );
	        f.pDetailImage.focus();
	        return false;
	    }
		
	    return true;
	}
	</script>
</head>

<body>

   <!-- Navigation 1 -->
   <nav
      class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
         <a class="navbar-brand"
            href="${path}/index.html">MuMiGeonJo-BACKPACKS</a>


         <button class="navbar-toggler navbar-toggler-right" type="button"
            data-toggle="collapse" data-target="#navbarResponsive"
            aria-controls="navbarResponsive" aria-expanded="false"
            aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
         </button>

        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
               <%
                  if (session.getAttribute("id") == null) {
               %>

               <li class="nav-item"><a class="nav-link"
                  href="${pageContext.request.contextPath}/view/loginForm.jsp">로그인</a></li>
               <li class="nav-item"><a class="nav-link"
                  href="${pageContext.request.contextPath}/view/register.jsp">회원가입</a></li>

               <%
                  } else {
               %>

               <li class="nav-item"><a class="nav-link"
                  href="${pageContext.request.contextPath}/mumi?command=userLogout">로그아웃</a></li>

               <%
                  if (session.getAttribute("id").equals("admin")) {
               %>
               <li class="nav-item"><a class="nav-link"
                  href="${pageContext.request.contextPath}/mumi?command=adminSelectAllMember">모든회원
                     조회</a></li>
               <%
                  } else {
               %>
               <li class="nav-item"><a class="nav-link"
                  href="${pageContext.request.contextPath}/mumi?command=userOrderlistRead">주문내역</a></li>

               <li class="nav-item"><a class="nav-link"
                  href="${pageContext.request.contextPath}/mumi?command=cartRead">장바구니</a></li>
                  
               <li class="nav-item"><a class="nav-link"
                  href="${pageContext.request.contextPath}/mumi?command=userUpdateForm">회원정보수정</a></li>
               <%
                  }
                  }
               %>
            </ul>
         </div>
      </div>
      <br>
   </nav>
   <!--Navigation 1 end -->
   


   <!--Navigation 2 -->
   <nav class="navbar navbar-expand-lg navbar-dark bg-dark " style="top: 0px; height: 80px;">

      <div class="container ml-auto" >

         <!--logo image-->
         <div>
         </div>

         <div class="collapse navbar-collapse" id="navbarResponsive" >
            <ul class="nav navbar-nav" style="position: absolute; left: 50%; transform: translatex(-50%);z-index:100">  
               <li class="nav-item"><a class="nav-link" href="${path}/view/aboutUs.jsp">About Us</a></li>
               <li class="nav-item dropdown"><a
                  class="nav-link dropdown-toggle" href="#"
                  id="navbarDropdownPortfolio" data-toggle="dropdown"
                  aria-haspopup="true" aria-expanded="false"> Online Shop </a>
                  <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPortfolio">
                    <a class="dropdown-item" href="${path}/mumi?command=userProductAllRead"> Backpacks</a> 
                  </div></li>
               <li class="nav-item dropdown"><a
                  class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog"
                  data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                     Community </a>
                  <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
                     <a class="dropdown-item" href="${path}/mumi?command=noticeRead">Notice</a> 
                  </div></li>
               <li class="nav-item dropdown"><a
                  class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog"
                  data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                     Customer Support </a>
                  <div class="dropdown-menu dropdown-menu-right"
                     aria-labelledby="navbarDropdownBlog">
                     <a class="dropdown-item" href="${pageContext.request.contextPath}/view/Info.jsp">Info</a> 
                     <a class="dropdown-item" href="${pageContext.request.contextPath}/mumi?command=userQARead">Q&A</a>
                  </div>
               </li>
            </ul>
         </div>
      </div>
      <br>
   </nav>
   <!-- Navigation 2 end -->


   <!-- Page Content -->
   <div class="container">   
	
      <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">상품관리
        <small> </small>
      </h1>

      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="${path}/mumi?command=adminProductAllRead">리스트로 돌아가기</a>
        </li>
        <!-- <li class="breadcrumb-item active">Blog Home 2</li> -->
      </ol>	
	
	<hr>

	
	<form name="writeForm" method="post" action="${path}/mumi?command=adminProductInsert" 
	  onSubmit='return checkValid()' enctype="multipart/form-data">
	
	<table align="center" cellpadding="5" cellspacing="2" width="600">
	    
	    <tr>
	        <td width="1220" height="20" colspan="2" bgcolor="#e9ecef">
	            <p align="center"><font color="black" size="3"><b> 상품 등록 </b></font></p>
	        </td>
	    </tr>
	    <tr>
	        <td width="200" height="20" >
	            <p align="right"><span>상품코드</span></p>
	        </td>
	        <td width="300" height="20"><b><span>
			<input type=text name="pCode" size="50"></span></b></td>
	    </tr>
	    <tr>
	        <td width="200" height="20">
	            <p align="right"><span>상품명</span></p>
	        </td>
	        <td width="300" height="20"><b><span>
			<input type=text name="pName" size="50"></span></b></td>
	    </tr>
	    <tr>
	        <td width="150" height="20">
	            <p align="right"><span>가격</span></p>
	        </td>
	        <td width="450" height="20" ><b><span>
			<input type=text name="pPrice" size="50"></span></b></td>
	    </tr>
	    <tr>
	        <td width="150" height="20">
	            <p align="right"><span>사이즈 (S/M/L)</span></p>
	        </td>
	        <td width="450" height="20"><b><span>
	        <input type=text name="pSize" size="50"></textarea></span></b></td>
	    </tr>
	    <tr>
	        <td width="150" height="20">
	            <p align="right"><span>입고일 (YYYYMMDD)</span></p>
	        </td>
	        <td width="450" height="20"><b><span>
	        <input type=text name="pDate" size="50"></textarea></span></b></td>
	    </tr>    
	    <tr>
	        <td width="150" height="20">
	            <p align="right"><span>입고수량</span></p>
	        </td>
	        <td width="450" height="20" ><b><span>
			<input type=text name="pEA" size="50"></span></b></td>
	    </tr> 
	    <tr>
	        <td width="150" height="20">
	            <p align="right"><span>메인이미지</span></p>
	        </td>
	        <td width="450" height="20">
	        	<b><span>
	        		 <input type="file" name="pImage" maxlength="60" size="40">
	        	   </span></b>
	        </td>
	    </tr>
	    <tr>
	        <td width="150" height="20">
	            <p align="right"><span>디테일이미지</span></p>
	        </td>
	        <td width="450" height="20">
	        	<b><span>
	        		 <input type="file" name="pDetailImage" maxlength="60" size="40">
	        	   </span></b>
	        </td>
	    </tr>
	 
	    
	    <tr>
	        <td width="450" height="20" colspan="2" align="center">
	        <b><span>
	        <input type=submit value="상품 등록" class = "btn btn-primary" style = "vertical-align : inherit;"> 
	        <input type=reset value=다시쓰기 class = "btn btn-primary" style = "vertical-align : inherit;"></span>
	        </b></td>
	    </tr>
	</table>
	
	</form>


   </div>
   <!-- /.container -->	

   <!-- Footer -->
   <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white"><strong>Copyright</strong> &copy; 무미건조 &nbsp;</p>
        <p class="m-0 text-center text-white"><strong>주소</strong> : 경기도 성남시 분당구 삼평동 682 유스페이스2 B동 8층 &nbsp;</p>
        <p class="m-0 text-center text-white"><strong>대표번호</strong> : 031-606-9320 &nbsp;</p>
      </div>
      <!-- /.container -->
   </footer>
   <!-- Footer end -->

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</BODY>
</HTML>

