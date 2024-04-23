<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>	
</head>
<body>
	<div class="wrap">
		<header>
			<%@include file="/WEB-INF/views/header.jsp"%>
		</header>
	</div>
	<section>
		<form>
			<div>
				<input type="text" name="restorant-name" placeholder="가게 이름">
			</div>
			<div>
				<input type="text" name="restorant-phone" placeholder="가게 전화번호">
			</div>
			<div>
				<input type="text" name="restorant-sub-phone" placeholder="가게 보조 전화번호">
			</div>
			<div>
				<input type="text" name="restorant-email" placeholder="가게 이메일">
			</div>
			<div>
				<input type="text" name="restorant-location" placeholder="가게 위치">
			</div>
			<div>
				<input type="text" name="restorant-msg" placeholder="손님께 드릴 말씀">
			</div>
			<div>
				<select name="restorant-kind" id="input-score">
		              <option selected value="0">직접입력</option>
		              <option value="ko">한식</option>
		              <option value="cn">중식</option>
		              <option value="jp">일식</option>
		              <option value="en">양식</option>
		        </select>
	        </div>
			<div>
				<input type="button" class="submit-restorant-info" value="등록하기">
			</div>
		</form>
	</section>
	
	<footer>
	
	</footer>

</body>

<script type="text/javascript">
	$(loadedHandler);
	
	function loadedHandler(){
		$(RestorantHandler);
		
	}
	
	function RestorantHandler(){
		$(".submit-restorant-info").on("click",insertRestorantHandler)
	}
	
	
	
/* 	INSERT INTO RESTORANT (,RESTORANT_NAME,RESTORANT_PHONE,RESTORANT_SUB_PHONE,RESTORANT_EMAIL,RESTORANT_LOCAL,RESTORANT_MESSAGE,RESTORANT_AREA) 
    VALUES (20240414,20240411,'ASDF',0103145,013465,'ASDF@SADF','ASDF','ASDF','AS'); */
	
    
    function insertRestorantHandler(){
		$.ajax({
			url : "${pageContext.request.contextPath}/uploadrestorantfunction"
			,method : "post"
			,data : {OwnerCode : ${sssOwnerCode }, 
					resName : $("[name=restorant-name]").val() ,
					resPhone : $("[name=restorant-phone]").val(), 
					resSubPhone : $("[name=restorant-sub-phone]").val() , 
					resEmail : $("[name=restorant-email]").val() , 
					resLoc : $("[name=restorant-location]").val() , 
					resMsg : $("[name=restorant-msg]").val() , 
					resKind : $("[name=restorant-kind]").val() }
			,success : function(result){
				if(result == 1){
					console.log("오너 계정 생성 성공");
					alert("레스토랑이 등록 되었습니다.");
					location.href="${pageContext.request.contextPath }/mypage";
				}else{
					alert("오류로 인하여 레스토랑 등록을 실패하였습니다.")
				}
			}
		})
	}
	
</script>


</html>