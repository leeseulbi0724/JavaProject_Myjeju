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
	
<section>	
	<div class = "store">
		<div><h3>스토어</h3></div>
		
		<div class = "store_nav">
			<ul>
			  <li><a href="store.do">전체</a></li>
			  <li><a href="store_eat.do">식품</a></li>
			  <li><a href="store_souve.do">기념품</a></li>
			  <li><a href="store_etc.do">잡화</a></li>
			</ul>
		</div>
		
		<div class = store_best>
			<div>
				<div><span>BEST MENU</span></div>
			</div>
				
			<c:forEach var = "best" items = "${bestlist}">
				<ul>
					<li>
						<a href = "store_content.do?sid=${best.sid}">
							<img src = "http://localhost:9000/myjeju/upload/${best.s_sfile}" width = "260"><p>[${best.s_category}] ${best.s_name}</p>
						</a>
					</li>
				</ul>
			</c:forEach>
		</div>
		
		<div class = "store_eat">
			<div>
				<div><span>식품</span></div>
				<div><a href = "store_eat.do">더 보기 +</a></div>
			</div>
			<c:forEach var = "eat" items = "${eatlist}">
				<ul>
					<li>
						<a href = "store_content.do?sid=${eat.sid}">
							<img src = "http://localhost:9000/myjeju/upload/${eat.s_sfile}" width = "260"><p>[${eat.s_category}] ${eat.s_name}</p>
						</a>
					</li>
				</ul>
			</c:forEach>
		</div>
		
		<div class = "store_souve">
			<div>
				<div><span>기념품</span></div>
				<div><a href = "store_souve.do">더 보기 +</a></div>
			</div>
			<c:forEach var = "souve" items = "${souvelist}">
				<ul>
					<li>
						<a href = "store_content.do?sid=${souve.sid}">
							<img src = "http://localhost:9000/myjeju/upload/${souve.s_sfile}" width = "260"><p>[${souve.s_category}] ${souve.s_name}</p>
						</a>
					</li>
				</ul>
			</c:forEach>
		</div>
		
		<div class = "store_etc">
			<div>
				<div><span>잡화</span></div>
				<div><a href = "store_etc.do">더 보기 +</a></div>
			</div>
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