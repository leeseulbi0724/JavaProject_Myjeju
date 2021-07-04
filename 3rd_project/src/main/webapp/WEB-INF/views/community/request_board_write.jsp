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
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/community/board_write.css">
<script src="js/jquery-3.6.0.min.js"></script>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>

<h3>요청게시판</h3>
<div class="container">
	<form autocomplete="off"  name="community_write" action="" method="post" enctype= "multipart/form-data">
		<input type="text" class="form-control input" name="title">
		<textarea name="content" style="resize: none;" class="form-control textarea"></textarea>
		<input type="file" class="form-control input" name="file">
	<a class="btn" href="request_board.do" id="list">목록</a>
	<button type="button" class="btn"  id="write">등록</button>
	</form>
</div>

<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>