<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="test/html; charset=UTF-8">
	<meta name ="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/admincss/bootstrap.css">
	<link rel="stylesheet" href="css/member/custom.css">
	<link rel="stylesheet" href="http://localhost:9000/myjeju/css/index.css">
	<link rel="shortcut icon" type="image⁄x-icon" href="http://localhost:9000/myjeju/images/index/icon.png">
	<title>JEJU ISLAND</title>
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script type="text/javascript">
		
		function registerCheckFunction() {
			var userID = $('#userID').val();
			$.ajax({
				type: 'POST',
				url: './UserRegisterCheckServlet',
				data: {userID : userID},
				success: function(result) {
					if(result == 1) {
						$('#checkMessage').html('사용할 수 있는 아이디입니다.');
						$('#checkType').attr('class', 'modal-content panel-success');
					} else {
						$('#checkMessage').html('사용할 수 없는 아이디입니다.');
						$('#checkType').attr('class', 'modal-content panel-warning');
					}
					$('#checkModal').modal("show");
				}
			});
		}
		function passwordCheckFunction() {
			var userPassword1 = $('#userPassword1').val();
			var userPassword2 = $('#userPassword2').val();
			if(userPassword1 != userPassword2) {
				$('#passwordCheckMessage').html('비밀번호가 서로 일치하지 않습니다.');
			} else {
				$('#passwordCheckMessage').html('');
			}
		}
	</script>
</head>
<body>
	<%
		String userID = null;
		if(session.getAttribute("userID") != null){
			userID = (String) session.getAttribute("userID");
		}
		if(userID != null) {
			session.setAttribute("messageType", "오류 메시지");
			session.setAttribute("messageContent", "현재 로그인이 되어 있는 상태입니다.");
			response.sendRedirect("index.jsp");
			return;
		}
	%>
	<jsp:include page="../header.jsp"></jsp:include>
	<div style="text-align:center; width:1200px; height: 50px; margin:65px auto; margin-bottom:80px;" >
		<h3>회원가입</h3>
		</div>
		<div class="container" style="margin-bottom:100px;">
			<form method="post" action="./userRegister">
				<table class="table table-bordered table-hover" style="text-align: center; border: 1px solid #dddddd">
					<tbody>	
						<tr>
							<td style="width: 110px;"><h5>아이디</h5></td>
							<td><input class="form-control" type="text" id="userID" name="userID" maxlength="20" placeholder="아이디를 입력하세요."></td>
							<td style="width: 110px;"><button class="btn btn-primary" onclick="registerCheckFunction();" type="button" style="background-color:#4fa9de; border-color:#4fa9de;">중복체크</button></td>
						</tr>
						<tr>
							<td style="width: 110px;"><h5>비밀번호</h5></td>
							<td colspan="2"><input onkeyup="passwordCheckFunction();" class="form-control" id="userPassword1" type="password" name="userPassword1" maxlength="20" placeholder="비밀번호를 입력하세요."></td>
						</tr>
						<tr>
							<td style="width: 110px;"><h5>비밀번호 확인</h5></td>
							<td colspan="2"><input onkeyup="passwordCheckFunction();" class="form-control" id="userPassword2" type="password" name="userPassword2" maxlength="20" placeholder="비밀번호 확인를 입력하세요."></td>
						</tr>
						<tr>
							<td style="width: 110px;"><h5>이름</h5></td>
							<td colspan="2"><input class="form-control" id="userName" type="text"  name="userName" maxlength="20" placeholder="이름를 입력하세요."></td>
						</tr>
						<tr>
							<td style="width: 110px;"><h5>생년월일</h5></td>
							<td colspan="2"><input class="form-control" id="userbirth" type="text"  name="userbirth" maxlength="20" placeholder="생년월일을 입력하세요."></td>
						</tr>
						<tr>
							<td style="width: 110px;"><h5>닉네임</h5></td>
							<td colspan="2"><input class="form-control" id="userbirth" type="text"  name="userbirth" maxlength="20" placeholder="생년월일을 입력하세요."></td>
						</tr>
						<tr>
							<td style="width: 110px;"><h5>이메일</h5></td>
							<td colspan="2">
							<input class="form-control pull-left" id="userEmail1" type="email" name="userEmail1" maxlength="20" placeholder="이메일을 입력하세요." style="width:42%;">
							<span class="pull-left" style="background-color: rgba(0,0,0,0); font-color:black; font-size: 17px; margin: 4px 10px;">@</span>
							<input class="form-control pull-left" id="userEmail2" type="email" name="userEmail2" maxlength="20" placeholder="이메일주소을 입력하세요." style="width:42%;">
							<div class="dropdown pull-left" style="width:10%; margin-left:10px;">
							  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" style="width:100%;">
							    <span id="choosevalue">선택</span>
							    <span class="caret"></span>
							  </button>
							  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							    <li><a href="#">naver.com</a></li>
							    <li><a href="#">gmail.com</a></li>
							    <li><a href="#">daum.net</a></li>
							    <li role="separator" class="divider"></li>
							    <li><a href="#">직접입력</a></li>
							  </ul>
							</div>
							</td>
						</tr>
						<tr>
							<td style="width: 110px;"><h5>휴대폰번호</h5></td>
							<td colspan="2">
							<div class="dropdown pull-left" style="width:10%;">
							  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" style="width:100%;">
							    <span id="choosevalue">선택</span>
							    <span class="caret"></span>
							  </button>
							  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							    <li><a href="#">010</a></li>
							    <li><a href="#">011</a></li>
							    <li><a href="#">017</a></li>
							  </ul>
							</div>
							<span class="pull-left" style="background-color: rgba(0,0,0,0); font-color:black; font-size: 20px; margin: 0 10px;">-</span>
							<input class="form-control pull-left" id="hp1" type="text" name="hp1" maxlength="20" placeholder="핸드폰번호를 입력하세요." style="width:41%;">
							<span class="pull-left" style="background-color: rgba(0,0,0,0); font-color:black; font-size: 20px; margin: 0 10px;">-</span>
							<input class="form-control pull-left" id="hp2" type="text" name="hp2" maxlength="20" placeholder="핸드폰번호를 입력하세요." style="width:41%;">
						</tr>
						<tr>
							<td style="width: 110px;"><h5>주소</h5></td>
							<td>
							<input class="form-control pull-left" id="addr1" type="text" name="addr1" maxlength="20" placeholder="주소를 입력하세요." style="width:100%; margin-bottom:5px;">
							<input class="form-control pull-left" id="addr2" type="text" name="addr2" maxlength="20" placeholder="상세주소를 입력하세요." style="width:100%;">
							</td>							
							<td style="width: 110px;"><button class="btn btn-primary" onclick="#" type="button" style="margin:17px 0;background-color:#4fa9de; border-color:#4fa9de;">주소검색</button></td>
						</tr>
						<tr>
							<td Style="text-align: left;" colspan="3"><h5 style="color: red;" id="passwordCheckMessage"></h5><input class="btn btn-primary pull-right" type="submit" value="등록" style="background-color:#4fa9de; border-color:#4fa9de;"></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
		<%
			String messageContent = null;
			if(session.getAttribute("messageContent") != null) {
				messageContent = (String) session.getAttribute("messageContent");
			}
			String messageType = null;
			if(session.getAttribute("messageType") != null) {
				messageType = (String) session.getAttribute("messageType");
			}
			if(messageContent != null) {
		%>
		<div class="modal fade" id="messageModal" tabindex="-1" role="dialog" aria-hidden="true">
			<div class="vertical-alignment-helper">
				<div class="modal-dialog vertical-align-center">
					<div class="modal-content <% if(messageType.equals("오류 메시지")) out.println("panel-warning"); else out.println("panel-success"); %>">
						<div class="modal-header panel-heading">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times</span>
								<span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title">
								<%= messageType %>
							</h4>
						</div>
						<div class="modal-body">
								<%= messageContent %>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
						</div>
					</div>
				</div>
			</div>
		</div>	
		<script>
			$('#messageModal').modal("show");
		</script>
		<%
			session.removeAttribute("messageContent");
			session.removeAttribute("messageType");
			}
		%>
		<div class="modal fade" id="checkModal" tabindex="-1" role="dialog" aria-hidden="true">
			<div class="vertical-alignment-helper">
				<div class="modal-dialog vertical-align-center">
					<div id="checkType" class="modal-content panel-info">
						<div class="modal-header panel-heading">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times</span>
								<span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title">
								확인 메시지
							</h4>
						</div>
						<div id="checkMessage" class="modal-body">
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>