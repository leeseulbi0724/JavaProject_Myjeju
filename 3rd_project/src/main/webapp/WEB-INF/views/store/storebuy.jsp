<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
<title>스토어 | JEJU ISLAND</title>
<link rel = "stylesheet" href = "http://localhost:9000/myjeju/css/index.css">
<link rel = "stylesheet" href = "http://localhost:9000/myjeju/css/store.css">
<link rel="stylesheet" href="css/admincss/bootstrap.css">
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<style>
	.store_buy {
		width : 1100px;
		margin : auto;
		margin-top  : 50px;
		text-align : center;
	}
	
	.store_buy_top {
		/* border : 1px solid red; */
		margin : 10px 0 20px;
	}
	
	.store_buy_top>div:first-child {
		width : 70%;
		display : inline-block;
		/* border : 1px solid blue; */
	}
	
	.store_buy_top>div>h2 {
		text-align : left;
	}
	
	.store_buy_top2 {
		width : 28%;
		display : inline-block;
	}
	
	li {
		list-style : none;
	}
	
	/* STORE_BUY_TABLE 주문/결제 정보 */
	.store_buy_table tr, .store_buy_table th, .store_buy_table td {
		border : 1px solid gainsboro;
		border-collapse : collapse;
		border-radius : 2px;
	} 
	
	.store_buy_table {
		/* border : 1px solid green; */
		width : 100%;
		text-align : center;
		font-size : 14px;
	}
	
	.store_buy_table th {
		height : 17px;
		font-size : 18px;
		text-align : center;
		/* border : 1px solid red; */
	}
	
	.store_buy_table td:first-child {
		/* border : 1px solid red; */
		position : relative;
	}
	
	.store_buy_table td:first-child>img {
		margin-left : -150px;
		padding : 10px 0;
	}
	
	.store_buy_table td:first-child>span {
		/* border : 1px solid red; */
		margin-left : 50px;
		text-align : center;
		font-size : 24px;
		font-weight : bold;
		position : absolute;
		top : 40%;
	}
	
	/* 주문자 정보 */
	.store_buy_addr {
		/* border : 1px solid green; */
		margin : 40px 0;
		text-align : left;
		
	}

	.store_buy_addr2>div:first-child {
		margin : 20px 0;
	}
	
	.store_buy_addr2>div:nth-child(2), .store_buy_addr2>div:nth-child(3),
	.store_buy_addr2>div:nth-child(4), .store_buy_addr2>div:nth-child(5) {
		height : 35px;
		margin : 5px 0 10px 10px;
		border-bottom : 1px dotted #595959;
	}
	
	.store_buy_addr2>div>label {
		display : inline-block;
		width : 15%;
		font-weight : bold;
		font-size : 20px;
	}
	
	.store_buy_addr2>div>span, .store_buy_addr2>div>select {
		/* border : 1px solid green; */
		color : #595959;
		font-size : 18px;
	}
	
	/* 총 결제 금액 */
	.store_sum {
		/* border : 1px solid purple; */
		text-align : right;
		font-size : 30px;
	}

	/* 결제 버튼 */
	.store_btn_style3 {
		margin : 15px 0;
		background-color : #4fa9de;
		border : 1px solid #4fa9de;
		color : white;
		width : 20%;
		border-radius : 5px;
		font-size : 26px;
		font-weight : 600;
		padding : 5px;
	}
	
	.store_btn_style3:hover {
		background-color:#268ecc;
		border:1px solid #268ecc;
	}
	
</style>
</head>
<body>
	<!-- Header -->
	<jsp:include page = "../header.jsp"></jsp:include>
	
	<section>
		<div class = "store_buy">
		
			<div class = "store_category_logo">상품 구매 페이지</div>
		
			<div class = "store_buy_top">
				<div><h2>주문 / 결제</h2></div>
				
				<div class = "store_buy_top2">
					<ol>
						<li>
							<span>장바구니 > </span>
							<span><strong>주문 / 결제 </strong></span>
							<span> > 완료</span>
						</li>
					</ol>
				</div>	
			</div>
			<form name = "store_buy_form" action = "store_buy_proc.do" method = "post" class = "store_buy_form">
				<div class = "store_buy_product">
					<table class = "store_buy_table">
						<tr>
							<th width = 60%>상품정보</th>
							<th>배송비</th>
							<th>수량</th>
							<th>총 금액</th>
						</tr>
						
						<tr>
							<td>
								<img src="http://localhost:9000/myjeju/images/store/store2.png">
								<span>제주 오메기떡</span>
							</td>
							<td name = "store_ship">2,500</td>
							<td name = "store_amount">1</td>
							<td name = "store_sum">12,400</td>
	
						</tr>
					</table>
				</div>
				
				<div class = "store_buy_addr">
					<div class = "store_buy_addr2">
						<div><h2>배송지 정보</h2></div>
						<div><label>이름</label><span name = "store_name"> vo.getName() </span></div>
						<div><label>휴대폰 번호</label><span name = "store_hp"> vo.getHp() </span></div>
						<div><label>주소</label><span name = "store_addr"> vo.getAddr() </span></div>
						<div>
							<label>요청사항</label>
							<select name = "addrRe" id = "addrRe">
								<option value = "choice">요청사항을 입력해주세요.</option>
								<option value = "Requ1">배송 전에 미리 연락 바랍니다</option>
								<option value = "Requ2">부재시 경비실에 맡겨주세요</option>
								<option value = "Requ3">부재시 전화 주시거나 문자 남겨주세요</option>
								<option value = "Requ4">조심히 다뤄주세요</option>
							</select>
						</div>
					</div>
				</div>
				
				<div class = "store_sum">총 결제 금액 <strong>12,400 원</strong></div>
				
				<button type = "submit" class = "store_btn_style3" id = "store_buy">결제하기</button>
				
			</form>
			
		
		</div>
	
	
	</section>
	
	<!-- Footer -->
	<jsp:include page = "../footer.jsp"></jsp:include>
</body>
</html>