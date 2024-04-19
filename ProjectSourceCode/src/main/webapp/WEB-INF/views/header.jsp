<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<a href="${getContext.request.contextPath}/mini/mypage">${sssMemberCode }</a>
			</div>
</c:if>
			
			<div class="title">Restorant</div>
