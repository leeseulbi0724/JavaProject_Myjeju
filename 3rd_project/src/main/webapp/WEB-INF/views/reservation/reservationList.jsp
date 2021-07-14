<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	request.setCharacterEncoding("UTF-8");

	String currenthome = request.getParameter("currenthome");
	String f_value = request.getParameter("preday");
	String s_value = request.getParameter("presday");
	String year = request.getParameter("preyear");
	
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
<title>예약하기 | JEJU ISLAND</title>
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/index.css">
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/reservation/reserList.css">
<script src="http://localhost:9000/myjeju/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<!-- header -->
	<jsp:include page="../header.jsp"></jsp:include>
	
	<!-- content -->
	<section class="reservationList">
		<div class="reservation_content">
			<h3 style="margin-bottom: 10px;">예약리스트</h3><br>
		</div>
		<div class="search">
			<div class="search_detail">
				<h2>상세검색</h2><br>
				<label>체크인</label><br>
				<input type="date" value='<%= f_day %>'><br>
				<label>체크아웃</label><br>
				<input type="date" value='<%= s_day %>'><br>
				<label>인원</label><br>
				<input type="number"><br>
				<button class="search_btn" type="submit">검색하기</button>
			</div>
			<div class="search_label">
				<h2><%= currenthome %></h2><span>20개의 숙소</span>
			</div>
			<div class="search_category">
				<p>정렬기준</p>
				<div class="standard">
				<span>요금</span><div class="partition"></div><span>고객평점</span>
				</div>
			</div>
		</div>
	</section>
	<!-- footer -->
	<jsp:include page="../footer.jsp"></jsp:include>
	
</body>
</html>