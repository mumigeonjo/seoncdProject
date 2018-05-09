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
          <a href="${path}/view/adminProductInsert.jsp">상품 등록</a>
        </li>
        <!-- <li class="breadcrumb-item active">Blog Home 2</li> -->
      </ol>	
	
	<hr>
	
	<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
	<caption></caption>
		<colgroup>
			<col width="12%"/>
			<col width="12%"/>
			<col width="12%"/>
			<col width="10%"/>
			<col width="16%"/>
			<col width="10%"/>
			<col width="14%"/>
			<col width="14%"/>
		</colgroup>
		<tr>
	        <td bgcolor="#e9ecef">
	            <p align="center">
	            <font color="black"><b><span>상품코드</span></b></font></p>
	        </td>
	        <td bgcolor="#e9ecef">
	            <p align="center"><font color="black"><b><span>상품명</span></b></font></p>
	        </td>
	        <td bgcolor="#e9ecef">
	            <p align="center"><font color="black"><b><span>가격</span></b></font></p>
	        </td>
	        <td bgcolor="#e9ecef">
	            <p align="center"><font color="black"><b><span>사이즈</span></b></font></p>
	        </td>
	        <td bgcolor="#e9ecef">
	            <p align="center"><font color="black"><b><span>입고일</span></b></font></p>
	        </td>
	        <td bgcolor="#e9ecef">
	            <p align="center"><font color="black"><b><span>잔여수량</span></b></font></p>
	        </td>
	        <td bgcolor="#e9ecef">
	            <p align="center"><font color="black"><b><span>메인이미지</span></b></font></p>
	        </td>
	        <td bgcolor="#e9ecef">
	            <p align="center"><font color="black"><b><span>디테일이미지</span></b></font></p>
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
			            <p align="center"><span>
						<a href="${path}/mumi?command=adminProductRead&pCode=${proDto.pCode}">		            
			              ${proDto.pCode}
			            </a>
			            </span></p>
			        </td>
			        <td bgcolor="">
						<p align="center"><span>
						${proDto.pName}</span></p>
			        </td>
			        
			        <td bgcolor="">
			            <p align="center"><span>
			            <fmt:formatNumber value="${proDto.pPrice}"/></span></p>
			        </td>
			        <td bgcolor="">
			            <p align="center"><span>
			            ${proDto.pSize}</span></p>
			        </td>
			         
			         <td bgcolor="">
			            <p align="center"><span>
			            ${proDto.pDate}</span></p>
			        </td>
			         <td bgcolor="">
			            <p align="center"><span>
			            <fmt:formatNumber value="${proDto.pEA}"/></span></p>
			        </td>
			        <td bgcolor="">
			            <p align="center"><span>
			            ${proDto.pImage}</span></p>
			        </td>
			        <td bgcolor="">
			            <p align="center"><span>
			            ${proDto.pDetailImage}</span></p>
			        </td>			        		        
			    </tr>
	    </c:forEach>
		</c:otherwise>
	    </c:choose>
	</table>
	
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


  </body>
</html>
	
	
	
	
	
	
	
	
	
	
	
	
