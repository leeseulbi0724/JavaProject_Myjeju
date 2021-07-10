<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
<title>포인트 내역 | JEJU ISLAND</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" ></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/index.css">
<style>
	section { text-align:center; margin-bottom:50px; }
	.center { 
		margin-top:80px; 
		width:1000px; 
		display:inline-block; 
	}
	
	.title { 
		display:inline-block;
		border:1px solid lightgray;
		background-color:rgb(248,249,251); 
		width:100%; height:100px;
	}
	.title>p { 
		display:inline-block; 
		margin-top:20px;
	}
	
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
	.box { display:inline-block; width:900px; border-bottom:1px solid lightgray; padding:20px 0; }
	.box>div.plus { border:1px solid gray; border-radius:50px; display:inline-block; float:left; padding:30px; color:gray; }
	.box>div.minus { border:1px solid red; border-radius:50px; display:inline-block; float:left; padding:30px; color:red; }
	.box>p.info { color:gray; float:left; margin:20px; font-size:14px; }
	.box>p.info>span { color:black; }
	.box>p.price_plus { float:right; margin:20px; }
	.box>p.price_minus { color:red; float:right; margin:20px; }
	
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
<body>
<jsp:include page="../header.jsp"></jsp:include>

<section>
	<div class="center">
		<div class="title">
			<p>총 보유 포인트<br>
			<strong>125</strong>p</p>
		</div>
		<div class="content">
			<p>2021.07</p>
			<div class="box">
				<div class="plus">적립</div>
				<p class="info">2021.07.10 14:57:24<br><span>상품 구매 적립</span></p>
				<p class="price_plus">+1,247원</p>
			</div>
			<div class="box">
				<div class="minus">사용</div>
				<p class="info">2021.07.10 14:57:24<br><span>상품 구매 사용</span></p>
				<p class="price_minus">-1,247원</p>
			</div>
		</div>
		<div class="more">
			<div class="img"></div><span>더보기</span>
		</div>
	</div>
</section>

<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>