<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/bootstrap.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/style.css">
<link rel="stylesheet" 
	href="<%=request.getContextPath()%>/resource/css/head.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>	
<jsp:include page="/WEB-INF/views/function/function.jsp"/>


<title>Insert title here</title>
</head>
<body>
	<header>
		<div>
			<%@include file="/WEB-INF/views/header.jsp"%>
		</div>
	</header>
	<section>
	<form>
			<div>
				비밀번호 변경 : <input type="password" name="password"  value="${memPassword }">
			</div>
			<div>
				비밀번호 재확인 : <input type="password" class="password-check"  value="${memPassword }">
			</div>
			
			<div>
				휴대폰 변경 : <input type="text" name="phone"  value="${memPhone }">
			</div>
			
			<div>
				이메일 변경: <input type="text" name="email"  value="${memEmail }">
			</div>
			
			<div>
				<input type="button" class="update-btn" value="수정하기">
			</div>
		</form>
	</section>
	<section>
	
	</section>
	<section>
	
	</section>
	
	<footer>
		<div id="fh5co-footer">
			<%@include file="/WEB-INF/views/footer.jsp"%>
		</div>
	</footer>
</body>

<script>
$(loadedHandler);
function loadedHandler(){
	$(loginCheckHandler);
	$(mypageHandler);
	$(updateClickHandler)
}

function loginCheckHandler(){
	if(memCheck()) {return;}	
}

function mypageHandler(){
	$.ajax({
		url : "${pageContext.request.contextPath}/mypagefunction"
		,method : "post"
		,data : {memCode : ${sssMemberCode }}
		,success : function(){
			
		}
	})
}
function updateClickHandler(){
	$(".update-btn").on("click", mypageUpdateHandler);
	
}

function mypageUpdateHandler() {
	console.log(${sssMemberCode } );
	console.log($("[name=password]").val());
	console.log($("[name=phone]").val());
	console.log($("[name=email]").val());
    $.ajax({
    	url : "${pageContext.request.contextPath }/mypageupdatefunction",
    	method : "post",
    	data : { memCode : ${sssMemberCode } 
	    	, password : $("[name=password]").val() 
	    	, phone : $("[name=phone]").val()
	    	, email : $("[name=email]").val() },
    	success : function(result){
    		console.log(result);
    		if(result == 1){
    			alert("수정 되었습니다");
    			location.href="${pageContext.request.contextPath }/mypage";
	     	}else {
	     		alert ("수정 실패하셨습니다");
	     	
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
</html>