<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
<title>스토어 | JEJU ISLAND</title>
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
	h3 { 
		border-bottom:5px solid #4fa9de; 
		font-size:20px; 
		font-weight:bold; 
		display:inline-block;
	}
	.center>div:first-child { margin-top:50px; margin-bottom:30px; }
	
	.table tr:first-child th { font-weight:normal; border-bottom:1px solid; }
	.table tr:first-child th:first-child { 
		font-weight:bold; 
		text-align:left; 
		font-size:20px; 
		width:500px;
	}
	.table tr:last-child td:first-child { text-align:left; }
	.number { display:inline-block; width:100px; height:25px; }
		
	.addr { 
		display:inline-block; 
		width:560px;
		height:300px;
		float:left;
		margin-top:20px; 
	}
	.price {
		display:inline-block; 
		width:400px;
		height:300px;
		float:left;
		margin-top:20px;		
		float:right;
	}
	.addr>p, .price>p { font-weight:bold; font-size:20px; text-align:left; }
	.addr>div { width:560px; height:200px; }
	.price>div { wdith:4000px; height:200px; }
	.addr>div, .price>div { 
		border-top:1px solid;
		border-left:1px solid lightgray;
		border-right:1px solid lightgray;
		border-bottom:1px solid lightgray;		
		text-align:left;
	}	
	
	.addr img { margin:10px; margin-right:0; vertical-align:middle; }
	.addr span.one { color:gray; font-weight:bold; font-size:17px; }
	.addr div>p { margin-left:20px; }
	.addr span.two { color:gray; }
	
	.form-select { width:300px; margin-left:30px; height:30px; padding:0 10px; }
	.text { width:400px; height:30px; margin-left:30px; margin-top:5px; }
	
	.price>div>div { font-size:17px; margin:10px; }
	.price>div>div.discount { margin-top:20px; padding-bottom:10px; border-bottom:1px solid lightgray; }
	.price>div>div strong { float:right; }
	.price>div>div .form-control { width:100px; display:inline-block; height:25px; font-size:14px; }
	.price>div>div button { 
		background-color:rgb(235,235,235); 
		border:none; 
		font-size:14px; 
		border-radius:4px; 
		padding:0 5px;
	}
	.price>div>div span { margin-left:100px; }
	.price>div>div:nth-child(2)>span:last-child, .point_text { font-size:13px; color:gray; float:right; }
	
	 .pay {
	 	background-color:rgb(7,114,215); 
	 	color:white;
	 	 float:right; 
	 	padding:2px 5px;
	 	font-size:14px;
	 	margin-top:-5px;
	 	margin-right:10px; 
	 	margin-left:10px;
	 }
	 .pay:hover { background-color:rgb(4,72,134); color:white; }
	 
	 
	 .modal-dialog { margin-top:180px; }
	 .modal-body { text-align:center; }
	 .modal-body a {
	 	border:1px solid lightgray;
	 	width:250px; height:250px;
	 	display:inline-block;
	 	margin-right:20px;
	 }
	 .modal-title { font-weight:bold; }
	 .self { background-color:rgb(245,245,245); }
</style>
</head>
<script>
	$(document).ready(function() {
		$(".form-select").change(function() {
			if ($(this).val() == "msg0") {
				$(".text").attr("type","text");
			} else {
				$(".text").attr("type","hidden");
			}			
		});
	});
</script>
<body>
<jsp:include page="../header.jsp"></jsp:include>

<section>
	<div class="center">
		<table class="table">		
			<tr>
				<th>주문상품 1개</th>
				<th>수량</th>
				<th>가격</th>
			</tr>
			<tr>
				<td>
					<img src="http://localhost:9000/myjeju/images/store/store2.png" width=50 height=30>
					<a>오메기떡</a>
				</td>
				<td>
					<input class="form-control number" type="number" value="1" disabled>
				</td>
				<td><strong>25,000원</strong></td>			
		</table>		
		<div class="addr">
			<p>배송정보</p>
			<div>
				<img src="http://localhost:9000/myjeju/images/store/pin.png" width=30 height=30><span class="one">배송지</span>
				<p>경기도 수원시 영통구 **** 204호<br>
				<span class="two">이슬비 | 010-9369-2489</span></p>
				<select class="form-select">
					<option value="msg0">직접 입력
					<option value="msg1">집 앞에 놔주세요.
					<option value="msg2">배송전 연락 바랍니다.
					<option value="msg3">부재 시 경비실에 맡겨주세요.
				</select>
				<input type="text" class="form-control text">
			</div>
		</div>
		<div class="price">
			<p>결제금액</p>
			<div>
				<div>상품금액<strong>25,500원</strong></div>
				<div>포인트 사용
					<span><input type="text" class="form-control">
					<button>전체 사용</button>	</span>					
					<span class="">총 보유 포인트 152p</span>
				</div>
				<div class="discount">할인금액<strong>152원</strong></div>
				<div>결제금액<strong>25,348원</strong></div>
				<span class="point_text">적립 예정 포인트 1267p
				<a href="#" class="btn pay" data-bs-toggle="modal" data-bs-target="#staticBackdrop">결제하기</a></span>	
			</div>
		</div>		
	</div>
</section>

<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">결제 방법</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <a href="payment.do" class="self">
        	<img src="http://localhost:9000/myjeju/images/store/card.png" width=100% height=100% >
        </a>
        <a href="#" class="kakao">
        	<img src="http://localhost:9000/myjeju/images/store/pay.jpg" width=100% height=100% >
        </a>
      </div>      
    </div>
  </div>
</div>

<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>