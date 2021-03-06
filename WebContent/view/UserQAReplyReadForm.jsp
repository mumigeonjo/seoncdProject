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
    <meta name="author" content="">S

    <title>Modern Business - Start Bootstrap Template</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/modern-business.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
	<script>

	function insertAnswer(bIndexNo){	

			$("#insertcommand"+bIndexNo).val("adminQAReplyForm");
			$("#insertForm"+bIndexNo).submit();

	}

	function updateAnswer(bIndexNo){	

			$("#requestcommand"+bIndexNo).val("adminQAReplyUpdateForm");
			$("#requestForm"+bIndexNo).submit();
			
	}	
	
	$(function(){
		$("#btndiv").css({"margin-left":"250px"})
	})
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
      <h1 class="mt-4 mb-3">Question Detail
      </h1>

      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="index.html">Home</a>
        </li>
        <li class="breadcrumb-item active">
          QuestionDetail
        </li>
      </ol>
      <div class="mb-4" id="accordion" role="tablist" aria-multiselectable="true">
 		
  	 	<form name="userQAReplyRead">
  	 	  <fieldset style="text-align: center;">
  	 	    <font style = "vertical-align : inherit; font-size:20pt;">DetailView</font>
   			  <div>
			    <label for="exampleTextarea">Question 제목</label>
			    <textarea class="form-control" id="bTitle" name="bTitle" rows="1" disabled="disabled">${userQAread.bTitle}</textarea>
			  </div>
			  
			  <div style="margin:0px 0px 10px">
			    <label for="exampleTextarea">Question 내용</label>
			    <textarea class="form-control" id="bContent" name="bContent" rows="3" disabled="disabled">${userQAread.bContent}</textarea>
			  </div>
	
			  <div style="margin:0px 0px 10px">
			    <label for="exampleTextarea">Answer 내용</label>
			    <textarea class="form-control" id="qContent" name="qContent" rows="1">${readAnswer.qContent}</textarea>
			  </div>
			  
			  <div style="margin:0px 0px 10px">
			    <label for="exampleTextarea">Answer 날짜</label>
			    <textarea class="form-control" id="qDate" name="qDate" rows="1" disabled="disabled">${readAnswer.qDate}</textarea>
			  </div>
  	 	  </fieldset>
  	 	</form>
  	 	<div id="btndiv">
  	 	<c:if test="${id eq 'admin'}"> 
			<form name ="insertForm" id="insertForm${userQAread.bIndexNo}" method=post action="${path}/mumi" style = "float:left;">
				 <input type=hidden name="bIndexNo" value="${userQAread.bIndexNo}">
				 <input type=hidden id="insertcommand${userQAread.bIndexNo}" name="command" value="">
		 		 <input type=button name="btn" value="답변추가" class = "btn btn-primary" style = "vertical-align : inherit;" onClick="javascript:insertAnswer(${userQAread.bIndexNo});"> 
		 		 
			</form>
		</c:if> 
  	 	<c:if test="${id eq 'admin'}"> 
			<form name ="requestForm" id="requestForm${userQAread.bIndexNo}" method=post action="${path}/mumi" style = "float:left;" >
				 <input type=hidden name="qIndexNo" value="${readAnswer.qIndexNo}">	
				 <input type=hidden name="qContent" value="${readAnswer.qContent}">	         				          
				 <input type=hidden id="requestcommand${userQAread.bIndexNo}" name="command" value="">
		 		 <input type=button name="btn" value="답변수정" class = "btn btn-primary" style = "vertical-align : inherit;" 
		 		 onClick="javascript:updateAnswer(${userQAread.bIndexNo});">
			</form>
		</c:if> 
		</div>
  	 	
 
  
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
