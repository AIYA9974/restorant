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
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/head.css">
<style type="text/css">

</style>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>

</head>
<body>
	<div class="wrap">
		<header>
			<div>
			<%@include file="/WEB-INF/views/header.jsp"%>
			</div>	
		</header>
		
<!-- section 시작점 -->
		<section class="sc-kind-btn">
			<form>
				<input type="button" name="kr" class="kr"  value="KR">
				<input type="button" name="jp" class="jp"  value="JP">
				<input type="button" name="cn" class="cn" value="CN">
				<input type="button" name="us" class="us" value="US">
			</form>
	<!-- 	<label for="kr">한식</label>
			<label for="jp">일식</label>
			<label for="cn">중식</label>
			<label for="us">양식</label> -->
			
			<div class=flex>
				<div class="restorant-list">
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
	
	<script>
	$(loadedHandler)
	
	
	function loadedHandler(){
		
		$(".kr").on("click",function (){restorantKrListHandler()});
		$(".jp").on("click",function (){restorantJpListHandler()});
		$(".cn").on("click",function (){restorantCnListHandler()});
		$(".us").on("click",function (){restorantUsListHandler()});
	}	
	
	
	function restorantKrListHandler(){
		console.log($("[name=kr]").val());
		$.ajax({
			url : "${pageContext.request.contextPath}/restorantlistfunction"
			,method : "post"
			,data : {resKind : $("[name=kr]").val() }
			,dataType : "json"
			,success : function(result){
				if(result != null){
					console.log("리스트 불러오기 성공");
					console.log(result);
					ListDisplayWrap(result);
				}else{
					alert("레스토랑 리스트 불러오기 실패")
				}
				
			}
			,error : function(request, status, error){
				alert("code: "+request.status + "\n" + "message: " 
						+ request.responseText + "\n"
						+ "error: "+error);
			}
	});
	}
	
	function restorantJpListHandler(){
		console.log($("[name=jp]").val());
		$.ajax({
			url : "${pageContext.request.contextPath}/restorantlistfunction"
			,method : "post"
			,data : {resKind : $("[name=jp]").val() }
			,dataType : "json"
			,success : function(result){
				if(result != null){
					console.log("리스트 불러오기 성공");
					console.log(result);
					ListDisplayWrap(result);
				}else{
					alert("레스토랑 리스트 불러오기 실패")
				}
				
			}
			,error : function(request, status, error){
				alert("code: "+request.status + "\n" + "message: " 
						+ request.responseText + "\n"
						+ "error: "+error);
			}
	});
	}
	
	function restorantCnListHandler(){
		console.log($("[name=cn]").val());
		$.ajax({
			url : "${pageContext.request.contextPath}/restorantlistfunction"
			,method : "post"
			,data : {resKind : $("[name=cn]").val() }
			,dataType : "json"
			,success : function(result){
				if(result != null){
					console.log("리스트 불러오기 성공");
					console.log(result);
					ListDisplayWrap(result);
				}else{
					alert("레스토랑 리스트 불러오기 실패")
				}
				
			}
			,error : function(request, status, error){
				alert("code: "+request.status + "\n" + "message: " 
						+ request.responseText + "\n"
						+ "error: "+error);
			}
	});
	}
	
	function restorantUsListHandler(){
		console.log($("[name=us]").val());
		$.ajax({
			url : "${pageContext.request.contextPath}/restorantlistfunction"
			,method : "post"
			,data : {resKind : $("[name=us]").val() }
			,dataType : "json"
			,success : function(result){
				if(result != null){
					console.log("리스트 불러오기 성공");
					console.log(result);
					ListDisplayWrap(result);
				}else{
					alert("레스토랑 리스트 불러오기 실패")
				}
				
			}
			,error : function(request, status, error){
				alert("code: "+request.status + "\n" + "message: " 
						+ request.responseText + "\n"
						+ "error: "+error);
			}
	});
	}
	
	function ListDisplayWrap(datalist){
		console.log(datalist)
		var htmlVal = '';
		for(var idx in datalist){
			var reslistdto = datalist[idx];
			htmlVal += `
				<form class="reslist" action="${pageContext.request.contextPath}/restorantmaincontroller" method="post">
			
					<input type="hidden" name="resCode" value="\${reslistdto.resCode}">
					<input type="hidden" name="resName" value="\${reslistdto.resName}">
					<input type="hidden" name="resPhone" value="\${reslistdto.resPhone}">
					<input type="hidden" name="resLoc" value="\${reslistdto.resLoc}">
					<div class="reslist_grid">
					
					<div>한식 1 그림</div>
						<div class="flex">
								<div>\${reslistdto.resName}</div>
								<div>\${reslistdto.resPhone}</div>
								<div>\${reslistdto.resLoc}</div>
						</div>
					</div>
					
					<input type="submit" name="visit-restorant" value="방문하기">
				</form>
				
			`;
			$(".restorant-list").html(htmlVal)
			
			}
	}
	</script>


</body>
</html>