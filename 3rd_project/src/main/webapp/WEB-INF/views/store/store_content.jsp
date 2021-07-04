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
<script src="http://localhost:9000/myjeju/js/jquery-3.6.0.min.js"></script>
<script>

	$(document).ready(function() {
		
		/* 상단 카테고리 클릭 시 스크롤 다운 */
		$("#move1").click(function() {
			var offset = $("#img1").offset();
			$('html').animate({scrollTop : offset.top}, 300);
		});
		
		$("#move2").click(function() {
			var offset = $("#img2").offset();
			$('html').animate({scrollTop : offset.top}, 300);
		});
		
		$("#move3").click(function() {
			var offset = $("#img3").offset();
			$('html').animate({scrollTop : offset.top}, 300);
		});
		
		$("#move4").click(function() {
			var offset = $("#img4").offset();
			$('html').animate({scrollTop : offset.top}, 300);
		});
		
		
		/* 버튼 색상 변경 */
		$(".store_content_category>button").each(function() {
			$(this).click(function() {
				$(this).addClass("selected");
				$(this).siblings().removeClass("selected");
			});
		});
		
		/* 메뉴바 상단 고정 */
		var menu = $(".store_content_category").offset();
		
		$(window).scroll(function() {
			if($(document).scrollTop() > menu.top) {
				$('.store_content_category').addClass('menu-fixed');
			} else {
				$('.store_content_category').removeClass('menu-fixed');
			}
		});
		
		
	});

</script>
<style>
	/******** STORE_CONTENT ********/
	.store_content {
		/* border : 1px solid red; */
		width : 1100px;
		margin : auto;
		margin-top  : 50px;
		text-align : center;
	}
	
	.store_content_1 {
		border : 1px solid lightgray;
	}
	
	/* STORE_CONTENT_TOP */
	.store_content_top {
		/* border : 1px solid blue; */
		text-align : left;
	}
	
	/* form */
	.store_content_form {
		/* border : 1px solid green; */
		margin-bottom : 50px;
	}
	
	.store_content_form>div.img_area {
		/* border : 1px solid blue; */
		width: 380px;
		display : table-cell;
		text-align : center;
		padding : 15px 20px 0 20px;
	}
	
	.store_content_form>div.img_area>img {
		width : 100%;
	}
	
	.store_content_form>div.text_area {
		/* border : 1px solid yellow; */
		width: 435px;
		display: table-cell;
		vertical-align: top;
    	word-wrap: break-word;
    	letter-spacing: -0.5px;
    	padding-left : 20px;
	}
	
	.title-box {
		padding: 28px 0 28px;
		position: relative;
		word-wrap: break-word;
		letter-spacing: -0.5px;
	}
	
	.store_content_title {
		font-size: 24px;
		line-height: 26px;
		color: #333333;
		font-weight : 700;
		word-wrap: break-word;
		letter-spacing: -0.5px;
	}
	
	.store_content_price {
		font-size: 22px;
		line-height: 26px;
		color: #333333;
		font-weight : 500;
		word-wrap: break-word;
		letter-spacing: -0.5px;
		margin-top : 10px;
	}
	
	/* 수량, 옵션 */
	.option-box {
		padding: 28px 0 28px;
		position: relative;
		word-wrap: break-word;
		letter-spacing: -0.5px;
	}
	
	.option-box>div {
		margin: 5px 0;
		font-size : 20px;
		font-weight : 500;
	}
	
	.option-box>div>input {
		border : 1px solid #444;
		height : 25px;
		width : 170px;
		font-size : 16px;
	}
	
	.option-box>span:nth-child(2) {
		margin: 5px 0;
		font-size : 20px;
		font-weight : 500;	
		margin-right : 34px;
	}
	
	.option-box>select:nth-child(3) {
		border : 1px solid #444;
		height : 30px;
		width : 170px;
	}
	
	/* 장바구니, 주문하기 버튼 */
	.store_btn_style1 {
		width:150px;
		background-color:dimgray;
		border:1px solid dimgray;
		padding:10px;
		color:white;
		font-size:16px;
		font-weight:bold;
		text-align:center;
		margin-top:20px;
		margin-right : -5px;
		cursor:pointer;
	}
	
	.store_btn_style2 {
		width:200px;
		background-color:#4fa9de;
		border:1px solid #4fa9de;
		padding:10px;
		color:white;
		font-size:16px;
		font-weight:bold;
		text-align:center;
		margin-top:20px;
		cursor:pointer;
	}
	
	.store_btn_style1:hover{
		background-color:#595959;
		border:1px solid #595959;
	}
	
	.store_btn_style2:hover {
		background-color:#268ecc;
		border:1px solid #268ecc;
	}
	
	hr {
		margin-top : 50px;
		border : 1px solid lightgray;
	}
	
	
	/* STORE_CONTENT_MIDDLE */
	.store_content_middle {
		/* border : 1px solid red; */
		margin-bottom : 50px;
	}
	
	/* STORE_CONTENT_SCROLL */
	.store_content_category {
		/* border : 1px solid red; */
		width : 100%;
		height : 40px;
		margin-bottom : 20px;
	}
	
	.content_category_btn {
		color : #999;
		border : 1px solid gray;
		font-size : 16px;
		font-weight : 600;
		width : 220px;
		height : 35px;
		background-color : hsl(160, 0, 235);
		margin-left : -6px;
	}
	
	.content_area>img {
		margin-top : -4px;
	}
	
	/* Jquery 기능 */
	.selected {
		background-color : #4fa9de;
		color : white;
	}
	
	.menu-fixed {
	  position: fixed;
	  top: 0px;
	  left:0px;

	}

	

</style>


</head>
<body>

	<!-- Header -->
	<jsp:include page = "../header.jsp"></jsp:include>
	
	<div class = "store_content">
		
		<div class = "store_category_logo">상품 상세페이지</div>
		<div class = "store_content_1">
			<div class = "store_content_top">
				<form name = "store_form" action = "store_order.do" method = "post" class = "store_content_form">
				
					<div class = "img_area">
						<img src = "http://localhost:9000/myjeju/images/store/store2.png">
					</div>
					
					<div class = "text_area">
						<div class = "title-box">
							<div class = "store_content_title">[식품] 제주도 오메기떡</div>
							<div class = "store_content_price">￦ 9,900</div>
						</div>
						
						<div class = "option-box">
							<div>수량　　<input type = "number" min = "0" max = "10"></div>
							<span>옵션</span>
							<select name = "hp1" id = "hp1">
								<option value = "choice">선택</option>
								<option value = "010">기본</option>
								<option value = "011">소금맛</option>
								<option value = "016">설탕맛</option>
								<option value = "017">허니버터맛</option>
							</select>
						</div>
						
						<div class = "store_content_price_sum"> 가격 * 수량 </div>
						
						
						<button type = "button" class = "store_btn_style1" id = "storeBasket">장바구니</button>
						<button type = "button" class = "store_btn_style2">바로구매</button>
					</div>
					
					<hr>
						
				</form>
	
			</div>
		
		
			<div class = "store_content_middle">
				<div class= "store_content_category">
					<button type = "button" class = "content_category_btn" id = "move1">상품상세</button>
					<button type = "button" class = "content_category_btn" id = "move2">상품평</button>
					<button type = "button" class = "content_category_btn" id = "move3">상품문의</button>
					<button type = "button" class = "content_category_btn" id = "move4">배송/교환/반품 안내</button>
				</div>
			
				<div class = "content_area">
					<img src = "http://localhost:9000/myjeju/images/store/omegi1.jpg" id = "img1">
					<img src = "http://localhost:9000/myjeju/images/store/omegi2.jpg" id = "img2">
					<img src = "http://localhost:9000/myjeju/images/store/omegi3.jpg" id = "img3">
					<img src = "http://localhost:9000/myjeju/images/store/omegi1.jpg" id = "img4">
				</div>
				
				<div class = "content_qna">
					<h1> content Q&A</h1>
				
				</div>
			</div>
		
		</div>
		
	</div>
	
	<!-- Footer -->
	<jsp:include page = "../footer.jsp"></jsp:include>

</body>
</html>


				
				