<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
<title>주문내역 | JEJU ISLAND</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/index.css">
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/mypage/myorder.css">
</head>
<body>
<jsp:include page="../../header.jsp"></jsp:include>

<section>
	<div class="center">
		<div><h3>주문내역</h3></div>
		<div class="search">
			<input type="text" class="form-control">
			<button type="button" class="btn btn-dark">조회</button>
		</div>
		<div>
			<p>전체 주문 내역 <span>1</span></p>
			<table class="table table-bordered">
				<tr>
					<th>주문일</th>
					<th>분류</th>
					<th>상품명</th>
					<th>수량</th>
				</tr>
				<tr>
					<td>2021-07-03 <span>22:56:01</span><br>
					결제금액 : <strong>54,400</strong>원</td>
					<td>식품</td>
					<td><img src="http://localhost:9000/myjeju/images/store/store2.png" width=50 height=30>오메기떡</td>
					<td>2개</td>
			</table>
		</div>
	</div>
</section>

<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>