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
<link rel="stylesheet" href="css/admincss/bootstrap.css">
<link rel="stylesheet" href="css/admincss/bootstrap.min.css">
<script src="http://localhost:9000/myjeju/js/bootstrap.min.js"></script>
<script>

	$(document).ready(function() {
		
		/* 상단 카테고리 클릭 시 스크롤 다운 */
		$("#move1").click(function() {
			var offset = $("#here1").offset();
			$('html').animate({scrollTop : offset.top}, 0);
		});
		
		$("#move2").click(function() {
			var offset = $("#here2").offset();
			$('html').animate({scrollTop : offset.top}, 0);
		});
		
		$("#move3").click(function() {
			var offset = $("#here3").offset();
			$('html').animate({scrollTop : offset.top}, 0);
		});
		
		$("#move4").click(function() {
			var offset = $("#here4").offset();
			$('html').animate({scrollTop : offset.top}, 0);
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
		
		$("#store_buy").click(function() {
			if($("#product_amount").val() == 0) {
				alert("수량을 입력해주세요");
				$("#product_amount").focus();
				return false;
			} else if ($("#product_taste").val() == "choice") {
				alert("옵션을 선택해주세요");
				$("#product_taste").focus();
				return false;
			} else {
				store_form.submit();
			}
			
		});
		
		
		/* 문의하기 버튼 클릭시 모달창*/
		$('#storefaqBtn').click(function(e){
			e.preventDefault();
			$('#faqModal').modal("show");
		});
		
		/* 답변하기 버튼 클릭시 모달창 */
		$('#storereplyBtn').click(function(e){
			e.preventDefault();
			$('#replyModal').modal("show");
		});
		
		
	});

</script>
<style>
	/******** STORE_CONTENT ********/
	.store_content {
		/* border : 1px solid red; */
		width : 1100px;
		margin : auto;
		margin-top  : 80px;
		text-align : center;
	}
	
	.store_content_1 {
		/* border : 1px solid lightgray; */
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
		margin-bottom : 30px;
		cursor : pointer;
	}
	
	.content_category_btn {
		color : #999;
		border : 1px solid lightgray;
		font-size : 16px;
		font-weight : 600;
		width : 220px;
		height : 40px;
		background-color : hsl(160, 0, 235);
		margin-left : -6px;
		cursor : pointer;
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
	
	/******* 상품평 ********/
	.store_product_review {
		/* border : 1px solid red; */
		margin : 30px 0;
		padding-top : 40px;
	}
	
	.store_product_review>div:first-child {
		text-align : left;
		font-size : 24px;
		font-weight : 600;
		margin : 20px 0 15px;
		padding : 10px 0;
		border-bottom : 3px solid #595959;
	}
	
	
	.store_product_review>article {
		/* border : 1px solid purple; */
		border-bottom : 2px solid gray;
		margin-bottom : 20px;
		padding  : 0 0 10px 15px;
	}
	
	.store_product_review>article>div {
		/* border : 1px solid green; */
		margin : 8px 0 10px 8px;
		text-align : left;
		font-size : 18px;
	}

	.store_product_review>article>div:first-child {
		font-weight : 700;
	}
	
	.store_product_review>article>div:nth-child(2)>span {
		margin-right : 20px;
	}
	
	.store_product_review>article>div:nth-child(3) {
		color : #595959;
	}
	
	.store_product_review>article>div:nth-child(5)>span:first-child,
	.store_product_review>article>div:nth-child(6)>span:first-child {
		display: inline-block;
		width : 10%;
		font-weight : 700;
	}
	
	
	/****** 상품문의 ********/
	.store_product_faq {
		margin : 20px 0;
		padding : 30px 0;
	}
	
	.store_product_faq_top {
		border-bottom : 3px solid #595959;
	} 
	
	.store_product_faq_top>div:first-child {
		/* border : 1px solid purple; */
		display : inline-block;
		text-align : left;
		width : 90%;
		font-size : 24px;
		font-weight : 600;
		margin : 20px 0 15px;
		padding : 10px 0;
	}
	
	.store_product_faq_top>button {
		background-color : #4fa9de;
		border : 1px solid #4fa9de;
		border-radius : 10px;
		padding : 10px;
		color : white;
		font-size : 15px;
		font-weight : bold;
		text-align : center;
		cursor : pointer;
	}
	
	.store_product_faq_top>button:hover {
		background-color:#268ecc;
		border:1px solid #268ecc;
	}

	
	/* 상품문의 - 본문 */
	.store_product_faq_content {
		/* border : 1px solid purple; */
		padding : 20px 0 20px 10px;
		text-align : left;
	}
	
	.store_product_faq_content>article {
		/* border : 1px solid green; */
		/* position : relative; */
		padding : 20px 0;
		border-bottom : 1px solid #777777;
	}
	
	/* 질문이모티콘 */
	.store_product_faq_content>article button {
		background-color : #777777;
		display : inline-block;
		padding : 4px;
		font-size : 12px;
		font-weight : 700;
		color : white;
		border : 1px solid #777777;
	}
	
	.store_product_faq_content>article strong {
		margin-left : 5px;
	}
	
	.store_product_faq_content>article>div>div {
		margin-bottom : 10px;
	}
	
	/* 답변하기 버튼 */
	.store_product_faq_content>article>div>div:nth-child(4) {
		text-align : right;
		margin-right : 10px;
	}
	
	.store_product_faq_content>article>div>div:nth-child(4)>button {
		background-color : #4fa9de;
		padding : 4px;
		font-size : 14px;
		font-weight : 700;
		color : white;
		border : 1px solid #4fa9de;
		border-radius : 10px;
		cursor : pointer;
	}
	
	.store_product_faq_content>article>div>div:nth-child(4)>button:hover {
		background-color:#268ecc;
		border:1px solid #268ecc;
	}
	
	
	
	/* 문의하기 - 답변 */
	.store_product_faq_content>article:nth-child(2) {
		/* border : 1px solid green; */
		padding : 20px 0;
		border-bottom : 1px solid #777777;
	}
	
	
	/***** 배송 / 교환 / 반품 안내 *****/
	 .store_product_ship {
	 	margin : 20px 0;
		padding : 30px 0;
	 }
	
	.store_product_ship>div:first-child {
		text-align : left;
		font-size : 24px;
		font-weight : 600;
		margin : 20px 0 15px;
		padding : 10px 0;
		border-bottom : 3px solid #595959;
	}
	
	.store_product_ship_content>div, .store_product_ship_content>table {
		text-align : left;
		margin : 5px 0 15px 10px;
		/* border : 1px solid purple; */
	}
	
	.store_product_ship_content>table {
		width : 100%;
		border-collapse: collapse;
	}
	
	.store_product_ship_content>table tr, .store_product_ship_content>table td {
		border : 1px solid lightgray;
		border-collapse: collapse;
	}
	
	.store_product_ship_content>table td:nth-child(2n-1) {
		width : 18%;
		background-color : #f2f2f2;
		text-align : center;
		padding : 10px;
	}
	
	.store_product_ship_content>table td:nth-child(2n) {
		padding-left : 10px;
	}
	
	
	/******* 모달창 *******/
	.modal-title {
		text-align : left;
		font-weight : 700;
	}
	
	.modal-body>input:first-child, .modal-body>select, .modal-body>div>input {
		display : inline-block;
		width : 90%;
		margin : 5px 0;
	}
	
</style>


</head>
<body>

	<!-- Header -->
	<jsp:include page = "../header.jsp"></jsp:include>
	
	<div class = "store_content">
		
		<div><h3>상품 상세페이지</h3></div>
		
		<div class = "store_content_1">
			<div class = "store_content_top">
				<form name = "store_form" action = "store_buy.do" method = "get" class = "store_content_form">
				
					<div class = "img_area">
						<img src = "http://localhost:9000/myjeju/images/store/store2.png">
					</div>
					
					<div class = "text_area">
						<div class = "title-box">
							<div class = "store_content_title">[식품] 제주도 오메기떡</div>
							<div class = "store_content_price">￦ 9,900</div>
						</div>
						
						<div class = "option-box">
							<div>수량　　<input type = "number" min = "0" max = "10" id = "product_amount" name = "product_amount"></div>
							<span>옵션</span>
							<select name = "product_taste" id = "product_taste">
								<option value = "choice">선택</option>
								<option value = "basic">기본</option>
								<option value = "salt">소금맛</option>
								<option value = "sugar">설탕맛</option>
								<option value = "honeybutter">허니버터맛</option>
							</select>
						</div>
						
						<div class = "store_content_price_sum"> 가격 * 수량 </div>
						
						
						<button type = "button" class = "store_btn_style1" id = "storeBasket">장바구니</button>
						<button type = "submit" class = "store_btn_style2" id = "store_buy">바로구매</button>
					</div>

						
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
					<img src = "http://localhost:9000/myjeju/images/store/omegi1.jpg" id = "here1">
					<img src = "http://localhost:9000/myjeju/images/store/omegi2.jpg">
					<img src = "http://localhost:9000/myjeju/images/store/omegi3.jpg">
				</div>
				
				<div class = "store_product_review" id = "here2">
					<div>상품평</div>
					<article>
						<div>이진옥</div>
						<div><span>별점</span><span>2021.07.06</span></div>
						<div>제주도 오메기떡</div>
						<div>한줄평</div>
						<div><span>신선도</span><span>아주좋아요</span></div>
						<div><span>맛 만족도</span><span>아주 맛있어요</span></div>
					</article>
					
					<article>
						<div>이진옥</div>
						<div><span>별점</span><span>2021.07.06</span></div>
						<div>제주도 오메기떡</div>
						<div>한줄평</div>
						<div><span>신선도</span><span>아주좋아요</span></div>
						<div><span>맛 만족도</span><span>아주 맛있어요</span></div>
					</article>
					
					<article>
						<div>이진옥</div>
						<div><span>별점</span><span>2021.07.06</span></div>
						<div>제주도 오메기떡</div>
						<div>한줄평</div>
						<div><span>신선도</span><span>아주좋아요</span></div>
						<div><span>맛 만족도</span><span>아주 맛있어요</span></div>
					</article>
				</div>
				
				<div class = "store_product_faq" id = "here3">
					<div class = "store_product_faq_top">
						<div>상품문의</div>
						<button type = "button" id = "storefaqBtn">문의하기</button>
					</div>
					
					  <!-- 문의하기 Modal-->
						<div class="modal fade" id="faqModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button class="close" type="button" data-dismiss="modal" aria-label="Close">
										<span aria-hidden="true">&times;</span></button>
										</button>
										<h3 class="modal-title" id="exampleModalLabel">문의하기</h3>
									</div>
									<div class="modal-body">
										<input type = "text" value = "상품명 vo.stname" readonly>
										<select name = "product_taste" id = "product_taste">
											<option value = "choice">선택</option>
											<option value = "basic">기본</option>
											<option value = "salt">소금맛</option>
											<option value = "sugar">설탕맛</option>
											<option value = "honeybutter">허니버터맛</option>
										</select>	
										
										<div><input type = "text" placeholder = "문의할 내용을 입력해주세요"></input></div>
									</div>
									<div class="modal-footer">
										<a class="btn" id="modalY" href="#">문의하기</a>
										<button class="btn" type="button" data-dismiss="modal">닫기</button>
									</div>
								</div>
							</div>
						</div>
					
					<div class = "store_product_faq_content">
						<article>
							<div>
								<div><button>질문</button><strong>이진*</strong><span> vo.문의시간 </span></div>
								<div> vo.수량 | vo.옵션 </div>
								<div>상품문의 합니다. 이거 이렇게 하는거 맞나요? 오메기떡 맛있나요?</div>
								<div><button type = "button" id = "storereplyBtn">답변하기</button></div>
							</div>
						</article>
						
						<article>
							<div>
								<div><button>답변</button><strong>판매자</strong><span> vo.답변시간 </span></div>
								<div>안녕하세요 이용해주셔서 감사합니다. 네 맛있습니다.</div>
							</div>
						</article>
					</div>
					
					<!-- 답변하기 Modal-->
						<div class="modal fade" id="replyModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button class="close" type="button" data-dismiss="modal" aria-label="Close">
										<span aria-hidden="true">&times;</span></button>
										</button>
										<h3 class="modal-title" id="exampleModalLabel">문의하기</h3>
									</div>
									<div class="modal-body">
										<input type = "text" value = "사용자명 vo.name" readonly>
										<div><input type = "text" placeholder = "답변할 내용을 입력해주세요"></input></div>
									</div>
									<div class="modal-footer">
										<a class="btn" id="modalY" href="#">답변하기</a>
										<button class="btn" type="button" data-dismiss="modal">닫기</button>
									</div>
								</div>
							</div>
						</div>
				
				</div>
				
				<div class = "store_product_ship" id = "here4">
					<div>배숑/교환/반품 안내</div>
					<div class = "store_product_ship_content">
						<div><h4>배송정보</h4></div>
						<table>
							<tr>
								<td>배송방법</td>
								<td>순차배송</td>
								<td rowspan = "2">배송비</td>
								<td rowspan = "2">3,000원</td>
							</tr>
						
							<tr>
								<td>배송사</td>
								<td>쌍용택배</td>
							</tr>
							
							<tr>
								<td>묶음배송 여부</td>
								<td colspan = "3">불가능</td>
							</tr>
							
							<tr>
								<td>배송기간</td>
								<td colspan = "3">도서산간 지역 등은 배송에 3-5일이 더 소요될 수 있습니다.</td>
							</tr>
						</table>
					
						<div><h4>교환/반품 안내</h4></div>
						<table>
							<tr>
								<td>교환/반품 비용</td>
								<td colspan = "2">6,000원 - 단, 고객 변심의 경우에만 발생</td>
							</tr>
							
							<tr>
								<td>교환/반품 신청 기준일</td>
								<td>ㆍ단순변심에 의한 교환/반품은 제품 수령 후 7일 이내까지, 교환/반품 제한사항에 해당하지 않는 경우에만 가능 (배송비용과 교환/반품 비용 왕복배송비 고객부담)<br>
									ㆍ상품의 내용이 표시·광고의 내용과 다른 경우에는 상품을 수령한 날부터 3개월 이내, 그 사실을 안 날 또는 알 수 있었던 날부터 30일 이내에 청약철회 가능</td>
							</tr>
							
						</table>
					
						<div><h4>교환/반품 제한사항</h4></div>
						<div>ㆍ주문/제작 상품의 경우, 상품의 제작이 이미 진행된 경우</div>
						<div>ㆍ상품 포장을 개봉하여 사용 또는 설치 완료되어 상품의 가치가 훼손된 경우 (단, 내용 확인을 위한 포장 개봉의 경우는 예외)</div>
						<div>ㆍ고객의 사용, 시간경과, 일부 소비에 의하여 상품의 가치가 현저히 감소한 경우</div>
						<div>ㆍ세트상품 일부 사용, 구성품을 분실하였거나 취급 부주의로 인한 파손/고장/오염으로 재판매 불가한 경우</div>
						<div>ㆍ모니터 해상도의 차이로 인해 색상이나 이미지가 실제와 달라, 고객이 단순 변심으로 교환/반품을 무료로 요청하는 경우</div>
						<div>ㆍ제조사의 사정 (신모델 출시 등) 및 부품 가격 변동 등에 의해 무료 교환/반품으로 요청하는 경우</div>
					
						<div><h4>※ 각 상품별로 아래와 같은 사유로 취소/반품이 제한 될 수 있습니다.</h4></div>
						<table>
							<tr>
								<td>의류/잡화/수입명품</td>
								<td>ㆍ상품의 택(TAG) 제거, 라벨 및 상품 훼손, 구성품 누락으로 상품의 가치가 현저히 감소된 경우</td>
							</tr>
							
							<tr>
								<td>계절상품/식품/화장품</td>
								<td>ㆍ신선냉동 식품의 단순변심의 경우 <br>
									ㆍ뷰티 상품 이용 시 트러블(알러지, 붉은 반점, 가려움, 따가움)이 발생하는 경우, 진료 확인서 및 소견서 등을 증빙하면 환불이 가능 (제반비용 고객부담)</td>
							</tr>
							
							<tr>
								<td>전자/가전/설치상품</td>
								<td>ㆍ설치 또는 사용하여 재판매가 어려운 경우, 액정이 있는 상품의 전원을 켠 경우</td>
							</tr>
							
							<tr>
								<td>자동차용품</td>
								<td>ㆍ상품을 개봉하여 장착한 이후 단순변심인 경우</td>
							</tr>
							
							<tr>
								<td>CD/DVD/GAME/BOOK</td>
								<td>ㆍ복제가 가능한 상품의 포장 등을 훼손한 경우</td>
							</tr>
							
						</table>
						
						<div><h4>판매자정보</h4></div>
						<table>
							<tr>
								<td>상호/대표자</td>
								<td>쌍용 제주아일랜드</td>
								<td>사업장 소재지</td>
								<td>서울특별시 강남구 역삼동</td>
							</tr>
							
							<tr>
								<td>e-mail</td>
								<td>jeju@jeju.co.kr</td>
								<td>연락처</td>
								<td>02-1234-5678</td>
							</tr>
							
							<tr>
								<td>통신판매업 신고번호</td>
								<td>제1-서울강남-0001호</td>
								<td>사업자번호</td>
								<td>123-45-678</td>
							</tr>
						
						</table>
				
					</div>
				</div> 
				
			</div>
		
		</div>
		
	</div>
	
	
	
	
	
	<!-- Footer -->
	<jsp:include page = "../footer.jsp"></jsp:include>

</body>
</html>


				
				