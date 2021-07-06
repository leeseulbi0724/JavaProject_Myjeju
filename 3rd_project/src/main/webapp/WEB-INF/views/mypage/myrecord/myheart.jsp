<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	.list_box>div { display:inline-block; border:1px solid lightgray; width:200px; height:200px; }
	
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
		<p>총 <span>4건</span></p>
		<div class="list_box">
			<div>
				<img src="http://localhost:9000/myjeju/images/travel/성산일출봉.jpg" width=100% height=100% >
				<button type="button" class="btn_style" id="heart_btn"><img src="http://localhost:9000/myjeju/images/travel/empty_heart.png">452</button>
			</div>
			<div>
				<img src="http://localhost:9000/myjeju/images/travel/한라산.jpg" width=100% height=100% >
				<button type="button" class="btn_style" id="heart_btn"><img src="http://localhost:9000/myjeju/images/travel/empty_heart.png">452</button>
			</div>
			<div>
				<img src="http://localhost:9000/myjeju/images/travel/사려니숲길.jpg" width=100% height=100% >
				<button type="button" class="btn_style" id="heart_btn"><img src="http://localhost:9000/myjeju/images/travel/empty_heart.png">452</button>
			</div>
			<div>
				<img src="http://localhost:9000/myjeju/images/no2.jpg" width=100% height=100% >
				<button type="button" class="btn_style" id="heart_btn"><img src="http://localhost:9000/myjeju/images/travel/empty_heart.png">452</button>
			</div>
		</div>
		<button type="button" class="btn_style5" id="more_btn">more
			<img src="http://localhost:9000/myjeju/images/travel/bill_list_btn2.png">
			<img src="http://localhost:9000/myjeju/images/travel/bill_list_btn.png">
		</button>
	</div>
</section>

<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>