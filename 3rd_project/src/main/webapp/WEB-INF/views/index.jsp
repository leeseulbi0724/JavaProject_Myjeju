<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
	<title>JEJU ISLAND</title>
	<link rel="stylesheet" href="http://localhost:9000/myjeju/css/index.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="http://localhost:9000/myjeju/js/jquery-3.6.0.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="main_header">
		<div class="tap">
			<nav>
				<a href="http://localhost:9000/myjeju/index.do"><img src="http://localhost:9000/myjeju/images/index/logo3.png"></a>
				<ul>
					<li><a href="http://localhost:9000/myjeju/login.do">LOGIN </a><div></div></li>
					<li><a href="http://localhost:9000/myjeju/join.do">JOIN</a></li>
				</ul>
			</nav>
		</div>
		<div class="menu_tap">
			<ul>
				<li><a href="#">숙소</a></li>
				<li><a href="#">맛집</a></li>
				<li><a href="#">여행지</a></li>
				<li><a href="#">스토어</a></li>
				<li><a href="#">커뮤니티</a></li>
			</ul>
		</div>
	</div>
	
	<!-- content -->
	<!-- carousel 시작-->
	<div id="demo" class="carousel slide" data-ride="carousel" style="text-align:center;">

	<!-- Indicators -->
	<ul class="carousel-indicators">
	  	<li data-target="#demo" data-slide-to="0" class="active"></li>
	    <li data-target="#demo" data-slide-to="1"></li>
	    <li data-target="#demo" data-slide-to="2"></li>
	    <li data-target="#demo" data-slide-to="3"></li>
	</ul>
	  
	<!-- The slideshow -->
	<div class="carousel-inner">
		<div class="carousel-item active">
	    	<img src="http://localhost:9000/myjeju/images/index/main1.jpg" width="100%">
	    </div>
	    <div class="carousel-item">
	    	<img src="http://localhost:9000/myjeju/images/index/main2.jpg" width="100%">
	    </div>
	    <div class="carousel-item">
	    	<img src="http://localhost:9000/myjeju/images/index/main3.jpeg" width="100%">
	    </div>
	    <div class="carousel-item">
	    	<img src="http://localhost:9000/myjeju/images/index/main4.jpeg" width="100%">
	    </div>
	</div>
	  
	<!-- Left and right controls -->
	<a class="carousel-control-prev" href="#demo" data-slide="prev">
		<span class="carousel-control-prev-icon"></span>
	</a>
	<a class="carousel-control-next" href="#demo" data-slide="next">
	    <span class="carousel-control-next-icon"></span>
	</a>
	</div>
	<!-- carousel 종료-->
	 
	 
	 
	 
	<!-- footer -->
	<footer>
		
	</footer>
</body>
</html>