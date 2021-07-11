<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.myjeju.vo.* , com.myjeju.dao.* " %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
	<title>숙소 | JEJU ISLAND</title>
	<link rel="stylesheet" href="http://localhost:9000/myjeju/css/index.css">
	<link rel="stylesheet" href="http://localhost:9000/myjeju/css/travel/travel.css">
	<link rel="stylesheet" href="http://localhost:9000/myjeju/css/travel/map.css">
	<script src="http://localhost:9000/myjeju/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<!-- header -->
	<jsp:include page="../header.jsp"></jsp:include>
	
	<!-- content -->
	<div class="travel_content">
		<h3>숙소</h3>
		<section class="recommend_zone">
			<div class="travel_title">추천 숙소</div>
			<div class="travel_spot">
				<article class="travel_spot1">
					<a href="http://localhost:9000/myjeju/travel_detail.do"><img src="http://localhost:9000/myjeju/images/no1.jpg"></a>
					<div class="spot_infor">
						<p class="spot_name">스테이라움 <span>전망좋은숙소</span></p>
						<p class="spot_tag">#일출봉 #비경감상소 #경관/포토 #일몰 #전망</p>
						<button type="button" class="btn_style" id="heart_btn">
							<img src="http://localhost:9000/myjeju/images/travel/empty_heart.png">81
						</button>
						<img src="http://localhost:9000/myjeju/images/travel/star.png"><span class="star_score">4.9 (82)</span>
					</div>
				</article>
				<article class="travel_spot2">
					<a href="http://localhost:9000/myjeju/travel_detail.do"><img src="http://localhost:9000/myjeju/images/no2.jpg"></a>
					<div class="spot_infor">
						<p class="spot_name">한동지몽동 <span>펜션</span></p>
						<p class="spot_tag">#바다 #한동지 #경관 #언덕위</p>
						<button type="button" class="btn_style" id="heart_btn">
							<img src="http://localhost:9000/myjeju/images/travel/empty_heart.png">38
						</button>
						<img src="http://localhost:9000/myjeju/images/travel/star.png"><span class="star_score">4.8 (17)</span>
					</div>
				</article>
				<article class="travel_spot3">
					<a href="http://localhost:9000/myjeju/travel_detail.do"><img src="http://localhost:9000/myjeju/images/no3.jpg"></a>
					<div class="spot_infor">
						<p class="spot_name">자운 <span>게스트하우스</span></p>
						<p class="spot_tag">#자운 #게하 #제주 #전통 #고즈넉</p>
						<button type="button" class="btn_style" id="heart_btn">
							<img src="http://localhost:9000/myjeju/images/travel/empty_heart.png">227
						</button>
						<img src="http://localhost:9000/myjeju/images/travel/star.png"><span class="star_score">4.7 (15)</span>
					</div>
				</article>
			</div>
		</section>
		<section class="map_zone">
			<div class="travel_title">숙소 찾기</div>
			<div id="map" style="width:100%;height:500px;"></div>
			<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2d54e46df64658650b7436b0cf338c67&libraries=services"></script>
			<script>
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
		    	mapOption = { 
			        center: new kakao.maps.LatLng(33.407461303086784, 126.61957095129178), // 지도의 중심좌표
			        level: 10 // 지도의 확대 레벨
		    };
		
			var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
		 	
			// 마커를 표시할 위치와 title 객체 배열입니다 
			var positions = [
		    	{	
		    		title : '자운게스트하우스',
		    		addr : '제주특별자치도 서귀포시 대정읍 하모리 818-8',
		    		tel : '064-794-2415',
		        	latlng: new kakao.maps.LatLng(33.22677759096375, 126.25531933528)
		    	},
		    	{	
		    		title : '스테이라움',
		    		addr : '제주특별자치도 서귀포시 성산읍 오조리 570-1',
		    		tel : '010-7495-9910',
		        	latlng: new kakao.maps.LatLng(33.46824947997743, 126.91558647663133)
		    	},
		    	{	
		    		title : '한동지몽동',
		    		addr : '제주특별자치도 제주시 구좌읍 한동로1길',
		    		tel : '010-8810 7588',
		        	latlng: new kakao.maps.LatLng(33.538067745363335, 126.82689008525008)
		    	},
		    	{	
		    		title : '제주센트럴파크레지던스',
		    		addr : '제주특별자치도 제주시 연동 292-40',
		    		tel : '010-9983-0083',
		        	latlng: new kakao.maps.LatLng(33.48899088840315, 126.49520037084571)
		    	},
		    	{	
		    		title : '태흥예술극장',
		    		addr : '제주특별자치도 서귀포시 남원읍 태위로912번길 28',
		    		tel : '064-901-8738',
		        	latlng: new kakao.maps.LatLng(33.28455123295662, 126.74477008247413)
		    	},
		    	{	
		    		title : '당당하우스',
		    		addr : '제주특별자치도 제주시 구좌읍 송당리 1916-5',
		    		tel : '010-3249-7277',
		        	latlng: new kakao.maps.LatLng(33.46607756747349, 126.78261816217112)
		    	},
		    	{	
		    		title : '뚜르드제주',
		    		addr : '제주특별자치도 제주시 구좌읍 종달로1길',
		    		tel : '010-5007-5012',
		        	latlng: new kakao.maps.LatLng(33.49617928584109, 126.90002638433614)
		    	},
		    	{	
		    		title : '서귀포 Apro',
		    		addr : '제주특별자치도 서귀포시 표선면 토산리 1481-1',
		    		tel : '010-4157-9960',
		        	latlng: new kakao.maps.LatLng(33.328524652551685, 126.76570541316822)
		    	},
		    	{
		    		title : '팀버하우스',
		    		addr : '제주특별자치도 제주시 애월읍 곽지리 1624',
		    		tel : '010-9679-4241',
		        	latlng: new kakao.maps.LatLng(33.45119013793356, 126.30791458247862)
		    	},
		    	{
		    		title : '하랑게스트하우스',
		    		addr : '제주특별자치도 서귀포시 대정읍 일과로13번길 1',
		    		tel : '010-4404-5585',
		        	latlng: new kakao.maps.LatLng(33.23301495999036, 126.24381841502205)
		    	},
		    	{
		    		title : '디스이스핫(THISISHOT_EL)',
		    		addr : '제주특별자치도 제주시 구좌읍 하도리 59-1',
		    		tel : '064-784-4447',
		        	latlng: new kakao.maps.LatLng(33.5133628857966, 126.89734854015344)
		    	},
		    	{
		    		title : '하이레지던스',
		    		addr : '제주특별자치도 제주시 은남1길 46',
		    		tel : '064-743-1300',
		        	latlng: new kakao.maps.LatLng(33.4900513123438, 126.49112769416554)
		    	},
		    	{
		    		title : '그린나래',
		    		addr : '제주특별자치도 서귀포시 성산읍 서성일로 615',
		    		tel : '064-782-7071',
		        	latlng: new kakao.maps.LatLng(33.42822222927255, 126.85087311131457)
		    	},
		    	{
		    		title : '달다하우스',
		    		addr : '제주특별자치도 제주시 구좌읍 김녕리 1607',
		    		tel : '010-2695-7737',
		        	latlng: new kakao.maps.LatLng(33.55652291888224, 126.74883349597148)
		    	},
		    	{
		    		title : '더하도스파빌라',
		    		addr : '제주특별자치도 제주시 구좌읍 하도리 53-37',
		    		tel : '010-2696-0201',
		        	latlng: new kakao.maps.LatLng(33.51064209142311, 126.89294542480685)
		    	}
		    	
			];
			
			for(let i=0; i < positions.length; i++){
			    var data = positions[i];
			    displayMarker(data);
			}
			
			// 지도에 마커를 표시하는 함수입니다    
			function displayMarker(data) { 
			    var marker = new kakao.maps.Marker({
			        map: map,
			        position: data.latlng
			    });
			    var overlay = new kakao.maps.CustomOverlay({
			        yAnchor: 1,
			        position: marker.getPosition()
			    });
			    
		    	var content = document.createElement('div');
		  	    content.innerHTML =  "<div>" + data.title + "</div>" + "<div>" + data.addr + "</div>" + "<div>" + data.tel;
		  	    content.style.cssText = 'background: white; border: 1px solid black; padding:3px; border-radius:5px ';
			
			    var closeBtn = document.createElement('button');
			    closeBtn.innerHTML = '닫기';
			    closeBtn.style.cssText = 'background: white; border: 1px solid black; float:right; margin-top:-68px ';
			    closeBtn.onclick = function () {
			        overlay.setMap(null);
			    };
			    content.appendChild(closeBtn);
			    overlay.setContent(content);

			    kakao.maps.event.addListener(marker, 'click', function() {
			        overlay.setMap(map);
			    });
			}
			</script>
		</section>
		<section class="list_zone">
			<div class="travel_title">숙소 리스트</div>
			<div class="travel_search_zone">
				<input type="text" name="travel_search" id="travel_search" placeholder="숙소를 검색하세요.">
				<button type="button" class="btn_style3" id="travel_search_btn">검색</button>
			</div>
			<table class="travel_list">
				<tbody>
					<tr class="travel_list1">
						<td class="travel_list_pic">
							<img src="http://localhost:9000/myjeju/images/house/그린나래.jpg">
						</td>
						<td>
							<p class="spot_name">그린나래 <span>2성급 호텔</span></p>
							<p class="spot_addr">제주특별자치도 서귀포시 성산읍 서성일로 615</p>
							<div>
								<img src="http://localhost:9000/myjeju/images/travel/star.png"><span class="star_score">4.4 (268)</span>
							</div>
						</td>
						<td>
							<button type="button" class="btn_style" id="heart_btn"><img src="http://localhost:9000/myjeju/images/travel/empty_heart.png">1,674</button>
							<button type="button" class="btn_style4" id="more_infor" onclick="location.href='http://localhost:9000/myjeju/travel_detail.do'">상세정보</button>
						</td>
					</tr>
					<tr class="travel_list2">
						<td class="travel_list_pic">
							<img src="http://localhost:9000/myjeju/images/house/당당하우스.jpg">
						</td>
						<td>
							<p class="spot_name">당당하우스 <span>펜션</span></p>
							<p class="spot_addr">제주특별자치도 제주시 구좌읍 송당리 1916-5</p>
							<div>
								<img src="http://localhost:9000/myjeju/images/travel/star.png"><span class="star_score">4.1 (683)</span>
							</div>
						</td>
						<td>
							<button type="button" class="btn_style" id="heart_btn"><img src="http://localhost:9000/myjeju/images/travel/empty_heart.png">354</button>
							<button type="button" class="btn_style4" id="more_infor" onclick="location.href='http://localhost:9000/myjeju/travel_detail.do'">상세정보</button>
						</td>
					</tr>
					<tr class="travel_list3">
						<td class="travel_list_pic">
							<img src="http://localhost:9000/myjeju/images/house/동행게스트하우스.jpg">
						</td>
						<td>
							<p class="spot_name">동행 <span>게스트하우스</span></p>
							<p class="spot_addr">제주특별자치도 제주시 한림읍 한림해안로 590</p>
							<div>
								<img src="http://localhost:9000/myjeju/images/travel/star.png"><span class="star_score">4.3 (433)</span>
							</div>
						</td>
						<td>
							<button type="button" class="btn_style" id="heart_btn"><img src="http://localhost:9000/myjeju/images/travel/empty_heart.png">287</button>
							<button type="button" class="btn_style4" id="more_infor" onclick="location.href='http://localhost:9000/myjeju/travel_detail.do'">상세정보</button>
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