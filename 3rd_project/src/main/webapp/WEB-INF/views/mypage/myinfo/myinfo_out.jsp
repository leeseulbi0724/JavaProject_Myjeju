<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/index.css">
<style>
	section { text-align:center; }
	.center { 
		margin-top:80px; 
		width:1000px; 
		display:inline-block; 
	}
	h3 { 
		border-bottom:5px solid #4fa9de; 
		font-size:20px; 
		font-weight:bold; 
		float:left;
	}	
	#ok, #cancle { margin:5px; padding:2px 10px; }
	#ok { background-color:#4fa9de; color:white; }
	#ok:hover { background-color:rgb(23,86,123); }
</style>
</head>
<body>
<jsp:include page="../../header.jsp"></jsp:include>

<section>
	<div class="center">
		<h3>회원탈퇴</h3>
		<a class="btn btn-outline-secondary" href="mypage.do" id="cancle">취소</a>
		<a class="btn" id="ok" href="#">탈퇴</a>
	</div>
</section>

<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>