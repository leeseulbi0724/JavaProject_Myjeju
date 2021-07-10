<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
<title>스토어 | JEJU ISLAND</title>
<link rel = "stylesheet" href = "http://localhost:9000/myjeju/css/index.css">
<link rel = "stylesheet" href = "http://localhost:9000/myjeju/css/store/store.css">
</head>
<body>
	<!-- Header -->
	<jsp:include page = "../header.jsp"></jsp:include>
	
	<!-- Content -->
<section>	
	<div class = "storeeat">
		<div><h3>스토어</h3></div>
		
		<div class = "store_nav">
			<ul>
			  <li><a href="store.do">전체</a></li>
			  <li><a href="store_eat.do">식품</a></li>
			  <li><a href="store_souve.do">기념품</a></li>
			  <li><a href="store_etc.do">잡화</a></li>
			</ul>
		</div>
	
		<div class = "store_eat_list">
			<ul>
				<li><a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store1.png"><p>[식품] 감귤 타르트</p></a></li>
				<li><a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store2.png"><p>[식품] 제주 오메기떡</p></a></li>
				<li><a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store3.png"><p>[식품] 제주도 한라봉</p></a></li>
			</ul>
			
			<ul>
				<li><a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store1.png"><p>[식품] 감귤 타르트</p></a></li>
				<li><a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store2.png"><p>[식품] 제주 오메기떡</p></a></li>
				<li><a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store3.png"><p>[식품] 제주도 한라봉</p></a></li>
			</ul>
			
			<ul>
				<li><a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store1.png"><p>[식품] 감귤 타르트</p></a></li>
				<li><a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store2.png"><p>[식품] 제주 오메기떡</p></a></li>
				<li><a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store3.png"><p>[식품] 제주도 한라봉</p></a></li>
			</ul>
		</div>
	</div>
</section>	
	
	<!-- Footer -->
	<jsp:include page = "../footer.jsp"></jsp:include>
</body>
</html>