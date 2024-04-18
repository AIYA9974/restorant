<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <link rel ="stylesheet" href="<%=request.getContextPath() %>/resource/css/login/login.css">
</head>
<body>
	<section class="login-form">
		<h1>로그인</h1>

		<form>
			<div class="int-area">
				<input type="text" name="id" id="id" autocomplete="on" required>
				<label for="id">USER NAME</label>
			</div>
			<div class="int-area">
				<input type="password" name="pwd" id="pw" autocomplete="on" required>
				<label for="pw">PASSWORD</label>
			</div>
			<div class="btn-area">
				<input class="login_button" type="button" value="로그인">
			</div>
		</form>
		<div class="caption">
			<a href="membership">회원가입</a> <span>|</span> <a href="">아이디 찾기</a> <a
				href="">비밀번호 찾기</a>
		</div>

	</section>


	<script>
let id = $('#id');
let pw = $('#pw');
let btn = $('.btn');

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
});
$(loadedHandler);
function loadedHandler(){
	$(".btn-area .login_button").on("click",loginClickHandler);
}
		
function loginClickHandler(){
	console.log($("[name=id]").val());
	console.log($("[name=pwd]").val());
    $.ajax({
    	url : "${pageContext.request.contextPath}/loginfunction",
    	method : "post",
    	data : {id : $("[name=id]").val(), pwd : $("[name=pwd]").val() },
    	success : function(result){
    		console.log(result);
    		if(result != "null"){
    			alert("반갑습니다");
    			location.href="${pageContext.request.contextPath}/home";
	     	}else {
	     		alert ("아이디 또는 패스워드가 일치하지 않습니다. \n 다시 확인해 주세요");
	     		$("[name=pwd]").val("");
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