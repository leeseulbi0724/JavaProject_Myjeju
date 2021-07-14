<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
<title>자유게시판 | JEJU ISLAND</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/index.css">
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/community/board_write.css">
<script src="http://localhost:9000/myjeju/js/jquery-3.6.0.min.js"></script>
<style>
	.file {
		background-color:white;
		position:absolute;
		left:535px;
		margin-top:5px;
		width:500px;
		text-align:left;
	}
</style>
</head>
<script>
	$(document).ready(function() {
		$("#write").click(function() {
			if ($("#title").val() == "") {
				alert("제목을 입력해주세요");
				$("#title").focus();
			} else if ($("#content").val() == "") {
				alert("내용을 입력해주세요");
				$("#content").focus();
			} else {
				free_update.submit();
			}
		});
		
		$("#file_input").change(function() {
			if (window.FileReader) {
				var filename = $(this)[0].files[0].name;
				$(".file").text("").text(filename);
			}
		});
	});
</script>
<body>
<jsp:include page="../header.jsp"></jsp:include>

<h3>자유게시판</h3>
<div class="container">
	<form autocomplete="off" name="free_update" action="free_update_proc.do" method="post" enctype="multipart/form-data">
		<input type="text" class="form-control input" name="ftitle" value="${vo.ftitle }" id="title">
		<textarea name="fcontent" style="resize: none;" class="form-control textarea" id="content">${vo.fcontent }</textarea>
		<input type="file" class="form-control input" name="file1" id="file_input">
		<input type="hidden" name="fid" value="${vo.fid }">
		<span class="file">${vo.ffile }</span>
	<a class="btn" href="free_board.do" id="list">목록</a>
	<button type="button" class="btn"  id="write">등록</button>
	</form>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>