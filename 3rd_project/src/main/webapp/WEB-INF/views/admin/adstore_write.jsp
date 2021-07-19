<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "javax.servlet.jsp.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="test/html; charset=UTF-8">
	<meta name ="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/admincss/bootstrap.css">
	<link rel="stylesheet" href="css/admincss/custom.css">
	<link rel="stylesheet" href="css/admincss/setupforcounsel.css">
	<title>Myjeju 관리자 메뉴</title>
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script type="text/javascript"></script>
</head>	
<script>

	$(document).ready(function() {
		
		$("#adstoreWriteBtn").click(function() {
			if($("#s_category").val() == "choice") {
				alert("카테고리를 입력해주세요");
				$("#s_category").focus();
				return false;
			} else if ($("#s_name").val() == "") {
				alert("상품명을 입력해주세요");
				$("#s_name").focus();
				return false;
			} else if ($("#s_price").val() == "") {
				alert("가격을 입력해주세요");
				$("#s_price").focus();
				return false;
			} else if ($("#s_image").val() == "") {
				alert("메인이미지를 삽입해주세요");
				$("#s_image").focus(); 
				return false;
			} else if ($("#s_content").val() == "") {
				alert("상세이미지를 삽입해주세요");
				$("#s_content").focus(); 
				return false;	
			} else {
				adstore_write_form.submit();
			}
		});
	});

</script>
<body style = "height : 900px;">

	<nav class="navbar navbar-default">
		<div class ="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expeanded="false">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="http://localhost:9000/myjeju/adminindex.do">Myjeju 관리자 메뉴</a>
		</div>
		
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="http://localhost:9000/myjeju/adminindex.do">메인</a>
				<li><a href="adnotice.do">공지사항관리</a></li>
				<li><a href="adboard.do">게시판관리</a></li>
				<li><a href="adrequest.do">요청관리</a></li>
				<li><a href="admember.do">회원관리<span id="unread" class="label label-info"></span></a></li>
				<li><a href="#">정보관리</a></li>
				<li class="active"><a href="adstore.do">상품관리</a>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="http://localhost:9000/myjeju/index.do">메인으로</a>
				</li>
			</ul>						
		</div>
	</nav>

	
	<!-- content -->
	<section>
		<div class = "store_write">
			<form name = "adstore_write_form" action = "adstore_write_proc.do" method = "post" enctype = "multipart/form-data">
				<table>
					<tr>
						
						<th>카테고리</th>
						<td>
							<select name = "s_category" id = "s_category">
								<option value = "choice">선택</option>
								<option value = "식품">식품</option>
								<option value = "기념품">기념품</option>
								<option value = "잡화">잡화</option>
							</select>
						</td>	
					</tr>
					
					<tr>
						<th>상품명</th>
						<td><input type = "text" name = "s_name" id = "s_name"></td>
					</tr>
					
					<tr>
						<th>가격</th>
						<td><input type = "text" name = "s_price" id = "s_price"></td>				
					</tr>
					
					<tr>
						<th>메인 이미지</th>
						<td><input type = "file" name = "sfile1" id = "s_image"></td>
					</tr>
					
					<tr>
						<th>내용 이미지</th>
						<td><input type = "file" name = "sfile2" id = "s_content"></td>
					</tr>
					
					<tr>
						<td>
							<button type = "button" id = "adstoreWriteBtn">상품등록</button>
							<a href = "store.do"><button type ="button">스토어 홈으로</button></a>
						</td>
					</tr>
				</table>		
			</form>
		</div>
	</section>

	
</body>
</html>