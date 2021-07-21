<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
<title>My 후기 | JEJU ISLAND</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="http://localhost:9000/myjeju/css/index.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
<script src="http://localhost:9000/myjeju/js/jquery-3.6.0.min.js"></script>
<style>
	section { text-align:center; margin-bottom:50px;  }
	.center { 
		margin-top:100px; 
		width:900px; 
		display:inline-block; 
	}
	h3 { 
		border-bottom:5px solid #4fa9de; 
		font-size:20px; 
		font-weight:bold; 
		display:inline-block;
	}	
	
	#delete { 
		float:right;
		text-decoration:none; 
		color:gray; 
		border:1px solid lightgray; 
		border-radius:5px; 
		padding:3px 10px;
		font-size:14px;
		margin-bottom:10px;
	}
	
	.table { font-size:14px; }
	.table tr:first-child th { background-color:rgb(247,248,249); border-top:1px solid lightgray; }
	
	.inner-star::before{color: #FF9600;}
	.outer-star {position: relative;display: inline-block;color: #CCCCCC;}
	.inner-star {position: absolute;left: 0;top: 0;width: 0%;overflow: hidden;white-space: nowrap;}
	.outer-star::before, .inner-star::before {content: '\f005 \f005 \f005 \f005 \f005';font-family: 'Font Awesome 5 free';font-weight: 900;}
</style>
<script>
	
	$(document).ready(function() {
		
		$("#delete").click(function() {
			
			if($("input[type^=checkbox]").is(":checked") == false) {
				alert("삭제할 리뷰를 선택해주세요");
			} else {
				var result = confirm("해당 리뷰를 삭제하시겠습니까?");
				
				if(result) {
					var index = $("input[type^=checkbox]:checked").val();
					alert(index);
					
				}

			}
		});
		
		

	});

</script>
</head>
<body>
<jsp:include page="../../header.jsp"></jsp:include>

<section>
	<div class="center">
		<div><h3>My 후기</h3></div>		
		<button type = "button" id="delete">삭제</button>
			<table class="table">
				<tr>
					<th></th>
					<th>구분</th>
					<th>별점</th>
					<th>내용</th>
					<th>작성일</th>
				</tr>
				
				<c:forEach var = "list" items = "${store_list}" varStatus = "status">
					<tr>
						<c:if test = "${!empty list.sid}">
							<td><input type="checkbox" name = "${list.srid}"></td>
							<td>상품 </td>
							<td>
								<div class='RatingStar'>
								  <div class='RatingScore'>
								    <div class='outer-star'><div class='inner-star' style = "width : ${(list.sr_star)*20}%"></div></div>
								  </div>
								</div>
							</td>
							<td><a href = "store_content.do?sid=${list.sid}">${list.sr_review}</a></td>
							<td>${list.sr_time }</td>
						</c:if>
					</tr>
					
					<tr>
						<c:if test = "${!empty travel_list[status.index].reid}">
							<td><input type="checkbox" value = "${travel_list[status.index].tid}"></td>
							<td>여행지</td>
							<td>
								<div class='RatingStar'>
								  <div class='RatingScore'>
								    <div class='outer-star'><div class='inner-star' style = "width : ${(travel_list[status.index].t_star)*20}%"></div></div>
								  </div>
								</div>
							</td>
							<td><a href = "travel_detail.do?tid=${travel_list[status.index].tid}">${travel_list[status.index].t_review}</a></td>
							<td>${travel_list[status.index].t_time}</td>
						</c:if>
					</tr>
					
				</c:forEach>	
				<!-- <tr>
					<td><input type="checkbox"></td>
					<td>상품</td>
					<td>
						<div class='RatingStar'>
						  <div class='RatingScore'>
						    <div class='outer-star'><div class='inner-star'></div></div>
						  </div>
						</div>
					</td>
					<td>선물받은 지인이 오메기떡 진짜 맛있다네요!</td>
					<td>2017-07-06</td>
				</tr> -->
			</table>
	</div>
</section>

<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>