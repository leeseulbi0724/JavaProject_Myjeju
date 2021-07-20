<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
<title>스토어 | JEJU ISLAND</title>
<link rel = "stylesheet" href = "http://localhost:9000/myjeju/css/index.css">
<link rel = "stylesheet" href = "http://localhost:9000/myjeju/css/store/store.css">
<script src="http://localhost:9000/myjeju/js/jquery-3.6.0.min.js"></script>
<style>
	.store_nav>ul>li>a {
		border : 1px solid lightgray;
	}
	
	.store_nav a.on {
		border-bottom : 2px solid #4fa9de;
	}

</style>
<script>
	$(document).ready(function() {
		$('.store_nav a').click(function() {
			$('.store_nav li').removeClass()
				$(this).addClass('on')
		});
	});
</script>
</head>
<body>
	<!-- Header -->
	<jsp:include page = "../header.jsp"></jsp:include>
	
	
	<!-- Content -->
<section>
	<div class = "storesouve">
		<div><h3>스토어</h3></div>
		
		<div class = "store_nav">
			<ul>
			  <li><a href="store.do">전체</a></li>
			  <li><a href="store_eat.do">식품</a></li>
			  <li><a href="store_souve.do">기념품</a></li>
			  <li><a href="store_etc.do">잡화</a></li>
			</ul>
		</div>
	
		<div class = "store_souve_list">
			<c:forEach var = "souve" items = "${souvelist}">
				<ul>
					<li>
						<a href = "store_content.do?sid=${souve.sid}">
						<img src = "http://localhost:9000/myjeju/images/store/${souve.s_image}" width = "260">
						<p>[${souve.s_category}] ${souve.s_name}</p>
						
						<c:choose>
							<c:when test = "${souve.star_avg <= 1}">
								<img src = "http://localhost:9000/myjeju/images/travel/star.png" class = "star_img">
								<span class = "star_avg">${souve.star_avg}</span>
							</c:when>
							<c:when test = "${souve.star_avg <= 1.5}">
								<img src = "http://localhost:9000/myjeju/images/travel/star1.png" class = "star_img">
								<span class = "star_avg">${souve.star_avg}</span>
							</c:when>
							<c:when test = "${souve.star_avg <= 2.5}">
								<img src = "http://localhost:9000/myjeju/images/travel/star2.png" class = "star_img">
								<span class = "star_avg">${souve.star_avg}</span>
							</c:when>
							<c:when test = "${souve.star_avg <= 3.5}">
								<img src = "http://localhost:9000/myjeju/images/travel/star3.png" class = "star_img">
								<span class = "star_avg">${souve.star_avg}</span>
							</c:when>
							<c:when test = "${souve.star_avg <= 4.5}">
								<img src = "http://localhost:9000/myjeju/images/travel/star4.png" class = "star_img">
								<span class = "star_avg">${souve.star_avg}</span>
							</c:when>
							<c:when test = "${souve.star_avg <= 5}">
								<img src = "http://localhost:9000/myjeju/images/travel/star5.png" class = "star_img">
								<span class = "star_avg">${souve.star_avg}</span>
							</c:when>
						</c:choose>
						</a>
					</li>
				</ul>
			</c:forEach>	
		</div>
	</div>
</section>	


	<!-- Footer -->
	<jsp:include page = "../footer.jsp"></jsp:include>
</body>
</html>