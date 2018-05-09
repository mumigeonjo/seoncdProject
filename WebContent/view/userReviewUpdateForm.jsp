<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="path" value="${pageContext.request.contextPath}"
	scope="application" />
<!DOCTYPE html>

<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Modern Business - Start Bootstrap Template</title>

<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/modern-business.css" rel="stylesheet">

<!-- <script type="text/javascript">
    	function sendInsert() {
    	    var f = window.document.noticeForm;
    		
    		if ( f.nTitle.value == "") {
    		    alert( "공지사항 제목을 입력해주세요" );
    		    f.nTitle.focus();
    			return false;
    	    }
    		if ( f.nContent.value == "" ) {
    			alert( "공지사항 내용을 입력해주세요" );
    			f.nContent.focus();
    			return false;
    		}
		}
    	
    </script> -->

</head>

<body>
	<!-- Navigation 1 -->
	<nav
		class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="index.html">MuMiGeonJo-BACKPACKS</a>


			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="about.html">Login</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="services.html">Register</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="contact.html">Mypage</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="contact.html">Cart</a>
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
                <a class="dropdown-item" href="full-width.html">Fuzll Width Page</a>
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
		style="top: 0px; height: 200px">

		<div class="container" style="vertical-align: middle">

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
					<li class="nav-item"><a class="nav-link" href="about.html">About
							Us</a></li>
					<!--             
            <li class="nav-item">
              <a class="nav-link" href="services.html">뭐야</a>
            </li>
      -->

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownPortfolio" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> Online Shop </a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdownPortfolio">
							<a class="dropdown-item" href="portfolio-1-col.html">1 Column
								Portfolio</a> <a class="dropdown-item" href="portfolio-2-col.html">2
								Column Portfolio</a> <a class="dropdown-item"
								href="portfolio-3-col.html">Backpacks</a> <a
								class="dropdown-item" href="portfolio-4-col.html">4 Column
								Portfolio</a> <a class="dropdown-item" href="portfolio-item.html">Single
								Portfolio Item</a>
						</div></li>
					<!--             
            <li class="nav-item">
              <a class="nav-link" href="contact.html">Community</a>
            </li>    
 			-->
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							Community </a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdownBlog">
							<a class="dropdown-item" href="blog-home-1.html">Notice</a> <a
								class="dropdown-item" href="blog-home-2.html">Blog Home 2</a> <a
								class="dropdown-item" href="blog-post.html">Blog Post</a>
						</div></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							Customer Support </a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdownBlog">
							<a class="dropdown-item" href="full-width.html">Info</a> <a
								class="dropdown-item" href="sidebar.html">Sidebar Page</a> <a
								class="dropdown-item" href="faq.html">FAQ</a> <a
								class="dropdown-item" href="404.html">404</a> <a
								class="dropdown-item" href="pricing.html">Pricing Table</a>
						</div></li>
				</ul>
			</div>
		</div>
		<br>
	</nav>
	<!-- Navigation 2 end -->

	<!-- Page Content -->
	<div class="container">

		<!-- Page Heading/Breadcrumbs -->
		<h1 class="mt-4 mb-3">review</h1>

		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="../index.html">Home</a></li>
			<li class="breadcrumb-item active">Notice</li>
		</ol>

		<div class="mb-4" id="accordion" role="tablist"
			aria-multiselectable="true">

			<form name="reviewForm" method="post"
				action="${pageContext.request.contextPath}/mumi?command=userReviewUpdate&rIndexNo=${requestScope.dto.rIndexNo}"
				onSubmit='return sendInsert()'>
				<fieldset style="text-align: center;">
					<font style="vertical-align: inherit; font-size: 20pt;"> 양식
					</font>
					<form>
						<p>Please select your preferred contact method:</p>
						<div>
							<input type="radio" id="rRate1" name="rRate"
								value="1"> <label for="contactChoice1">★</label>
							
							<input type="radio" id="rRate2" name="rRate"
								value="2"> <label for="contactChoice2">★★</label>
							
							<input type="radio" id="rRate3" name="rRate"
								value="3"> <label for="contactChoice3">★★★</label>
							
							<input type="radio" id="rRate1"" name="rRate"
								value="4"> <label for="contactChoice4">★★★★</label>
							
							<input type="radio" id="rRate1"" name="rRate"
								value="5"> <label for="contactChoice5">★★★★★</label>
						</div>
					</form>

			

					<input type="hidden" name="pCode" value="${requestScope.pCode}"></input>
					<div style="margin: 0px 0px 10px">
						<label for="exampleTextarea">review 내용</label>
						<textarea class="form-control" id="rContent" name="rContent"
							rows="3">${requestScope.dto.rContent }
							</textarea>
 					</div>
					<div>
						<input type="hidden" id="memberId" name="memberId" value="${requestScope.memberId}">
					</div>

					<div>
						<!--   <form method="post"  action="UpLoad" enctype="multipart/form-data" >
			    <input type="file" name="file" /><p> -->
			</form>
		</div>
		<button type="submit" class="btn btn-primary"
			style="vertical-align: inherit;">저장하기</button>

		</fieldset>
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
	<script src="../vendor/jquery/jquery.min.js"></script>
	<script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
