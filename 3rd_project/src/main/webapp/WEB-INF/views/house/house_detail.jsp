<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
	<title>숙소 | JEJU ISLAND</title>
	<link rel="stylesheet" href="http://localhost:9000/myjeju/css/index.css">
	<link rel="stylesheet" href="http://localhost:9000/myjeju/css/food/food_detail.css">
	<script src="http://localhost:9000/myjeju/js/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(function(){
			/* $(".infor_content").each(function(){
				var content = $(".infor_content");
				var content_txt = content.text();
				var content_txt_short = content_txt.substring(0,130)+"...";
				
				if(content_txt.length >= 100){
		               content.html(content_txt_short);
				}else{
		        	$("#more_btn").hide();
		        }
				
				 $("#more_btn").click(toggle_content);
				 
				 function toggle_content(){
					 if($(this).hasClass('short')){
		                    // 접기 상태
		                    $(".more_img1").show();
		                    $(".more_img2").hide();
		                    content.html(content_txt_short);
		                    $(this).removeClass('short');
		                }else{
		                    // 더보기 상태
		                    $(".more_img2").show();
		                    $(".more_img1").hide();
		                    content.html(content_txt);
		                    $(this).addClass('short');
		                }
				 }
			}); */
		});
	</script>
</head>
<body>
	<!-- header -->
	<jsp:include page="../header.jsp"></jsp:include>
	
	<!-- content -->
	<div class="food_detail_top">
		<img src="http://localhost:9000/myjeju/images/house/house_detail/스테이라움.jpg">
		<div>
			<h1>스테이라움</h1>
			<h3>전망좋은숙소</h3>
			<p>
				제주특별자치도 서귀포시 성산읍 오조리 570-1<br>
				(+82) 010-7495-9910
			</p>
			<div>
				<button type="button" class="btn_style" id="heart_btn"><img src="http://localhost:9000/myjeju/images/travel/empty_heart.png">675</button>
				<img src="http://localhost:9000/myjeju/images/travel/star.png"><span class="star_score">4.8 (223)</span>
			</div>
		</div>
	</div>
	<div class="food_detail_content">
		<section class="detail_infor">
			<p class="infor_content" >
				성산일출봉 근처에 위치한 숙소로 성산일출봉의 근사한 바다 전망을 볼 수 있습니다.<br>
			</p>
			<div></div>
			<p>
				객실 정보 : 2인실 전용 숙소
			</p>
			
		</section>
		
		<section class="detail_image">
			<div class="detail_image2">
	 			<img src="http://localhost:9000/myjeju/images/house/house_detail/스테이라움1.jpg">
	 		</div>
	 		<div class="detail_image2">
	 			<img src="http://localhost:9000/myjeju/images/house/house_detail/스테이라움2.jpg">
	 		</div>
	 		<div class="detail_image2">
	 			<img src="http://localhost:9000/myjeju/images/house/house_detail/스테이라움3.jpg">
	 		</div>
	 		<div class="detail_image2">
	 			<img src="http://localhost:9000/myjeju/images/house/house_detail/스테이라움4.jpg">
	 		</div>
		</section>
		
		<section class="detail_review">
			<!-- <h3>리뷰</h3> --> 
			<div class="food_review_zone">
				<dl>
					<dt>
						<img src="http://localhost:9000/myjeju/images/travel/travel_detail/human.png">
						<div class="user_name">사용자</div>
					</dt>
					<dd>
						<select name="star" id="star">
							<option id="star5" value="star5">★★★★★</option>
							<option id="star4" value="star4">★★★★☆</option>
							<option id="star3" value="star3">★★★☆☆</option>
							<option id="star2" value="star2">★★☆☆☆</option>
							<option id="star1" value="star1">★☆☆☆☆</option>
						</select>
					</dd>
					<dd><input type="text" name="food_review" id="food_review" placeholder="숙소가 어떠셨나요? 리뷰를 남겨주세요."></dd>
					<dd>
						<button type="button" class="btn_style3" id="food_review_btn">등록</button>
					</dd>
				</dl>
			</div>
			<div class="food_review_zone2">
				<div class="review_date">2021-07-09</div>
				<dl>
					<dt>
						<img src="http://localhost:9000/myjeju/images/travel/travel_detail/human.png">
						<div class="user_name">장희수</div>
					</dt>
					<dd>
						<img src="http://localhost:9000/myjeju/images/travel/star3.png"class="review_star">
					</dd>
					<dd>숙소 풍경이 다 했습니다!!!</dd>
					<dd>
						<img src="http://localhost:9000/myjeju/images/travel/travel_detail/like_finger.png" class="like_finger">
						<div class="like_score">14</div>
						<img src="http://localhost:9000/myjeju/images/travel/travel_detail/btn-alert.png" class="btn_alert">
					</dd>
				</dl>
				<div class="review_date">2021-07-09</div>
				<dl>
					<dt>
						<img src="http://localhost:9000/myjeju/images/travel/travel_detail/human.png">
						<div class="user_name">김민호</div>
					</dt>
					<dd>
						<img src="http://localhost:9000/myjeju/images/travel/star3.png"class="review_star">
					</dd>
					<dd>성산일출봉 일몰 정말 멋있어요! 숙소도 깨끗하고 좋았습니다.</dd>
					<dd>
						<img src="http://localhost:9000/myjeju/images/travel/travel_detail/like_finger.png" class="like_finger">
						<div class="like_score">2</div>
						<img src="http://localhost:9000/myjeju/images/travel/travel_detail/btn-alert.png" class="btn_alert">
					</dd>
				</dl>
				<div class="review_date">2021-07-08</div>
				<dl>
					<dt>
						<img src="http://localhost:9000/myjeju/images/travel/travel_detail/human.png">
						<div class="user_name">이슬비</div>
					</dt>
					<dd>
						<img src="http://localhost:9000/myjeju/images/travel/star3.png"class="review_star">
					</dd>
					<dd>숙소 너무 깔끔하고 사장님도 친절하세요~~~ 다음에 또 묵고싶습니다!</dd>
					<dd>
						<img src="http://localhost:9000/myjeju/images/travel/travel_detail/like_finger.png" class="like_finger">
						<div class="like_score">8</div>
						<img src="http://localhost:9000/myjeju/images/travel/travel_detail/btn-alert.png" class="btn_alert">
					</dd>
				</dl>
			</div>
			<button type="button" class="btn_style6" id="more_btn">
				<img src="http://localhost:9000/myjeju/images/travel/bill_list_btn2.png">
				<img src="http://localhost:9000/myjeju/images/travel/bill_list_btn.png">
			</button>
		</section>
		<button type="button" class="btn_style2" id="reserve_btn" onclick="location.href='http://localhost:9000/myjeju/calendar.do?hid=1&hdid=hd_1'">예약하기</button>
	</div>
	<!-- footer -->
	<jsp:include page="../footer.jsp"></jsp:include>
	
</body>
</html>