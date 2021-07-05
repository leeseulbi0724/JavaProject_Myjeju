<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
<title>기본정보 수정 | JEJU ISLAND</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/index.css">
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/mypage/request.css">
</head>
<body>
<jsp:include page="../../header.jsp"></jsp:include>

<section>
	<p>회원님의 개인정보 보호를 위해 <strong>비밀번호</strong>를 입력하셔야 합니다.<br>
	<span>로그인 시 사용하시는 비밀번호를 입력해주세요.</span></p>
	<input type="password" class="form-control">
	<div>
		<a class="btn btn-outline-secondary" href="mypage.do" id="cancle">취소</a>
		<a class="btn" id="ok" href="myinfo.do">확인</a>
	</div>
</section>

<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>