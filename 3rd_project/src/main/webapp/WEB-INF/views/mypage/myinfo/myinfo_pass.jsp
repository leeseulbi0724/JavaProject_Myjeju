<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
<title>비밀번호 변경 | JEJU ISLAND</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/index.css">
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/mypage/myinfo.css">
</head>
<body>
<jsp:include page="../../header.jsp"></jsp:include> 

<section>
	<div><h3>비밀번호 변경</h3></div>
	<div class="center">
	<table class="table">
		<tr>
			<th>현재 비밀번호</th>
			<th><input type="password" class="form-control"></th>
		</tr>
		<tr>
			<th>새 비밀번호</th>
			<th><input type="password" class="form-control"></th>
		</tr>		
		<tr>
			<th>새 비밀번호 재입력</th>
			<th><input type="password" class="form-control"> ※비밀번호 확인을 위해 한번 더 입력해 주시기 바랍니다.</th>
		</tr>		
	</table>	
	<a class="btn btn-outline-secondary" href="mypage.do" id="cancle">취소</a>
	<a class="btn" id="ok" href="#">수정</a>
	</div>
</section>

<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>