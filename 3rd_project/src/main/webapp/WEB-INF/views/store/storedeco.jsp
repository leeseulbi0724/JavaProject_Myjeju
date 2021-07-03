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
	.store_category>a:nth-child(3)>span {
		color : #4fa9de;
	}

</style>
</head>
<body>
	<!-- Header -->
	<jsp:include page = "../header.jsp"></jsp:include>
	
	<!-- Content -->
	<div class = "storedeco">
		<div class= "store_category">
			<a href = "store.do"><span>전체</span></a>
			<a href = "store_eat.do"><span>식품</span></a>
			<a href = "store_deco.do"><span>실내품</span></a>
			<a href = "store_etc.do"><span>잡화</span></a>
		</div>
		
	
		<div class = "store_category_deco">실내품</div>
	
		<div class = "store_deco_image">
				<article>
					<a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store1.png" style = "display:block;"><p>[실내품] 감귤 타르트</p></a>
					<a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store2.png" style = "display:block;"><p>[실내품] 제주 오메기떡</p></a>
					<a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store3.png" style = "display:block;"><p>[실내품] 제주도 한라봉</p></a>
				</article>
				
				<article>
					<a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store1.png" style = "display:block;"><p>[실내품] 감귤 타르트</p></a>
					<a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store2.png" style = "display:block;"><p>[실내품] 제주 오메기떡</p></a>
					<a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store3.png" style = "display:block;"><p>[실내품] 제주도 한라봉</p></a>
				</article>
				
				<article>
					<a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store1.png" style = "display:block;"><p>[실내품] 감귤 타르트</p></a>
					<a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store2.png" style = "display:block;"><p>[실내품] 제주 오메기떡</p></a>
					<a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store3.png" style = "display:block;"><p>[실내품] 제주도 한라봉</p></a>
				</article>
			</div>
	
	
	
	</div>
	
	<!-- Footer -->
	<jsp:include page = "../footer.jsp"></jsp:include>
</body>
</html>