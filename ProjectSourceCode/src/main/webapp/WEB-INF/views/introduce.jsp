<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<head>
<title>introduce</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/bootstrap.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/style.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/introduce.css">

</head>
<body>
	<div class="wrap">

		<div class="logo"><a href="home">LOGO</a></div>

		<div class="home_login">
			<div>
				<a href="login" >LOGIN</a>
			</div>
		</div>
		<div class="introduce">
			음식 리뷰 사이트를 만들어 보았습니다. 모두 좋은정보 교류하여 행복한 맛집 탐방이 되셨음 합니다.
			<div>
				-사이트 제작자 일동-
			</div>
		</div>
	</div>


	<div id="fh5co-footer">
		<%@include file="/WEB-INF/views/footer.jsp"%>
	</div>

</body>
</html>