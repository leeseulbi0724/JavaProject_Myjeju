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
<style>
	.write, .list { 				
		padding:5px 10px;
		border-radius:4px;
		margin:10px 0; 
	}
	.write { background-color:rgb(20,86,184); color:white;  }
	.list { background-color:rgb(228,228,228); color:black; }
	
	form>div {
		background-color:white;
		position:absolute;
		margin-top:-45px;
		margin-left:93px;
		width:800px;
		text-align:left;
	}
</style>
<script>
$(document).ready(function() {
	$(".write").click(function() {
		if ($("#title").val() == "") {
			alert("제목을 입력해주세요");
			$("#title").focus();		
		} else if ($("#content").val() == "") {
			alert("내용을 입력해주세요");
			$("#content").focus();		
		} else {
           adnotice_update.submit();
		}
	});
	
	$("#file").change(function() {
		if (window.FileReader) {
			var filename = $(this)[0].files[0].name;
			$(".file_name").text("").text(filename);
		}
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
					<li  class="active"><a href="adnotice.do">공지사항관리</a></li>
					<li ><a href="adboard.do">게시판관리</a></li>
					<li><a href="adrequest.do">요청관리</a></li>
					<li><a href="admember.do">회원관리<span id="unread" class="label label-info"></span></a></li>
					<li><a href="adhouse.do">숙소관리</a></li>
					<li><a href="adfood.do">맛집관리</a></li>
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
			<div> 공지사항관리 </div>
			<div></div>
		</section>
			<div style="width:1000px; display:inline-block;">
			<form name="adnotice_update" action="adnotice_update_proc.do" method="post" enctype="multipart/form-data">
				<input type="text" class="form-control"style="margin-bottom:5px; width:100%" name="ntitle" id="title" value="${vo.ntitle }">
				<input type="hidden" value="${vo.nid }" name="nid">
				<textarea class="form-control" style="height:500px; margin-bottom:5px; " name="ncontent" id="content">${vo.ncontent }</textarea>
				<input type="file" class="form-control" name="file1" style="margin-bottom:20px;" id="file">
				<div class="file_name">${vo.nfile }</div>
				<a href="adnotice_content.do?nid=${vo.nid }" class="list" >취소</a>
				<a class="write" >수정</a>
			</form>
			</div>
		<section class ="setup_faq_list">
		
		</section>
		
	</div>
</body>
</html>