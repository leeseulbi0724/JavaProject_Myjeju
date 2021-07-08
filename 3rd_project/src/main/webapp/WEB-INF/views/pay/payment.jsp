<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
<title>결제 | JEJU ISLAND</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" ></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/index.css">
<script src="http://localhost:9000/myjeju/js/jquery-3.6.0.min.js"></script>
<style>
	section { text-align:center; margin-bottom:50px;  }
	.center { 
		margin-top:100px; 
		width:1000px; 
		display:inline-block; 
	}
	
	.info {
		display:inline-block;
		background-color:white;
		border:2px solid lightgray;
		width:800px; height:130px;
		text-align:center;
	}
	.info>div {
		display:inline-block; width:230px; height:100px; border-right:1px solid lightgray;
		margin:10px; float:left;
	}
	.info>div>p { margin-top:25px; }
	.info>div:first-child { margin-left:30px; }
	.info>div:last-child { border:none; font-size:18px; }
	
	.card { 
		display:inline-block;
		width:800px;
		height:200px;
		background-color:rgb(242,244,245); 
		border:1px solid lightgray;
		font-size:14px;
	}
	.card ul { list-style:none; text-align:left; margin:40px 200px; }
	.card label { margin-bottom:5px; }
	
	.number .form-control, .day .form-control { display:inline-block; width:60px; height:25px; } 
	.pass .form-control, .birth .form-control { display:inline-block; width:130px; height:25px; }
	
	.card span { font-size:13px; color:gray; }
	.card>input { margin:10px 0 50px 0; }
		
	.card a {
		 text-decoration:none; border:1px solid lightgray; padding:5px 10px; border-radius:4px; }	
	.back {
		background-color:rgb(245,245,245);
		color:black;
	}
	 .pay {
	 	background-color:rgb(7,114,215); 
	 	color:white;
	 	font-size:14px;
	 	margin-top:-5px;
	 	margin-right:10px; 
	 	margin-left:10px;
	 }
	 .pay:hover { background-color:rgb(4,72,134); color:white; }
</style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>

<section>
<div class="center">
	<div class="info">
		<div>
			<p>총 상품 금액<br><strong>25,000</strong>원	</p>
		</div>
		<div>
			<p>할인 금액<br><strong style="color:red">-2,500</strong>원	</p>
		</div>
		<div>
			<p>총 결제 금액<br><strong style="color:red">22,500</strong>원</p>
		</div>
	</div>
	<div class="card">
		<ul>
			<li class="number">
				<label>카드번호</label>
				<input class="form-control">-
				<input class="form-control">-
				<input class="form-control">-
				<input class="form-control">			
			<li>
			<li class="day">
				<label>유효기간</label>
				<input class="form-control">/
				<input class="form-control">
			</li>
			<li class="pass">
				<label>비밀번호</label>
				<input class="form-control"><span>앞 2자리</span>
			</li>
			<li class="birth">
				<label>생년월일</label>
				<input class="form-control"><span>생년월일 6자리</span>
			</li>
		</ul>
		<input type="checkbox">결제에 동의하시겠습니까?
		<div>
			<a href="store.do" class="back">스토어 돌아가기</a>
			<a href="#" class="pay">결제</a>
		</div>
	</div>
</div>
</section>

<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>