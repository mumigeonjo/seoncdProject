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
<link href="${path}/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${path}/css/modern-business.css" rel="stylesheet">
<SCRIPT type="text/javascript">
	
		function sendUpdate(rIndexNo){
			
			$("#command"+rIndexNo).val("userReiveUpdate");
			$("#requestForm"+rIndexNo).submit();	
		}
			
		function UserSendDelete(rIndexNo){	
	
			if (confirm("정말 삭제하시겠습니까?")==true){
				$("#command"+rIndexNo).val("userReviewDelete");
				$("#requestForm"+rIndexNo).submit();

			}
	
			return;	 	
		}	
		
		function adminSendDelete(rIndexNo){	
			if (confirm("정말 삭제하시겠습니까?")==true){
					$("#command"+rIndexNo).val("adminReviewDelete");
					$("#requestForm"+rIndexNo).submit();
			}
	
			return;	 	
		}	
				
	</script>

</head>

<body>
	<!-- Navigation -->
	<nav
		class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="index.html">Start Bootstrap</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="about.html">About</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="services.html">Services</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="contact.html">Contact</a>
					</li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownPortfolio" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> Portfolio </a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdownPortfolio">
							<a class="dropdown-item" href="portfolio-1-col.html">1 Column
								Portfolio</a> <a class="dropdown-item" href="portfolio-2-col.html">2
								Column Portfolio</a> <a class="dropdown-item"
								href="portfolio-3-col.html">3 Column Portfolio</a> <a
								class="dropdown-item" href="portfolio-4-col.html">4 Column
								Portfolio</a> <a class="dropdown-item" href="portfolio-item.html">Single
								Portfolio Item</a>
						</div></li>
					<li class="nav-item active dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							Blog </a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdownBlog">
							<a class="dropdown-item" href="blog-home-1.html">Blog Home 1</a>
							<a class="dropdown-item" href="blog-home-2.html">Blog Home 2</a>
							<a class="dropdown-item active" href="blog-post.html">Blog
								Post</a>
						</div></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							Other Pages </a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdownBlog">
							<a class="dropdown-item" href="full-width.html">Full Width
								Page</a> <a class="dropdown-item" href="sidebar.html">Sidebar
								Page</a> <a class="dropdown-item" href="faq.html">FAQ</a> <a
								class="dropdown-item" href="404.html">404</a> <a
								class="dropdown-item" href="pricing.html">Pricing Table</a>
						</div></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Page Content -->
	<div class="container">

		<!-- Page Heading/Breadcrumbs -->
		<h1 class="mt-4 mb-3">
			Post Title <small>by <a href="#">Start Bootstrap</a>
			</small>
		</h1>

		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="index.html">Home</a></li>
			<li class="breadcrumb-item active">Blog Home 2</li>
		</ol>

		<div class="row">

			<!-- Post Content Column -->
			<div class="col-lg-8">

				<!-- Preview Image -->
				<img class="img-fluid rounded" src="http://placehold.it/900x300"
					alt="">

				<hr>

				<!-- Date/Time -->


				<hr>

				<!-- Post Content -->
				<p class="lead">Lorem ipsum dolor sit amet, consectetur
					adipisicing elit. Ducimus, vero, obcaecati, aut, error quam
					sapiente nemo saepe quibusdam sit excepturi nam quia corporis
					eligendi eos magni recusandae laborum minus inventore?</p>



				<blockquote class="blockquote">
					<p class="mb-0">Lorem ipsum dolor sit amet, consectetur
						adipiscing elit. Integer posuere erat a ante.</p>
					<footer class="blockquote-footer">
						Someone famous in <cite title="Source Title">Source Title</cite>
					</footer>
				</blockquote>



				<hr>


				<!-- Comments Form -->
				<div class="card my-4">
					<h5 class="card-header">review</h5>
					<div class="card-body">
						<c:if test="${sessionScope.id} not empty">
							<c:if test="${sessionScope.id ne 'admin'}">
								<div>
									<span style="font-size: 15pt;"> <a
										href="${pageContext.request.contextPath}/view/review.jsp">등록하기</a>
								</div>
							</c:if>
							</c:if>
						
						<!-- ------------------------------------------------------------------------ -->

						<c:forEach items="${requestScope.list}" var="list"	varStatus="status">



							<div data-toggle="collapse" data-parent="#accordion"
								href="#${list.rIndexNo}" aria-expanded="true"
								aria-controls="collapseOne">${status.count}
								
								제목 : ${list.rContent} 글쓴이 : ${list.memberID} 별점 :${list.rRate}</div>

							<!-- 유저 수정삭제 -->
							<c:if test="${sessionScope.id eq list.memberID}">
								<form name="requestForm" id="requestForm${list.rIndexNo}"
									method=post action="${path}/mumi?command=userReviewDelete&rIndexNo="+${list.rIndexNo}>
									<input type=hidden id="command${list.nIndexNo}"
										name="command" value=""> <input type=button value="수정"
										class="btn btn-primary" style="vertical-align: inherit;"
										onClick="javascript:userSendUpdate(${list.rIndexNo});">
									<input type=button value="삭제" class="btn btn-primary"
										style="vertical-align: inherit;"
										onClick="javascript:userSendDelete(${list.rIndexNo});">
								</form>
							</c:if>

							<!-- 관리자 삭제버튼! -->
							<c:if test="${id eq 'admin'}">
								<form name="requestForm" id="requestForm${list.rIndexNo}"
									method=post action="${path}/mumi?command=adminReviewDelete&rIndexNo=${list.rIndexNo}">
									<input type=hidden id="command${list.rIndexNo}"
										name="command" value=""> <input type=button value="삭제"
										class="btn btn-primary" style="vertical-align: inherit;"
										onClick="javascript:adminSendDelete(${list.rIndexNo});">

								</form>
							</c:if>
						</c:forEach>

					</div>
				</div>
			</div>
		</div>

		<!-- Sidebar Widgets Column -->
		<div class="col-md-4">

			<!-- Search Widget -->
			<div class="card mb-4">
				<h5 class="card-header">Search</h5>
				<div class="card-body">
					<div class="input-group">
						<input type="text" class="form-control"
							placeholder="Search for..."> <span
							class="input-group-btn">
							<button class="btn btn-secondary" type="button">Go!</button>
						</span>
					</div>
				</div>
			</div>



		</div>

	</div>
	<!-- /.row -->

	</div>


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
