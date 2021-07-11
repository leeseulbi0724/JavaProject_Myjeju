<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.myjeju.vo.* , com.myjeju.dao.* " %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
	<title>카페 | JEJU ISLAND</title>
	<link rel="stylesheet" href="http://localhost:9000/myjeju/css/index.css">
	<link rel="stylesheet" href="http://localhost:9000/myjeju/css/travel/travel.css">
	<script src="http://localhost:9000/myjeju/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<!-- header -->
	<jsp:include page="../header.jsp"></jsp:include>
	
	<!-- content -->
	<div class="travel_content">
		<h3>카페</h3>
		<section class="recommend_zone">
			<div class="travel_title">추천 카페</div>
			<div class="travel_spot">
				<article class="travel_spot1">
					<a href="http://localhost:9000/myjeju/food_detail.do"><img src="http://localhost:9000/myjeju/images/food/cafe2.jpg"></a>
					<div class="spot_infor">
						<p class="spot_name">CAFE가호 <span>애월 카페</span></p>
						<p class="spot_tag">#애월 #카페 #커피 #디저트 #가호</p>
						<button type="button" class="btn_style" id="heart_btn"><img src="http://localhost:9000/myjeju/images/travel/empty_heart.png">516</button>
						<img src="http://localhost:9000/myjeju/images/travel/star.png"><span class="star_score">4.5 (764)</span>
					</div>
				</article>
				<article class="travel_spot2">
					<a href="http://localhost:9000/myjeju/food_detail.do"><img src="http://localhost:9000/myjeju/images/food/cafe1.jpg"></a>
					<div class="spot_infor">
						<p class="spot_name">카페 델문도 <span>함덕 카페</span></p>
						<p class="spot_tag">#함덕 #바다위 #카페 #커피 #디저트</p>
						<button type="button" class="btn_style" id="heart_btn"><img src="http://localhost:9000/myjeju/images/travel/empty_heart.png">452</button>
						<img src="http://localhost:9000/myjeju/images/travel/star.png"><span class="star_score">4.1 (869)</span>
					</div>
				</article>
				<article class="travel_spot3">
					<a href="http://localhost:9000/myjeju/food_detail.do"><img src="http://localhost:9000/myjeju/images/food/cafe3.jpg"></a>
					<div class="spot_infor">
						<p class="spot_name">하이엔드 제주 <span>애월 카페</span></p>
						<p class="spot_tag">#애월 #하이엔드 #카페 #커피 #디저트</p>
						<button type="button" class="btn_style" id="heart_btn"><img src="http://localhost:9000/myjeju/images/travel/empty_heart.png">248</button>
						<img src="http://localhost:9000/myjeju/images/travel/star.png"><span class="star_score">3.8 (852)</span>
					</div>
				</article>
			</div>
		</section>
		<section class="map_zone">
	<div class="travel_title" style="margin-bottom:20px;">카페 찾기</div>
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
		<c:forEach var="vo" items="${list}">
		{
			title : '${vo.ca_name}',
			addr : '${vo.ca_addr}',
			tel : '${vo.ca_hp}',
			latlng:	new kakao.maps.LatLng(${vo.ca_vpoint}, ${vo.ca_hpoint})
		},
		</c:forEach>
	]
	
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
  	    content.innerHTML =  "<div>" + data.title + "</div>" + "<div>" + data.addr + "</div>" + "<div>" + data.tel +  "</div>";
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
			<div class="travel_title">카페 리스트</div>
			<div class="travel_search_zone">
				<input type="text" name="travel_search" id="travel_search" placeholder="카페를 검색하세요.">
				<button type="button" class="btn_style3" id="travel_search_btn">검색</button>
			</div>
			<table class="travel_list">
				<tbody>
					<tr class="travel_list1">
						<td class="travel_list_pic">
							<img src="http://localhost:9000/myjeju/images/food/cafe4.jpg">
						</td>
						<td>
							<p class="spot_name">두갓 <span>카페</span></p>
							<p class="spot_addr">제주특별자치도 제주시 해안동 2363-1</p>
							<div>
								<img src="http://localhost:9000/myjeju/images/travel/star.png"><span class="star_score">4.6 (57)</span>
							</div>
						</td>
						<td>
							<button type="button" class="btn_style" id="heart_btn"><img src="http://localhost:9000/myjeju/images/travel/empty_heart.png">1,674</button>
							<button type="button" class="btn_style4" id="more_infor" onclick="location.href='http://localhost:9000/myjeju/food_detail.do'">상세정보</button>
						</td>
					</tr>
					<tr class="travel_list2">
						<td class="travel_list_pic">
							<img src="http://localhost:9000/myjeju/images/food/cafe5.jpg">
						</td>
						<td>
							<p class="spot_name">골목카페옥수 <span>애월 카페</span></p>
							<p class="spot_addr">제주특별자치도 제주시 애월읍 소길1길 19</p>
							<div>
								<img src="http://localhost:9000/myjeju/images/travel/star.png"><span class="star_score">4.2 (142)</span>
							</div>
						</td>
						<td>
							<button type="button" class="btn_style" id="heart_btn"><img src="http://localhost:9000/myjeju/images/travel/empty_heart.png">354</button>
							<button type="button" class="btn_style4" id="more_infor" onclick="location.href='http://localhost:9000/myjeju/food_detail.do'">상세정보</button>
						</td>
					</tr>
					<tr class="travel_list3">
						<td class="travel_list_pic">
							<img src="http://localhost:9000/myjeju/images/food/cafe6.jpg">
						</td>
						<td>
							<p class="spot_name">아뜨리에 카페명월 <span>서귀포 카페</span></p>
							<p class="spot_addr">제주특별자치도 서귀포시 안덕면 상창리 1273-1</p>
							<div>
								<img src="http://localhost:9000/myjeju/images/travel/star.png"><span class="star_score">4.2 (93)</span>
							</div>
						</td>
						<td>
							<button type="button" class="btn_style" id="heart_btn"><img src="http://localhost:9000/myjeju/images/travel/empty_heart.png">287</button>
							<button type="button" class="btn_style4" id="more_infor" onclick="location.href='http://localhost:9000/myjeju/food_detail.do'">상세정보</button>
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