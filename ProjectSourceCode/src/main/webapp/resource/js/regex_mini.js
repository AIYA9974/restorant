/**
 * 
 */

 //모든 공백 체크 정규식
    	var empJ = /\s/g;
    	//아이디 정규식
    	var idJ = /^[a-z0-9_-]{4,12}$/;
    	// 비밀번호 정규식
    	var pwJ = /^[A-Za-z0-9]{4,12}$/; 
    	// 이메일 검사 정규식
    	var mailJ = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    	// 휴대폰 번호 정규식
    	var phoneJ = /^[01]{1,3}-[0-9]{4}-[0-9]{4}$/;
    	
    	// 이름에 특수문자 들어가지 않도록 설정
    	$("#user_id").blur(function() {
    		if (idJ.test($(this).val())) {
    				console.log(nameJ.test($(this).val()));
    				$("#msg-memberId").text('');
    		} else {
    			$('#msg-memberId').text('4~12자 특수문자는 _- 만 허용해요.');
    			$('#msg-memberId').css('color', 'red');
    		}
    	});
    	
    	// 비밀번호에 특수문자 들어가지 않도록 설정
    		$("#user_Password").blur(function() {
		if (pwJ.test($(this).val())) {
				console.log(nameJ.test($(this).val()));
				$("#msg-memberPassword").text('');
		} else {
			$('#msg-memberPassword').text('4~12자 특수문자빼고 넣어주세요');
			$('#msg-memberPassword').css('color', 'red');
		}
	});
	
	
		//email에 
	    		$("#user_email").blur(function() {
		if (mailJ.test($(this).val())) {
				console.log(nameJ.test($(this).val()));
				$("#msg-memberemail").text('');
		} else {
			$('#msg-memberemail').text('4~12자 특수문자빼고 넣어주세요');
			$('#msg-memberemail').css('color', 'red');
		}
	});
		//전화번호에 
	$('#user_phone').blur(function(){
		if(phoneJ.test($(this).val())){
			console.log(nameJ.test($(this).val()));
			$("#phone_check").text('');
		} else {
			$('#phone_check').text('휴대폰번호를 확인해주세요 :)');
			$('#phone_check').css('color', 'red');
		}
	});