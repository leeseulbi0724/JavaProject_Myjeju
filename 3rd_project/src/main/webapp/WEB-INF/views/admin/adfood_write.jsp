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
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script type="text/javascript"></script>
</head>
<style>
	.write, .list { 				
		padding:5px 10px;
		border-radius:4px;
		margin:10px 0; 
	}
	.write { background-color:rgb(20,86,184); color:white;  }
	.list { background-color:rgb(228,228,228); color:black; }
	
	.table tr { border-bottom:1px solid lightgray; }
	.table .title {
		background-color:rgb(248,248,248);
		vertical-align : middle;		
	}
	.table #hid { width:60px; display:inline-block; }
</style>
<script>
$(document).ready(function() {
	$(".write").click(function() {
		if ($("#name").val() == "") {
			alert("이름을 입력해주세요");
			$("#name").focus();		
		} else if ($("#tag").val() == "") {
			alert("태그를 입력해주세요");
			$("#tag").focus();		
		} else if ($("#category").val() == "") {
			alert("종류를 입력해주세요");
			$("#category").focus();		
		} else if ($("#info").val() == "") {
			alert("설명을 입력해주세요");
			$("#info").focus();		
		} else if ($("#addr1").val() == "") {
			alert("주소를 입력해주세요");
			$("#addr1").focus();		
		} else if ($("#addr2").val() == "") {
			alert("상세 주소를 입력해주세요");
			$("#addr2").focus();		
		} else if ($("#vpoint").val() == "") {
			alert("경도를 입력해주세요");
			$("#vpoint").focus();		
		} else if ($("#hpoint").val() == "") {
			alert("위도를 입력해주세요");
			$("#hpoint").focus();		
		} else if ($("#hp").val() == "") {
			alert("번호를 입력해주세요");
			$("#hp").focus();		
		} else if ($("#file").val() == "") {
			alert("파일을 첨부해주세요");
			$("#file").focus();		
		} else {
			admin_food.submit();
		}
	});
	
	$("#search").click(function() {
		daum.postcode.load(function() {
			new daum.Postcode({
				oncomplete:function(data) {
	                var addr = ''; // 주소 변수
	                var extraAddr = ''; // 참고항목 변수
	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    addr = data.roadAddress;
	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    addr = data.jibunAddress;
	                }
	                if(data.userSelectedType === 'R'){
	                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                        extraAddr += data.bname;
	                    }
	                    // 건물명이 있고, 공동주택일 경우 추가한다.
	                    if(data.buildingName !== '' && data.apartment === 'Y'){
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                    if(extraAddr !== ''){
	                        extraAddr = ' (' + extraAddr + ')';
	                    }	                
	                } else {
	                 
	                }
	                document.getElementById("addr1").value = addr;
	                // 커서를 상세주소 필드로 이동한다.
	                document.getElementById("addr2").focus();
				}
			}).open();
		});	
		
	});
	
	
});
</script>
<body style="height:900px">
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
					<li ><a href="adboard.do">게시판관리</a></li>
					<li><a href="adrequest.do">요청관리</a></li>
					<li><a href="admember.do">회원관리<span id="unread" class="label label-info"></span></a></li>
					<li><a href="adhouse.do">숙소관리</a></li>
					<li  class="active"><a href="adfood.do">음식점관리</a></li>
					<li><a href="adcafe.do">카페관리</a></li>
					<li><a href="adtravel.do">여행지관리</a></li>
					<li><a href="adstore.do">상품관리</a>
				</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="http://localhost:9000/myjeju/index.do">메인으로</a>
				</li>
			</ul>						
			</div>
		</nav>
			<!-- content -->
	<div class = "content_setup_faq">
	
		<section class = "section_setup_faq">
			<div></div>
			<div> 음식점관리 </div>
			<div></div>
		</section>
			<div style="width:1000px; display:inline-block;">
			<form name="admin_food" action="adfood_write_proc.do" method="post" enctype= "multipart/form-data">			
			<table class="table">
		 		<tr>
		 			<th class="title">이름</th>
		 			<th><input type="text" class="form-control" placeholder="상호명을 입력해주세요" id="name" name="f_name"></th>
		 			<th class="title">해시태그</th>
		 			<th><input type="text" class="form-control" placeholder="해시태그를 입력해주세요" id="tag" name="f_tag"></th>
		 			<th class="title">종류</th>
		 			<th><input type="text" class="form-control" placeholder="종류를 입력해주세요" id="category" name="f_infor"></th>
		 		</tr>
		 		<tr>
		 			<th class="title">설명</th>
		 			<th colspan="5"><input type="text" class="form-control" placeholder="간단한 설명을 입력해주세요" id="info" name="f_infor2"></th>
		 		</tr>	
		 		<tr>
		 			<th class="title">주소</th>
		 			<th colspan="4">
		 				<input type="text" class="form-control" placeholder="주소를 입력해주세요" name="f_addr1"  id="addr1">
		 				<input type="text" class="form-control" placeholder="상세를 입력해주세요"name="f_addr2"  id="addr2">			 				
		 			</th>	
		 			<th><button class="btn btn-primary" type="button" style="margin:17px 0;background-color:#4fa9de; border-color:#4fa9de;" id="search">주소검색</button></th>	 				 			
		 		</tr>	
		 		<tr>
		 			<th class="title">경도</th>
		 			<th><input type="text" class="form-control" placeholder="경도를 입력해주세요" id="vpoint" name="f_vpoint"></th>
		 			<th class="title">위도</th>
		 			<th><input type="text" class="form-control" placeholder="위도를 입력해주세요" id="hpoint" name="f_hpoint"></th>
		 			<th class="title">연락처</th>
		 			<th><input type="text" class="form-control" value="(+82)" placeholder="연락처를 입력해주세요" id="hp" name="f_hp"></th>
		 		</tr>	
		 		<tr>
		 			<th class="title">사진 (여러장 가능)</th>
		 			<th colspan="5"><input type="file" class="form-control" multiple="multiple" name="file" id="file"></th>
		 		</tr> 		
		 	</table>
				<a href="adfood.do" class="list" >취소</a>
				<a class="write" >등록</a>
			</form>
			</div>
		<section class ="setup_faq_list">
		
		</section>
		
	</div>
</body>
</html>