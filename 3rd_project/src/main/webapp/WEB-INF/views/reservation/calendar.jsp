<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String[] day = {"일","월","화","수","목","금","토"};
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
<title>예약하기 | JEJU ISLAND</title>
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/index.css">
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/reservation/reservation.css">
<script src="http://localhost:9000/myjeju/js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){
    // test라는 클래스를가진 div를 클릭할 경우 "테스트입니다요."라는 alert가 뜬다.
    $(".days,.days_sun,.days_sat").click(function(){  
        alert($(this).children().val());
    });    
});	
</script>
</head>
<body>
	<!-- header -->
	<jsp:include page="../header.jsp"></jsp:include>
	
	<!-- content -->
	<div class="calendar_content">
		<h3 style="margin-bottom: 20px;">예약하기</h3>
		<br>
		<form action = "http://localhost:9000/myjeju/calendar.do" method="post">
			<input type = "hidden" name = "preyear" value="${year}">
			<input type = "hidden" name = "premonth" value="${month-1}">
			<button type="submit"><</button>
		</form>
		
		<h3 class="date" style="font-size:25px; margin-bottom: 20px;">${year}.${month}</h3>
		
		<form action ="http://localhost:9000/myjeju/calendar.do" method="post">
			<input type = "hidden" name = "preyear" value="${year}">
			<input type = "hidden" name = "premonth" value="${month+1}">
			<button type="submit">></button>
		</form>
		<section class="calendar">
		<%
		for(int i = 0; i< day.length; i++) {
		%>
			<div class="day"><%= day[i] %></div>	
		<%
		}
		%>
		<br>
		<div class="days_sun">${calvalue[0]} </div>
		<c:forEach var="list" items="${calvalue}" varStatus="status" begin="1" end="5">
		<div class="days" id="days">${list } <input type="hidden" value = "${list}"> </div>
		</c:forEach>
		<div class="days_sat">${calvalue[6]} </div>
		<br>
		<div class="days_sun">${calvalue[7]} </div>
		<c:forEach var="list" items="${calvalue}" varStatus="status" begin="8" end="12">
		<div class="days" id="days">${list } </div>
		</c:forEach>
		<div class="days_sat">${calvalue[13]} </div>
		<br>
		<div class="days_sun">${calvalue[14]} </div>
		<c:forEach var="list" items="${calvalue}" varStatus="status" begin="15" end="19">
		<div class="days" id="days">${list } </div>
		</c:forEach>
		<div class="days_sat">${calvalue[20]} </div>
		<br>
		<div class="days_sun">${calvalue[21]} </div>
		<c:forEach var="list" items="${calvalue}" varStatus="status" begin="22" end="26">
		<div class="days" id="days">${list } </div>
		</c:forEach>
		<div class="days_sat">${calvalue[27]} </div>
		<br>
		<div class="days_sun">${calvalue[28]} </div>
		<c:forEach var="list" items="${calvalue}" varStatus="status" begin="29" end="33">
		<div class="days" id="days">${list } </div>
		</c:forEach>
		<div class="days_sat">${calvalue[34]} </div>
		<br>
		
		<c:if test = "${maxrow == 6}">
			<c:forEach var="list" items="${calvalue}" varStatus="status" begin="41" end="41">
			<div class="days_sun">${calvalue[35]} </div>
			</c:forEach>
		</c:if>
		<c:if test = "${maxrow == 6}">
			<c:forEach var="list" items="${calvalue}" varStatus="status" begin="36" end="40">
			<div class="days" id="days">${list} </div>
			</c:forEach>
		</c:if>
		<c:if test = "${maxrow == 6}">
			<c:forEach var="list" items="${calvalue}" varStatus="status" begin="41" end="41">
			<div class="days_sat">${calvalue[41]} </div>
			</c:forEach>
		</c:if>
		
		</section>
	</div>
	<!-- footer -->
	<jsp:include page="../footer.jsp"></jsp:include>
	
</body>
</html>