<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.myjeju.vo.* " %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
<title>숙박시설 정보조회</title>
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/accomodation.css">
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/index.css">
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
		<p style="margin-top:-12px"></p>
	<div class="map_wrap">
	    <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>
	    <ul id="category">
	        <li id="AD5" data-order="0"> 
	            <span class="category_bg hotel"></span>
	            숙박
	        </li>       
	        <li id="FD6" data-order="1"> 
	            <span class="category_bg restaurant"></span>
	            음식점
	        </li>  
	        <li id="CE7" data-order="2"> 
	            <span class="category_bg cafe"></span>
	            카페
	        </li>
	         <li id="AT4" data-order="3"> 
	            <span class="category_bg attraction"></span>
	            관광지
	         </li> 
	         <li id="CT1" data-order="4"> 
	            <span class="category_bg culture"></span>
	           	문화공간
	         </li>    
	        
	    </ul>
	</div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2d54e46df64658650b7436b0cf338c67&libraries=services"></script>
<script>
// 마커를 클릭했을 때 해당 장소의 상세정보를 보여줄 커스텀오버레이입니다
var placeOverlay = new kakao.maps.CustomOverlay({zIndex:1}), 
    contentNode = document.createElement('div'), // 커스텀 오버레이의 컨텐츠 엘리먼트 입니다 
    markers = [], // 마커를 담을 배열입니다
    currCategory = ''; // 현재 선택된 카테고리를 가지고 있을 변수입니다
 
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.407461303086784, 126.61957095129178), // 지도의 중심좌표
        level: 10 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places(map); 

// 지도에 idle 이벤트를 등록합니다
kakao.maps.event.addListener(map, 'idle', searchPlaces);

// 커스텀 오버레이의 컨텐츠 노드에 css class를 추가합니다 
contentNode.className = 'placeinfo_wrap';

// 커스텀 오버레이의 컨텐츠 노드에 mousedown, touchstart 이벤트가 발생했을때
// 지도 객체에 이벤트가 전달되지 않도록 이벤트 핸들러로 kakao.maps.event.preventMap 메소드를 등록합니다 
addEventHandle(contentNode, 'mousedown', kakao.maps.event.preventMap);
addEventHandle(contentNode, 'touchstart', kakao.maps.event.preventMap);

// 커스텀 오버레이 컨텐츠를 설정합니다
placeOverlay.setContent(contentNode);  

// 각 카테고리에 클릭 이벤트를 등록합니다
addCategoryClickEvent();

// 엘리먼트에 이벤트 핸들러를 등록하는 함수입니다
function addEventHandle(target, type, callback) {
    if (target.addEventListener) {
        target.addEventListener(type, callback);
    } else {
        target.attachEvent('on' + type, callback);
    }
}

// 카테고리 검색을 요청하는 함수입니다
function searchPlaces() {
    if (!currCategory) {
        return;
    }
    
    // 커스텀 오버레이를 숨깁니다 
    placeOverlay.setMap(null);

    // 지도에 표시되고 있는 마커를 제거합니다
    removeMarker();
    
    ps.categorySearch(currCategory, placesSearchCB, {useMapBounds:true}); 
}

// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
function placesSearchCB(data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {

        // 정상적으로 검색이 완료됐으면 지도에 마커를 표출합니다
        displayPlaces(data);
    } else if (status === kakao.maps.services.Status.ZERO_RESULT) {
        // 검색결과가 없는경우 해야할 처리가 있다면 이곳에 작성해 주세요

    } else if (status === kakao.maps.services.Status.ERROR) {
        // 에러로 인해 검색결과가 나오지 않은 경우 해야할 처리가 있다면 이곳에 작성해 주세요
        
    }
}

// 지도에 마커를 표출하는 함수입니다
function displayPlaces(places) {

    // 몇번째 카테고리가 선택되어 있는지 얻어옵니다
    // 이 순서는 스프라이트 이미지에서의 위치를 계산하는데 사용됩니다
    var order = document.getElementById(currCategory).getAttribute('data-order');

    

    for ( var i=0; i<places.length; i++ ) {

            // 마커를 생성하고 지도에 표시합니다
            var marker = addMarker(new kakao.maps.LatLng(places[i].y, places[i].x), order);

            // 마커와 검색결과 항목을 클릭 했을 때
            // 장소정보를 표출하도록 클릭 이벤트를 등록합니다
            (function(marker, place) {
                kakao.maps.event.addListener(marker, 'click', function() {
                    displayPlaceInfo(place);
                });
            })(marker, places[i]);
    }
}

// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
function addMarker(position, order) {
    var imageSrc = "http://localhost:9000/myjeju/images/blue_marker2.png", // 마커 이미지 url, 스프라이트 이미지를 씁니다
        imageSize = new kakao.maps.Size(27, 28),  // 마커 이미지의 크기
        imgOptions =  {
           /*  spriteSize : new kakao.maps.Size(72, 208), // 스프라이트 이미지의 크기
            spriteOrigin : new kakao.maps.Point(46, (order*36)), */ // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
            offset: new kakao.maps.Point(11, 28) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
        },
        markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
            marker = new kakao.maps.Marker({
            position: position, // 마커의 위치
            image: markerImage 
        });

    marker.setMap(map); // 지도 위에 마커를 표출합니다
    markers.push(marker);  // 배열에 생성된 마커를 추가합니다

    return marker;
}

// 지도 위에 표시되고 있는 마커를 모두 제거합니다
function removeMarker() {
    for ( var i = 0; i < markers.length; i++ ) {
        markers[i].setMap(null);
    }   
    markers = [];
}

// 클릭한 마커에 대한 장소 상세정보를 커스텀 오버레이로 표시하는 함수입니다
function displayPlaceInfo (place) {
    var content = '<div class="placeinfo">' +
                    '   <a class="title" href="' + place.place_url + '" target="_blank" title="' + place.place_name + '">' + place.place_name + '</a>';   

    if (place.road_address_name) {
        content += '    <span title="' + place.road_address_name + '">' + place.road_address_name + '</span>' +
                    '  <span class="jibun" title="' + place.address_name + '">(지번 : ' + place.address_name + ')</span>';
    }  else {
        content += '    <span title="' + place.address_name + '">' + place.address_name + '</span>';
    }                
   
    content += '    <span class="tel">' + place.phone + '</span>' + 
                '</div>' + 
                '<div class="after"></div>';

    contentNode.innerHTML = content;
    placeOverlay.setPosition(new kakao.maps.LatLng(place.y, place.x));
    placeOverlay.setMap(map);  
}


// 각 카테고리에 클릭 이벤트를 등록합니다
function addCategoryClickEvent() {
    var category = document.getElementById('category'),
        children = category.children;

    for (var i=0; i<children.length; i++) {
        children[i].onclick = onClickCategory;
    }
}

// 카테고리를 클릭했을 때 호출되는 함수입니다
function onClickCategory() {
    var id = this.id,
        className = this.className;

    placeOverlay.setMap(null);

    if (className === 'on') {
        currCategory = '';
        changeCategoryClass();
        removeMarker();
    } else {
        currCategory = id;
        changeCategoryClass(this);
        searchPlaces();
    }
}

// 클릭된 카테고리에만 클릭된 스타일을 적용하는 함수입니다
function changeCategoryClass(el) {
    var category = document.getElementById('category'),
        children = category.children,
        i;

    for ( i=0; i<children.length; i++ ) {
        children[i].className = '';
    }

    if (el) {
        el.className = 'on';
    } 
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