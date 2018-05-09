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
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/modern-business.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>

    <script type="text/javascript">
    	function sendUpdate() {
    	    var f = window.document.userQAUpdateForm;
    		
    		if ( f.bTitle.value == "") {
    		    alert( "Question 제목을 입력해주세요" );
    		    f.bTitle.focus();
    			return false;
    	    }
    		if ( f.bContent.value == "" ) {
    			alert( "Question 내용을 입력해주세요" );
    			f.bContent.focus();
    			return false;
    		}
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
                <a class="dropdown-item" href="faq.html">FAQ</a>
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
      <h1 class="mt-4 mb-3">Question Answer수정하기
      </h1>

      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="index.html">Home</a>
        </li>
        <li class="breadcrumb-item active">
          Question
        </li>
      </ol>

      <div class="mb-4" id="accordion" role="tablist" aria-multiselectable="true">
 	<form  name ="requestForm" id="requestForm" method=post action="${path}/mumi?command=adminQAReplyUpdate" >
  	 	<!-- <form name="userQAUpdateForm" method="post" action="mumi?command=userQAReplyUpdate" onSubmit='return sendUpdate()'> -->
  	 	  <fieldset style="text-align: center;">
  	 	    <font style = "vertical-align : inherit; font-size:20pt;"> 양식 </font>
			  <div style="margin:0px 0px 10px">
			    <label for="exampleTextarea">Question Answer 내용</label>
			    <textarea class="form-control" id="qContent" name="qContent" rows="3">${userQAReplyUpdate.qContent}</textarea>
			  </div>
<%--   	 	  	  <input type=hidden name="qIndexNo" value="${userQAReplyUpdate.qIndexNo}">
  	 	  	  <input type=hidden name="qContentUpdate" value="$('#qContent').val()"> --%>
  	 	  	  
<%--   	 	  	  <input type=hidden name="qDate" value="${userQAReplyUpdate.qDate}"> --%>

<!--   	 	  	  <button type = "submit" class = "btn btn-primary" style = "vertical-align : inherit;">수정하기</button> -->
  	 	  	  
  	 	  	   
	          		  <input type=hidden name="qIndexNo" id="qIndexNo" value="${userQAReplyUpdate.qIndexNo}">		
		        	<button type = "submit" class = "btn btn-primary" style = "vertical-align : inherit;">수정하기</button>
		      
		        
  	 	  </fieldset>
  	 	<!-- </form> -->
  	 	
  	 	  </form>
  
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
