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
	section { text-align:center; margin-bottom:50px; }
	.center { 
		margin-top:80px; 
		width:800px; 
		display:inline-block; 
	}
	h3 { 
		border-bottom:5px solid #4fa9de; 
		font-size:20px; 
		font-weight:bold;
		display:inline-block;
	}		
	.box { 
		width:800px; height:320x; 
		display:inline-block;
		margin-top:50px;
		text-align:left;
		font-size:14px;
	 }
	 .ul { list-style:none; margin:0; padding:0; margin-bottom:20px; }
	 .ul li { margin-left:15px; }
	 .box span { font-size:18px; display:block; }
	#ok, #cancle { margin:5px; padding:2px 10px; }
	#ok { background-color:#4fa9de; color:white; }
	#ok:hover { background-color:rgb(23,86,123); }
	
	.table { border-top:1px solid; font-size:14px; }
	.table th { font-weight:normal; text-align:left; }
	.table th a, .table th button { padding:1px 10px; font-size:14px; }
	.table th:first-child {
		 font-weight:normal; 
		 width:150px; 
		 margin-bottom:10px; 		 
		 background-color:rgb(247,248,249); 
		 vertical-align:middle;
	}
	.form-control { width:200px; display:inline-block; height:25px; font-size:14px; }
</style>
</head>
<body>
<jsp:include page="../../header.jsp"></jsp:include>

<section>
	<div class="center">
		<h3>회원탈퇴</h3>
		<div class="box">
			[ 주의 ] JEJU ISLAND 회원탈퇴를 신청하기 전에 안내 사항을 꼭 확인해주세요.<br>
			<span>1. 탈퇴 후 삭제 내역</span>
			<ul>
				<li>개인 정보</li>
				<li>My 이력</li>
				<li>스토어 주문 내역</li>
				<li>로그인과 관련된 모든 정보</li>
			</ul>
			<span>2. 탈퇴 사유</span>
			<ul class="ul">
				<li><input type="radio" name="one"> 서비스 장애가 있어서</li>
				<li><input type="radio" name="two"> 이벤트 및 혜택이 적어서</li>
				<li><input type="radio" name="three"> 불만 및 불편사항에 대한 고객응대가 나빠서</li>
				<li><input type="radio" name="four"> 이용빈도가 낮고 개인정보 유출이 우려되어</li>
			</ul>	
			<table class="table">
			<tr>
				<th>비밀번호 입력</th>
				<th><input type="password" class="form-control"> ※원활한 회원탈퇴를 위해 비밀번호를 입력해주세요.</th>
			</tr>		
			</table>		
		</div>
		<a class="btn btn-outline-secondary" href="mypage.do" id="cancle">취소</a>
		<a class="btn" id="ok" href="#">탈퇴</a>
	</div>
</section>

<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>