<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
     <link rel ="stylesheet" href="<%=request.getContextPath() %>/resource/css/membership/membership.css">
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
	    <section class="membership-form">
        <h1>회원가입</h1>
        <form action="">
            <div class="int-area">
                <input type="text" name="id" id="id" autocomplete="off" required>
                <label for="id">USER NAME</label>
            </div>
            <div>
                <div id="msg-memberId"></div>
            </div>
            
            <div class="int-area">
                <input type="password" name="pw"  id="pw" autocomplete="off" required>
                <label for="pw">PASSWORD</label>
            </div>
            <div>
                <div id="msg-memberpassword"></div>
            </div>
            <div class="int-area">
                <input type="password" name="pwch" class="pwch" id="pwch" autocomplete="off" required>
                <label for="pw">PASSWORD CHECK</label>
            </div>
            <div>
                <div id="msg-memberpasswordCheck"></div>
            </div>
            <div class="int-area">
                <input type="text" name="email" id="email" autocomplete="off" required>
                <label for="email">Email</label>
            </div>
            <div>
                <div id="msg-memberemail"></div>
            </div>
            <div class="int-area">
                <input type="text" name="phone" id="phone" autocomplete="off" required>
                <label for="phone">phone</label>
            </div>
            <div>
                <div id="msg-memberphone"></div>
            </div>
            <div class="btn-area">
                <input class="membership-btn" id="membership-btn" type="button" value="회원가입">
            </div>
        </form>
        <div class="caption">
            <a href="login">로그인 하러가기</a>
        </div>
    </section>

    <script>
    
      /*   let id = $('#id');
        let pw = $('#pw');
        let pwch = $('#pwch');
        let email = $('#email');
        let phone = $('#phone');
        let btn = $('#btn');

        $(btn).on('click', function() {
            if($(id).val() == "") {
                $(id).next('label').addClass('warning');
                setTimeout(function() {
                    $('label').removeClass('warning');
                },1500);
            }
            else if($(pw).val() == "") {
                $(pw).next('label').addClass('warning');
                setTimeout(function() {
                    $('label').removeClass('warning');
                },1500);
            }
            else if($(pwch).val() == "") {
                $(pwch).next('label').addClass('warning');
                setTimeout(function() {
                    $('label').removeClass('warning');
                },1500);
            }
            else if($(email).val() == "") {
                $(email).next('label').addClass('warning');
                setTimeout(function() {
                    $('label').removeClass('warning');
                },1500);
            }
            else if($(phone).val() == "") {
                $(phone).next('label').addClass('warning');
                setTimeout(function() {
                    $('label').removeClass('warning');
                },1500);
            }
        });
        
        //모든 공백 체크 정규식
    	var empJ = /\s/g;
    	//아이디 정규식
    	var idJ = /^[a-z0-9_-]{4,12}$/;
    	// 비밀번호 정규식
    	var pwJ = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()])[A-Za-z0-9!@#$%^&*()]{8,12}$/; 
    	// 이메일 검사 정규식
    	var mailJ = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    	// 휴대폰 번호 정규식
    	var phoneJ = /^[01]{1,3}-[0-9]{4}-[0-9]{4}$/;
        
    	$("#id").blur(function() {
    		if (idJ.test($(this).val())) {
    				console.log(idJ.test($(this).val()));
    				$("#msg-memberId").text('');
    		} else {
    			$('#msg-memberId').text('4~12자 특수문자는 _- 만 허용해요.');
    			$('#msg-memberId').css('color', 'red');
    		}
    	});
    	$("#pw").blur(function() {
    		if (pwJ.test($(this).val())) {
    				console.log(pwJ.test($(this).val()));
    				$("#msg-memberpassword").text('');
    		} else {
    			$('#msg-memberpassword').text('특수문자 포함 8~12자로 써주세요');
    			$('#msg-memberpassword').css('color', 'red');
    		}
    	});
    	$("#email").blur(function() {
    		if (mailJ.test($(this).val())) {
    				console.log(mailJ.test($(this).val()));
    				$("#msg-memberemail").text('');
    		} else {
    			$('#msg-memberemail').text('이메일형식으로 작성해주세요');
    			$('#msg-memberemail').css('color', 'red');
    		}
    	});
    	$("#phone").blur(function() {
    		if (phoneJ.test($(this).val())) {
    				console.log(phoneJ.test($(this).val()));
    				$("#msg-memberphone").text('');
    		} else {
    			$('#msg-memberphone').text('-제외하고 휴대폰번호를 써주세요');
    			$('#msg-memberphone').css('color', 'red');
    		}
    	});
	    	$("#pwch").blur(function() {
	    		var pw1 = $("#pw").val();
				var pw2 = $("#pwch").val();
	    			if(pw1 == pw2) {
	    				$('#msg-memberpasswordCheck').text("비밀번호가 일치합니다")
	    				$('#msg-memberpasswordCheck').css('color', 'green');
	    			} else {
	    				$('#msg-memberpasswordCheck').text("비밀번호가 일치하지않습니다.비밀번호를 재확인해주세요")
	    				$('#msg-memberpasswordCheck').css('color', 'red');
	    			}
	    		
	    	});	 */
    	
		$(loadedHandler)
		
		function loadedHandler(){
			$(".membership-btn").on("click", createAccountHandler);
		}
		
		function createAccountHandler(){
			console.log($("[name=id]").val());
			console.log($("[name=pw]").val());
			console.log($("[name=phone]").val());
			console.log($("[name=email]").val());
		    $.ajax({
		    	url : "${pageContext.request.contextPath }/createaccountfunction",
		    	method : "post",
		    	data : {id : $("[name=id]").val(), pwd : $("[name=pw]").val() , phone : $("[name=phone]").val(), email : $("[name=email]").val() },
		    	success : function(result){
		    		console.log(result);
		    		if(result == 1){
		    			alert("회원가입 되셨습니다");
		    			location.href="${pageContext.request.contextPath }/login";
			     	}else {
			     		alert ("회원가입에 실패하셨습니다");
			     		$("[name=id]").val("");
			     		$("[name=pw]").val("");
			     		$("[name=phone]").val("");
			     		$("[name=email]").val("");
			     	}
		    	}
		     	,error : function(request, status, error){
					alert("code: "+request.status + "\n" + "message: " 
							+ request.responseText + "\n"
							+ "error: "+error);
				}
		    })
		}
		
		
		
        
        
    </script>
</body>
</html>