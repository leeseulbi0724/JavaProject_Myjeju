<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
	<title>관광지 | JEJU ISLAND</title>
	<link rel="stylesheet" href="http://localhost:9000/myjeju/css/index.css">
	<link rel="stylesheet" href="http://localhost:9000/myjeju/css/travel/travel.css">
	<script src="http://localhost:9000/myjeju/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<!-- header -->
	<jsp:include page="../header.jsp"></jsp:include>
	
	<!-- content -->
	<div class="travel_content">
		<h3>관광지</h3>
		<section class="recommend_zone">
			<div class="travel_title">추천 관광지</div>
			<div class="travel_spot">
				<article class="travel_spot1">
					<img src="http://localhost:9000/myjeju/images/travel/한라산.jpg">
					<div class="spot_infor">
						<p class="spot_name">한라산 <span>국립공원</span></p>
						<p class="spot_tag">#산 #걷기/등산 #경관/포토 #친구 #사계절</p>
						<button type="button" class="btn_style" id="heart_btn"><img src="http://localhost:9000/myjeju/images/travel/empty_heart.png">516</button>
						<img src="http://localhost:9000/myjeju/images/travel/star.png"><span class="star_score">4.6 (416)</span>
					</div>
				</article>
				<article class="travel_spot2">
					<img src="http://localhost:9000/myjeju/images/travel/성산일출봉.jpg">
					<div class="spot_infor">
						<p class="spot_name">성산일출봉 <span>봉우리,고지</span></p>
						<p class="spot_tag">#일출 #오름 #경관/포토 #부모</p>
						<button type="button" class="btn_style" id="heart_btn"><img src="http://localhost:9000/myjeju/images/travel/empty_heart.png">452</button>
						<img src="http://localhost:9000/myjeju/images/travel/star.png"><span class="star_score">4.5 (594)</span>
					</div>
				</article>
				<article class="travel_spot3">
					<img src="http://localhost:9000/myjeju/images/travel/사려니숲길.jpg">
					<div class="spot_infor">
						<p class="spot_name">사려니 숲길 <span>도보코스</span></p>
						<p class="spot_tag">#숲길 #걷기/등산 #친구 #커플 #흐림 #봄</p>
						<button type="button" class="btn_style" id="heart_btn"><img src="http://localhost:9000/myjeju/images/travel/empty_heart.png">248</button>
						<img src="http://localhost:9000/myjeju/images/travel/star.png"><span class="star_score">4.4 (268)</span>
					</div>
				</article>
			</div>
		</section>
		<section class="map_zone">
			<div class="travel_title">관광지 찾기</div>
			<div class="travel_map">지도
				
			</div>
		</section>
		<section class="list_zone">
			<div class="travel_title">관광지 리스트</div>
			<table class="travel_list">
				<tbody>
					<tr class="travel_list1">
						<td>
							<img src="http://localhost:9000/myjeju/images/travel/우도.jpg">
						</td>
						<td>
							<p class="spot_name">우도 <span>해양도립공원</span></p>
							<p class="spot_addr">제주특별자치도 제주시 우도면 삼양고수물길 1</p>
							<div>
								<img src="http://localhost:9000/myjeju/images/travel/star.png"><span class="star_score">4.4 (268)</span>
							</div>
						</td>
					</tr>
					<tr class="travel_list2">
						<td>
							<img src="http://localhost:9000/myjeju/images/travel/이호테우.jpg">
						</td>
						<td>
							<p class="spot_name">이호테우 해변 <span>해수욕장,해변</span></p>
							<p class="spot_addr">제주특별자치도 제주시 서해안로 58</p>
							<div>
								<img src="http://localhost:9000/myjeju/images/travel/star.png"><span class="star_score">4.1 (683)</span>
							</div>
						</td>
					</tr>
					<tr class="travel_list3">
						<td>
							<img src="http://localhost:9000/myjeju/images/travel/천지연폭포.jpg">
						</td>
						<td>
							<p class="spot_name">천지연 폭포 <span>폭포</span></p>
							<p class="spot_addr">제주특별자치도 서귀포시 남성중로 2-15</p>
							<div>
								<img src="http://localhost:9000/myjeju/images/travel/star.png"><span class="star_score">4.3 (433)</span>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</section>
	</div>
	<!-- footer -->
	<jsp:include page="../footer.jsp"></jsp:include>
	
</body>
</html>