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
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script type="text/javascript">
		
		/* function registerCheckFunction() {
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
		} */
		
		function addr() {
			daum.postcode.load(function() {
				new daum.Postcode({
					oncomplete:function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

		                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
		                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
		                var addr = ''; // 주소 변수
		                var extraAddr = ''; // 참고항목 변수

		                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
		                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
		                    addr = data.roadAddress;
		                } else { // 사용자가 지번 주소를 선택했을 경우(J)
		                    addr = data.jibunAddress;
		                }

		                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
		                if(data.userSelectedType === 'R'){
		                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
		                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
		                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
		                        extraAddr += data.bname;
		                    }
		                    // 건물명이 있고, 공동주택일 경우 추가한다.
		                    if(data.buildingName !== '' && data.apartment === 'Y'){
		                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
		                    }
		                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
		                    if(extraAddr !== ''){
		                        extraAddr = ' (' + extraAddr + ')';
		                    }
		                    // 조합된 참고항목을 해당 필드에 넣는다.
		                    /* document.getElementById("sample6_extraAddress").value = extraAddr; */
		                
		                } else {
		                   /*  document.getElementById("sample6_extraAddress").value = ''; */
		                }

		                // 우편번호와 주소 정보를 해당 필드에 넣는다.
		                /* document.getElementById('sample6_postcode').value = data.zonecode; */
		                document.getElementById("addr1").value = addr;
		                // 커서를 상세주소 필드로 이동한다.
		                document.getElementById("addr2").focus();
					}
				}).open();
			});	
		}
		
		$(document).ready(function() {
			$(".email li").click(function() {
				$("#userEmail2").val($(this).text());
			});
			
			$(".hp li").click(function() {				
				var hp = $(".hp1").text($(this).text())
				$("#hp1").val($(".hp1").text());
			})

			
			/** 휴대폰 인증 문자 보내기 **/
		    $("#send").click(function() {       
		       var number = Math.floor(Math.random() * 100000) + 100000;
		          if(number>100000){ number = number - 10000; }
		          $("#text").val(number);      /* 난수로 생성된 인증번호를 hidden name : text 에 숨긴다 */  
		          var hp = $("#hp1").val()+$("#hp2").val()+$("#hp3").val();
		          alert(hp);
		 
		      /*     
		       var to = $("#to").val();
		       var name = $("#name").val();
		       var first = $("#first").val();
		       var last = $("#last").val();
		       var id = $("#id").val();   	 */	      
		    
/* 			 if ( name == "" || name == null ) {
		    	  alert("이름을 입력해주세요");
		    	  $("#name").focus();
		      } else if ( first == "" || first == null ) {
		    	  alert("주민등록번호를 입력해주세요");
		    	  $("#first").focus();
		      } else if ( last == "" || last == null ) {
		    	  alert("주민등록번호를 입력해주세요");
		    	  $("#last").focus();    	  
		      } else if ( id == "" || id == null ) {
		 	      alert("아이디를 입력해주세요");
		 	      $("#id").focus();
			  } else if ( to == "" || to == null ) {
		    	  alert("휴대폰 번호를 입력해주세요");
		    	  $("#to").focus();    	 
		      } else { */
		      		var con_test = confirm("해당번호로 인증문자를 발송하시겠습니까?");   /* 문자를 보낼껀지 물어본다 */          
		          	if(con_test == true){   
		               $.ajax({
		                   url:"sendSms.do",
		                   type:"post",
		                   data: {
		                	 	to: hp,
		                        text: $("#text").val()
		                   }, 
		                 success:function(){
		                   alert("해당 휴대폰으로 인증번호를 발송했습니다");
		                   $("#userNum").focus();
		                   },
		                   error(){
		                      
		                   }
		                   
		                });  
		          } else if(con_test == false) {
			        	/*   $("#to").val("");
			              $("#name").val("");
			              $("#first").val("");
			              $("#last").val("");
			              $(".id").val(""); */
		             }
/* 		         }  */  
		    })
		    $("#enterBtn").click(function() {   /* 내가 작성한 번호와 인증번호를 비교한다 */
		       var userNum = $("#userNum").val();       
		       var sysNum = $("#text").val();         
		       
		       if(userNum == null || userNum == ""){ 
		    	   alert("휴대폰으로 발송된 인증번호를 입력해주세요");
		    	   $("#userNum").focus();
		    	} else{     
		          if(userNum.trim() == sysNum.trim()){
		              alert("인증번호가 일치합니다");
		              $("#addr1").foucs();
		           }
		           else {
		              alert("인증번호가 일치하지 않습니다");
		              $("#userNum").val("").focus();
		           }          
		       }
		    });

		});
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
	<div style="text-align:center; width:1200px; height: 50px; margin:75px auto; margin-bottom:70px;" >
		<h3 style="width: 100px;">회원가입</h3>
		</div>
		<div class="container" style="margin-bottom:100px;">
			<form autocomplete="off" name="member_join" method="post" action="join_proc.do">
				<table class="table table-bordered table-hover" style="text-align: center; border: 1px solid #dddddd">
					<tbody>	
						<tr>
							<td style="width: 110px;"><h5>아이디</h5></td>
							<td><input class="form-control" type="text" id="userID" name="id" maxlength="20" placeholder="아이디를 입력하세요."></td>
							<td style="width: 110px;"><button class="btn btn-primary" onclick="registerCheckFunction();" type="button" style="background-color:#4fa9de; border-color:#4fa9de;">중복체크</button></td>
						</tr>
						<tr>
							<td style="width: 110px;"><h5>비밀번호</h5></td>
							<td colspan="2"><input onkeyup="passwordCheckFunction();" class="form-control" id="userPassword1" type="password" name="pass" maxlength="20" placeholder="비밀번호를 입력하세요."></td>
						</tr>
						<tr>
							<td style="width: 110px;"><h5>비밀번호 확인</h5></td>
							<td colspan="2"><input onkeyup="passwordCheckFunction();" class="form-control" id="userPassword2" type="password" name="cpass" maxlength="20" placeholder="비밀번호 확인를 입력하세요."></td>
						</tr>
						<tr>
							<td style="width: 110px;"><h5>이름</h5></td>
							<td colspan="2"><input class="form-control" id="userName" type="text"  name="name" maxlength="20" placeholder="이름를 입력하세요."></td>
						</tr>
						<tr>
							<td style="width: 110px;"><h5>생년월일</h5></td>
							<td colspan="2"><input class="form-control" id="userbirth" type="text"  name="birth" maxlength="20" placeholder="생년월일 6자리를 입력하세요."></td>
						</tr>					
						<tr>
							<td style="width: 110px;"><h5>이메일</h5></td>
							<td colspan="2">
							<input class="form-control pull-left" id="userEmail1" type="text" name="email1" maxlength="20" placeholder="이메일을 입력하세요." style="width:42%;">
							<span class="pull-left" style="background-color: rgba(0,0,0,0); font-color:black; font-size: 17px; margin: 4px 10px;">@</span>
							<input class="form-control pull-left" id="userEmail2" type="text" name="email2" maxlength="20" placeholder="이메일주소을 입력하세요." style="width:42%;">
							<div class="dropdown pull-left" style="width:10%; margin-left:10px;">
							  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" style="width:100%;">
							    <span id="choosevalue">선택</span>
							    <span class="caret"></span>
							  </button>
							  <ul class="dropdown-menu email" aria-labelledby="dropdownMenu1">
							    <li><a>naver.com</a></li>
							    <li><a>gmail.com</a></li>
							    <li><a>daum.net</a></li>
							    <li role="separator" class="divider"></li>
							    <li><a>직접입력</a></li>
							  </ul>
							</div>
							</td>
						</tr>
						<tr>
							<td style="width: 110px;"><h5>휴대폰번호</h5></td>
							<td>
							<div class="dropdown pull-left" style="width:10%;">
							  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" style="width:100%;">							    
							    <span id="choosevalue" class="hp1">선택</span>
							    <span class="caret"></span>
							  </button>
							  <ul class="dropdown-menu hp" aria-labelledby="dropdownMenu1">
							    <li><a>010</a></li>
							    <li><a>011</a></li>
							    <li><a>017</a></li>
							  </ul>
							</div>
							<input name="hp1" id="hp1" type="hidden">
							<span class="pull-left" style="background-color: rgba(0,0,0,0); font-color:black; font-size: 20px; margin: 0 10px;">-</span>
							<input class="form-control pull-left" id="hp2" type="text" name="hp2" maxlength="20" placeholder="핸드폰번호를 입력하세요." style="width:41.85%;">
							<span class="pull-left" style="background-color: rgba(0,0,0,0); font-color:black; font-size: 20px; margin: 0 10px;">-</span>
							<input class="form-control pull-left" id="hp3" type="text" name="hp3" maxlength="20" placeholder="핸드폰번호를 입력하세요." style="width:41.85%;">
							<td style="width: 110px;"><button class="btn btn-primary" type="button" style="background-color:#4fa9de; border-color:#4fa9de;" id="send">전송</button></td>
						</tr>
						<tr>
							<td style="width: 110px;"><h5>인증번호</h5></td>
							<td><input class="form-control pull-left" placeholder="인증번호 6자리를 입력하세요." id="userNum" ></td>
							<td style="width: 110px;"><button class="btn btn-primary" type="button" style="background-color:#4fa9de; border-color:#4fa9de;" id="enterBtn">확인</button>
							<input type="hidden" name="text" id="text"></td>
						</tr>
						<tr>
							<td style="width: 110px;"><h5>주소</h5></td>
							<td>
							<input class="form-control pull-left" id="addr1" type="text" name="addr1" maxlength="20" placeholder="주소를 입력하세요." style="width:100%; margin-bottom:5px;">
							<input class="form-control pull-left" id="addr2" type="text" name="addr2" maxlength="20" placeholder="상세주소를 입력하세요." style="width:100%;">
							</td>							
							<td style="width: 110px;"><button class="btn btn-primary" onclick="addr()" type="button" style="margin:17px 0;background-color:#4fa9de; border-color:#4fa9de;">주소검색</button></td>
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