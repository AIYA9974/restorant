<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/menu.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/bootstrap.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/style.css">
<jsp:include page="/WEB-INF/views/function/function.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>

<title>Insert title here</title>
</head>
<body>
	<div class="wrap">
		<section>
			<input type="button" class="add-btn" value="추가하기">
			<input type="button" class="remove-btn" value="삭제하기">
			<form>
				<div class="menu-add">
					<div class="flex">
						<div><input type="text" name="menu-num" value="1" readonly="readonly"> </div>
						<div><input type="text" name="menu-name" placeholder="메뉴 이름"> </div>
						<div><input type="textarea" name="menu-info" placeholder="메뉴 설명"> </div>
						<div><input type="file" name="menu-picture" placeholder="메뉴 사진"> </div>
					</div>
				</div>
				<input type="button" class="menu-submit" value="등록" >
			</form>
		</section>
	
	</div>
	
	<script type="text/javascript">
		$(loadedHandler);
		
		function loadedHandler(){
			menuHandler();
			$(".menu-submit").on("click" , function(){menuListInserthandler()});
			
		}	
		
		function menuHandler(){
			addMenuHandler();
			
		}
		
		function addMenuHandler(){
			var i = 1;
			$(".add-btn").on("click", function(){ i++; menuEndHandler(i);})
			$(".remove-btn").on("click", function(){ i--; menuEndHandler(i);})
			
		}
		
		
		function menuEndHandler(i){
			var htmlVal ='';
			console.log(i);
			
			for(var h=0; h<i; h++){
				htmlVal +=`
					<div class="flex">
						<div><input type="text" name="menu-num" value="\${h+1}" readonly="readonly"> </div>
						<div><input type="text" name="menu-name" placeholder="메뉴 이름"> </div>
						<div><input type="textarea" name="menu-info" placeholder="메뉴 설명"> </div>
						<div><input type="file" name="menu-picture" placeholder="메뉴 사진"> </div>
					</div>
				`;
			
			}	
			$(".menu-add").html(htmlVal);
		}
		
		function menuListInserthandler(){
			var menuList = [];
			for(var i=0; i< $("[name=menu-num]").length; i++){
				var menuObj = new Object();
				menuObj.menuNum = $("[name=menu-num]").eq(i).val();
				menuObj.menuName = $("[name=menu-name]").eq(i).val();
				menuObj.menuInfo = $("[name=menu-info]").eq(i).val();
				menuList.push(menuObj);
			}
			console.log(menuList)
			$.ajax({
				url:"${pageContext.request.contextPath}/menuuploadfunction",
				type : "POST",
				data: JSON.stringify(menuList),
				contentType: "application/json; charset=utf-8",
				success: function(result){
					if(result >0 ){
						alert("sdkskdkfjlsdjflsdf");
						location.href="${pageContext.request.contextPath}/mypage";
					}else {
						alert("sdkskdkfjlsdjflsdf");
					}
				}
		       });

			
			console.log(menuList);
		}
		
		function menuUploadHandler(){
			
		/* 	console.log("버튼누름 작동함")
			$.ajax({
				url : "${pageContext.request.contextPath}/menuuploadfunction"
				,method : "post"
				,data : {
					menuNum : $("[name=menu-num]").val()
					,menuName : $("[name=menu-name]").val()
					,menuInfo : $("[name=menu-info]").val()
					
					
				}
				,success : function(result){
					console.log(result);
				}
				,error : function(request, status, error){
					alert("code: "+request.status + "\n" + "message: " 
							+ request.responseText + "\n"
							+ "error: "+error);
				}
			}) */
		}
		
	</script>
</body>
</html>