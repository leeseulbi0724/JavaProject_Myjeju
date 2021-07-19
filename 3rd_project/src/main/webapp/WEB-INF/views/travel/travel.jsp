<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.myjeju.vo.* , com.myjeju.dao.* " %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head profile="http://www.w3.org/2005/10/profile">
<meta charset="UTF-8">
	<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
	<title>여행지 | JEJU ISLAND</title>
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
	<link rel="stylesheet" href="http://localhost:9000/myjeju/css/travel/travel.css">
	<link rel="stylesheet" href="http://localhost:9000/myjeju/css/am-pagination.css">
	<script src="http://localhost:9000/myjeju/js/jquery-3.6.0.min.js"></script>
	<script src="http://localhost:9000/myjeju/js/am-pagination.js"></script>
	<script>
		$(document).ready(function(){ 
			
			/* var pager = jQuery('#ampaginationsm').pagination({
				maxSize: 5,	    		// max page size
			    totals:${dbcount},	// total pages	
			    page:${rpage},		// initial page		
			    pageSize:${pageSize},			// max number items per page
			
			    // custom labels		
			    lastText: '&raquo;&raquo;', 		
			    firstText: '&laquo;&laquo;',		
			    prevText: '&laquo;',		
			    nextText: '&raquo;',
					     
			    btnSize:'sm'	// 'sm'  or 'lg'	
			});
			
			jQuery('#ampaginationsm').on('am.pagination.change',function(e){
				   jQuery('.showlabelsm').text('The selected page no: '+e.page);
		           $(location).attr('href', "http://localhost:9000/myjeju/travel.do?rpage="+e.page);         
		    }); */ 
			
		    var pageNo = 0;
			$("#more_btn").on("click", function(){
				moreList();
			}); 
			
			
			//moreList(); //더보기 버튼 호출
			function moreList(category, tname){
				var startNum = $("#list_body").children("tr").length;
				var addListHtml="";
				
				$.ajax({
					url:"travel_proc.do?category="+category+"&tname="+tname,
					//data:{"startNum":startNum},
					//contentType: 'application/x-www-form-urlencoded; charset=euc-kr',
					success:function(result){
						//alert(startNum);
						$("#list_body").empty();
						var jdata = JSON.parse(result);
							
						for(var i in jdata.jlist){
							addListHtml += "<tr class='travel_list1'>";
							addListHtml += "<td class='travel_list_pic'>";
							addListHtml += "<img src='http://localhost:9000/myjeju/images/travel/" + jdata.jlist[i].t_image1 + "'>";
							addListHtml += "</td>";
							addListHtml += "<td>";
							addListHtml += "<p class='spot_name'>" + jdata.jlist[i].t_name;
							addListHtml += "<span>" + jdata.jlist[i].t_infor + "</span>";
							addListHtml += "</p>";
							addListHtml += "<p class='spot_addr'>" + jdata.jlist[i].t_addr + "</p>";
							addListHtml += "<div>";
							addListHtml += "<img src='http://localhost:9000/myjeju/images/travel/star.png'>";
							addListHtml += "<span class='star_score'>4.4 (268)</span>";
							addListHtml += "</div>";
							addListHtml += "</td>";
							addListHtml += "<td>";
							addListHtml += "<button type='button' class='btn_style' id='heart_btn'>"
							addListHtml += "<img src='http://localhost:9000/myjeju/images/travel/empty_heart.png'>" + jdata.jlist[i].t_like;
							addListHtml += "</button>";
							addListHtml += "<a href='http://localhost:9000/myjeju/travel_detail.do?tid=" + jdata.jlist[i].tid + "'>";
							addListHtml += "<button type='button' class='btn_style4' id='more_infor'>상세정보</button>";
							addListHtml += "</a>";
							addListHtml += "</td>";
							addListHtml += "</tr>";
						}
						$("#list_body").append(addListHtml);
						//alert("jdata.jlist.length:"+jdata.jlist.length);
						$("#more_btn").remove();
					}
				});
			}
			
			$("#travel_search_btn").click(function(){
				if($("#category").val() == "t_name"){
					if($("#travel_search").val() == ""){
						alert("검색할 여행지명을 입력해주세요.");
						$(this).focus();
						return false;
					}else{
						var category = $("#category").val();
						var tname = $("#travel_search").val();
						$("#list_body").empty();
						$("#more_btn").remove();
						moreList(category, tname);
					}
				}else if($("#category").val() == "t_addr"){
					if($("#travel_search").val() == ""){
						alert("검색할 지역명을 입력해주세요.");
						$(this).focus();
						return false;
					}else{
						var category = $("#category").val();
						var tname = $("#travel_search").val();
						$("#list_body").empty();
						$("#more_btn").remove();
						moreList(category, tname);
					}
				}
				
			});
			
			$("#category").change(function(){
				$("#travel_search").val("");
			});
			
		});
		
	</script>
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
					<a href="http://localhost:9000/myjeju/travel_detail.do?tid=${toplist.tid}"><img src="http://localhost:9000/myjeju/images/travel/${toplist.t_image1}"></a>
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
			idx : '${vo.tid}',
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
  	    content.innerHTML =  "<div class='overlay'>" 
	    	+ "<div class='content'>"
    		+ "<div class='title'>" + data.title + "</div>"
    			+ "<div class='body'>"
    				+ "<div class='img'>" + "<img src=" + "http://localhost:9000/myjeju/images/travel/"+data.img + ">" + "</div>" 
    				+ "<div class='addr'>" + data.addr + "</div>" + "<br>" 
    				+ "<div class='tel'>" + data.tel +  "</div>" + "<br>"
    				+ "<a href="+"http://localhost:9000/myjeju/travel_detail.do?tid=" + data.idx + ">상세보기</a>"
    			+ "</div>"
    		+ "</div>"
    	+ "</div>";
    	 content.style.cssText = 'background: white; border-radius:10px; margin:0; padding:0; ';
	
	    var closeBtn = document.createElement('button');
	    closeBtn.innerHTML = '닫기';
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
			<div class="travel_title">여행지 리스트</div>
			<div class="travel_search_zone">
				<!-- <form name="search_form" action="travel.do" method="get"> -->
					<select name="search" class="search" id="category">
						<option value="t_name">여행지</option>
						<option value="t_addr">지역명</option>
					</select>
					<input type="text" name="search_text" id="travel_search" placeholder="여행지를 검색하세요.">
					<button type="submit" class="btn_style3" id="travel_search_btn">검색</button>
				<!-- </form> -->
			</div>
			<table id="travel_list_table" class="travel_list">
				<tbody id="list_body">
					<c:forEach var="vo" items="${list}">
						<tr class="travel_list1">
							<td class="travel_list_pic">
								<img src="http://localhost:9000/myjeju/images/travel/${vo.t_image1}">
							</td>
							<td>
								<p class="spot_name">${vo.t_name}<span>${vo.t_infor}</span></p>
								<p class="spot_addr">${vo.t_addr}</p>
								<div>
									<img src="http://localhost:9000/myjeju/images/travel/star.png"><span class="star_score">4.4 (268)</span>
								</div>
							</td>
							<td>
								<button type="button" class="btn_style" id="heart_btn"><img src="http://localhost:9000/myjeju/images/travel/empty_heart.png">${vo.t_like}</button>
								<a href="http://localhost:9000/myjeju/travel_detail.do?tid=${vo.tid }">
									<button type="button" class="btn_style4" id="more_infor">상세정보</button>
								</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- <div id="ampaginationsm" style="text-align:center;"></div> -->
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