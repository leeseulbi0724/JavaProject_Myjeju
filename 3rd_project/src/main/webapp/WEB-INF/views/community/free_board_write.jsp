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
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>

<h3>자유게시판</h3>
<div class="container">
	<form autocomplete="off"  name="community_write" action="community_write_process.jsp" method="post" enctype= "multipart/form-data">
		<input type="text" class="form-control input" name="title" placeholder="제목">
		<textarea name="content" style="resize: none;" class="form-control textarea" placeholder="내용"></textarea>
		<input type="file" class="form-control input" name="file">
	<a class="btn" href="free_board.do" id="list">목록</a>
	<button type="button" class="btn"  id="write">등록</button>
	</form>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>