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
<title>Insert title here</title>
<c:set var="path" value="${pageContext.request.contextPath}"
	scope="application" />
<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/modern-business.css"
	rel="stylesheet">
	
<style>
#footer {
	position: fixed;
	left: 0px;
	bottom: 0px;
	width: 100%;
	text-align: center;
}
#loginForm {
	  padding:20px;
	  text-align: center;
}
table {
    width: 400px;
    height: 200px;
    margin-left: auto;
    margin-right: auto;
    margin-top:180px;
  }
   table, th, td {
    border: 1px solid #bcbcbc;
  }
</style>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">

function check(){
	var forms = document.getElementById("loginForm");
	var id=loginForm.id.value;
	var password=loginForm.pwd.value;
	
	if(id.length == 0){
		alert("아이디를 입력하세요.");
		loginForm.id.focus();
		return false;
	}
	if(password.length == 0){
		alert("비밀번호를 입력하세요.");
		loginForm.pwd.focus();
		return false;
	} 
	
	return true;
}

$(document).ready(function(){
	$("#historyback").click(function(){
		window.history.back();
	})
})
</script>
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
<form method="post" action="${pageContext.request.contextPath}/mumi?command=userLogin" id="loginForm" onsubmit="return check()">
<table>

<tr>
	<th>아이디</th>
	<th><input type="text" id="id" name="id"></th>
</tr>
<tr>
	<th>비밀번호</th>
	<th><input type="text" id="pwd" name="pwd"></th>
</tr>
<tr>
	<th><button>로그인</button></th>
	<th><button type="button" id="historyback" name="historyback">뒤로 가기</button></th>
</tr>
</table>
<br>
<h4> ${requestScope.errorMsg}</h4>
</form>
	  <!-- Footer -->
   <footer class="py-5 bg-dark" id="footer" >
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