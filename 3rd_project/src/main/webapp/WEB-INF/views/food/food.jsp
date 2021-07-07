<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
	<title>음식점 | JEJU ISLAND</title>
	<link rel="stylesheet" href="http://localhost:9000/myjeju/css/index.css">
	<link rel="stylesheet" href="http://localhost:9000/myjeju/css/travel/travel.css">
	<script src="http://localhost:9000/myjeju/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<!-- header -->
	<jsp:include page="../header.jsp"></jsp:include>
	
	<!-- content -->
	<div class="travel_content">
		<h3>음식점</h3>
		<section class="recommend_zone">
			<div class="travel_title">추천 음식점</div>
			<div class="travel_spot">
				<article class="travel_spot1">
					<a href="http://localhost:9000/myjeju/travel_detail.do"><img src="http://localhost:9000/myjeju/images/food/foodstore3.jpg"></a>
					<div class="spot_infor">
						<p class="spot_name">하도작은식당 <span>서양음식전문점</span></p>
						<p class="spot_tag">#양식 #파스타 #뇨끼 #와인 #하도</p>
						<button type="button" class="btn_style" id="heart_btn"><img src="http://localhost:9000/myjeju/images/travel/empty_heart.png">675</button>
						<img src="http://localhost:9000/myjeju/images/travel/star.png"><span class="star_score">4.8 (223)</span>
					</div>
				</article>
				<article class="travel_spot2">
					<a href="http://localhost:9000/myjeju/travel_detail.do"><img src="http://localhost:9000/myjeju/images/food/foodstore2.jpg"></a>
					<div class="spot_infor">
						<p class="spot_name">미도리 제주  <span>음식점</span></p>
						<p class="spot_tag">#미도리 #정식 #연여구이 #제주시</p>
						<button type="button" class="btn_style" id="heart_btn"><img src="http://localhost:9000/myjeju/images/travel/empty_heart.png">558</button>
						<img src="http://localhost:9000/myjeju/images/travel/star.png"><span class="star_score">4.6 (89)</span>
					</div>
				</article>
				<article class="travel_spot3">
					<a href="http://localhost:9000/myjeju/travel_detail.do"><img src="http://localhost:9000/myjeju/images/food/foodstore1.jpg"></a>
					<div class="spot_infor">
						<p class="spot_name">별돈별 <span>협재해변점</span></p>
						<p class="spot_tag">#고기 #흑돼지 # #바다 #별돈별 #협재</p>
						<button type="button" class="btn_style" id="heart_btn"><img src="http://localhost:9000/myjeju/images/travel/empty_heart.png">452</button>
						<img src="http://localhost:9000/myjeju/images/travel/star.png"><span class="star_score">4.5 (103)</span>
					</div>
				</article>
			</div>
		</section>
		<section class="map_zone">
			<div class="travel_title">음식점 찾기</div>
			<div class="travel_map">지도
				
			</div>
		</section>
		<section class="list_zone">
			<div class="travel_title">음식점 리스트</div>
			<div class="travel_search_zone">
				<input type="text" name="travel_search" id="travel_search" placeholder="음식점을 검색하세요.">
				<button type="button" class="btn_style3" id="travel_search_btn">검색</button>
			</div>
			<table class="travel_list">
				<tbody>
					<tr class="travel_list1">
						<td class="travel_list_pic">
							<img src="http://localhost:9000/myjeju/images/food/foodstore4.jpg">
						</td>
						<td>
							<p class="spot_name">우진해장국 <span>해장국 전문점</span></p>
							<p class="spot_addr">제주특별자치도 제주시 삼도2동 서사로 11</p>
							<div>
								<img src="http://localhost:9000/myjeju/images/travel/star.png"><span class="star_score">4.6 (209)</span>
							</div>
						</td>
						<td>
							<button type="button" class="btn_style" id="heart_btn"><img src="http://localhost:9000/myjeju/images/travel/empty_heart.png">1,029</button>
							<button type="button" class="btn_style4" id="more_infor">상세정보</button>
						</td>
					</tr>
					<tr class="travel_list2">
						<td class="travel_list_pic">
							<img src="http://localhost:9000/myjeju/images/food/foodstore5.jpg">
						</td>
						<td>
							<p class="spot_name">고집돌우럭 <span>함덕점</span></p>
							<p class="spot_addr">제주특별자치도 제주시 특별자치도, 조천읍 신북로 491-9</p>
							<div>
								<img src="http://localhost:9000/myjeju/images/travel/star.png"><span class="star_score">4.0 (555)</span>
							</div>
						</td>
						<td>
							<button type="button" class="btn_style" id="heart_btn"><img src="http://localhost:9000/myjeju/images/travel/empty_heart.png">354</button>
							<button type="button" class="btn_style4" id="more_infor">상세정보</button>
						</td>
					</tr>
					<tr class="travel_list3">
						<td class="travel_list_pic">
							<img src="http://localhost:9000/myjeju/images/food/foodstore6.jpg">
						</td>
						<td>
							<p class="spot_name">올래국수 <span>국수 전문점</span></p>
							<p class="spot_addr">제주특별자치도 제주시 연동 귀아랑길 24</p>
							<div>
								<img src="http://localhost:9000/myjeju/images/travel/star.png"><span class="star_score">4.1 (869)</span>
							</div>
						</td>
						<td>
							<button type="button" class="btn_style" id="heart_btn"><img src="http://localhost:9000/myjeju/images/travel/empty_heart.png">287</button>
							<button type="button" class="btn_style4" id="more_infor">상세정보</button>
						</td>
					</tr>
				</tbody>
			</table>
		</section>
		<button type="button" class="btn_style5" id="more_btn">more
			<img src="http://localhost:9000/myjeju/images/travel/bill_list_btn2.png">
			<img src="http://localhost:9000/myjeju/images/travel/bill_list_btn.png">
		</button>
	</div>
	<!-- footer -->
	<jsp:include page="../footer.jsp"></jsp:include>
	
</body>
</html>