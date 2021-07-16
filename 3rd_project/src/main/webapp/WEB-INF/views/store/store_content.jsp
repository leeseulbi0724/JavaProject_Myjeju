<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
<title>스토어 | JEJU ISLAND</title>
<link rel = "stylesheet" href = "http://localhost:9000/myjeju/css/index.css">
<link rel = "stylesheet" href = "http://localhost:9000/myjeju/css/store/store.css">
<script src="http://localhost:9000/myjeju/js/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="css/admincss/bootstrap.css">
<link rel="stylesheet" href="css/admincss/bootstrap.min.css">
<script src="http://localhost:9000/myjeju/js/bootstrap.min.js"></script>
<script>

	$(document).ready(function() {
		
		/* 상단 카테고리 클릭 시 스크롤 다운 */
		$("#move1").click(function() {
			var offset = $("#here1").offset();
			$('html').animate({scrollTop : offset.top}, 100);
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
		
		
		/* 버튼 색상 변경
		$(".store_content_category>button").each(function() {
			$(this).click(function() {
				$(this).addClass("selected");
				$(this).siblings().removeClass("selected");
			});
		}); */
		
		/* window 스크롤 시 메뉴바 색상 변경 */
		/* $(window).scroll(function(){
	        var scroll = $(window).scrollTop();
	        var move1 = $("#move1").scrollTop();
	        var move2 = $("#move2").scrollTop();
	        var move3 = $("#move3").scrollTop();
	        var move4 = $("#move4").scrollTop();
	        
	        if (scroll > move1) {
				$("#move1").css("background" , "#4fa9de");
	        } else if (scroll > move2){
				$("#move2").css("background" , "#4fa9de");   
	        } else if (scroll > move3) {
	        	$("#move3").css("background" , "#4fa9de");
	        } else if (scroll > move4) {
	        	$("#move4").css("background", "#4fa9de");
	        } else {
	        	$(".store_content_category>button").css("background", "hsl(160, 0, 235)");
	        }
	      }); */
	      
	      
		
		/* 메뉴바 상단 고정 */
		var menu = $(".store_content_category").offset();
		
		$(window).scroll(function() {
			if($(document).scrollTop() > menu.top) {
				$('.store_content_category').addClass('menu-fixed');
			} else {
				$('.store_content_category').removeClass('menu-fixed');
			}
		});
		
		
		/* 장바구니 클릭시 */
		$("#storeBasket").click(function() {
			if($("#b_count").val() == 0) {
				alert("수량을 입력해주세요");
				$("#b_count").focus();
				return false;
			} else {				
					var form1 = $("#store_form").serialize();
					 $.ajax({
					        url:"mybasket_proc1.do",
					        type:"post",
					        data: form1, 
					        dataType: "json",
					      success:function(result){
					       		if ( result ) {
					       		 location.replace("mybasket.do");
					       		} else {
					       			alert("장바구니 담기 실패");
					       		}
					       	},		
					    });
			}
		});	

			
		/* 구매하기 버튼 클릭 시 */
		$("#store_buy").click(function() {
			if($("#b_count").val() == 0) {
				alert("수량을 입력해주세요");
				$("#b_count").focus();
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
			
			var st_value = $("#st_id1").val();
			$("#st_id2").val(st_value);

			var content = $("#st_content1").val();
			$("#st_content2").val(content);
			
			$('#replyModal').modal("show");
		});
		
		/* 문의하기 모달에서 문의하기 버튼 */
		$("#modalY1").click(function() {
			stofaq_form.submit();
		});
		
		/* 답변하기 모달에서 답변하기 버튼 */
		$("#modalY2").click(function(){
			storep_form.submit();
		});

		
	});

	
	
</script>

</head>
<body>

	<!-- Header -->
	<jsp:include page = "../header.jsp"></jsp:include>
	
	<div class = "store_content">
		
		<div><h3>상품 상세페이지</h3></div>
		
		<div class = "store_content_1">
			<div class = "store_content_top">
				<form name = "store_form" action = "store_buy.do" method = "POST" class = "store_content_form" id = "store_form">					
					<div class = "img_area">
						<img src = "http://localhost:9000/myjeju/images/store/${vo.s_image}">
					</div>
					
					<div class = "text_area">
						<div class = "title-box">
							<div class = "store_content_title">[${vo.s_category}] ${vo.s_name}</div>
							<div class = "store_content_price">가격　　　　　　${vo.s_price}원</div>
							<input type = "hidden" name = "s_name" value = "${vo.s_name}">
							<input type = "hidden" name = "s_price" value = "${vo.s_price}">
							<input type = "hidden" name = "s_image" value = "${vo.s_image}">
							<input type = "hidden" name = "s_sfile" value = "${vo.s_sfile}">
						</div>
						
						<div class = "option-box">
							<div>수량　　<input type = "number" min = "0" max = "10" id = "b_count" name = "b_count"></div>
						</div>						
						<input type = "hidden" value = "${id}" name = "id"  id = "id">
						<input type = "hidden" value = "${sid}" name = "sid"  id = "sid">
						<button type = "button" class = "store_btn_style1" id = "storeBasket">장바구니</button>
						<%-- <a href = "mybasket_proc.do?id=${id}"><button type = "button" class = "store_btn_style1" id = "storeBasket">장바구니</button></a> --%>
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
					<img src = "http://localhost:9000/myjeju/images/store/${vo.s_content}" id = "here1">
				</div>
				
				<div class = "store_product_review" id = "here2">
					<div>상품평</div>
					<article>
						<div>이진옥</div>
						<div><span>별점</span><span>2021.07.06</span></div>
						<div>제주도 오메기떡</div>
						<div><span>한줄평</span><span>맛있어요 짱</span></div>
					</article>
					
					<article>
						<div>이진옥</div>
						<div><span>별점</span><span>2021.07.06</span></div>
						<div>제주도 오메기떡</div>
						<div><span>한줄평</span><span>맛있어요 짱</span></div>
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
										<h3 class="modal-title" id="exampleModalLabel">문의하기</h3>
									</div>
									
									<form name = "stofaq_form" action = "store_faq_proc.do" method = "GET" class = "stofaq_form">
										<div class="modal-body">
											<input type = "text" value = "${id}" name = "id" id = "id" readonly>
											<input type = "text" value = "${sid}" name = "sid" id = "sid" readonly>
											<div><input type = "text" placeholder = "문의할 내용을 입력해주세요" name = "st_content" id = "st_content"></div>
										</div>
										
										<div class="modal-footer">
											<button class="btn" type="button" id = "modalY1">문의하기</button>
											<button class="btn" type="button" data-dismiss="modal">닫기</button>
										</div>
									</form>
									
								</div>
							</div>
						</div>
					
					<div class = "store_product_faq_content">
						<table class = "store_product_faq_table">
							<c:forEach var = "flist" items = "${flist}">
								<input type = "hidden" id = "st_id1" value = "${flist.st_id}">
								<input type = "hidden" id = "st_content1" value = "${flist.st_content}">
								<tr>
									<th>질문</th>
									<td>${id} ${flist.sid} ${flist.st_id}</td>
									<td>${flist.st_content}</td>
									<td>${flist.st_time}</td>
									<td><button type = "button" id = "storereplyBtn" class = "replyBtn">답변하기</button></td>
								</tr>
								
								<tr>
									<c:if test = "${!empty flist.re_content}">
										<th>┖─답변</th>
										<td>제주아일랜드 관리자</td>
										<td colspan = "2">${flist.re_content}</td>
										<td>${flist.re_time}</td>
									</c:if>
								</tr>
							</c:forEach>
							
						</table>
					</div>

					
					<!-- 답변하기 Modal-->
						<div class="modal fade" id="replyModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button class="close" type="button" data-dismiss="modal" aria-label="Close">
										<span aria-hidden="true">&times;</span></button>
										<h3 class="modal-title" id="exampleModalLabel">답변하기</h3>
									</div>
									
									<form name = "storep_form" action = "store_faq_reply_proc.do" method = "GET" class = "storep_form">
										<div class="modal-body">
											<input type = "text" value = "${id}" name = "id" id = "id" readonly>
											<input type = "text" value = "${sid}" name = "sid" id = "sid" readonly>
											<input type = "text" name = "st_id" id = "st_id2" readonly>
											<input type = "text" name = "st_content" id = "st_content2" readonly>
											<div><input type = "text" placeholder = "답변할 내용을 입력해주세요" name = "re_content" id = "re_content"></input></div>
										</div>
										
										<div class="modal-footer">
											<%-- <a class="btn" id="modalY2" href="store_faq_reply_proc.do?sid=${sid}">답변하기</a> --%>
											<button class="btn" type="button" id = "modalY2">답변하기</button>
											<button class="btn" type="button" data-dismiss="modal">닫기</button>
										</div>
									</form>	
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
