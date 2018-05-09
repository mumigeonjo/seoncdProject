<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< HEAD
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
=======
	pageEncoding="UTF-8"%>
>>>>>>> branch 'master' of https://github.com/mumigeonjo/seoncdProject.git
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Modern Business - Start Bootstrap Template</title>
<<<<<<< HEAD
<c:set var="path" value="${pageContext.request.contextPath}"
   scope="application" />
=======

>>>>>>> branch 'master' of https://github.com/mumigeonjo/seoncdProject.git
<!-- Bootstrap core CSS -->
<<<<<<< HEAD
<link
   href="${path}/vendor/bootstrap/css/bootstrap.min.css"
   rel="stylesheet">
=======
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
>>>>>>> branch 'master' of https://github.com/mumigeonjo/seoncdProject.git

<!-- Custom styles for this template -->
<<<<<<< HEAD
<link href="${path}/css/modern-business.css"
   rel="stylesheet">
=======
<link href="css/modern-business.css" rel="stylesheet">
>>>>>>> branch 'master' of https://github.com/mumigeonjo/seoncdProject.git
</head>

<body>
<<<<<<< HEAD
   <!-- Navigation 1 -->
   <nav
      class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
         <a class="navbar-brand"
            href="${path}/index.html">MuMiGeonJo-BACKPACKS</a>
=======
${sessionScope.id }님 환영합니다.
	<!-- Navigation 1 -->
	<nav
		class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="index.html">MuMiGeonJo-BACKPACKS</a>
>>>>>>> branch 'master' of https://github.com/mumigeonjo/seoncdProject.git


         <button class="navbar-toggler navbar-toggler-right" type="button"
            data-toggle="collapse" data-target="#navbarResponsive"
            aria-controls="navbarResponsive" aria-expanded="false"
            aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
         </button>

<<<<<<< HEAD
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


               <!--             
=======
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<% if(session.getAttribute("id")==null){ %>
					<li class="nav-item"><a class="nav-link" href="view/loginForm.jsp">Login</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="register.jsp">Register</a>
					</li>
					<%}else{  %>
					<li class="nav-item"><a class="nav-link" href="./mumi?command=userLogout">LogOut</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="contact.html">Mypage</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="contact.html">Cart</a>
					</li>
					<%} %>

					<!--             
>>>>>>> branch 'master' of https://github.com/mumigeonjo/seoncdProject.git
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
   <nav class="navbar navbar-expand-lg navbar-dark bg-dark " style="top: 0px; height: 80px;">

      <div class="container ml-auto" >

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
         <div class="collapse navbar-collapse" id="navbarResponsive" >
<!--              <ul class="navbar-nav ml-auto">   -->
            <ul class="nav navbar-nav" style="position: absolute; left: 50%; transform: translatex(-50%);z-index:100">  
               <li class="nav-item"><a class="nav-link" href="${path}/view/aboutUs.jsp">About Us</a></li>
               <!--             
            <li class="nav-item">
              <a class="nav-link" href="services.html">뭐야</a>
            </li>
      -->

               <li class="nav-item dropdown"><a
                  class="nav-link dropdown-toggle" href="#"
                  id="navbarDropdownPortfolio" data-toggle="dropdown"
                  aria-haspopup="true" aria-expanded="false"> Online Shop </a>
                  <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPortfolio">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/mumi?command=userProductAllRead"> Backpacks</a> 
                  </div></li>
               <!--             
            <li class="nav-item">
              <a class="nav-link" href="contact.html">Community</a>
            </li>    
<<<<<<< HEAD
          -->
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
=======
 			-->
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							Community </a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdownBlog">
							<a class="dropdown-item" href="mumi?command=noticeRead">Notice</a> <a
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
>>>>>>> branch 'master' of https://github.com/mumigeonjo/seoncdProject.git



<<<<<<< HEAD
   <!-- header -->
   <header>
      <div id="carouselExampleIndicators" class="carousel slide"
         data-ride="carousel">
         <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0"
               class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
         </ol>
         <div class="carousel-inner" role="listbox">
            <!-- Slide One - Set the background image for this slide in the line below -->
            <div class="carousel-item active"
               style="background-image: url('${path}/img/home2.PNG')">
               <div class="carousel-caption d-none d-md-block">
                  <h3>캠핑</h3>
                  <p>This is a description for the first slide.</p>
               </div>
            </div>
            <!-- Slide Two - Set the background image for this slide in the line below -->
            <div class="carousel-item"
               style="background-image: url('${path}/img/home3.png')">
               <div class="carousel-caption d-none d-md-block">
                  <h3>기차 여행</h3>
                  <p>This is a description for the second slide.</p>
               </div>
            </div>
            <!-- Slide Three - Set the background image for this slide in the line below -->
            <div class="carousel-item"
               style="background-image: url('${path}/img/home4.jpg')">
               <div class="carousel-caption d-none d-md-block">
                  <h3>집에 보관할때도 멋스럽게</h3>
                  <p>This is a description for the third slide.</p>
               </div>
            </div>
         </div>
         <a class="carousel-control-prev" href="#carouselExampleIndicators"
            role="button" data-slide="prev"> <span
            class="carousel-control-prev-icon" aria-hidden="true"></span> <span
            class="sr-only">Previous</span>
         </a> <a class="carousel-control-next" href="#carouselExampleIndicators"
            role="button" data-slide="next"> <span
            class="carousel-control-next-icon" aria-hidden="true"></span> <span
            class="sr-only">Next</span>
         </a>
      </div>
   </header>
   <!-- header end -->
=======
	<!-- header -->
	<header>
		<div id="carouselExampleIndicators" class="carousel slide"
			data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carouselExampleIndicators" data-slide-to="0"
					class="active"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner" role="listbox">
				<!-- Slide One - Set the background image for this slide in the line below -->
				<div class="carousel-item active"
					style="background-image: url('img/home2.PNG')">
					<div class="carousel-caption d-none d-md-block">
						<h3>캠핑</h3>
						<p>This is a description for the first slide.</p>
					</div>
				</div>
				<!-- Slide Two - Set the background image for this slide in the line below -->
				<div class="carousel-item"
					style="background-image: url('img/home3.png')">
					<div class="carousel-caption d-none d-md-block">
						<h3>기차 여행</h3>
						<p>This is a description for the second slide.</p>
					</div>
				</div>
				<!-- Slide Three - Set the background image for this slide in the line below -->
				<div class="carousel-item"
					style="background-image: url('img/home4.jpg')">
					<div class="carousel-caption d-none d-md-block">
						<h3>집에 보관할때도 멋스럽게</h3>
						<p>This is a description for the third slide.</p>
					</div>
				</div>
			</div>
			<a class="carousel-control-prev" href="#carouselExampleIndicators"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</header>
	<!-- header end -->
>>>>>>> branch 'master' of https://github.com/mumigeonjo/seoncdProject.git



   <!-- Page Content -->
   <div class="container">
      <h1 class="my-4"></h1>

<<<<<<< HEAD
      <!-- img Section -->
      <div class="row">
         <div class="col-lg-6" style="text-align:center; padding:50px 0px 0px 0px">
            <h2></h2>
            <h2><strong>여행하는 즐거움</strong></h2>
            <p><strong><span style="font-size: 20px;"><u>우리가 무미건조를 선택하는 이유</u></span></strong></p>
            
 <!--            <ul>
               <li>장기간 여행에 최적화</li>
               <li>다양한 착용법</li>
               <li>최고급 품질</li>
               <li>킬리만의 멋스러운 디자인</li>
            </ul> -->
               장기간 여행에 최적화<br>
               다양한 착용법<br>
               최고급 품질<br>
               킬리만의 멋스러운 디자인<br>
            
         </div>
         <div class="col-lg-6">
            <img class="img-fluid rounded"
               src="${path}/img/P002.jpg" alt="">
         </div>
         <div class="col-lg-6">
            <img class="img-fluid rounded"
               src="${path}/img/P003.jpg" alt="">
         </div>
         <br>
         <div class="col-lg-6">
            <img class="img-fluid rounded"
               src="${path}/img/P004.jpg" alt="">
         </div>
         <br>
      </div>
      <!-- img Section end -->
=======
		<!-- img Section -->
		<div class="row">
			<div class="col-lg-6">
				<h2></h2>
				<h2>여행하는 즐거움</h2>
				<p>우리가 킬리를 선택하는 이유:</p>
				<ul>
					<li>장기간 여행에 최적화</li>
					<li>다양한 착용법</li>
					<li>최고급 품질</li>
					<li>킬리만의 멋스러운 디자인</li>
				</ul>
			</div>
			<div class="col-lg-6">
				<img class="img-fluid rounded" src="img/P002.jpg" alt="">
			</div>
			<div class="col-lg-6">
				<a href="mumi?command=userReviewRead&pCode=P003M">
				<img class="img-fluid rounded" src="img/P003.jpg" alt="">
			</div>
			<br>
			<div class="col-lg-6">
				<a href="mumi?command=userReviewRead&pCode=P001M">
				          <img class="img-fluid rounded" src="img/P004.jpg" alt=""></a>
				
			</div>
			<br>
		</div>
		<!-- img Section end -->
>>>>>>> branch 'master' of https://github.com/mumigeonjo/seoncdProject.git

      <hr>

      <!-- Call to Action Section -->
      <div class="row mb-4">
         <!--       
        <div class="col-md-8">
          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Molestias, expedita, saepe, vero rerum deleniti beatae veniam harum neque nemo praesentium cum alias asperiores commodi.</p>
        </div>
       -->
         <div style="text-align:right; width:100%; padding:0px 20px 0px 0px">
            <a class="btn btn-lg btn-secondary" href="#">Top</a>
         </div>
      </div>
      <!-- Call to Action Section end-->

   </div>
   <!-- Page Content end -->


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
   <script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
   <script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
   <!-- Bootstrap core JavaScript end -->


</body>
</html>