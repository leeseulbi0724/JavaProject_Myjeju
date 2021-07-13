<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.myjeju.vo.* , com.myjeju.dao.* " %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			<c:forEach var="toplist" items="${toplist}">
				<article class="travel_spot1">
					<a href="http://localhost:9000/myjeju/food_detail.do?fid=${toplist.fid}"><img src="http://localhost:9000/myjeju/images/food/${toplist.f_image1}"></a>
					<div class="spot_infor">
						<p class="spot_name">${toplist.f_name} <span>${toplist.f_infor}</span></p>
						<p class="spot_tag">${toplist.f_tag}</p>
						<button type="button" class="btn_style" id="heart_btn">
							<img src="http://localhost:9000/myjeju/images/travel/empty_heart.png">${toplist.f_like}
						</button>
						<img src="http://localhost:9000/myjeju/images/travel/star.png"><span class="star_score">4.8 (223)</span>
					</div>
				</article>
			</c:forEach>
			</div>
		</section>
		<section class="map_zone">
			<div class="travel_title" style="margin-bottom:20px;">음식점 찾기</div>
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
			title : '${vo.f_name}',
			addr : '${vo.f_addr}',
			tel : '${vo.f_hp}',
			img : '${vo.f_image1}',
			latlng:	new kakao.maps.LatLng(${vo.f_vpoint}, ${vo.f_hpoint})
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
  	    content.innerHTML = "<div>" + "<img src=" + "http://localhost:9000/myjeju/images/food/"+data.img + ">" + "</div>" + "<div>" + data.title + "</div>" + "<div>" + data.addr + "</div>" + "<div>" + data.tel +  "</div>";
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
			<div class="travel_title">음식점 리스트</div>
			<div class="travel_search_zone">
				<input type="text" name="travel_search" id="travel_search" placeholder="음식점을 검색하세요.">
				<button type="button" class="btn_style3" id="travel_search_btn">검색</button>
			</div>
			<table class="travel_list">
				<tbody>
				<c:forEach var="vo" items="${list}">
					<tr class="travel_list1">
						<td class="travel_list_pic">
							<img src="http://localhost:9000/myjeju/images/food/${vo.f_image1}">
						</td>
						<td>
							<p class="spot_name">${vo.f_name} <span>${vo.f_infor}</span></p>
							<p class="spot_addr">${vo.f_addr}</p>
							<div>
								<img src="http://localhost:9000/myjeju/images/travel/star.png"><span class="star_score">4.6 (209)</span>
							</div>
						</td>
						<td>
							<button type="button" class="btn_style" id="heart_btn"><img src="http://localhost:9000/myjeju/images/travel/empty_heart.png">${vo.f_like}</button>
							<button type="button" class="btn_style4" id="more_infor" onclick="location.href='http://localhost:9000/myjeju/food_detail.do?fid=${vo.fid}'">상세정보</button>
						</td>
					</tr>
				</c:forEach>
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