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
<style>
	.store_buy {
		width : 1100px;
		margin : auto;
		margin-top  : 50px;
		text-align : center;
	}
	
	.store_buy_top {
		border : 1px solid red;
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
	
	/* STORE_BUY_TABLE */
	.store_buy_table tr, .store_buy_table th, .store_buy_table td {
		border : 1px dotted #595959;
		border-collapse : collapse;
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
		top : 25%;
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
			<form name = "store_buy_form" action = "store_buy.do" method = "post" class = "store_buy_form">
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
							<td>2,500</td>
							<td>1</td>
							<td>12,400</td>
	
						</tr>
					</table>
				</div>
				
				<div class = "store_buy_addr">
					<div><h5>배송지 정보</h5></div>
					<div> vo.getName() </div>
					<div> vo.getHp() </div>
					<div> vo.getAddr() </div>
					
					<select name = "addrRe" id = "addrRe">
						<option value = "choice">요청사항을 입력해주세요.</option>
						<option value = "Re1">배송 전에 미리 연락 바랍니다</option>
						<option value = "Re2">부재시 경비실에 맡겨주세요</option>
						<option value = "Re3">부재시 전화 주시거나 문자 남겨주세요</option>
						<option value = "Re4">조심히 다뤄주세요</option>
					</select>
				</div>
				
			</form>
			
			<div>총 결제 금액 <strong>12,400원</strong></div>
		
		</div>
	
	
	</section>
	
	<!-- Footer -->
	<jsp:include page = "../footer.jsp"></jsp:include>
</body>
</html>