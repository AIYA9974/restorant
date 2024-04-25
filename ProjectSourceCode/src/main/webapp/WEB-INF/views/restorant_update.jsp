<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/head.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/style.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/bootstrap.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<div class="wrap">
		<header>
			<div>
				<%@include file="/WEB-INF/views/header.jsp"%>
			</div>
		</header>
	${resGetInfo.resName };
	asdfsadf
		<section>
			<form>
			<div>
				<input type="text" name="restorant-name" placeholder="가게 이름" value="${resName}">
			</div>
			<div>
				<input type="text" name="restorant-phone" placeholder="가게 전화번호" value="${resPhone }">
			</div>
			<div>
				<input type="text" name="restorant-sub-phone" placeholder="가게 보조 전화번호" value="${resSubPhone }">
			</div>
			<div>
				<input type="text" name="restorant-email" placeholder="가게 이메일" value="${resEmail }">
			</div>
			<div>
				<input type="text" name="restorant-location" placeholder="가게 위치" value="${resLocal }">
			</div>
			<div>
				<input type="text" name="restorant-msg" placeholder="손님께 드릴 말씀" value="${resMsg }">
			</div>
			<div>
				<input type="button" class="submit-restorant-info" value="수정하기">
			</div>
		</form>
		</section>
		
		<footer>
			<div id="fh5co-footer">
				<%@include file="/WEB-INF/views/footer.jsp"%>
			</div>
		</footer>
	</div>
	
<script>
$(loadedHandler);
console.log();
function loadedHandler(){
	$(getInfoHandler);
}

function getInfoHandler(){
	$.ajax({
		url :"${pageContext.request.contextPath}/restorantupdategetinfofunction"
		,method : "post"
		,data : {resCode : ${sssResCode}}
		,success : function(result){
			console.log(${sssResCode});
			console.log(result);
			if(result != null){
				console.log("레스토랑 정보 불러오기 성공");
				getInfoWrap(result);
			}else{
				console.log("레스토랑 정보 불러오기 실패");
			}
			
		}
		
	})
}

function getInfoWrap(result){
	var info = result;
	console.log(${info.resName});
	input
}
</script>
	
</body>
</html>