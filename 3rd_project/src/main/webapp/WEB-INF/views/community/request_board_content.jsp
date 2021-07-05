<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
<title>요청게시판 | JEJU ISLAND</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/index.css">
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/community/board_content.css">
<script src="http://localhost:9000/myjeju/js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function() {		
	$("#con_textarea").css("height", $("textarea").prop('scrollHeight')+5);	
});
</script>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>

<h3>요청게시판</h3>
<section>
<div class="content_box">
	<div class="box">
		<p class="info">닉네임(아이디) | <span class="date">2021-07-01 21:29:12</span></p>
		<table class="table">
				<tr>
					<th class="table-secondary">제목</th>
				</tr>
				<tr>
					<td>					 	
						<textarea class="form-control"  disabled style="resize: none;" id="con_textarea">내용</textarea>						
					</td>
				</tr>
		</table>
		<a class="btn" href="request_board.do" id="list">목록</a>	
		<%-- <% if (vo.getId().equals( session.getAttribute("signedUser"))) { %>
		<a class="btn btn-primary"  id="delete" >삭제</a>
		<% } %> --%>
	</div>
</div>
</section>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>