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
<% String resinfo = request.getParameter("getinfo"); %>
	<div class="wrap">
		<header>
			<div>
				<%@include file="/WEB-INF/views/header.jsp"%>
			</div>
		</header>
	${test };
		<section>
			<div class="info-value">
			</div>
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
		url :"${pageContext.request.contextPath}/restorantgetinfofunction"
		,method : "post"
		,data : {resCode : ${sssResCode}}
		,dataType : "json"
		,success : function(result){
			console.log(result);
			if(result != null){
				console.log("레스토랑 정보 불러오기 성공");
				displayWrapRest(result);
			}else{
				console.log("레스토랑 정보 불러오기 실패");
			}
		}
		,error : function(request, status, error){
			alert("code: "+request.status + "\n" + "message: " 
					+ request.responseText + "\n"
					+ "error: "+error);
		}
	});
}

function displayWrapRest(result){
	console.log(result);
	htmlVal = '';
	htmlVal += `
		<form>
		<div class="inputInfo">
			가게이름 : <input type="text" name="restorant-name" placeholder="가게 이름" value="\${result.resName}">
		</div>
		<div>
			가게 전화번호 : <input type="text" name="restorant-phone" placeholder="가게 전화번호" value="\${result.resPhone }">
		</div>
		<div>
			가게 보조 전화번호 : <input type="text" name="restorant-sub-phone" placeholder="가게 보조 전화번호" value="\${result.resSubPhone }">
		</div>
		<div>
			가게 이메일 : <input type="text" name="restorant-email" placeholder="가게 이메일" value="\${result.resEmail }">
		</div>
		<div>
			가게 위치 : <input type="text" name="restorant-location" placeholder="가게 위치" value="\${result.resLocal }">
		</div>
		<div>
			손님께 메세지 : <input type="text" name="restorant-msg" placeholder="손님께 드릴 말씀" value="\${result.resMsg }">
		</div>
		<div>
			<input type="button" class="submit_restorant_info" value="수정하기">
		</div>
	</form>
	`;
	
	$(".info-value").html(htmlVal);
	
	$(updateHandler);
}

function updateHandler(){
	$(".submit_restorant_info").on("click", updateResInfoHandler);
}

function updateResInfoHandler(){
	$.ajax({
		url :"${pageContext.request.contextPath}/restorantupdatefunction"
		,method : "post"
		,data : {
			resCode : ${sssResCode},
			resName : $("[name=restorant-name]").val() ,
			resPhone : $("[name=restorant-phone]").val(), 
			resSubPhone : $("[name=restorant-sub-phone]").val() , 
			resEmail : $("[name=restorant-email]").val() , 
			resLoc : $("[name=restorant-location]").val() , 
			resMsg : $("[name=restorant-msg]").val() , 
		}
		,success : function(result){
			console.log("result : "+result);
			if(result == 1){
				alert("수정되었습니다");
				location.href="${pageContext.request.contextPath }/mypage";
			}else{
				alert("수정실패 하였습니다");
			}
		}
		,error : function(request, status, error){
			alert("code: "+request.status + "\n" + "message: " 
					+ request.responseText + "\n"
					+ "error: "+error);
		}
	});
}

</script>
	
</body>
</html>