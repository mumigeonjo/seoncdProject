<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<c:set var="path" value="${pageContext.request.contextPath}"
	scope="application" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#historyback").click(function(){
		window.history.back();
	})
})
</script>
<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/modern-business.css"
	rel="stylesheet">
<style>
#footer {
    position:absolute;
    bottom:0;
    width:100%;
    height:70px;   
    background:#ccc;
}

#registerForm {
	  padding:20px;
	  text-align: center;
}
table {
    width: 400px;
    height: 400px;
    margin-left: auto;
    margin-right: auto;
    margin-top:50px;
  }
   table, th, td {
    border: 1px solid #bcbcbc;
  }
</style>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<!-- Navigation 1 -->
	<nav
		class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand"
				href="${pageContext.request.contextPath}/index.html">MuMiGeonJo-BACKPACKS</a>


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
						href="${pageContext.request.contextPath}/mumi?command=userUpdateForm">회원정보
							수정</a></li>

					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/cartRead">장바구니</a></li>

					<%
						}
						}
					%>

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
	<form method="post" action="${pageContext.request.contextPath}/mumi?command=userJoin" id="registerForm">
		<table>
			<tr>
				<th>아이디</th>
				<th><input type="text" name="id" id="id"></th>
			</tr>

			<tr>
				<th>비밀번호</th>
				<th><input type="text" name="pwd" id="pwd"></th>
			</tr>

			<tr>
				<th>이름</th>
				<th><input type="text" name="name" id="name"></th>
			</tr>

			<tr>
				<th>핸드폰번호</th>
				<th><input type="text" name="phone" id="phone"></th>
			</tr>

			<tr>
				<th>주소</th>
				<th><input type="text" name="addr" id="addr"></th>
			</tr>
			<tr>
				<th><button>제출</button></th>
				<th><button type="button" id="historyback">뒤로가기</button></th>
			</tr>
		</table>
		
	</form>
	<!-- Footer -->
	<footer class="py-5 bg-dark" id="footer">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; 무미건조</p>
		</div>
		<!-- /.container -->
	</footer>
	<!-- Footer end -->


	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- Bootstrap core JavaScript end -->
</body>
</html>