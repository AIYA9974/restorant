<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/mypage.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/bootstrap.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/style.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/head.css">
<jsp:include page="/WEB-INF/views/function/function.jsp" />

<script src="https://code.jquery.com/jquery-3.7.1.js"></script>


<title>Insert title here</title>
</head>
<body>
	<div class="wrap">
		<header>
			<div>
				<%@include file="/WEB-INF/views/header.jsp"%>
			</div>
		</header>
		<section class="sc-member-info">
			<div >
				<div>아이디 : </div>
				<div><input type="text" class="id" readonly="readonly" value="${memId }"></div>
			</div>
	
			<div > 
				<div>휴대폰 번호 :</div> 
				<div><input type="text" class="phone" readonly="readonly" value="${memPhone }"></div>
			</div>
	
			<div >
				<div>이메일 : </div>
				<div><input type="text" class="email" readonly="readonly" value="${memEmail }"></div>
			</div>
			
			<div class="mypage-update">
				<a href="${pageContext.request.contextPath}/mypageupdate">수정하기</a>
			</div>
		</section>
		<section class="owner-session">
			<div>
				<c:if test="${empty sssOwnerCode }">
					<form>
						<input type="button" class="owner-create-btn" value="오너계정 생성">
					</form>
				</c:if>
	
				<c:if test="${not empty sssOwnerCode }">
					<form>
						<input type="button" class="owner-delete-btn" value="오너계정 삭제">
					</form>
					
					<div class="restorant-upload-a">
						<a href="${pageContext.request.contextPath}/restorantupload">레스토랑 등록</a>
					</div>
					
					<div class="cut">--------------------  등록된 레스토랑  --------------------</div>
					<div class="restorant-list">
						
					</div>
				</c:if>
			</div>
		
					
		</section>
	</div>
	<footer>
		<div id="fh5co-footer">
			<%@include file="/WEB-INF/views/footer.jsp"%>
		</div>
	</footer>
</body>

<script>
console.log(${resName});

$(loadedHandler);
function loadedHandler(){
	$(loginCheckHandler);
	$(mypageHandler);
	$(ownerCodeHandler);
	$(restorantHandler);
}

function loginCheckHandler(){
	if(memCheck()) {return;}	
}

function mypageHandler(){
	$.ajax({
		url : "${pageContext.request.contextPath}/mypagefunction"
		,method : "post"
		,data : {memCode : ${sssMemberCode }}
		,success : function(){
			console.log("멤버 체크 성공");
			
		}
	})
}

function ownerCodeHandler(){
	$(ownerCheckHandler);	
	$(".owner-create-btn").on("click",ownerCreateHandler);
	$(".owner-delete-btn").on("click",ownerDeleteHandler);
}

function ownerCheckHandler(){
	$.ajax({
		url : "${pageContext.request.contextPath}/ownercheckfunction"
		,method : "post"
		,data : {memCode : ${sssMemberCode }}
		,success : function(){
			console.log("오너 체크 성공");
		}
		,error : function(request, status, error){
			alert("code: "+request.status + "\n" + "message: " 
					+ request.responseText + "\n"
					+ "error: "+error);
		}
	})
}

function ownerCreateHandler(){
	$.ajax({
		url : "${pageContext.request.contextPath}/ownercodecreatefunction"
		,method : "post"
		,data : {memCode : ${sssMemberCode }}
		,success : function(result){
			if(result == 1){
				console.log("오너 계정 생성 성공");
				alert("오너 계정이 생성되었습니다.");
				location.href="${pageContext.request.contextPath }/mypage";
			}else{
				alert("오너 계정이 오류로 인하여 생성이 취소 되었습니다.")
			}
			
		}
		,error : function(request, status, error){
			alert("code: "+request.status + "\n" + "message: " 
					+ request.responseText + "\n"
					+ "error: "+error);
		}
	});
}

function ownerDeleteHandler(){
	$.ajax({
		url : "${pageContext.request.contextPath}/ownercodedeletefunction"
		,method : "post"
		,data : {memCode : ${sssMemberCode }}
		,success : function(result){
			if(result == 1){
				console.log("오너 계정 삭제 성공");
				alert("오너 삭제이 생성되었습니다.");
				location.href="${pageContext.request.contextPath }/mypage";
			}else{
				alert("오너 계정이 오류로 인하여 삭제가 취소 되었습니다.")
			}
		}
		,error : function(request, status, error){
			alert("code: "+request.status + "\n" + "message: " 
					+ request.responseText + "\n"
					+ "error: "+error);
		}
	})
}

function restorantHandler(){
	$(restorantUploadedListHandler);
	
}
	
function restorantUploadedListHandler(){
	
	$.ajax({
		url : "${pageContext.request.contextPath}/restorantuploadedlistfunction"
		,method : "post"
		,data : {ownerCode : ${sssOwnerCode } + null}
		,dataType : "json"
		,success : function(result){
				console.log("레스토랑 리스트 성공");
				console.log(result);
				
				restorantListWrap(result);
		} 
		,error : function(request, status, error){
			alert("code: "+request.status + "\n" + "message: " 
					+ request.responseText + "\n"
					+ "error: "+error);
		}
	})
}

function restorantListWrap(datalist){
	
	var htmlVal = '';
	for(var idx in datalist){
		var reslistdto = datalist[idx];
		htmlVal += `
			<div class="reslist-wrap">
				<form class="reslist">
					
						<input type="hidden" name="resName" value="\${reslistdto.resName}">
						<input type="hidden" name="resLoc" value="\${reslistdto.resLoc}">
						<input type="hidden" name="resKind" value="\${reslistdto.resKind}">
						<div class="reslist_grid">
							<div>이름 : \${reslistdto.resName}</div>
							<div>위치 : \${reslistdto.resLoc}</div>
							<div>분야 : \${reslistdto.resKind}</div>
						</div>
				</form>
				<form class="res_update   reslist-btn-form" action="${pageContext.request.contextPath}/restorantupdate" method="post">
					<input type="hidden" name="resCode" class="resCode" value="\${reslistdto.resCode}">
					<input type="submit" class="restorant-update-btn  reslist-btn" value="수정하기">
				</form>
				<form class="res_delete   reslist-btn-form" action="${pageContext.request.contextPath}/restorantdeletefuncion" method="post">
						<input type="hidden" name="resCode" class="resCode" value="\${reslistdto.resCode}">
						<input type="submit" class="restorant-delete-btn  reslist-btn" value="등록 삭제하기">
				</form>
			</div>
		`;
		$(".restorant-list").html(htmlVal)
		
		}
	
}



</script>
</html>