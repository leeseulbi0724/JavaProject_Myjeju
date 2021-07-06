<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
<title>스토어 | JEJU ISLAND</title>
<link rel = "stylesheet" href = "http://localhost:9000/myjeju/css/index.css">
<link rel = "stylesheet" href = "http://localhost:9000/myjeju/css/store.css">
<style>
	.store_category>a:nth-child(1)>span {
		color : #4fa9de;
	}
	
	.store_category {
		text-align : center;
	}
</style>
</head>
<body>

	<!-- Header -->
	<jsp:include page = "../header.jsp"></jsp:include>
	
	<!-- Content -->
	<div class = "store_main">
		<div><h3>스토어</h3></div>
		<div class= "store_category">
			<a href = "store.do"><span>전체</span></a>
			<a href = "store_eat.do"><span>식품</span></a>
			<a href = "store_deco.do"><span>실내품</span></a>
			<a href = "store_etc.do"><span>잡화</span></a>
		</div>
	
		<div class = "store_best">
			<div>
				<div>BEST</div>
			</div>
			<div class = "store_best_image">
				<article>
					<a href = "store_content.do"><img src = "http://localhost:9000/myjeju/images/store/store1.png" style = "display:block;"><p>[실내품] 제주도 캔들</p></a>
					<a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store2.png" style = "display:block;"><p>[식품] 제주 오메기떡</p></a>
					<a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store3.png" style = "display:block;"><p>[식품] 제주도 한라봉</p></a>
				</article>
			</div>
			<hr>
		</div>
		
		<div class = "store_eat">
			<div>
				<div>식품</div>
				<a href = "store_eat.do">더 보기 +</a>
			</div>
			
			<div class = "store_eat_image">
				<article>
					<a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store1.png" style = "display:block;"><p>[식품] 감귤 타르트</p></a>
					<a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store2.png" style = "display:block;"><p>[식품] 제주 오메기떡</p></a>
					<a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store3.png" style = "display:block;"><p>[식품] 제주도 한라봉</p></a>
				</article>
			</div>
			<hr>
		</div>
		
		<div class = "store_deco">
			<div>
				<div>실내장식</div>
				<a href = "store_deco.do">더 보기 +</a>
			</div>
			
			<div class = "store_deco_image">
				<article>
					<a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store1.png" style = "display:block;"><p>[실내품] 제주도 캔들</p></a>
					<a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store2.png" style = "display:block;"><p>[실내품] 제주 컵받침</p></a>
					<a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store3.png" style = "display:block;"><p>[실내품] 감귤 발매트</p></a>
				</article>
			</div>
			<hr>
		</div>
	
		<div class = "store_etc">
			<div>
				<div>잡화</div>
				<a href = "store_etc.do">더 보기 +</a>
			</div>	
			
			<div class = "store_etc_image">
				<article>
					<a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store1.png" style = "display:block;"><p>[잡화] 제주도 감귤 모자</p></a>
					<a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store2.png" style = "display:block;"><p>[잡화] 제주 화산송이크림</p></a>
					<a href = "#"><img src = "http://localhost:9000/myjeju/images/store/store3.png" style = "display:block;"><p>[잡화] 제주 돌하르방 방향제</p></a>
				</article>
			</div>
		</div>
		
	</div>
	
	
	<!-- Footer -->
	<jsp:include page = "../footer.jsp"></jsp:include>
</body>
</html>