<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
<title>자유게시판 | JEJU ISLAND</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/index.css">
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/community/board_content.css">
<script src="http://localhost:9000/myjeju/js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function() {		
	$("#con_textarea").css("height", $("textarea").prop('scrollHeight')+5);
	
	$(".re_comment").click(function() {
		$(".re_box").css("display","block");		
	});
	
	$("#close").click(function() {
		$(".re_box").css("display","none");	
	});
	
});
</script>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>

<h3>자유게시판</h3>
<section>
<div class="content_box">
	<div class="box">
		<p class="info">${vo.id } | <span class="date">${vo.fdate }</span></p>
		<table class="table">
				<tr>
					<th class="title">${vo.ftitle }</th>
				</tr>
				<tr>
					<td>					 	
						<textarea class="form-control"  disabled style="resize: none;" id="con_textarea">${vo.fcontent }</textarea>
						<c:if test = "${!empty vo.fsfile}">
							<img src="http://localhost:9000/myjeju/upload/${vo.fsfile }" width=100% height=300px>
						</c:if>		
					</td>
				</tr>
		</table>
		<a class="btn" href="free_board.do" id="list">목록</a>	
		<%-- <% if (vo.getId().equals( session.getAttribute("signedUser"))) { %>
		<a class="btn btn-primary"  id="delete" >삭제</a>
		<% } %> --%>
		<div class="comment_box">
		<p class="text">댓글</p><br>
			<ul>
				<li>
					<div class="com_box">
						<p>닉네임(아이디)</p>
						<p>댓글 내용</p>
						<%-- <%if (cvo.getId().equals(session.getAttribute("signedUser"))) { %>
						<p class="date"><%= cvo.getCdate() %><a class="re_comment"">답글</a><a class="com_delete" id="<%= cvo.getCid() %>">삭제</a></p>
						<% } else { %>
						<% } %> --%>
						<p class="date">2021-07-01 22:15:11<a class="re_comment">답글</a></p>
						<div class="re_box">
							<textarea id="re_comment" class="form-control" style="resize: none;"></textarea>
							<button class="btn btn-outline-secondary" id="close">취소</button>
							<button class="btn btn-outline-secondary" id="re_up">등록</button>
							<%-- <input type="hidden" value="<%= cvo.getCid()%>" class="cid"> --%>
						</div>
					</div>
					<div class="com_subbox" >
						<img src="http://localhost:9000/myjeju/images/community/arrow.png" width=25 height=25>
						<div class="rebox">
							<p>닉네임(아이디)</p>
							<p>대댓글내용</p>
							<%--<%if (re_list.get(i).getId().equals(session.getAttribute("signedUser"))) { %>
							<p class="date"><%= re_list.get(i).getRdate() %><a class="recom_delete" id="<%= re_list.get(i).getRid() %>">삭제</a></p>
							<% } else { %> --%>
							<p class="date">2021-07-01 23:00:14</p>
							
						</div>
					</div>		
				</li>
				<li>
					<div class="rewrite_box">
						<textarea id="comment" class="form-control" style="resize: none;"></textarea>
						<button class="btn btn-outline-secondary" role="button" id="up">등록</button>
					</div>
				</li>
			</ul>		
		</div>
	</div>
</div>
</section>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>