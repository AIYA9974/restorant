<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>

function memCheck(){
	//Login 페이지로 이동
	var memcheck = "${sssMemberCode }";  // EL 은 ""안에 작성되어 blank 상황에 문법적 오류 발생을 방지함.
	
	if ( !memcheck ) {
		var result = confirm("로그인이 필요한 페이지 입니다. \n 로그인 화면으로 이동합니다.");
		if( result ){
			location.href="${pageContext.request.contextPath}/login"
		}else {
		/* 	location.href="${pageContext.request.contextPath}/home" */
		}
		return true;
	}
	
	return false;
}
</script>