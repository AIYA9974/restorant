<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/review_page.css">



</head>
<body>

	
	<div class="wrap">
		<header>
			<div>
				<%@include file="/WEB-INF/views/header.jsp"%>
			</div>	
		</header>
	  
	  	<div class="review-write">
	  		<div class="page">리뷰를 작성해 주세요</div>
	  		<input type="text"  placeholder="한줄평">
	  		<label for="input-score">별점</label>
	  		<select class="form-select" id="input-score">
	              <option selected value="0">직접입력</option>
	              <option value="1">⭐</option>
	              <option value="2">⭐⭐</option>
	              <option value="3">⭐⭐⭐</option>
	              <option value="4">⭐⭐⭐⭐</option>
	              <option value="5">⭐⭐⭐⭐⭐</option>
	        </select>
	        <textarea rows="5" cols="100" placeholder="리뷰를 적어 주세요~~"></textarea>
		</div>
	

		<div class="reivew-read">
		
		<div class="page">작성된 리뷰 보기</div>
			
			<div class="review-wrap">
				<div class="flex">	
					<div>정말 맛있었어요</div>
					<div>⭐⭐⭐⭐⭐</div>
				</div>
				
				<div class="expain">
				맛집이라서 왔는데 생각보다 더 맛있었어요.
				매우 만족합니다
				</div>
			</div>
			
			<hr>
			
			<div class="review-wrap">
				<div class="flex">	
					<div>조금 아쉬웠어요</div>
					<div>⭐⭐⭐</div>
				</div>
				
				<div class="expain">
				실력은 좋으신데.. 제 취향과 조금 달랐어요.
				그점을 제외하고는 정말 좋은 맛집이었습니다
				</div>
			</div>
			
			<hr>
			
			<div class="review-wrap">
				<div class="flex">	
					<div>진짜 맛있었어요</div>
					<div>⭐⭐⭐⭐⭐</div>
				</div>
				
				<div class="expain">
					가성비가 좋고 맛도 좋았어요. 매우 추천합니다
				</div>
			</div>
	
		</div>
	
		
		<footer>
			<div id="fh5co-footer">
				<%@include file="/WEB-INF/views/footer.jsp"%>
			</div>
		</footer>
	</div>  	
</body>
</html>