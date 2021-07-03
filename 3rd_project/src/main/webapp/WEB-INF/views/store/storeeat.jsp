<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
<title>스토어 | JEJU ISLAND</title>
<link rel = "stylesheet" href = "http://localhost:9000/myjeju/css/index.css">
<link rel = "stylesheet" href = "http://localhost:9000/myjeju/css/store.css">
<style>
	.store_category>a:nth-child(2)>span {
		color : #4fa9de;
	}

</style>
</head>
<body>
	<!-- Header -->
	<jsp:include page = "../header.jsp"></jsp:include>
	
	<!-- Content -->
	<div class = "storeeat">
		<div class= "store_category">
			<a href = "store.do"><span name = "store_all">전체</span></a>
			<a href = "store_eat.do"><span name = "store_eat">식품</span></a>
			<a href = "store_deco.do"><span name = "store_deco">실내품</span></a>
			<a href = "store_etc.do"><span name = "store_etc">잡화</span></a>
		</div>
		
	
		<div class = "store_category_eat">식품</div>
	
		<div class = "store_eat_image">
				<article>
					<a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store1.png" style = "display:block;"><p>[식품] 감귤 타르트</p></a>
					<a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store2.png" style = "display:block;"><p>[식품] 제주 오메기떡</p></a>
					<a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store3.png" style = "display:block;"><p>[식품] 제주도 한라봉</p></a>
				</article>
				
				<article>
					<a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store1.png" style = "display:block;"><p>[식품] 감귤 타르트</p></a>
					<a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store2.png" style = "display:block;"><p>[식품] 제주 오메기떡</p></a>
					<a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store3.png" style = "display:block;"><p>[식품] 제주도 한라봉</p></a>
				</article>
				
				<article>
					<a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store1.png" style = "display:block;"><p>[식품] 감귤 타르트</p></a>
					<a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store2.png" style = "display:block;"><p>[식품] 제주 오메기떡</p></a>
					<a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store3.png" style = "display:block;"><p>[식품] 제주도 한라봉</p></a>
				</article>
			</div>
	
	
	
	</div>
	
	
	
	
	
	<!-- Footer -->
	<jsp:include page = "../footer.jsp"></jsp:include>
</body>
</html>