<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String[] days = {"일","월","화","수","목","금","토"};
	String currenthome = "자운게스트하우스";
	
	String preday = request.getParameter("preday");
	String presday = request.getParameter("presday");
	
	String month = "0"; 
	String day = "0";
	String smonth = "0"; 
	String sday = "0";
	
	if(preday != null ){
		if(!preday.equals("")){
		String[] prearray = preday.split("/");
		month = prearray[0]; 
		day = prearray[1];
		}
	}
	if(presday != null){
		if(!presday.equals("")){
		String[] prearray = presday.split("/");
		smonth = prearray[0]; 
		sday = prearray[1];
		}
	}
	
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
	var f_day = 0;
    var s_day = 0;
    
    var month = <%= month %>;
    var day = <%= day %>;
    f_day = (month*100)+day;
    if(f_day != 0){
    	$(".firstday").text(month+ "." + day);
    	$(".preday").val(month + "/" + day);
    }
    var smonth = <%= smonth %>;
    var sday = <%= sday %>;
    s_day = (smonth*100)+sday;
    if(s_day != 0){
    	$(".secondday").text(smonth+ "." + sday);
    	$(".middleday").text("~");
    	$(".presday").val(smonth + "/" + sday);
    }
    
    $(".days,.days_sun,.days_sat").click(function() {
		$.fn.myFunction(this);
    });
    
    $.fn.myFunction = function(curval) {
  		if(f_day == 0){
	       	f_day = $(curval).children().val()*100 + Number($(curval).children("div").text());
       		$(".firstday").text($(curval).children().val() + "." + $(curval).children("div").text());
       		$(".preday").val($(curval).children().val() + "/" + $(curval).children("div").text());
       		$.fn.reset();
       		$(curval).children("div").css({"background-color":"#4fa9de","color":"white","border-radius":"20px 0 0 20px"});
   	    }else if(f_day != 0 && s_day !=0){
	       	f_day = $(curval).children().val()*100 + Number($(curval).children("div").text());
   	    	$(".firstday").text($(curval).children().val() + "." + $(curval).children("div").text());
	     	$(".secondday").text("");
	     	$(".preday").val($(curval).children().val() + "/" + $(curval).children("div").text());
	     	$(".presday").val("");
	     	$.fn.reset();
	     	$(curval).children("div").css({"background-color":"#4fa9de","color":"white","border-radius":"20px 0 0 20px"});
	     	s_day = 0;
   		}else if(f_day != 0){
   	    	s_day = $(curval).children().val()*100 + Number($(curval).children("div").text());
   	    	if(s_day <= f_day){
   	     		$(".firstday").text($(curval).children().val() + "." + $(curval).children("div").text());
   	     		$(".secondday").text("");
		    	$(".preday").val($(curval).children().val() + "/" + $(curval).children("div").text());
		    	$.fn.reset();
		    	$(curval).children("div").css({"background-color":"#4fa9de","color":"white","border-radius":"20px 0 0 20px"});
   	     		f_day = s_day;
   	     		s_day = 0;
   	    	}else if (s_day > f_day){
   	     		$(".secondday").text($(curval).children().val() + "." + $(curval).children("div").text());
		    	$(".presday").val($(curval).children().val() + "/" + $(curval).children("div").text());
		    	$(".middleday").text("~");
   	     		$(curval).children("div").css({"background-color":"#4fa9de","color":"white","border-radius":"0 20px 20px 0"});
   	     		var range = f_day + "/" + s_day;
   	     	 	$.fn.fillup(range);
   	    	}
   		}
	}
    $.fn.reset = function() {
		$(".days,.days_sun,.days_sat").children("div").css({"background-color":"white","color":"black","border-radius":"0"});
		$(".middleday").text("");
    }
    $.fn.fillup = function(range) {
    	var range_array = range.split("/");
		var f_range = Number(range_array[0])+1;     	
		var s_range = Number(range_array[1]);
    	for(var i=f_range; i<s_range; i++) {
    	$('[value='+ i +']').parent().children("div").css({"background-color":"#8ec8ea","color":"white"});
    	}
    }
    
    
    
});	
</script>
</head>
<body>
	<!-- header -->
	<jsp:include page="../header.jsp"></jsp:include>
	
	<!-- content -->
	<div class="calendar_content">
		<h3 style="margin-bottom: 10px;">예약하기</h3>
		<br>
		<form action = "http://localhost:9000/myjeju/calendar.do" method="post">
			<input type = "hidden" name = "preyear" value="${year}">
			<input type = "hidden" name = "premonth" value="${month-1}">
			<input type = "hidden" class="preday" name = "preday">
			<input type = "hidden" class="presday" name = "presday">
			<button type="submit" style="cursor:pointer;"><</button>
		</form>
		
		<h3 class="date" style="font-size:25px; margin-bottom: 10px;">${year}.${month}</h3>
		
		<form action ="http://localhost:9000/myjeju/calendar.do" method="post">
			<input type = "hidden" name = "preyear" value="${year}">
			<input type = "hidden" name = "premonth" value="${month+1}">
			<input type = "hidden" class="preday" name = "preday">
			<input type = "hidden" class="presday" name = "presday">
			<button type="submit" style="cursor:pointer;">></button>
		</form>
		<section class="calendar">
			<%
			for(int i = 0; i< days.length; i++) {
			%>
				<div class="day"><%= days[i] %></div>	
			<%
			}
			%>
			<br>
			<div class="days_sun">
				<input type="hidden" value = "${calvalue[0].month}">
				<input type="hidden" value = "${calvalue[0].month*100 + calvalue[0].day}">
				<div>${calvalue[0].day}</div> 
			</div>
			<c:forEach var="list" items="${calvalue}" varStatus="status" begin="1" end="5">
			<div class="days" id="days">
				<input type="hidden" value = "${list.month}"> 
				<input type="hidden" value = "${list.month*100 + list.day}"> 
				<div>${list.day }</div> 
			</div>
			</c:forEach>
			<div class="days_sat">
				<input type="hidden" value = "${calvalue[6].month}"> 
				<input type="hidden" value = "${calvalue[6].month*100 + calvalue[6].day}"> 
				<div>${calvalue[6].day}</div>
			</div>
			<br>
			<div class="days_sun">
				<input type="hidden" value = "${calvalue[7].month}"> 
				<input type="hidden" value = "${calvalue[7].month*100 + calvalue[7].day}">  
				<div>${calvalue[7].day}</div>
			</div>
			<c:forEach var="list" items="${calvalue}" varStatus="status" begin="8" end="12">
			<div class="days" id="days">
				<input type="hidden" value = "${list.month}"> 
				<input type="hidden" value = "${list.month*100 + list.day}"> 
				<div>${list.day }</div>
			</div>
			</c:forEach>
			<div class="days_sat">
				<input type="hidden" value = "${calvalue[13].month}"> 
				<input type="hidden" value = "${calvalue[13].month*100 + calvalue[13].day}"> 
				<div>${calvalue[13].day}</div> 
			</div>
			<br>
			<div class="days_sun">
				<input type="hidden" value = "${calvalue[14].month}"> 
				<input type="hidden" value = "${calvalue[14].month*100 + calvalue[14].day}"> 
				<div>${calvalue[14].day}</div> 
			</div>
			<c:forEach var="list" items="${calvalue}" varStatus="status" begin="15" end="19">
			<div class="days" id="days">
				<input type="hidden" value = "${list.month}"> 
				<input type="hidden" value = "${list.month*100 + list.day}"> 
				<div>${list.day }</div> 
			</div>
			</c:forEach>
			<div class="days_sat">
				<input type="hidden" value = "${calvalue[20].month}"> 
				<input type="hidden" value = "${calvalue[20].month*100 + calvalue[20].day}">
				<div>${calvalue[20].day}</div>
			</div>
			<br>
			<div class="days_sun">
				<input type="hidden" value = "${calvalue[21].month}"> 
				<input type="hidden" value = "${calvalue[21].month*100 + calvalue[21].day}"> 
				<div>${calvalue[21].day}</div>
			</div>
			<c:forEach var="list" items="${calvalue}" varStatus="status" begin="22" end="26">
			<div class="days" id="days">
				<input type="hidden" value = "${list.month}"> 
				<input type="hidden" value = "${list.month*100 + list.day}">  
				<div>${list.day }</div> 
			</div>
			</c:forEach>
			<div class="days_sat">
				<input type="hidden" value = "${calvalue[27].month}"> 
				<input type="hidden" value = "${calvalue[27].month*100 + calvalue[27].day}">  
				<div>${calvalue[27].day}</div> 
			</div>
			<br>
			<div class="days_sun">
				<input type="hidden" value = "${calvalue[28].month}"> 
				<input type="hidden" value = "${calvalue[28].month*100 + calvalue[28].day}">  
				<div>${calvalue[28].day}</div> 
			</div>
			<c:forEach var="list" items="${calvalue}" varStatus="status" begin="29" end="33">
			<div class="days" id="days">
				<input type="hidden" value = "${list.month}"> 
				<input type="hidden" value = "${list.month*100 + list.day}"> 
				<div>${list.day }</div> 
			</div>
			</c:forEach>
			<div class="days_sat">
				<input type="hidden" value = "${calvalue[34].month}"> 
				<input type="hidden" value = "${calvalue[34].month*100 + calvalue[34].day}"> 
				<div>${calvalue[34].day}</div> 
			</div>
			<br>
			
			<c:if test = "${maxrow == 6}">
				<c:forEach var="list" items="${calvalue}" varStatus="status" begin="41" end="41">
				<div class="days_sun">
					<input type="hidden" value = "${calvalue[35].month}"> 
					<input type="hidden" value = "${calvalue[35].month*100 + calvalue[35].day}"> 
					<div>${calvalue[35].day}</div> 
				</div>
				</c:forEach>
			</c:if>
			<c:if test = "${maxrow == 6}">
				<c:forEach var="list" items="${calvalue}" varStatus="status" begin="36" end="40">
				<div class="days" id="days">
					<input type="hidden" value = "${list.month}"> 
					<input type="hidden" value = "${list.month*100 + list.day}"> 
					<div>${list.day}</div> 
				</div>
				</c:forEach>
			</c:if>
			<c:if test = "${maxrow == 6}">
				<c:forEach var="list" items="${calvalue}" varStatus="status" begin="41" end="41">
				<div class="days_sat">
					<input type="hidden" value = "${calvalue[41].month}"> 
					<input type="hidden" value = "${calvalue[41].month*100 + calvalue[41].day}"> 
					<div>${calvalue[41].day}</div> 
				</div>
				</c:forEach>
			</c:if>
		</section>
		
		<h3><%= currenthome %></h3>
		<br>
		<div class="date">
			<div class="firstday"></div> <div class="middleday" style="display: inline-block;"></div> <div class="secondday"></div>
			<form class="search_form"action = "http://localhost:9000/myjeju/reservationList.do" method="post">
			<input type = "hidden" class="preyear" name = "preyear" value="${year}">
			<input type = "hidden" class="preday" name = "preday">
			<input type = "hidden" class="presday" name = "presday">
			<input type="hidden" name="currenthome" value=<%= currenthome %>>
			<button class="search_btn" type="submit">검색하기</button>
			</form>
		</div>
	</div>
	<!-- footer -->
	<jsp:include page="../footer.jsp"></jsp:include>
	
</body>
</html>