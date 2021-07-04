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
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/mypage/myinfo.css">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
function addr() {
	daum.postcode.load(function() {
		new daum.Postcode({
			oncomplete:function(data) {
				
			}
		}).open();
	});	
}

</script>
</head>
<body>
<jsp:include page="../../header.jsp"></jsp:include> 

<section>
	<div><h3>기본정보 수정</h3></div>
	<div class="center">	
	<table class="table">
		<tr>
			<th>아이디</th>
			<th>tmfql4428</th>
		</tr>
		<tr>
			<th>비밀번호</th>
			<th><a class="btn btn-outline-dark" href="myinfo_pass.do">비밀번호 변경</a></th>
		</tr>
		<tr>
			<th>이름</th>
			<th>이슬비</th>
		</tr>
		<tr>
			<th>생년월일</th>
			<th>980724-2******</th>
		</tr>
		<tr>
			<th>닉네임</th>
			<th><input type="text" class="form-control" value="슬비"></th>
		</tr>
		<tr>
			<th>이메일</th>
			<th>
				<input type="text" class="form-control" value="tmfql4428">@<input type="text" class="form-control" value="naver.com">
				<select class="form-select">
					<option value="선택">선택
				</select>
			</th>
		</tr>
		<tr>
			<th>휴대폰번호</th>
			<th>
				<select class="form-select">
					<option value="선택">선택
				</select>-
				<input type="text" class="form-control">-
				<input type="text" class="form-control">
			</th>
		</tr>
		<tr>
			<th>주소</th>
			<th>
				<input type="text" class="form-control addr" value="경기도 수원시 영통구 매탄동">
				<input type="text" class="form-control addr" value="-">
				<button class="btn btn-outline-dark"  onclick="addr()" >주소 검색</button>
			</th>
		</tr>
	</table>
	<a class="btn btn-outline-secondary" href="mypage.do" id="cancle">취소</a>
	<a class="btn" id="ok" href="#">수정</a>
	</div>
</section>

<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>