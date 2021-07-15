<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			<table class="table board_table free_table">
				<tr>
					<th></th>
					<th><strong>자유게시판</strong></th>
					<th>제목</th>
					<th>작성일</th>
				</tr>
				<c:forEach var = "vo"  items="${list1}">
					<tr class="free_tr">
						<td><input type="checkbox" value=${vo.fid }></td>
						<td>자유</td>
						<td><a href="http://localhost:9000/myjeju/free_board_content.do?fid=${vo.fid }">${vo.ftitle }</a></td>
						<td>${vo.fdate }</td>
					</tr>
				</c:forEach>
			</table>
			<table class="table board_table request_table">
				<tr>
					<th></th>
					<th><strong>요청게시판</strong></th>
					<th>제목</th>
					<th>작성일</th>
				</tr>
				<c:forEach var = "vo"  items="${list2}">
					<tr class="request_tr">
						<td><input type="checkbox" value=${vo.rid }></td>
						<td>요청</td>
						<td><a href="http://localhost:9000/myjeju/request_board_number.do?rid=${vo.rid }">${vo.rtitle }</a></td>
						<td>${vo.rdate }</td>
					</tr>
				</c:forEach>
			</table>
			
			<table class="table comment_table">
				<tr>
					<th></th>
					<th colspan="2">댓글</th>
					<th>작성일</th>
				</tr>
				<c:forEach var = "vo"  items="${list3}">
					<tr>
						<td><input type="checkbox"></td>
						<td>${vo.ccomment }</td>
						<td><a href="http://localhost:9000/myjeju/free_board_content.do?fid=${vo.fid}"}>게시글보기▶</a></td>
						<td>${vo.cdate }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</section>

<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>