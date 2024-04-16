<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/bootstrap.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/style.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/head.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/home/home_main.css">
</head>

<body>
	<div class="wrap">  


		<header>
			<div>
				<%@include file="/WEB-INF/views/header.jsp"%>
			</div>
		</header>
		<section>

			<a href="introduce">
				<div class="moto">
					<div>Moto</div>
				</div>
			</a> 
			<a href="restorant">
				<div class="seek">
					<div>seek rastorant</div>
				</div>

			</a>
		</section>

		<footer>
			<div id="fh5co-footer">
				<%@include file="/WEB-INF/views/footer.jsp"%>
			</div>
		</footer>
	</div>
</body>
</html>