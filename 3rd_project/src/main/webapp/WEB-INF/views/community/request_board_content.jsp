<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<p class="info">${vo.rcategory } | ${vo.id } | <span class="date">${vo.rdate }</span></p>
		<table class="table">
				<tr>
					<th class="title">${vo.rtitle }</th>
				</tr>
				<tr>
					<td>					 	
						<textarea class="form-control"  disabled style="resize: none;" id="con_textarea">${vo.rcontent }</textarea>
						<c:if test = "${!empty vo.rsfile}">
							<img src="http://localhost:9000/myjeju/upload/${vo.rsfile }" width=100% height=300px>
						</c:if>								
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