<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" ></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/index.css">
<style>
	body { background-color:rgb(248,249,251); text-align:center; }
	header { background-color:white; }
	
	section { display:inline-block; width:1300px; margin:50px 0; }
	.left { 
		border:1px solid lightgray; 
		display:inline-block; 
		width:400px; height:500px;
		 float:left; 
		 margin-left:50px;
		 background-color:white;
	}
	.left p { text-align:left; font-weight:bold; color:#4fa9de; font-size:20px; margin:15px; }
	.left p>span { color:black; }
	
	.img_div { display:inline-block; border-top:1px solid lightgray; border-bottom:1px solid lightgray; padding:10px; width:350px; }

	.center1, .center2, .center3 { 
		border:1px solid lightgray; 
		display:inline-block; 
		width:800px; height:150px; 
		background-color:white; 
		margin:5px 0;
	}
	.center1 p, .center2 p, .center3 p {
		font-weight:bold;
		font-size:18px;
		margin-left:30px;
	}
	.center1>div, .center2>div, .center3>div {
		display:inline-block;
		text-align:left;
		float:left;
		margin-top:35px;
	}
	.center1>div>div, .center2>div>div, .center3>div>div { margin-left:40px; }
	.center1 div a, .center2 div a, .center3 div a { text-decoration:none; color:gray; font-size:15px; }
	.center1 div a:first-child, .center1 div a:nth-child(2), .center2 div a:first-child,
	.center3 div a:first-child, .center3 div a:nth-child(2) { 
		border-right:1px solid; padding-right:10px; padding-left:5px; 
	}
	.center1 div a:hover, .center2 div a:hover, .center3 div a:hover { text-decoration:underline; }
	
	
</style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>

<section>
	<div class="left">
		<p>이슬비<span>님의 마이페이지</span></p>
		<div class="img_div"><img src="http://localhost:9000/myjeju/images/mypage/human.png" width=300 height=300 ></div>
	</div>
	
	<div class="center1">
		<div>
			<p>개인정보 수정</p>
			<div>
				<a href="myinfo_request.do">기본정보 수정</a>
				<a href="myinfo_pass.do">비밀번호 변경</a>
				<a href="myinfo_out.do">회원탈퇴</a>
			</div>
		</div>
	</div>
	<div class="center2">
		<div>
			<p>스토어</p>
			<div>
				<a href="#">장바구니</a>
				<a href="myorder.do">주문내역</a>
			</div>
		</div>
	</div>
	<div class="center3">
		<div>
			<p>My 이력</p>
			<div>
				<a href="#">My 게시글</a>
				<a href="#">My 후기</a>
				<a href="#">My 좋아요</a>
			</div>
		</div>
	</div>
</section>

<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>