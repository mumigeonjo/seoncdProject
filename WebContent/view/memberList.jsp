<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#historyback").click(function(){
		location.href='mumi';
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
table {
    width: 80%;
    height: 200px;
    margin-left: auto;
    margin-right: auto;
    margin-top:30px;
    padding:20px;
    
  }
   table, th, td {
    border: 1px solid #bcbcbc;
  }
  
button{
	color:black;
	text-decoration:none;
	
}
</style>
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
	<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>핸드폰번호</th>
			<th>주소</th>
			<th><button type="button" id="historyback" name="historyback">뒤로가기</button></th>
		</tr>
		<c:forEach var="dto" items="${requestScope.list}">
			<tr>
				<th>${dto.memberID}</th>
				<th>${dto.pwd }</th>
				<th>${dto.name }</th>
				<th>${dto.phone }</th>
				<th>${dto.addr }</th>
				<th><a href="${pageContext.request.contextPath}/mumi?command=adminUserDelete&memberID=${dto.memberID}">
				<button type="button" id="deleteUser" name="deleteUser">회원삭제</button></a></th>
			</tr>
		</c:forEach>
	</table>
	
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