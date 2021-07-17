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
<title>예약하기 | JEJU ISLAND</title>
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/index.css">
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/reservation/reserDetail.css">
<script src="http://localhost:9000/myjeju/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<!-- header -->
	<jsp:include page="../header.jsp"></jsp:include>
	
	<!-- content -->
	<section class="reservationDetail">
		<div class="reservation_content">
			<h3 style="margin-bottom: 10px;">예약상세</h3><br>
		</div>
		<h3><%= hid %></h3>
		<h3><%= hdid %></h3>
		<h3><%= f_day %></h3>
		<h3><%= s_day %></h3>
		<h3><%= roomid %></h3>
	</section>
	<!-- footer -->
	<jsp:include page="../footer.jsp"></jsp:include>
	
</body>
</html>