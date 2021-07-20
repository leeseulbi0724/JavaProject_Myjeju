<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.myjeju.vo.* , com.myjeju.dao.* " %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
	<title>숙소 | JEJU ISLAND</title>
	<style>
		.overlay{width: 370px; height:132px;}
		.content{ border-radius:10px; width: 370px; height:120px; margin-bottom:30px;}
		.addr{font-size:12px; font-weight:bold; margin-top:10px;  display:inline-block; margin-left:5px; }
		.tel{font-size:12px; font-weight:bold; color:#4fa9de; display:inline-block; margin-left:5px;}
		.title{background:#4fa9de; color:white; font-weight:bold; padding: 5px 10px;}
		.body a{text-decoration:none; margin-left:5px; margin-top:5px; font-size:13px; font-weight:bold;}
		.img{float:left; display:inline-block; margin-left:5px; border:3px solid #eee; margin-top:8px;}
		.img>img {width:75px; height:75px; object-fit:cover; vertical-align:top; }
	</style>
	<link rel="stylesheet" href="http://localhost:9000/myjeju/css/index.css">
	<link rel="stylesheet" href="http://localhost:9000/myjeju/css/house/house.css">
	<link rel="stylesheet" href="http://localhost:9000/myjeju/css/house/map.css">
	<script src="http://localhost:9000/myjeju/js/jquery-3.6.0.min.js"></script>
	<script>
		$(document.ready(function(){
			$(".btn_style").click(function(){
				var hid = "${vo.hid}";
				if ("${session_id}" == "") {
				location.replace("login.do");
				} else if (${h_result}) {
				$.ajax({
			                type: "post",
			                url: "heart_minus.do",
			                data:{hid:hid},
			                dataType: 'json',
			                success: function (result) {
			                    location.reload();
			                },
			            });
				} else {
				$.ajax({
			                type: "post",
			               	url: "heart_plus.do",
			                data:{hid:hid},
			                dataType: 'json',
			                success: function (result) {
			                    location.reload();
			               	 },
			});
		});         
	</script>
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
			<c:forEach var="toplist" items="${toplist}">
				<article class="travel_spot1">
					<a href="http://localhost:9000/myjeju/house_detail.do?hid=${toplist.hid }"><img src="http://localhost:9000/myjeju/images/house/${toplist.h_img}"></a>
					<div class="spot_infor">
						<p class="spot_name">${toplist.h_name} <span>${toplist.h_infor}</span></p>
						<p class="spot_tag">${toplist.h_tag}</p>
				<button type="button" class="btn_style" id="heart_btn">
				<c:if test = "${h_result eq 'false' }">
					<img src="http://localhost:9000/myjeju/images/empty_heart.png" class="heart_img">
				</c:if>
				<c:if test = "${h_result eq 'true' }">
					<img src="http://localhost:9000/mybook/images/full_heart.png" class="heart_img">
				</c:if>
				</button>
				</div>
				</article>
			</c:forEach>
				<%-- <img src="http://localhost:9000/myjeju/images/travel/empty_heart.png">${toplist.h_like} --%>
				<img src="http://localhost:9000/myjeju/images/travel/star.png"><span class="star_score">4.9 (82)</span>
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
				<c:forEach var="vo" items="${list}">
		    	{	
		    		title : '${vo.h_name}',
		    		addr : '${vo.h_addr}',
		    		tel : '${vo.h_hp}',
		    		img : '${vo.h_img}',
		    		idx : '${vo.hid}',
		        	latlng: new kakao.maps.LatLng(${vo.h_vpoint}, ${vo.h_hpoint})
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
		    	content.innerHTML =  
		    	"<div class='overlay'>" 
		    	+ "<div class='content'>"
		    		+ "<div class='title'>" + data.title + "</div>"
		    			+ "<div class='body'>"
		    				+ "<div class='img'>" + "<img src=" + "http://localhost:9000/myjeju/images/house/"+data.img + ">" + "</div>" 
		    				+ "<div class='addr'>" + data.addr + "</div>" + "<br>" 
		    				+ "<div class='tel'>" + data.tel +  "</div>" + "<br>"
		    				+ "<a href="+"http://localhost:9000/myjeju/house_detail.do?hid=" + data.idx + ">상세보기</a>"
		    			+ "</div>"
		    		+ "</div>"
		    	+ "</div>";
		    	
		   	    content.style.cssText = 'background: white; border-radius:10px; margin:0; padding:0; ';
			
			    var closeBtn = document.createElement('button');
			    closeBtn.innerHTML = "닫기";
			    closeBtn.style.cssText = 'background:white; border: 1px solid white; float:right; margin-top:-132px; color:black; font-weight:bold; padding:5.5px;';
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
				<c:forEach var="vo" items="${list}">
					<tr class="travel_list1">
						<td class="travel_list_pic">
							<img src="http://localhost:9000/myjeju/images/house/${vo.h_img}">
						</td>
						<td>
							<p class="spot_name">${vo.h_name} <span>${vo.h_infor}</span></p>
							<p class="spot_addr">${vo.h_addr}</p>
							<div>
								<img src="http://localhost:9000/myjeju/images/travel/star.png"><span class="star_score">4.4 (268)</span>
							</div>
						</td>
						<td>
							<button type="button" class="btn_style" id="heart_btn">
							<img src="http://localhost:9000/myjeju/images/travel/empty_heart.png">${vo.h_like}</button>
							<button type="button" class="btn_style4" id="more_infor" onclick="location.href='http://localhost:9000/myjeju/house_detail.do?hid=${vo.hid}'">상세정보</button>
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