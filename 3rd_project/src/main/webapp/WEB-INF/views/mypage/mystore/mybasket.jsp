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
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/mypage/mybasket.css">
</head>
<body>
<jsp:include page="../../header.jsp"></jsp:include>

<section>
	<div class="center">
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
		<a href="store_buy.do" class="btn pay">결제하기</a>		
	</div>
</section>

<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>