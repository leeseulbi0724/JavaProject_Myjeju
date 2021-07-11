<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
<title>스토어 | JEJU ISLAND</title>
<link rel = "stylesheet" href = "http://localhost:9000/myjeju/css/index.css">
<link rel = "stylesheet" href = "http://localhost:9000/myjeju/css/store/store.css">
</head>
<body>
	<!-- Header -->
	<jsp:include page = "../header.jsp"></jsp:include>
	
	<!-- Content -->
<section>	
	<div class = "storeetc">
		<div><h3>스토어</h3></div>
		
		<div class = "store_nav">
			<ul>
			  <li><a href="store.do">전체</a></li>
			  <li><a href="store_eat.do">식품</a></li>
			  <li><a href="store_souve.do">기념품</a></li>
			  <li><a href="store_etc.do">잡화</a></li>
			</ul>
		</div>
	
		<div class = "store_etc_list">
			<c:forEach var = "etc" items = "${etclist}">
				<ul>
					<li>
						<a href = "store_content.do?sid=${etc.sid}">
						<img src = "http://localhost:9000/myjeju/upload/${etc.s_sfile}" width = "260"><p>[${etc.s_category}] ${etc.s_name}</p>
						</a>
					</li>
				</ul>
			</c:forEach>	
		</div>
	</div>
</section>

	
	<!-- Footer -->
	<jsp:include page = "../footer.jsp"></jsp:include>
</body>
</html>