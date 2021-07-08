<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.myjeju.vo.* , com.myjeju.dao.* " %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
<title>숙박시설 | JEJU ISLAND</title>
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/accomodation.css">
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/index.css">
<script src="http://localhost:9000/myjeju/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<!-- header -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- content -->
	<div class="recommend_house">
		<div class="recommend_title">숙소</div>
		<div class="recommend_title2">추천숙소</div>
		<div class="recommend_content">
			<section>
				<article class="img_content">
					<div class="img1">
						<img src="http://localhost:9000/myjeju/images/no1.jpg">
						<div class="img_title1">[전망좋은숙소] 스테이라움 일출봉 비경감상소</div>
						<div class="img1_text">
							<button id="click1"><div class="heart"></div>81</button>
							<div class="detail_text">
								<div class="star-rating">
								<span style ="width:95%"></span> 
								</div>
								<div class="score">4.89 (82)</div>
							</div>
						</div>
					</div>
					<div class="img2">
						<img src="http://localhost:9000/myjeju/images/no2.jpg">
						<div class="img_title1">[바닷가근처숙소] 한동지몽동</div>
						<div class="img1_text">
							<button id="click2"><div class="heart"></div>38</button>
							<div class="detail_text">
								<div class="star-rating">
								<span style ="width:91%"></span> 
								</div>
								<div class="score">4.82 (17)</div>
							</div>
						</div>
					</div>
					<div class="img3">
						<img src="http://localhost:9000/myjeju/images/no3.jpg">
						<div class="img_title1">[제주전통] 자운게스트하우스</div>
						<div class="img1_text">
							<button id="click3"><div class="heart"></div>27</button>
							<div class="detail_text">
								<div class="star-rating">
								<span style ="width:90%"></span> 
								</div>
								<div class="score">4.73 (15)</div>
							</div>
						</div>
					</div>
				</article>
			</section>
		</div>
	</div>
	<div class="find_accomodation">
		<div class="find_title">숙소찾기(지도)</div>
		<div>
				<c:forEach var="vo" items="${list}">
					${vo.jname},${vo.jaddr},${vo.jtel}
				</c:forEach>
			
		</div>
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
			title : '${vo.jname}',
			addr : '${vo.jaddr}',
			tel : '${vo.jtel}',
			latlng:	new kakao.maps.LatLng(${vo.jlatitude}, ${vo.jlongitude})
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
	</div>
<div class="accomodation_list">
	<div class="accomodation_list_title">숙소리스트</div>
	<div class="buttontext">
	<input type="text">
	<button type="button">검색</button>
	</div>
	
	<table border="1">
		<tr>
			<th>NO</th>
			<th>등급</th>
			<th>숙소명</th>
			<th>객실수</th>
			<th>소재지</th>
			<th>홈페이지 주소</th>
			<th>총지배인</th>
			<th>전화번호</th>
		</tr>
		<tr>
			<td>1</td>
			<td>특1</td>
			<td>(주)호텔신라 제주신라</td>
			<td>429</td>
			<td>서귀포시 색달동 </td>
			<td>www.shilla.net</td>
			<td>김영윤</td>
			<td>736-4466</td>
		</tr>
		<tr>
			<td>2</td>
			<td>특1</td>
			<td>롯데호텔 제주</td>
			<td>500</td>
			<td>서귀포시 색달동</td>
			<td>www.lottehotel.co.kr</td>
			<td>김승웅</td>
			<td>731-1000</td>
		</tr>
		<tr>
			<td>3</td>
			<td>특1</td>
			<td>하얏트리젠시 제주</td>
			<td>224</td>
			<td>서귀포시 색달동</td>
			<td>www.hyattjeju.com</td>
			<td>에드리안 스레이터</td>
			<td>733-1234</td>
		</tr>
		<tr>
			<td>4</td>
			<td>특1</td>
			<td>스위트호텔 제주</td>
			<td>90</td>
			<td>서귀포시 색달동</td>
			<td>www.suites.co.kr</td>
			<td>손현종</td>
			<td>738-3800</td>
		</tr>
		<tr>
			<td>5</td>
			<td>특1</td>
			<td>파라다이스호텔 제주</td>
			<td>56</td>
			<td>서귀포시 토평동</td>
			<td>www.jeju.paradisehotel.co.kr</td>
			<td>한상완</td>
			<td>763-2100</td>
		</tr>
		<tr>
			<td>6</td>
			<td>특1</td>
			<td>제주그랜드 호텔</td>
			<td>512</td>
			<td>제주시 연동동</td>
			<td>www.oraresort.com</td>
			<td>이병선</td>
			<td>747-5000</td>
		</tr>
		<tr>
			<td>7</td>
			<td>특1</td>
			<td>제주오리엔탈 호텔</td>
			<td>313</td>
			<td>제주시 삼도2동</td>
			<td>www.oriental.co.kr</td>
			<td>송재정</td>
			<td>756-5552</td>
		</tr>
		<tr>
			<td>8</td>
			<td>특1</td>
			<td>제주 KAL호텔</td>
			<td>282</td>
			<td>제주시 이도1동</td>
			<td>www.kalhotel.co.kr</td>
			<td>홍성균</td>
			<td>724-2001</td>
		</tr>
		<tr>
			<td>9</td>
			<td>특1</td>
			<td>크라운프라자호텔 제주</td>
			<td>224</td>
			<td>제주시 연동</td>
			<td>www.crowneplaza.co.kr</td>
			<td>이종화</td>
			<td>741-8000</td>
		</tr>
		<tr>
			<td>10</td>
			<td>특1</td>
			<td>제주퍼시픽호텔</td>
			<td>177</td>
			<td>제주시 용담1동</td>
			<td>www.jejupacific.co.kr</td>
			<td>차삼식</td>
			<td>758-2500</td>
		</tr>
		
		
	</table>
	
	
</div>
	<!-- footer -->
</body>
</html>