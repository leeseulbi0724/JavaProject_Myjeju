<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.myjeju.vo.* , com.myjeju.dao.* " %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head profile="http://www.w3.org/2005/10/profile">
<meta charset="UTF-8">
	<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
	<title>여행지 | JEJU ISLAND</title>
	<link rel="stylesheet" href="http://localhost:9000/myjeju/css/index.css">
	<link rel="stylesheet" href="http://localhost:9000/myjeju/css/travel/travel.css">
	<script src="http://localhost:9000/myjeju/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<!-- header -->
	<jsp:include page="../header.jsp"></jsp:include>
	
	<!-- content -->
	<div class="travel_content">
		<h3>여행지</h3>
		<section class="recommend_zone">
			<div class="travel_title">추천 여행지</div>
			<div class="travel_spot">
			<c:forEach var="toplist" items="${toplist}">
				<article class="travel_spot1">
					<a href="http://localhost:9000/myjeju/travel_detail.do?tid=${toplist.tid }"><img src="http://localhost:9000/myjeju/images/travel/${toplist.t_image1}"></a>
					<div class="spot_infor">
						<p class="spot_name">${toplist.t_name} <span>${toplist.t_infor}</span></p>
						<p class="spot_tag">${toplist.t_tag}</p>
						<button type="button" class="btn_style" id="heart_btn">
							<img src="http://localhost:9000/myjeju/images/travel/empty_heart.png">${toplist.t_like}
						</button>
						<img src="http://localhost:9000/myjeju/images/travel/star.png"><span class="star_score">4.6 (416)</span>
					</div>
				</article>
			</c:forEach>
			</div>
		</section>
		
		<section class="map_zone">
			<div class="travel_title" style="margin-bottom:20px;">여행지 찾기</div>
			<%-- <div>
				<c:forEach var="vo" items="${list}">
				${vo.t_name},${vo.t_addr},${vo.t_hp},<img src="http://localhost:9000/myjeju/images/travel/${vo.t_image1 }"> 
				</c:forEach>
			</div> --%>
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
			title : '${vo.t_name}',
			addr : '${vo.t_addr}',
			tel : '${vo.t_hp}',
			img : '${vo.t_image1}',
			latlng:	new kakao.maps.LatLng(${vo.t_vpoint}, ${vo.t_hpoint})
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
  	    content.innerHTML =  "<div style='background-color:#4fa9de; color:white; font-weight:bold; padding:10px;'>" + data.title + "</div>" + "<div style='font-weight:bold; padding:10px;'>" + data.addr + "</div>" + "<div style='padding:10px; color:#4fa9de; '>" + data.tel +  "</div>" + "<div>" + "<a href='http://localhost:9000/myjeju/travel_detail.do' style='text-decoration:none; padding:10px;'>상세보기</a> </div>";
  	    content.style.cssText = 'background: white; border-radius:10px; margin:0; padding:0; ';
	
	    var closeBtn = document.createElement('button');
	    closeBtn.innerHTML = '닫기';
	    closeBtn.style.cssText = 'background: white; border: 1px solid white; float:right; margin-top:-145px; color:black; font-weight:bold; padding:3px;';
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
			<div class="travel_title">여행지 리스트</div>
			<div class="travel_search_zone">
				<input type="text" name="travel_search" id="travel_search" placeholder="여행지를 검색하세요.">
				<button type="button" class="btn_style3" id="travel_search_btn">검색</button>
			</div>
			<table class="travel_list">
				<tbody>
				<c:forEach var="vo" items="${list}">
					<tr class="travel_list1">
						<td class="travel_list_pic">
							<img src="http://localhost:9000/myjeju/images/travel/${vo.t_image1}">
						</td>
						<td>
							<p class="spot_name">${vo.t_name} <span>${vo.t_infor}</span></p>
							<p class="spot_addr">${vo.t_addr}</p>
							<div>
								<img src="http://localhost:9000/myjeju/images/travel/star.png"><span class="star_score">4.4 (268)</span>
							</div>
						</td>
						<td>
							<button type="button" class="btn_style" id="heart_btn"><img src="http://localhost:9000/myjeju/images/travel/empty_heart.png">${vo.t_like}</button>
							<button type="button" class="btn_style4" id="more_infor" onclick="location.href='http://localhost:9000/myjeju/travel_detail.do?tid=${vo.tid }'">상세정보</button>
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