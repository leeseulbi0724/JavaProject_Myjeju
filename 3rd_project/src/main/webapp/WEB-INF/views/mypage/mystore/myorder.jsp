<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
<title>결제 내역 | JEJU ISLAND</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" ></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/index.css">
<script src="http://localhost:9000/myjeju/js/jquery-3.6.0.min.js"></script>
<style>
	section { text-align:center; margin-bottom:50px; }
	.center { 
		margin-top:80px; 
		width:1000px; 
		display:inline-block; 
	}
	
	.title { 
		display:inline-block;
		width:100%;
		background-color:rgb(248,249,251); 
		border:1px solid lightgray;
		text-align:right;
	}	
	.store { background-color:rgb(175,182,196); color:white; float:left; font-weight:bold; border:none; padding:10px; }
	.reservation { background-color:rgb(248,249,251);  color:rgb(175,182,196); float:left; font-weight:bold; border:none; padding:10px; }
	.select { background-color:rgb(82,95,120); color:white; padding:2px; font-size:14px; border:none; border-radius:4px; }
	
	.title .form-control { display:inline-block; width:150px; font-size:13px; margin-top:5px; }
	
	.content {
		border-top:1px solid lightgray;
		display:inline-block;
		width:100%; 
		margin-top:50px;
		text-align:center;
	}
	.content>p { 
		background-color:white; 
		border:1px solid lightgray;
		border-radius:50px; 
		display:inline-block; 
		padding:10px 20px; 
		margin-top:-20px;
	}
	.reservation_content { display:none; }
	
	.box { display:inline-block; width:900px; border-bottom:1px solid lightgray; padding:20px 0; }
	.box img { border:2px solid lightgray; float:left; }
	.box>p.info { color:gray; float:left; margin:15px; font-size:14px; text-align:left; }
	.box>p.date  { float:left; margin:15px 50px; font-size:14px; text-align:left; }
	.box>p.info>a { color:black; text-decoration:none; }
	.box>p.info>a:hover { text-decoration:underline; }
	.box>p.price { float:right; font-weight:bold; margin-top:25px; }
	
	.more { 
		background-color:rgb(248,249,251); 
		border:1px solid lightgray; 
		display:inline-block; 
		width:100%; height:50px; 
		margin-top:10px;
	}
	.more .img { 
		display:inline-block; width:10px; height:10px; border:1px solid gray; 
		background-image:url("http://localhost:9000/myjeju/images/mypage/plus.png");
		background-size:cover;
		margin-top:20px; 
		
	}
	.more span { font-size:14px; margin-left:5px; }
</style>
</head>
<script>
	$(document).ready(function() {
		$(".reservation").click(function() {
			$(".store_content").css("display","none");
			$(".reservation_content").css("display","block");
			$(this).css({"color":"white", "background-color":"rgb(175,182,196)"});
			$(".store").css({"color":"rgb(175,182,196)", "background-color":"rgb(248,249,251)"});
			
		});
		
		$(".store").click(function() {
			$(".store_content").css("display","block");
			$(".reservation_content").css("display","none");
			$(this).css({"color":"white", "background-color":"rgb(175,182,196)"});
			$(".reservation").css({"color":"rgb(175,182,196)", "background-color":"rgb(248,249,251)"});
		});
	});
</script>
<body>
<jsp:include page="../../header.jsp"></jsp:include>

<section>
	<div class="center">
		<div class="title">
			<button class="store">스토어 구매내역</button>
			<button class="reservation">예약 내역</button>
			<input type="date" class="form-control" value='2021-07-10'> ~ <input type="date" class="form-control" value='2021-07-10'>
			<button class="select">조회</button>
		</div>
		<div class="content store_content">
			<p>2021.07</p>
			<c:forEach var = "vo"  items="${list}">
				<div class="box">
					<img src="http://localhost:9000/myjeju/images/store/${vo.o_file }" width=100 height=80>
					<p class="info">${vo.o_date }<br>${vo.o_name }<br><span>총 ${vo.o_count }개</span></p>
					<p class="price">${vo.o_price }원</p>
				</div>
			</c:forEach>			
		</div>
		
		<div class="content reservation_content">
			<p>2021.07</p>
			<div class="box">
				<img src="http://localhost:9000/myjeju/images/house/그린나래.jpg" width=100 height=80>
				<p class="info">2021.07.10 14:57:24<br><a href="#">그린나래</a><br><span>성인 2명 | 스위트룸</span></p>
				<p class="date"><strong>예약일</strong> 2021.07.28 ~ 2021.07.30<br><strong>체크인</strong> 14:00<br><strong>체크아웃</strong> 11:00</p>
				<p class="price">98,000원</p>
			</div>
			<div class="box">
				<img src="http://localhost:9000/myjeju/images/house/그린나래.jpg" width=100 height=80>
				<p class="info">2021.07.10 14:57:24<br><a href="#">그린나래</a><br><span>성인 2명 | 스위트룸</span></p>
				<p class="date"><strong>예약일</strong> 2021.07.28 ~ 2021.07.30<br><strong>체크인</strong> 14:00<br><strong>체크아웃</strong> 11:00</p>
				<p class="price">98,000원</p>
			</div>
		</div>
		
		<div class="more">
			<div class="img"></div><span>더보기</span>
		</div>

	</div>
</section>

<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>