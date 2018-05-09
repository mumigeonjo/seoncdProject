<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
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
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
	<!-- Custom styles for this template -->
	<link href="${path}/css/modern-business.css"  rel="stylesheet">

  </head>

  <body>

    <!-- Navigation 1 -->
   <nav
      class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
         <a class="navbar-brand"
            href="${path}/index.html">MuMiGeonJo-BACKPACKS</a>


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
                  href="${pageContext.request.contextPath}/mumi?command=userOrderlistRead">주문내역</a></li>

               <li class="nav-item"><a class="nav-link"
                  href="${pageContext.request.contextPath}/mumi?command=cartRead">장바구니</a></li>
                  
               <li class="nav-item"><a class="nav-link"
                  href="${pageContext.request.contextPath}/mumi?command=userUpdateForm">회원정보수정</a></li>
               <%
                  }
                  }
               %>
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
         </div>

         <div class="collapse navbar-collapse" id="navbarResponsive" >
            <ul class="nav navbar-nav" style="position: absolute; left: 50%; transform: translatex(-50%);z-index:100">  
               <li class="nav-item"><a class="nav-link" href="${path}/view/aboutUs.jsp">About Us</a></li>
               <li class="nav-item dropdown"><a
                  class="nav-link dropdown-toggle" href="#"
                  id="navbarDropdownPortfolio" data-toggle="dropdown"
                  aria-haspopup="true" aria-expanded="false"> Online Shop </a>
                  <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPortfolio">
                    <a class="dropdown-item" href="${path}/mumi?command=userProductAllRead"> Backpacks</a> 
                  </div></li>
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
   
   
   
    <!-- Page Content -->
    <div class="container">

      <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">BACKPACK
        <small>detail view</small>
      </h1>

      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="mumi?command=userProductAllRead">backpacks</a>
        </li>
        <!-- <li class="breadcrumb-item active">Blog Home 2</li> -->
      </ol>

      <!-- Portfolio Item Row -->
      <div class="row">
        <div class="col-md-8">
          <img class="img-fluid" src="${path}/saveImg/${list[0].pImage}" alt="">
        </div>

        <div class="col-md-4">
          <h1 class="my-3">${list[0].pName}</h1>
          <h4 class="my-3">상품 정보</h4>
 
    
          <ul>
      <c:choose>
      <c:when test="${empty requestScope.list}">
      </c:when>
      <c:otherwise>
      <c:forEach items="${requestScope.list}" var="proDto">  
            <li><fmt:formatNumber value="${proDto.pPrice}"/> / ${proDto.pSize}</li>

 	  </c:forEach>
	  </c:otherwise>
	  </c:choose>  
	        <li>제작일 : ${list[0].pDate}</li>
          </ul>
          <h6>
          상품을 구매하시려면 장바구니를 클릭해주세요<p>
          수량, 사이즈 옵션을 선택할 수 있습니다.<p>
          </h6>
          <a class="btn btn-primary" href="#">장바구니
            <span class="glyphicon glyphicon-chevron-right"></span>
          </a>          
        </div>
      </div>
      <!-- /.row -->
  
      <hr>
  
      <!-- Portfolio Item Row -->
      <div class="row">
        <div class="col-md-12">
          <img class="img-fluid" src="${path}/saveImg/${list[0].pDetailImage}" alt="">
        </div>
      </div>
      <!-- /.row -->
      	  
      <div class="row">

        <!-- Post Content Column -->
        <div class="col-lg-12">


          <!-- Preview Image -->
<%-- 
          <img class="img-fluid rounded" src="http://placehold.it/900x300" alt="">

          <hr>

          <!-- Date/Time -->
          <p>Posted on January 1, 2017 at 12:00 PM</p>

          <hr>

          <!-- Post Content -->
          <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ducimus, vero, obcaecati, aut, error quam sapiente nemo saepe quibusdam sit excepturi nam quia corporis eligendi eos magni recusandae laborum minus inventore?</p>

          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ut, tenetur natus doloremque laborum quos iste ipsum rerum obcaecati impedit odit illo dolorum ab tempora nihil dicta earum fugiat. Temporibus, voluptatibus.</p>

          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eos, doloribus, dolorem iusto blanditiis unde eius illum consequuntur neque dicta incidunt ullam ea hic porro optio ratione repellat perspiciatis. Enim, iure!</p>

          <blockquote class="blockquote">
            <p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
            <footer class="blockquote-footer">Someone famous in
              <cite title="Source Title">Source Title</cite>
            </footer>
          </blockquote>

          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Error, nostrum, aliquid, animi, ut quas placeat totam sunt tempora commodi nihil ullam alias modi dicta saepe minima ab quo voluptatem obcaecati?</p>

          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Harum, dolor quis. Sunt, ut, explicabo, aliquam tenetur ratione tempore quidem voluptates cupiditate voluptas illo saepe quaerat numquam recusandae? Qui, necessitatibus, est!</p>
 --%>

          <hr>

          <!-- Comments Form -->
          <div class="card my-4">
            <h5 class="card-header">Leave a Comment:</h5>
            <div class="card-body">
              <form>
                <div class="form-group">
                  <textarea class="form-control" rows="3"></textarea>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
              </form>
            </div>
          </div>

          <!-- Single Comment -->
          <div class="media mb-4">
            <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
            <div class="media-body">
              <h5 class="mt-0">Commenter Name</h5>
              Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
            </div>
          </div>

          <!-- Comment with nested comments -->
          <div class="media mb-4">
            <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
            <div class="media-body">
              <h5 class="mt-0">Commenter Name</h5>
              Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.

              <div class="media mt-4">
                <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
                <div class="media-body">
                  <h5 class="mt-0">Commenter Name</h5>
                  Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
                </div>
              </div>

              <div class="media mt-4">
                <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
                <div class="media-body">
                  <h5 class="mt-0">Commenter Name</h5>
                  Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
                </div>
              </div>

            </div>
          </div>

        </div>


        <!-- Sidebar Widgets Column -->
<!--       
        <div class="col-md-4">

          <!-- Search Widget -->
<!--           
          <div class="card mb-4">
            <h5 class="card-header">Search</h5>
            <div class="card-body">
              <div class="input-group">
                <input type="text" class="form-control" placeholder="Search for...">
                <span class="input-group-btn">
                  <button class="btn btn-secondary" type="button">Go!</button>
                </span>
              </div>
            </div>
          </div>
 -->

          <!-- Categories Widget -->
  <!--         
          <div class="card my-4">
            <h5 class="card-header">Categories</h5>
            <div class="card-body">
              <div class="row">
                <div class="col-lg-6">
                  <ul class="list-unstyled mb-0">
                    <li>
                      <a href="#">Web Design</a>
                    </li>
                    <li>
                      <a href="#">HTML</a>
                    </li>
                    <li>
                      <a href="#">Freebies</a>
                    </li>
                  </ul>
                </div>
                <div class="col-lg-6">
                  <ul class="list-unstyled mb-0">
                    <li>
                      <a href="#">JavaScript</a>
                    </li>
                    <li>
                      <a href="#">CSS</a>
                    </li>
                    <li>
                      <a href="#">Tutorials</a>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
 -->

          <!-- Side Widget -->
<!--           
          <div class="card my-4">
            <h5 class="card-header">Side Widget</h5>
            <div class="card-body">
              You can put anything you want inside of these side widgets. They are easy to use, and feature the new Bootstrap 4 card containers!
            </div>
          </div>  
        
          
        </div>
   -->
   
           
      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->

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
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>

</html>
