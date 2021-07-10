<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
<title>My 게시글 | JEJU ISLAND</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/index.css">
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/mypage/myboard.css">
<script src="http://localhost:9000/myjeju/js/jquery-3.6.0.min.js"></script>
</head>
<script>
	$(document).ready(function() {
		$("#comment").click(function() {
			$(".board_table").css("display","none");
			$(".comment_table").css("display","block");
			$(this).css("color","rgb(3,199,90)")
			$("#board").css("color","black");
		});
		
		$("#board").click(function() {
			$(".comment_table").css("display","none");
			$(".board_table").css("display","block");
			$(this).css("color","rgb(3,199,90)")
			$("#comment").css("color","black");
		});
	});
</script>
<body>
<jsp:include page="../../header.jsp"></jsp:include>

<section>
	<div class="center">
		<a href="#" id="board">작성 글</a>
		<a href="#" id="comment">작성 댓글</a>
		<a href="#"  id="delete">삭제</a>
		<div class="table_div">
			<table class="table board_table">
				<tr>
					<th><input type="checkbox"></th>
					<th>분류</th>
					<th>제목</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
				<tr>
					<td><input type="checkbox"></td>
					<td>자유</td>
					<td>게시글 제목</td>
					<td>2021-07-06</td>
					<td>125</td>
				</tr>
				<tr>
					<td><input type="checkbox"></td>
					<td>요청</td>
					<td>게시글 제목</td>
					<td>2021-07-06</td>
					<td>125</td>
				</tr>
			</table>
			
			<table class="table comment_table">
				<tr>
					<th><input type="checkbox"></th>
					<th colspan="2">댓글</th>
					<th>작성일</th>
				</tr>
				<tr>
					<td><input type="checkbox"></td>
					<td>감사합니당~</td>
					<td><a href="#">게시글보기▶</a></td>
					<td>2021-07-06</td>
				</tr>
				<tr>
					<td><input type="checkbox"></td>
					<td>감사합니당~</td>
					<td>삭제된 게시글</td>
					<td>2021-07-06</td>
				</tr>
			</table>
		</div>
	</div>
</section>

<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>