<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/restorant_main.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/bootstrap.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/style.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/head.css">
<jsp:include page="/WEB-INF/views/function/function.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		
		<section class="sc-menu">
			<c:if test="${menuList eq 1}">
				<div class="menu-list"></div>
			</c:if>
			
			<c:if test="${menuList eq 2}">
				<div class="null_menu">등록된 메뉴가 없습니다</div>
			</c:if>
			
			<c:if test="${menuList eq 3}">
				<div>에러발생</div>
			</c:if>
		</section>
		
		<section  class="sc-restorant-info">
			<div class="loc-map">지도 들어갈 위치 - 들어갈 예정</div>
			<div class="restorant_info">
			</div>
		</section>
		
		<section class="sc-restorant-common-info">
			<div class="common-info">
					<c:if test="${sssPlaceAlone eq 'Y'}">
						<div class="place-alone"><div>혼밥석</div></div>
					</c:if>
				
					<c:if test="${sssPlaceGroup eq 'Y'}">
						<div class="place-group"><div>그룹석</div></div>
					</c:if>
				
					<c:if test="${sssSitFloor eq 'Y'}">
						<div class="sit-floor"><div>좌식</div></div>
					</c:if>
				
					<c:if test="${sssSitChair eq 'Y'}">
						<div class="sit-chair"><div>의자식</div></div>
					</c:if>
					
					<c:if test="${sssStanding eq 'Y'}">
						<div class="standing"><div>스텐딩</div></div>
					</c:if>
			</div>
		
			
		</section>
		
		<footer>
			<div id="fh5co-footer">
				<%@include file="/WEB-INF/views/footer.jsp"%>
			</div>
		</footer>
	</div>
	
	
	
	
	
	
	
	
	
	
	
	<script type="text/javascript">
	$(loadedHandler);
	
	function loadedHandler(){
		menuUploadHandler();
		restorantMainPageFunctionHandler();
		restorantGetCommonInfoFunctionHandler();
	}
	
	function menuUploadHandler(){
			$.ajax({
				url : "${pageContext.request.contextPath}/restorantmenulistfunction"
				,method : "post"
				,data : {resCode : ${sssResCode}
				,dataType : "json"
				,success : function(result){
					if(result != null){
						console.log("메뉴 불러오기 성공");
						console.log(result);
						menuUploadListHnadler(result);
					}else if(result == null){
						console.log("등록된 메뉴가 없습니다");
					}else{
						alert("오류발생")
					}
					
				}
			}
		});
	}
	
	function menuUploadListHnadler(){
		console.log(datalist);
		
		var htmlVal = '';
		for(var idx in datalist){
			var menulistdto = datalist[idx];
			htmlVal += `
				<form class="reslist">
					
					<input type="hidden" name="menuNum" value="\${menulistdto.menuNum}">
					<input type="hidden" name="menuName" value="\${menulistdto.menuName}">
					<input type="hidden" name="menuInfo" value="\${menulistdto.menuInfo}">
					<div class="reslist_grid">
						<div>\${menulistdto.menuName}</div>
						<div>\${menulistdto.menuInfo}</div>
					</div>
				</form>
				
			`;
			$(".menu-list").html(htmlVal);
		}
	}
	
	function restorantMainPageFunctionHandler(){
		$.ajax({
			url : "${pageContext.request.contextPath}/restorantmainpagegetinfofunction"
			,method : "post"
			,data : {resCode : ${sssResCode}}
			,dataType : "json"
			,success : function(result){
				if(result != null){
					console.log("레스토랑 메인 페이지 인포 불러오기 성공");
					console.log(result);
					restorantMainPageWrap(result); 
				}else 
					console.log("레스토랑 메인 페이지 인포 불러오기 실패");
				
				
				
			}
		});
	}
		
	function restorantMainPageWrap(data){
		console.log(data);
		var htmlVal = '';
		
		htmlVal +=`
			<form>
				<input type="hidden" name="menuNum" value="\${data.resName }">
				<input type="hidden" name="resPhone" value="\${data.resPhone }">
				<input type="hidden" name="resSubPhone" value="\${data.resSubPhone }">
				<input type="hidden" name="resEmail" value="\${data.resEmail }">
				<input type="hidden" name="resLoc" value="\${data.resLoc }">
				<input type="hidden" name="resMsg" value="\${data.resMsg }">
			</form>
			<div class="res_info_wrap">
				<div class="flex"><div>식당 이름 : </div><div>\${data.resName }</div></div>
				<div class="flex"><div>식당 전화번호 : </div><div>\${data.resPhone }</div></div>
				<div class="flex"><div>식당 보조 전화번호 : </div><div>\${data.resSubPhone }</div></div>
				<div class="flex"><div>식당 이메일 : </div><div>\${data.resEmail }</div></div>
				<div class="flex"><div>식당 주소 : </div><div>\${data.resLoc }</div></div>
				<div class="flex msg">\${data.resMsg }</div>	
			</div>
		`;
		
		$(".restorant_info").html(htmlVal);
	}
	
	function restorantGetCommonInfoFunctionHandler(){
		$.ajax({
			url : "${pageContext.request.contextPath}/restorantgetcommoninfofunction"
			,method : "post"
			,data : {resCode : ${sssResCode}}
			,dataType : "json"
			,success : function(result){
				
			}
		});
	}
	
	
	
	</script>
	
</body>
</html>