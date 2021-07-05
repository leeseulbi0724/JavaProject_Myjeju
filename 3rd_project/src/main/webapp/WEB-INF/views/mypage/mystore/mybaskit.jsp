<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
<title>장바구니 | JEJU ISLAND</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" ></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/index.css">
<style>
	section { text-align:center; margin-bottom:50px;  }
	.center { 
		margin-top:80px; 
		width:1000px; 
		display:inline-block; 
	}
	h3 { 
		border-bottom:5px solid #4fa9de; 
		font-size:20px; 
		font-weight:bold; 
		display:inline-block;
	}
	.center>div { margin-top:50px; text-align:left; }
	
	.form-control { display:inline-block; width:100px; height:25px; }
	
	table { margin-top:20px; font-size:14px; margin-bottom:0; }
	table td { vertical-align:middle; }
	table th { border:1px solid lightgray; }
	table tr:first-child th, table tr:nth-child(2) th { background-color:rgb(247,248,249); }
	.price { color:rgb(249,143,83); font-weight:bold; }
	
	.count { border:1px solid lightgray; border-bottom:none; }
	.check { border-top:none; border-right:none; }
	.info { border-left:none; }
	
	.coin_box { 
		background-color:rgb(236,246,255);
		height:100px;
		border-top:1px solid rgb(109,174,226);
	 }
	 .coin_box p {
	 	font-weight:bold;
	 	float:right;
	 	margin:60px 10px 0 0;
	 }
	 .coin_box span { color:rgb(249,143,83); }
	  .btn { float:right; margin:10px 5px; }
	 .pay { background-color:rgb(7,114,215); color:white;  }
	 .pay:hover { background-color:rgb(4,72,134); color:white; }
	 .store { background-color:rgb(186,186,186); color:white; }
	 .store:hover { background-color:rgb(98,98,98); color:white; }
	 .delete { 
	 	border:1px solid lightgray; 
	 	color:gray; 
	 	padding:2px 10px;
	 	font-size:13px; 
	 }
</style>
</head>
<body>
<jsp:include page="../../header.jsp"></jsp:include>

<section>
	<div class="center">
		<div><h3>장바구니</h3></div>
		<table class="table">
			<tr>
				<th class="count">상품(2)</th>
			</tr>
			<tr>
				<th class="check"><input type="checkbox" ></th>
				<th class="info">상품정보</th>
				<th>수량</th>
				<th>판매가</th>
				<th></th>
			</tr>
			<tr>
				<td><input type="checkbox" checked></td>
				<td>
					<img src="http://localhost:9000/myjeju/images/store/store2.png" width=50 height=30>
					<a href="#">오메기떡</a>
				</td>
				<td>
					<input class="form-control" type="number" value="1">
				</td>
				<td class="price">25,000원</td>
				<td><a href="#" class="btn delete">삭제</a></td>
			</tr>				
			<tr>
				<td><input type="checkbox" checked></td>
				<td>
					<img src="http://localhost:9000/myjeju/images/store/store3.png" width=50 height=30>
					<a href="#">제주도 한라봉</a>
				</td>
				<td>
					<input class="form-control" type="number" value="1">
				</td>
				<td class="price">25,000원</td>
				<td><a href="#" class="btn delete">삭제</a></td>
			</tr>			
		</table>
		<div class="coin_box">
			<p>총 결제 금액 : <span>50,000원</span></p>
		</div>		
		<a href="store.do" class="btn store">계속 쇼핑하기</a>
		<a href="#" class="btn pay">결제하기</a>		
	</div>
</section>

<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>