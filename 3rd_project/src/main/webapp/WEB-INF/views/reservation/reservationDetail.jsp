<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	request.setCharacterEncoding("UTF-8");

	String currenthome = request.getParameter("currenthome");
	String f_value = request.getParameter("preday");
	String s_value = request.getParameter("presday");
	String year = request.getParameter("preyear");
	String hid = request.getParameter("hid");
	String hdid = request.getParameter("hdid");
	String roomid = request.getParameter("targetroom");
	
	String[] f_array = f_value.split("/");
	String[] s_array = s_value.split("/");
	
	
	String f_month = "";
	String f_day = "";
	
	if(f_array[0].length()==1){
		f_month = "0" + f_array[0];
	}else{
		f_month = f_array[0];
	}
	if(f_array[1].length()==1){
		f_day = "0" + f_array[1];
	}else{
		f_day = f_array[1];
	}
	
	String s_month = "";
	String s_day = "";
	
	if(s_array[0].length()==1){
		s_month = "0" + s_array[0];
	}else {
		s_month = s_array[0];
	}
	if(s_array[1].length()==1){
		s_day = "0" + s_array[1];
	}else {
		s_day = s_array[1];
	}
	
	f_day = year + "-" + f_month + "-" + f_day;
	s_day = year + "-" + s_month + "-" + s_day;
	
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
<title>예약상세 | JEJU ISLAND</title>
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/index.css">
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/reservation/reserDetail.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="http://localhost:9000/myjeju/js/jquery-3.6.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- header -->
	<jsp:include page="../header.jsp"></jsp:include>
	
	<!-- content -->
	<section class="reservationDetail">
		<div class="content">
			<div class="name_section">
				<div class="name" style="margin-bottom: 10px;">스테이라움</div>
				<div class="subname">오션뷰</div>
			</div>
			<div class="carosel">
				<div id="demo" class="carousel slide" data-ride="carousel" style="text-align:center;">

					<!-- The slideshow -->
					<div class="carousel-inner">
						<div class="carousel-item active">
					    	<img src="http://localhost:9000/myjeju/images/index/main1.jpg" width="100%">
					    </div>
					    <div class="carousel-item">
					    	<img src="http://localhost:9000/myjeju/images/index/main2.jpg" width="100%">
					    </div>
					    <div class="carousel-item">
					    	<img src="http://localhost:9000/myjeju/images/index/main3.jpeg" width="100%">
					    </div>
					    <div class="carousel-item">
					    	<img src="http://localhost:9000/myjeju/images/index/main4.jpeg" width="100%">
					    </div>
					</div>
					  
					<!-- Left and right controls -->
					<a class="carousel-control-prev" href="#demo" data-slide="prev">
						<span class="carousel-control-prev-icon"></span>
					</a>
					<a class="carousel-control-next" href="#demo" data-slide="next">
					    <span class="carousel-control-next-icon"></span>
					</a>
				</div>
			</div>
		</div>
		<div class="text_section">
			<div class="namesection2">
				<div class="name2" style="margin-bottom: 10px;">스테이라움</div>
				<div class="subname2">오션뷰</div>
			</div>
			<div class = "explain">성산일출봉 근처에 위치한 숙소로 성산일출봉의 근사한 바다 전망을 볼 수 있습니다.</div>
			<div class="date">
				<div class="f_day"><%= f_day %></div> ~ <div class="s_day"><%= s_day %></div>
			</div>
			<div class= "price_section">
				<div class="price">280,000원</div>
				<div class="seperate"></div>
				<div class="price_cal">140,000</div>
				<div class="x">x</div>
				<div class="night">2박</div>
			</div>
			<form action="#" method="post">
			<input type="hidden" name="hid" value=<%= hid %>>
			<input type="hidden" name="hdid" value=<%= hdid %>>
			<input type="hidden" name="roomid" value=<%= roomid %>>
			<input type="hidden" name="sessionid" value='${session_id}'>
			<input type="hidden" name="f_day" value=<%= f_day %>>
			<input type="hidden" name="s_day" value=<%= s_day %>>
			<button class="search_btn" type="submit">일정변경</button>			
			</form>
			<form action="#" method="post">
			<input type="hidden" name="hid" value=<%= hid %>>
			<input type="hidden" name="hdid" value=<%= hdid %>>
			<input type="hidden" name="roomid" value=<%= roomid %>>
			<input type="hidden" name="sessionid" value='${session_id}'>
			<input type="hidden" name="f_day" value=<%= f_day %>>
			<input type="hidden" name="s_day" value=<%= s_day %>>
			<button class="search_btn" type="submit">예약하기</button>			
			</form>
		</div>		
	</section>
	<!-- footer -->
	<jsp:include page="../footer.jsp"></jsp:include>
	
</body>
</html>