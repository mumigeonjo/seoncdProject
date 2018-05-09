<%@page import="java.util.ArrayList"%>
<%@page import="mumi.model.dto.QAReplyDTO"%>
<%@page import="mumi.model.dto.QADTO"%>
<%@page import="java.util.List"%>
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
    <link href="${path}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${path}/css/modern-business.css" rel="stylesheet">
   
    
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>

<!-- 	<SCRIPT language=javascript> -->
	<SCRIPT  type="text/javascript">
	
		function sendUpdate(bIndexNo){
			
			$("#command"+bIndexNo).val("userQAUpdateForm");
			$("#requestForm"+bIndexNo).submit();	
		}
			
		function sendDelete(bIndexNo){	

			if (confirm("정말 삭제하시겠습니까?")==true){
				$("#command"+bIndexNo).val("userQADelete");
				$("#requestForm"+bIndexNo).submit();
			}
			return;	 	
		}	
		
		function readAnswer(bIndexNo){	

				$("#command"+bIndexNo).val("adminQAReplyReadDetail");
				$("#requestForm"+bIndexNo).submit();
			
			return;	 	
		}	
				
	</script>
	
  </head>

  <body>

    <!-- Navigation 1 -->
    <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="index.html">MuMiGeonJo-BACKPACKS</a>

   
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
         
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="about.html">Login</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="services.html">Register</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="contact.html">Mypage</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="contact.html">Cart</a>
            </li>
            
			<!--             
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPortfolio" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Online Shop
              </a>
              <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPortfolio">
                <a class="dropdown-item" href="portfolio-1-col.html">1 Column Portfolio</a>
                <a class="dropdown-item" href="portfolio-2-col.html">2 Column Portfolio</a>
                <a class="dropdown-item" href="portfolio-3-col.html">Backpacks</a>
                <a class="dropdown-item" href="portfolio-4-col.html">4 Column Portfolio</a>
                <a class="dropdown-item" href="portfolio-item.html">Single Portfolio Item</a>
              </div>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Community
              </a>
              <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
                <a class="dropdown-item" href="blog-home-1.html">Blog Home 1</a>
                <a class="dropdown-item" href="blog-home-2.html">Blog Home 2</a>
                <a class="dropdown-item" href="blog-post.html">Blog Post</a>
              </div>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Customer Support
              </a>
              <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
                <a class="dropdown-item" href="full-width.html">Full Width Page</a>
                <a class="dropdown-item" href="sidebar.html">Sidebar Page</a>
                <a class="dropdown-item" href="faq.html">FAQ</a>
                <a class="dropdown-item" href="404.html">404</a>
                <a class="dropdown-item" href="pricing.html">Pricing Table</a>
              </div>
            </li>
            
             -->
            
          </ul>
        </div>
      </div>
      <br>
    </nav>
    <!--Navigation 1 end -->
    
    
    
    <!--Navigation 2 -->
     <nav class="navbar navbar-expand-lg navbar-dark bg-dark "
     style="top:0px;height:200px">
      
      <div class="container" style="vertical-align:middle" >
      
        <!--logo image-->
        <div>
      	<!-- <img class="img-fluid rounded" src="img/jquery.jpg" alt=""> -->
        </div>
        <!--logo image end -->
		<!--         
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
  		-->       
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="about.html">About Us</a>
            </li>
<!--             
            <li class="nav-item">
              <a class="nav-link" href="services.html">뭐야</a>
            </li>
      -->       

            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPortfolio" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Online Shop
              </a>
              <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPortfolio">
                <a class="dropdown-item" href="portfolio-1-col.html">1 Column Portfolio</a>
                <a class="dropdown-item" href="portfolio-2-col.html">2 Column Portfolio</a>
                <a class="dropdown-item" href="portfolio-3-col.html">Backpacks</a>
                <a class="dropdown-item" href="portfolio-4-col.html">4 Column Portfolio</a>
                <a class="dropdown-item" href="portfolio-item.html">Single Portfolio Item</a>
              </div>
            </li>
			<!--             
            <li class="nav-item">
              <a class="nav-link" href="contact.html">Community</a>
            </li>    
 			-->                    
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Community
              </a>
              <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
                <a class="dropdown-item" href="mumi?command=noticeRead">Notice</a>
                <a class="dropdown-item" href="blog-home-2.html">Blog Home 2</a>
                <a class="dropdown-item" href="blog-post.html">Blog Post</a>
              </div>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Customer Support
              </a>
              <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
                <a class="dropdown-item" href="full-width.html">Info</a>
                <a class="dropdown-item" href="sidebar.html">Sidebar Page</a>
                <a class="dropdown-item" href="mumi?command=userQARead">FAQ</a>
                <a class="dropdown-item" href="404.html">404</a>
                <a class="dropdown-item" href="pricing.html">Pricing Table</a>
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
      <h1 class="mt-4 mb-3">QA   
    	<small><small>소통게시판</small></small>
      </h1>
        
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="index.html">Home</a>
        </li>
        <li class="breadcrumb-item active">Question and Answers</li>
      </ol>
      
<%--         <%session.setAttribute("id", "admin");  %>  --%>  
      <%String id = (String)session.getAttribute("id"); %> 
      <c:set var="id" value="<%=id%>" />
     
<%--       <script type="text/javascript">
    	  alert(<%=id%>)
      </script> --%>

      <div class="mb-4" id="accordion" role="tablist" aria-multiselectable="true">
        
        <c:forEach items="${requestScope.userQARead}" var="userQARead" varStatus="status">
	        <div class="card">
	          <div class="card-header">
	          
	          	<div style="float:left">
	          	 <h5 class="mb-0">
	               
	               	${status.count}. <c:if test="${userQARead.bCategory eq '1'}">[상품문의]</c:if><c:if test="${userQARead.bCategory eq '2'}">[교환/환불]</c:if> ${userQARead.bTitle} <c:if test="${userQARead.bHasDate eq '1'}" style>ㅡ답변완료ㅡ</c:if>
	             </h5>	          	
	          	</div>            
	            <div style="text-align:right; float:left">&nbsp;&nbsp;${userQARead.bDate}&nbsp;&nbsp;</div>
		            <form  name ="requestForm" id="requestForm${userQARead.bIndexNo}" method=post action="${path}/mumi" >
			          <input type=hidden name="bIndexNo" value="${userQARead.bIndexNo}">
			          <input type=hidden name="bTitle" value="${userQARead.bTitle}">
			          <input type=hidden name="bContent" value="${userQARead.bContent}">
			          <input type=hidden name="bCategory" value="${userQARead.bCategory}">		          
			          <input type=hidden id="command${userQARead.bIndexNo}" name="command" value="">
			          <input type=button name="btn" value="삭제" class = "btn btn-primary" style = "float:right;vertical-align : inherit;" onClick="javascript:sendDelete(${userQARead.bIndexNo});">	
	 				  <input type=button name="btn" value="수정" class = "btn btn-primary" style = "float:right;vertical-align : inherit;" onClick="javascript:sendUpdate(${userQARead.bIndexNo});">				  
					 
					   <input type=button name="btn" value="보기" class = "btn btn-primary" style = "float:right; vertical-align : inherit;" onClick="javascript:readAnswer(${userQARead.bIndexNo});"> 
		            </form>
				 </div>
	
	          <div id="${userQARead.bIndexNo}" class="collapse" role="tabpanel" aria-labelledby="headingOne">
	            <div class="card-body">
	              ${userQARead.bContent}<hr>
	            <form>
	            	
	            </form>
	            </div>
	          </div>
	        </div>      
        </c:forEach>
        <!-- -----로그인시 session으로 값받아와서 관리자만 버튼 보여줌 -->
        <c:if test="${id eq id}">
	        <div align=right><span style="font-size:15pt;">&lt;<a href="${path}/view/userQAForm.html">글쓰기</a>&gt;</span></div>
        </c:if> 
        <!-- ------------------------------------------------------------------------ -->
      </div>  	
    </div>
    
    <!-- /.container -->
	
    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; 무미건조</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>

</html>
