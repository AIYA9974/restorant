<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restorant Seeker</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/bootstrap.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/style.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/restorant.css">
<style type="text/css">
	
</style>


</head>
<body>
	<div class="wrap">
		<header>
			<div>
			<%@include file="/WEB-INF/views/header.jsp"%>
			</div>	
		</header>
		
<!-- section 시작점 -->
		<section >
			<input type="radio" name="r1" id="kr" checked="checked">
			<input type="radio" name="r1" id="jp">
			<input type="radio" name="r1" id="cn">
			<input type="radio" name="r1" id="us">
			
			<label for="kr">한식</label>
			<label for="jp">일식</label>
			<label for="cn">중식</label>
			<label for="us">양식</label>
			
			<div class=flex>
				<div>
					<div>한식 1 그림</div>
					<div>한식 1 설명 <a href="reviewpage">리뷰</a></div>
				</div>
				<div>
					<div>한식 2 그림</div>
					<div>한식 2 설명<a href="reviewpage">리뷰</a></div>
				</div>
				<div>
					<div>한식 3 그림</div>
					<div>한식 3 설명<a href="reviewpage">리뷰</a></div>
				</div>				
			</div>
			
			
			<div class=flex>
				<div>
					<div>일식 1 그림</div>
					<div>일식 1 설명<a href="reviewpage">리뷰</a></div>
				</div>
				<div>
					<div>일식 2 그림</div>
					<div>일식 2 설명<a href="reviewpage">리뷰</a></div>
				</div>
				<div>
					<div>일식 3 그림</div>
					<div>일식 3 설명<a href="reviewpage">리뷰</a></div>
				</div>				
			</div>
			
			<div class=flex>
				<div>
					<div>중식 1 그림</div>
					<div>중식 1 설명<a href="reviewpage">리뷰</a></div>
				</div>
				<div>
					<div>중식 2 그림</div>
					<div>중식 2 설명<a href="reviewpage">리뷰</a></div>
					
				</div>
				<div>
					<div>중식 3 그림</div>
					<div>중식 3 설명<a href="reviewpage">리뷰</a></div>
				</div>				
			</div>
			
			<div class=flex>
				<div>
					<div>양식 1 그림</div>
					<div>양식 1 설명<a href="reviewpage">리뷰</a></div>
				</div>
				<div>
					<div>양식 1 그림</div>
					<div>양식 1 설명<a href="reviewpage">리뷰</a></div>
				</div>
				<div>
					<div>양식 1 그림</div>
					<div>양식 1 설명<a href="reviewpage">리뷰</a></div>
				</div>				
			</div>
		</section>
		
<!-- section 끝점 -->

		<footer>
			<div id="fh5co-footer">
				<%@include file="/WEB-INF/views/footer.jsp"%>
			</div>
		</footer>

	</div>



</body>
</html>