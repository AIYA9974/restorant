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
		
		<!-- 레스토랑 등록 페이지 -->
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
		              <option value="KO">한식</option>
		              <option value="CN">중식</option>
		              <option value="JP">일식</option>
		              <option value="US">양식</option>
		        </select>
	        </div>
	        <!-- /레스토랑 등록 페이지 -->
	        
	        <!-- 레스토랑 info 등록 페이지 -->
	        
	        
	        <div>
	        	혼밥석 유무 :
	        	Y : <input type="radio" name="place-alone" value="Y">
	        	N : <input type="radio" name="place-alone" value="N" checked="checked">
	        </div>
	        <div>
	        	단체석 유무 :
	        	Y : <input type="radio" name="place-group" value="Y">
	        	N : <input type="radio" name="place-group" value="N" checked="checked">
	        </div>
	        <div>
	        	좌식 테이블 :
	        	Y : <input type="radio" name="sit-floor" value="Y">
	        	N : <input type="radio" name="sit-floor" value="N" checked="checked">
	        </div>
	        <div>
	        	테이블 :
	        	Y : <input type="radio" name="sit-chair" value="Y">
	        	N : <input type="radio" name="sit-chair" value="N" checked="checked">
	        </div>
	        <div>
	        	스텐딩 테이블 :
	        	Y : <input type="radio" name="standing" value="Y">
	        	N : <input type="radio" name="standing" value="N" checked="checked">
	        </div>
	        
	        <!-- /레스토랑 info 등록 페이지 -->
	        
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
	
	
	
	
    
    function insertRestorantHandler(){
		$.ajax({
			url : "${pageContext.request.contextPath}/restorantuploadfunction"
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
					
					$(getResCodeHandler)
				
				}else{
					alert("오류로 인하여 레스토랑 등록을 실패하였습니다.")
				}
			}
		});
	}
	
   	
    function getResCodeHandler(){
    	$.ajax({
    		url : "${pageContext.request.contextPath}/restorantgetcodefunction"
    		,method : "post"
    		,data : {
    			resName : $("[name=restorant-name]").val()
    			,resPhone : $("[name=restorant-phone]").val()
    		}
    		,success : function(result){
    			console.log(result);
    			console.log("get rescode 성공 "+result);
    			insertRestorantInfoHandler(result);
    			createMenuHandler(result);
    		}
    	})
    }
   
    function insertRestorantInfoHandler(sssResCode){
    	console.log(sssResCode);
    	console.log($('[name=place-alone]:checked').val());
    	console.log($('[name=place-group]:checked').val());
    	console.log($('[name=sit-floor]:checked').val());
    	console.log($('[name=sit-chair]:checked').val());
    	console.log($('[name=standing]:checked').val());
    	
    	$.ajax({
    		url : "${pageContext.request.contextPath}/restorantcommoninfoinsertfunction"
    		,method : "post"
    		,data : {
    			resCode : sssResCode
    			,placeAlone : $('[name=place-alone]:checked').val()
    			,placeGroup : $('[name="place-group"]:checked').val()
    			,sitFloor :  $('[name="sit-floor"]:checked').val()
    			,sitChair : $('[name="sit-chair"]:checked').val()
    			,standing : $('[name="standing"]:checked').val()
    		}
    		,success : function(result){
    			console.log(result);
    			if(result == 1 ){
    				console.log("레스토랑 정보 삽입 성공하였습니다.");
    			}else{
    				console.log("레스토랑 정보 삽입 실패하였습니다.");
    			}
    		}
    	});
    }
    
    function createMenuHandler(sssResCode){
    	$.ajax({
    		url : "${pageContext.request.contextPath}/createmenufunction"
        		,method : "post"
        		,data : { resCode : sssResCode }
    	,success : function(result){
			console.log(result);
			if(result == 1 ){
				console.log("메뉴 생성 성공하였습니다.");
				location.href="${pageContext.request.contextPath}/createmenucontroller";
			}else{
				console.log("매뉴 생성 실패하였습니다.");
			}
		}
    			
    	})
    	
    }
    
</script>


</html>