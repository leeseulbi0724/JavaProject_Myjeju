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
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/community/board.css">
<script src="http://localhost:9000/myjeju/js/jquery-3.6.0.min.js"></script>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>

<h3>자유게시판</h3>
		<div class="container">
		<div class="search">
		<a class="btn btn-primary"  id="write" href="free_board_write.do">글쓰기</a>
			<select class="form-select" id="select">
				<option value="user">작성자</option>
				<option value="title">제목</option>
			</select>
			<input type="text" class="form-control" id="search_input">
			<a class="btn btn-outline-secondary" id="search" >검색</a>			
		</div>
		<table class="table" >
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody class="notice_tbody" >			
				<tr>
					<td><a class="noticeBtn">공지</a></td>
					<td><a href="#" class="notice_title">공지사항 제목</a></td>
					<td>관리자</td>
					<td>2021-07-06</td>
					<td>254</td>
				</tr>			
				<tr>
					<td><a class="noticeBtn">공지</a></td>
					<td><a href="#" class="notice_title">공지사항 제목</a></td>
					<td>관리자</td>
					<td>2021-07-06</td>
					<td>254</td>
				</tr>			
				<tr>
					<td><a class="noticeBtn">공지</a></td>
					<td><a href="#" class="notice_title">공지사항 제목</a></td>
					<td>관리자</td>
					<td>2021-07-06</td>
					<td>254</td>
				</tr>			
			</tbody>
			<tbody>
				<tr>
					<td>1</td>
					<td><a href="free_board_content.do">제목[0]</a></td>
					<td>이슬비</td>
					<td>2021.07.01</td>
					<td>25</td>
				</tr>	
				<tr>
					<td>1</td>
					<td><a href="#">제목[0]</a></td>
					<td>이슬비</td>
					<td>2021.07.01</td>
					<td>25</td>
				</tr>	
				<tr>
					<td>1</td>
					<td><a href="#">제목[0]</a></td>
					<td>이슬비</td>
					<td>2021.07.01</td>
					<td>25</td>
				</tr>	
				<tr>
					<td>1</td>
					<td><a href="#">제목[0]</a></td>
					<td>이슬비</td>
					<td>2021.07.01</td>
					<td>25</td>
				</tr>	
				<tr>
					<td>1</td>
					<td><a href="#">제목[0]</a></td>
					<td>이슬비</td>
					<td>2021.07.01</td>
					<td>25</td>
				</tr>	
				<tr>
					<td>1</td>
					<td><a href="#">제목[0]</a></td>
					<td>이슬비</td>
					<td>2021.07.01</td>
					<td>25</td>
				</tr>	
				<tr>
					<td>1</td>
					<td><a href="#">제목[0]</a></td>
					<td>이슬비</td>
					<td>2021.07.01</td>
					<td>25</td>
				</tr>	
				<tr>
					<td>1</td>
					<td><a href="#">제목[0]</a></td>
					<td>이슬비</td>
					<td>2021.07.01</td>
					<td>25</td>
				</tr>	
				<tr>
					<td>1</td>
					<td><a href="#">제목[0]</a></td>
					<td>이슬비</td>
					<td>2021.07.01</td>
					<td>25</td>
				</tr>	
				<tr>
					<td>1</td>
					<td><a href="#">제목[0]</a></td>
					<td>이슬비</td>
					<td>2021.07.01</td>
					<td>25</td>
				</tr>	
				<tr>
					<td>1</td>
					<td><a href="#">제목[0]</a></td>
					<td>이슬비</td>
					<td>2021.07.01</td>
					<td>25</td>
				</tr>	
				<tr>
					<td>1</td>
					<td><a href="#">제목[0]</a></td>
					<td>이슬비</td>
					<td>2021.07.01</td>
					<td>25</td>
				</tr>	
				<tr>
					<td>1</td>
					<td><a href="#">제목[0]</a></td>
					<td>이슬비</td>
					<td>2021.07.01</td>
					<td>25</td>
				</tr>	
				<tr>
					<td>1</td>
					<td><a href="#">제목[0]</a></td>
					<td>이슬비</td>
					<td>2021.07.01</td>
					<td>25</td>
				</tr>	
			</tbody>
		</table>
	</div>
	
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>