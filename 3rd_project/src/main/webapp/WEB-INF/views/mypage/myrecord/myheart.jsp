<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <c:set var = "house" value = "${fn:length(h_list) }" />
    <c:set var = "cafe" value = "${fn:length(ca_list) }" />
    <c:set var = "food" value = "${fn:length(f_list) }" />
    <c:set var = "travel" value = "${fn:length(t_list) }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
<title>My 좋아요 | JEJU ISLAND</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/index.css">
<script src="http://localhost:9000/myjeju/js/jquery-3.6.0.min.js"></script>
<style>
	section { text-align:center; margin-bottom:50px;  }
	.center { 
		margin-top:100px; 
		width:900px; 
		display:inline-block; 
	}
	h3 { 
		border-bottom:5px solid #4fa9de; 
		font-size:20px; 
		font-weight:bold; 
		display:inline-block;
	}	
	p { float:left; }
	p>span { font-weight:bold; }
	
	.list_box { margin-top:40px; text-align:center; }
	.list_box>div { display:inline-block; border:1px solid lightgray; width:200px; height:200px; margin-top:50px; }
	
	.btn_style5{
		width:65px;
		background-color:white;
		border:2px solid lightgray;
		border-radius:50px;
		padding:10px;
		color:lightgray;
		font-size:15px;
		font-weight:bold;
		text-align:center;
		margin-top:50px;
		cursor:pointer;
	}
	.btn_style5:hover{
		border:2px solid #4fa9de;
		color:#4fa9de;
	}
	button#more_btn>img { width:18px; }
	button#more_btn>img:last-child { display:none; }
	button#more_btn:hover img:first-child {	display:none; }
		button#more_btn:hover img:last-child { display:inline-block; }
</style>
</head>
<body>
<jsp:include page="../../header.jsp"></jsp:include>

<section>
	<div class="center">
		<div><h3>My 좋아요</h3></div>		
		<p>총 <span>${house+cafe+travel+food }건</span></p>
		<div class="list_box">
			<c:forEach var = "vo"  items="${h_list}">
				<div>
					<img src="http://localhost:9000/myjeju/images/house/${vo.h_img }" width=100% height=100% >
					<button type="button" class="btn_style" id="heart_btn"><img src="http://localhost:9000/myjeju/images/house/red_heart.png">${vo.h_like }</button>
				</div>
			</c:forEach>
			<c:forEach var = "vo"  items="${f_list}">
				<div>
					<img src="http://localhost:9000/myjeju/images/food/${vo.f_image1 }" width=100% height=100% >
					<button type="button" class="btn_style" id="heart_btn"><img src="http://localhost:9000/myjeju/images/house/red_heart.png">${vo.f_like }</button>
				</div>
			</c:forEach>
			<c:forEach var = "vo"  items="${ca_list}">
				<div>
					<img src="http://localhost:9000/myjeju/images/cafe/${vo.ca_image1 }" width=100% height=100% >
					<button type="button" class="btn_style" id="heart_btn"><img src="http://localhost:9000/myjeju/images/house/red_heart.png">${vo.ca_like }</button>
				</div>				
			</c:forEach>
			<c:forEach var = "vo"  items="${t_list}">
				<div>
					<img src="http://localhost:9000/myjeju/images/travel/${vo.t_image1 }" width=100% height=100% >
					<button type="button" class="btn_style" id="heart_btn"><img src="http://localhost:9000/myjeju/images/house/red_heart.png">${vo.t_like }</button>
				</div>
			</c:forEach>
		</div>	
	</div>
</section>

<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>