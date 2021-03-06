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
	
	.file_name, .sfile_name, .old_name { display:none; }
	th>div>button { display:inline-block; margin-left:5px; }
	#file { width:600px; display:inline-block; }
</style>
<script>
$(document).ready(function() {
	$("#file_name").val($(".file_name").text());
	$("#sfile_name").val($(".sfile_name").text());
	
	$(".write").click(function() {
		/*
		if ($("input[name^=cs_name]").val() == "") {
			alert("스팟명을 입력해주세요");
			$(this).focus();		
		} else if ($("textarea[name^=cs_infor]").val() == "") {
			alert("설명을 입력해주세요");
			$(this).focus();		
		} else if ($("#file").val() == "") {
			alert("파일을 첨부해주세요");
			$("#file").focus();		
		} else {
		} 
		*/
		admin_travel_spot.submit();
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
	                document.getElementById("addr").value = addr;
	                // 커서를 상세주소 필드로 이동한다.
	                document.getElementById("addr").focus();
				}
			}).open();
		});	
		
	});
	
	$("button[class='minus']").click(function() {
		$(this).closest("div").next().next().remove();
		$(this).closest("div").next().remove();
		$(this).closest("div").remove();
		
		$("#sfile_name").val($(".sfile_name").text());
		$("#file_name").val($(".file_name").text());
		
		$(".old_name").append($(this).prev().attr("name")+",");
		$("#old_name").val($(".old_name").text());
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
					<li><a href="adfood.do">음식점관리</a></li>
					<li><a href="adcafe.do">카페관리</a></li>
					<li class="active"><a href="adtravel.do">여행지관리</a></li>
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
			<div> 여행지관리 </div>
			<div></div>
		</section>
			<div style="width:1000px; display:inline-block;">
			<form name="admin_travel_spot" action="adtravel_carspot_update_proc.do" method="post" enctype= "multipart/form-data">			
			<table class="table">
		 		<tr>
		 			<th class="title">스팟</th>
		 			<th>
		 				<select name="spot_choice" class="form-control" id="spot_choice">
		 					<option value="photo">포토스팟</option>
		 					<option value="car" selected>차박스팟</option>
		 				</select>
		 			</th>
		 			<th class="title">이름</th>
		 			<th>
		 				<input type="text" class="form-control" placeholder="차박스팟명을 입력해주세요" id="cs_name" name="cs_name" value="${carvo.cs_name}">
		 			</th>
		 		</tr>
		 		<tr>
		 			<th class="title">설명</th>
		 			<th colspan="4">
		 				<textarea class="form-control" placeholder="차박스팟 설명을 입력해주세요" id="cs_info" name="cs_infor" style="height:200px;">${carvo.cs_infor}</textarea>
		 			</th>
		 		</tr>
		 		<tr>
		 			<th class="title" >사진 추가</th>
		 			<th colspan="4"><input type="file" class="form-control" multiple="multiple" name="file" id="file"></th>
		 		</tr> 		
		 		<tr>
		 			<th class="title" rowspan="3">기존 사진</th>
		 			<th colspan="4">
				 		<c:forEach var="carvo"  items="${list}">
			 				<div>
			 					<input type="text" class="form-control"  id="file" readonly value="${carvo.cs_csfile }" name="${carvo.cs_cssfile }">
			 					<button type="button" class="minus">-</button>
			 				</div>
		 					<span class="file_name">${carvo.cs_csfile},</span>		 					
		 					<span class="sfile_name">${carvo.cs_cssfile},</span>
				 		</c:forEach>
		 			</th>		 			
		 		</tr> 		
		 	</table>
		 		<input type="hidden" name="tid" value="${carvo.tid }">
		 		<input id="file_name" type="hidden" name="cs_csfile">
		 		<input id="sfile_name"  type="hidden" name="cs_cssfile">
		 		<input id="old_name" type="hidden" name="old_name">
		 		<span class="old_name"></span>
				<a href="adtravel.do" class="list" >취소</a>
				<a class="write" >등록</a>
			</form>
			</div>
		<section class ="setup_faq_list">
		
		</section>
		
	</div>
</body>
</html>