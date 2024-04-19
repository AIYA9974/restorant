<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<div>
			아이디 : <input type="text" class="id" readonly="readonly" value="${memId }">
		</div>
		
		<div>
			휴대폰 번호 : <input type="text" class="phone" readonly="readonly" value="${memPhone }">
		</div>
		
		<div>
			이메일 : <input type="text" class="email" readonly="readonly" value="${memEmail }">
		</div>
		<a href="${getContext.request.contextPath}/mini/mypageupdate">수정하기</a>
	</section>
	<section>
		<div>
			<form>
				<input type="button" class="owner-create-btn" value="오너계정 생성">
			</form>
		</div>
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
	$(OwnerCodeHandler);
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
function OwnerCodeHandler(){
	$(".owner-create-btn").on("click",ownerCreateHandler);
	
}
function ownerCreateHandler(){
	$.ajax({
		url : "${pageContext.request.contextPath}/ownercodecreatefunction"
		,method : "post"
		,data : {memCode : ${sssMemberCode }}
		,success : function(result){
			if(result == 1){
				alert("오너 계정이 생성되었습니다.");
			}else{
				alert("오너 계정이 오류로 인하여 생성이 취소 되었습니다.")
			}
		}
	})
}


</script>
</html>