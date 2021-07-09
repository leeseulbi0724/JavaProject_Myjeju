<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
	<title>여행지 | JEJU ISLAND</title>
	<link rel="stylesheet" href="http://localhost:9000/myjeju/css/index.css">
	<link rel="stylesheet" href="http://localhost:9000/myjeju/css/travel/travel_detail.css">
	<script src="http://localhost:9000/myjeju/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<!-- header -->
	<jsp:include page="../header.jsp"></jsp:include>
	
	<!-- content -->
	<div class="travel_detail_top">
		<img src="http://localhost:9000/myjeju/images/travel_detail/한라산2.jpg">
		<div>
			<h1>한라산</h1>
			<h2>국립공원</h2>
			<p>
				제주특별자치도 제주시 1100로 2070-61<br>
				(+82) 064-713-9950
			</p>
		</div>
	</div>
	<div class="travel_detail_content">
		<section class="detail_infor">
			<h1>한라산 국립공원</h1>
			<div></div>
			<p>
				지리산, 북한의 금강산과 함께 한반도의 3대 영산에 속하는 한라산은<br>
				한반도의 최남단에 위치하고 있으며, 높이 해발 1,950m로 남한에서 가장 높다.<br><br>
	
				다양한 식생 분포를 이뤄 학술적 가치가 매우 높고 동식물의 보고로서, <br>
				1966년 10월 12일 천연기념물 제182호인 한라산천연보호구역으로 지정보호되고 있다. <br>
				1970년 3월 24일 국립공원으로 지정되었고, 2002년 12월에는 UNESCO 생물권 보전지역으로 지정되었다.<br><br>
	
				신생대 제4기의 젊은 화산섬인 한라산은 지금으로부터 2만 5천년 전까지 화산분화 활동을 하였으며, <br>
				한라산 주변에는 360여 개의 오름들이 분포되어 있어 특이한 경관을 창출하고 있다.<br>
				섬 중앙에 우뚝 솟은 한라산의 웅장한 자태는 자애로우면서도 강인한 기상을 가슴에 품고 있는 듯하다.
			</p>
			<button type="button" class="btn_style6" id="more_btn">
				<img src="http://localhost:9000/myjeju/images/travel/bill_list_btn2.png">
				<img src="http://localhost:9000/myjeju/images/travel/bill_list_btn.png">
			</button>
		</section>
		
		<section class="detail_image">
			<div class="detail_image2">
	 			<img src="http://localhost:9000/myjeju/images/travel_detail/한라산4.jpg">
	 		</div>
	 		<div class="detail_image2">
	 			<img src="http://localhost:9000/myjeju/images/travel_detail/한라산5.jpg">
	 		</div>
	 		<div class="detail_image2">
	 			<img src="http://localhost:9000/myjeju/images/travel_detail/한라산7.jpg">
	 		</div>
	 		<div class="detail_image2">
	 			<img src="http://localhost:9000/myjeju/images/travel_detail/한라산8.jpg">
	 		</div>
		</section>
		
		<section class="detail_photo">
			<div class="detail_photo2">
	 			<img src="http://localhost:9000/myjeju/images/travel_detail/photospot1.jpg">
	 		</div>
			<div class="detail_photo_infor">
				<h3>포토스팟</h3>
	 			<p>	
					윗세오름 코스<br> 
	 			</p>
	 			<p>	
					윗세오름 올라가는 중반에 위치한 휴식 공간으로,
					한라산의 절경을 배경으로 기념 사진을 찍을 수 있다.
	 			</p>
	 		</div>
		</section>
		
		<section class="detail_car">
			<h3>차박스팟</h3>
		</section>
		
		<section class="detail_review">
			<!-- <h3>리뷰</h3> --> 
			<div class="travel_review_zone">
				<dl>
					<dt>
						<img src="http://localhost:9000/myjeju/images/travel_detail/human.png">
						<div class="user_name">사용자</div>
					</dt>
					<dd><input type="text" name="travel_review" id="travel_review" placeholder="여행지가 어떠셨나요? 리뷰를 남겨주세요."></dd>
					<dd>
						<button type="button" class="btn_style3" id="travel_review_btn">등록</button>
					</dd>
				</dl>
			</div>
			<div class="travel_review_zone2">
				<div class="review_date">2021-07-09</div>
				<dl>
					<dt>
						<img src="http://localhost:9000/myjeju/images/travel_detail/human.png">
						<div class="user_name">장희수</div>
					</dt>
					<dd>한라산 정말 멋있어요! 올라가기 전에 김밥이나 간단한 초콜렛 꼭 챙겨가세요~ 많이 힘드네요</dd>
					<dd>
						<img src="http://localhost:9000/myjeju/images/travel_detail/like_finger.png" class="like_finger">
						<div class="like_score">14</div>
						<img src="http://localhost:9000/myjeju/images/travel_detail/btn-alert.png" class="btn_alert">
					</dd>
				</dl>
				<div class="review_date">2021-07-09</div>
				<dl>
					<dt>
						<img src="http://localhost:9000/myjeju/images/travel_detail/human.png">
						<div class="user_name">김민호</div>
					</dt>
					<dd>한라산 강추입니다!</dd>
					<dd>
						<img src="http://localhost:9000/myjeju/images/travel_detail/like_finger.png" class="like_finger">
						<div class="like_score">2</div>
						<img src="http://localhost:9000/myjeju/images/travel_detail/btn-alert.png" class="btn_alert">
					</dd>
				</dl>
				<div class="review_date">2021-07-08</div>
				<dl>
					<dt>
						<img src="http://localhost:9000/myjeju/images/travel_detail/human.png">
						<div class="user_name">이슬비</div>
					</dt>
					<dd>올라가는 건 힘들었지만 경치가 대박이에요!!!</dd>
					<dd>
						<img src="http://localhost:9000/myjeju/images/travel_detail/like_finger.png" class="like_finger">
						<div class="like_score">8</div>
						<img src="http://localhost:9000/myjeju/images/travel_detail/btn-alert.png" class="btn_alert">
					</dd>
				</dl>
			</div>
			<button type="button" class="btn_style6" id="more_btn">
				<img src="http://localhost:9000/myjeju/images/travel/bill_list_btn2.png">
				<img src="http://localhost:9000/myjeju/images/travel/bill_list_btn.png">
			</button>
		</section>
		
		<section class="detail_recommend">
			<h3>근처 추천 숙소</h3>
			
		</section>
	</div>
	<!-- footer -->
	<jsp:include page="../footer.jsp"></jsp:include>
	
</body>
</html>