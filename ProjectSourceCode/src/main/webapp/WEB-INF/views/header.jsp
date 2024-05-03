<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


		<div class="logo">
				<a href="home">LOGO</a>
			</div>
<c:if test="${empty sssMemberCode }">
			<div class="login">
				<a href="${getContext.request.contextPath}/mini/login">LOGIN</a>
			</div>
</c:if>
<c:if test="${not empty sssMemberCode }">
			<div class="login">
				<a href="${getContext.request.contextPath}/mini/mypage">마이페이지</a>
				<form> <input type="button" class="logout-btn" value="로그아웃"></form>
			</div>
</c:if>
			
			<div class="title">Restorant</div>

			
<script>
$(loadedHandler);
function loadedHandler(){
$(".logout-btn").on("click",function (){menuListInserthandler()});
}

function menuListInserthandler(){
	$.ajax({
		url:"${pageContext.request.contextPath}/logoutfunction",
		type : "POST",
		success: function(result){
				alert("로그아웃 되었습니다");
				location.href="${pageContext.request.contextPath}/home"
		}
     });
}
	

</script>