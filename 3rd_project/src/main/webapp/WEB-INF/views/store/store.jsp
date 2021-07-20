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
</head>
<style>
	.store_nav>ul>li>a {
		border : 1px solid lightgray;
	}
	
	.store_nav a.on {
		border-bottom : 2px solid #4fa9de;
	}
	
	.star_img {
		vertical-align : bottom;
	}
	
	.star_avg {
		vertical-align : bottom;
		margin-left : 5px;
		font-size : 20px;
		font-weight : 500;
	}
	
</style>
<script>
	$(document).ready(function() {
		$('.store_nav a').click(function() {
			$('.store_nav li').removeClass()
				$(this).addClass('on')
		});
		
		var sid = ${best.sid}.val();
		$(".click").click(function() {
			alert(sid);
		});
	});
</script>
<body>

	<!-- Header -->
	<jsp:include page = "../header.jsp"></jsp:include>
	
<section>	
	<div class = "store">
		<div><h3>스토어</h3></div>
		
		<div class = "store_nav">
			<ul>
			  <li><a href="store.do">전체</a></li>
			  <li><a href="store_eat.do">식품</a></li>
			  <li><a href="store_souve.do">기념품</a></li>
			  <li><a href="store_etc.do">잡화</a></li>
			</ul>
		</div>
		
		<div class = store_best>
			<div>
				<div><span>BEST MENU</span></div>
			</div>
				
			<c:forEach var = "best" items = "${bestlist}">
				<ul>
					<li>
						<a href = "store_content.do?sid=${best.sid}" class = "click">
							<img src = "http://localhost:9000/myjeju/images/store/${best.s_image}" width = "260">
							<p>[${best.s_category}] ${best.s_name}</p>

							<c:choose>
								<c:when test = "${best.star_avg <= 1}">
									<img src = "http://localhost:9000/myjeju/images/travel/star.png" class = "star_img">
									<span class = "star_avg">${best.star_avg}</span>
								</c:when>
								<c:when test = "${best.star_avg <= 1.5}">
									<img src = "http://localhost:9000/myjeju/images/travel/star1.png" class = "star_img">
									<span class = "star_avg">${best.star_avg}</span>
								</c:when>
								<c:when test = "${best.star_avg <= 2.5}">
									<img src = "http://localhost:9000/myjeju/images/travel/star2.png" class = "star_img">
									<span class = "star_avg">${best.star_avg}</span>
								</c:when>
								<c:when test = "${best.star_avg <= 3.5}">
									<img src = "http://localhost:9000/myjeju/images/travel/star3.png" class = "star_img">
									<span class = "star_avg">${best.star_avg}</span>
								</c:when>
								<c:when test = "${best.star_avg <= 4.5}">
									<img src = "http://localhost:9000/myjeju/images/travel/star4.png" class = "star_img">
									<span class = "star_avg">${best.star_avg}</span>
								</c:when>
								<c:when test = "${best.star_avg <= 5}">
									<img src = "http://localhost:9000/myjeju/images/travel/star5.png" class = "star_img">
									<span class = "star_avg">${best.star_avg}</span>
								</c:when>
							</c:choose>
						</a>
					</li>
				</ul>
			</c:forEach>
		</div>
		
		<div class = "store_eat">
			<div>
				<div><span>식품</span></div>
				<div><a href = "store_eat.do">더 보기 +</a></div>
			</div>
			<c:forEach var = "eat" items = "${eatlist}">
				<ul>
					<li>
						<a href = "store_content.do?sid=${eat.sid}">
							<img src = "http://localhost:9000/myjeju/images/store/${eat.s_image}" width = "260">
							<p>[${eat.s_category}] ${eat.s_name}</p>
							
							<c:choose>
								<c:when test = "${eat.star_avg <= 1}">
									<img src = "http://localhost:9000/myjeju/images/travel/star.png" class = "star_img">
									<span class = "star_avg">${eat.star_avg}</span>
								</c:when>
								<c:when test = "${eat.star_avg <= 1.5}">
									<img src = "http://localhost:9000/myjeju/images/travel/star1.png" class = "star_img">
									<span class = "star_avg">${eat.star_avg}</span>
								</c:when>
								<c:when test = "${eat.star_avg <= 2.5}">
									<img src = "http://localhost:9000/myjeju/images/travel/star2.png" class = "star_img">
									<span class = "star_avg">${eat.star_avg}</span>
								</c:when>
								<c:when test = "${eat.star_avg <= 3.5}">
									<img src = "http://localhost:9000/myjeju/images/travel/star3.png" class = "star_img">
									<span class = "star_avg">${eat.star_avg}</span>
								</c:when>
								<c:when test = "${eat.star_avg <= 4.5}">
									<img src = "http://localhost:9000/myjeju/images/travel/star4.png" class = "star_img">
									<span class = "star_avg">${eat.star_avg}</span>
								</c:when>
								<c:when test = "${eat.star_avg <= 5}">
									<img src = "http://localhost:9000/myjeju/images/travel/star5.png" class = "star_img">
									<span class = "star_avg">${eat.star_avg}</span>
								</c:when>
							</c:choose>
						</a>
					</li>
				</ul>
			</c:forEach>
		</div>
		
		<div class = "store_souve">
			<div>
				<div><span>기념품</span></div>
				<div><a href = "store_souve.do">더 보기 +</a></div>
			</div>
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
		
		<div class = "store_etc">
			<div>
				<div><span>잡화</span></div>
				<div><a href = "store_etc.do">더 보기 +</a></div>
			</div>
			<c:forEach var = "etc" items = "${etclist}">
				<ul>
					<li>
						<a href = "store_content.do?sid=${etc.sid}">
							<img src = "http://localhost:9000/myjeju/images/store/${etc.s_image}" width = "260">
							<p>[${etc.s_category}] ${etc.s_name}</p>
							
							<c:choose>
								<c:when test = "${etc.star_avg <= 1}">
									<img src = "http://localhost:9000/myjeju/images/travel/star.png" class = "star_img">
									<span class = "star_avg">${etc.star_avg}</span>
								</c:when>
								<c:when test = "${etc.star_avg <= 1.5}">
									<img src = "http://localhost:9000/myjeju/images/travel/star1.png" class = "star_img">
									<span class = "star_avg">${etc.star_avg}</span>
								</c:when>
								<c:when test = "${etc.star_avg <= 2.5}">
									<img src = "http://localhost:9000/myjeju/images/travel/star2.png" class = "star_img">
									<span class = "star_avg">${etc.star_avg}</span>
								</c:when>
								<c:when test = "${etc.star_avg <= 3.5}">
									<img src = "http://localhost:9000/myjeju/images/travel/star3.png" class = "star_img">
									<span class = "star_avg">${etc.star_avg}</span>
								</c:when>
								<c:when test = "${etc.star_avg <= 4.5}">
									<img src = "http://localhost:9000/myjeju/images/travel/star4.png" class = "star_img">
									<span class = "star_avg">${etc.star_avg}</span>
								</c:when>
								<c:when test = "${etc.star_avg <= 5}">
									<img src = "http://localhost:9000/myjeju/images/travel/star5.png" class = "star_img">
									<span class = "star_avg">${etc.star_avg}</span>
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