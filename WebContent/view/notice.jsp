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
	
		function sendUpdate(nIndexNo){
			
			$("#command"+nIndexNo).val("noticeUpdateForm");
			$("#requestForm"+nIndexNo).submit();	
		}
			
		function sendDelete(nIndexNo){	

			if (confirm("정말 삭제하시겠습니까?")==true){
				$("#command"+nIndexNo).val("noticeDelete");
				$("#requestForm"+nIndexNo).submit();
			}
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
                <a class="dropdown-item" href="blog-home-1.html">Notice</a>
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
                <a class="dropdown-item" href="mumi?command=noticeRead">FAQ</a>
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
      <h1 class="mt-4 mb-3">공지사항   
    	<small><small>자주 묻는 질문 및 이벤트</small></small>
      </h1>
        
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="index.html">Home</a>
        </li>
        <li class="breadcrumb-item active">Notice</li>
      </ol>
      
<%--         <%session.setAttribute("id", "admin");  %>  --%>  
      <%String id = (String)session.getAttribute("id"); %> 
      <c:set var="id" value="<%=id%>" />
     
<%--       <script type="text/javascript">
    	  alert(<%=id%>)
      </script> --%>

      <div class="mb-4" id="accordion" role="tablist" aria-multiselectable="true">
        
        <c:forEach items="${requestScope.noticeRead}" var="noticeRead" varStatus="status">
	        <div class="card">
	          <div class="card-header" role="tab" id="headingOne">
	          	<div style="float:left">
	          	 <h5 class="mb-0">
	               <a data-toggle="collapse" data-parent="#accordion" href="#${noticeRead.nIndexNo}" aria-expanded="true" aria-controls="collapseOne">
	               	${status.count}. ${noticeRead.nTitle} 
	               </a>
	             </h5>	          	
	          	</div>            
	            <div style="text-align:right; float:left">&nbsp;&nbsp;${noticeRead.nDate}&nbsp;&nbsp;</div>
	            <!-- ------------------------------------------------------------------------ -->
	            <!-- -----로그인시 session으로 값받아와서 관리자만 버튼 보여줌 -->	           
	           	 <c:if test="${id eq 'admin'}"> 
		            <form name ="requestForm" id="requestForm${noticeRead.nIndexNo}" method=post action="${path}/mumi" >
			          <input type=hidden name="nIndexNo" value="${noticeRead.nIndexNo}">
			          <input type=hidden name="nTitle" value="${noticeRead.nTitle}">
			          <input type=hidden name="nContent" value="${noticeRead.nContent}">		          
			          <input type=hidden id="command${noticeRead.nIndexNo}" name="command" value="">
	 				  <input type=button value="수정" class = "btn btn-primary" style = "vertical-align : inherit;" onClick="javascript:sendUpdate(${noticeRead.nIndexNo});">
					  <input type=button value="삭제" class = "btn btn-primary" style = "vertical-align : inherit;" onClick="javascript:sendDelete(${noticeRead.nIndexNo});">	 
					  
		            </form>
				 </c:if> 
	            <!-- ------------------------------------------------------------------------ -->
	          </div>
	
	          <div id="${noticeRead.nIndexNo}" class="collapse" role="tabpanel" aria-labelledby="headingOne">
	            <div class="card-body">
	              ${noticeRead.nContent}
	            </div>
	          </div>
	        </div>      
        </c:forEach>
        <!-- -----로그인시 session으로 값받아와서 관리자만 버튼 보여줌 -->
        <c:if test="${id eq 'admin'}"> 
	        <div align=right><span style="font-size:15pt;">&lt;<a href="${path}/view/noticeForm.html">글쓰기</a>&gt;</span></div>
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
