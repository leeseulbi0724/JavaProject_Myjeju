<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스토어 상품등록 | 예시</title>
<link rel = "stylesheet" href = "http://localhost:9000/myjeju/css/index.css">
<link rel = "stylesheet" href = "http://localhost:9000/myjeju/css/store/store.css">
<script src="http://localhost:9000/myjeju/js/jquery-3.6.0.min.js"></script>
<script>

	$(document).ready(function() {
		
		$("#storeWriteBtn").click(function() {
			if($("#s_category").val() == "choice") {
				alert("카테고리를 입력해주세요");
				$("#s_category").focus();
				return false;
			} else if ($("#s_name").val() == "") {
				alert("상품명을 입력해주세요");
				$("#s_name").focus();
				return false;
			} else if ($("#s_price").val() == "") {
				alert("가격을 입력해주세요");
				$("#s_price").focus();
				return false;
			/* } else if ($("#s_image").val() == "") {
				alert("메인이미지를 삽입해주세요");
				$("#s_image").focus(); 
				return false; */
			} else {
				store_write_form.submit();
			}
		});
	});
	
	


</script>
</head>
<body>	
	
	<!-- header -->
	<jsp:include page = "../header.jsp"></jsp:include>
	
	
	<!-- content -->
<section>
	<div class = "store_write">
		<form name = "store_write_form" action = "store_write_proc.do" method = "post" enctype = "multipart/form-data">
			<table>
				<tr>
					
					<th>카테고리</th>
					<td>
						<select name = "s_category" id = "s_category">
							<option value = "choice">선택</option>
							<option value = "식품">식품</option>
							<option value = "기념품">기념품</option>
							<option value = "잡화">잡화</option>
						</select>
					</td>	
				</tr>
				
				<tr>
					<th>상품명</th>
					<td><input type = "text" name = "s_name" id = "s_name"></td>
				</tr>
				
				<tr>
					<th>가격</th>
					<td><input type = "text" name = "s_price" id = "s_price"></td>				
				</tr>
				
				<tr>
					<th>메인 이미지</th>
					<td><input type = "file" name = "sfile1" id = "s_image"></td>
				</tr>
				
				<tr>
					<th>내용 이미지</th>
					<td><input type = "file" name = "sfile2" id = "s_content"></td>
				</tr>
				
				<tr>
					<td>
						<button type = "button" id = "storeWriteBtn">상품등록</button>
						<a href = "store.do"><button type ="button">스토어 홈으로</button></a>
					</td>
				</tr>
			</table>		
		</form>
	</div>
</section>
	
	
	<!-- footer -->
	<jsp:include page = "../footer.jsp"></jsp:include>
	
	
</body>
</html>