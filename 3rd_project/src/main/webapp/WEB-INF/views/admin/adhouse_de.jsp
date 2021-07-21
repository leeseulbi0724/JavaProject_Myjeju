<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "javax.servlet.jsp.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="test/html; charset=UTF-8">
	<meta name ="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/admincss/bootstrap.css">
	<link rel="stylesheet" href="css/admincss/custom.css">
	<link rel="stylesheet" href="css/admincss/setupforcounsel.css">
	<title>Myjeju 관리자 메뉴</title>
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script type="text/javascript"></script>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class ="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expeanded="false">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="http://localhost:9000/myjeju/adminindex.do">Myjeju 관리자 메뉴</a>
		</div>
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="http://localhost:9000/myjeju/adminindex.do">메인</a>
					<li><a href="adnotice.do">공지사항관리</a></li>
					<li><a href="adboard.do">게시판관리</a></li>
					<li><a href="adrequest.do">요청관리</a></li>
					<li><a href="admember.do">회원관리<span id="unread" class="label label-info"></span></a></li>
					<li class="active"><a href="adhouse.do">숙소관리</a></li>
					<li><a href="adfood.do">맛집관리</a></li>
					<li><a href="adtravel.do">여행지관리</a></li>
					<li><a href="adstore.do">상품관리</a>
				</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="http://localhost:9000/myjeju/index.do">메인으로</a>
				</li>
			</ul>						
			</div>
		</nav>
			<!-- content -->
	<div class = "content_setup_faq">
	
		<section class = "section_setup_faq">
			<div></div>
			<div> 숙소관리 </div>
			<div></div>
		</section>
	
		<section class ="setup_faq_list">
			<table class = "content_layout_setup_faq">
				<tr>
					<th> 번호 </th>
					<th> 숙소아이디 </th>
					<th> 이름 </th>
					<th> 객실아이디 </th>
					<th> 가격 </th>
				</tr>
			 	<c:forEach var="vo" items="${list}">
				<tr>
					<td>${vo.rno}</td>
					<td onclick="location.href='adhouse_de_content.do?hdid=${vo.hdid}'">${vo.hid}</td>
					<td onclick="location.href='adhouse_de_content.do?hdid=${vo.hdid}'">${vo.hd_name}</td>
					<td onclick="location.href='adhouse_de_content.do?hdid=${vo.hdid}'">${vo.hdid}</td>
					<td>${vo.hd_price}</td>
				</tr>
				</c:forEach>
			</table>
		</section>
		<section class = "setup_faq_search">
			<form name = "setup_counsel_form" action ="adhouse.do" method = "post">
				<select class = "search" name = "search" style = "width: 70px; height: 27px">
					<option value = "id">아이디</option>
					<option value = "name">이름</option>
				</select>
				<input type = "text" name = "search_text" class = "search_text" style = "width: 300px; margin: 0 10px;">
				<button type = "submit" class = "btn_search">검색</button>
			</form>
		</section>
	</div>
</body>
</html>