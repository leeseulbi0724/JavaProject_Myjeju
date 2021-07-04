<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
	<title>관광지 | JEJU ISLAND</title>
	<link rel="stylesheet" href="http://localhost:9000/myjeju/css/index.css">
	<link rel="stylesheet" href="http://localhost:9000/myjeju/css/travel/travel.css">
	<script src="http://localhost:9000/myjeju/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<!-- header -->
	<jsp:include page="../header.jsp"></jsp:include>
	
	<!-- content -->
	<div class="travel_content">
		<h3>관광지</h3>
		<section class="recommend_zone">
			<div class="travel_title">추천 관광지</div>
			<div class="travel_spot">
				<article class="travel_spot1">
					<img src="http://localhost:9000/myjeju/images/travel/한라산.jpg">
					<p>한라산</p>
				</article>
				<article class="travel_spot2">
					<img src="http://localhost:9000/myjeju/images/travel/성산일출봉.jpg">
					<p>성산일출봉</p>
				</article>
				<article class="travel_spot3">
					<img src="http://localhost:9000/myjeju/images/travel/비자림.jpg">
					<p>비자림</p>
				</article>
			</div>
		</section>
		<section class="map_zone">
			
		</section>
		<section class="">
			
		</section>
	</div>
	<!-- footer -->
	<jsp:include page="../footer.jsp"></jsp:include>
	
</body>
</html>