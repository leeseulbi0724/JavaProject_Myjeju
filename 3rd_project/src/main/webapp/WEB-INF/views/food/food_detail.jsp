<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
	<title>음식점 | JEJU ISLAND</title>
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
		<img src="http://localhost:9000/myjeju/images/food/food_detail/foodstore3.jpg">
		<div>
			<h1>하도작은식당</h1>
			<h3>서양음식전문점</h3>
			<p>
				제주특별자치도 제주시 구좌읍 하도13길 62-9<br>
				(+82) 010-4813-3091
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
				서양음식을 주 메뉴로하는 동쪽 하도리에 위치한 예약제식당입니다.<br>
				매주 월,화 휴무<br>
				영업시간 pm12:00 ~ pm7:30<br>
				쉬는시간 pm3:00 ~ pm5:00<br>
			</p>
		</section>
		
		<section class="detail_image">
			<div class="detail_image2">
	 			<img src="http://localhost:9000/myjeju/images/food/food_detail/하도리1.jpg">
	 		</div>
	 		<div class="detail_image2">
	 			<img src="http://localhost:9000/myjeju/images/food/food_detail/하도리3.jpg">
	 		</div>
	 		<div class="detail_image2">
	 			<img src="http://localhost:9000/myjeju/images/food/food_detail/하도리2.jpg">
	 		</div>
	 		<div class="detail_image2">
	 			<img src="http://localhost:9000/myjeju/images/food/food_detail/하도리4.jpg">
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
					<dd><input type="text" name="food_review" id="food_review" placeholder="식사가 어떠셨나요? 리뷰를 남겨주세요."></dd>
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
					<dd>여기 정말 맛집입니다!!! 분위기도 너무 좋아요~~</dd>
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
					<dd>제주도가면 꼭 가는 가게입니다! 강추입니다!</dd>
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
					<dd>제주도 맛집 top5안에 들어요~!</dd>
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
	</div>
	<!-- footer -->
	<jsp:include page="../footer.jsp"></jsp:include>
	
</body>
</html>