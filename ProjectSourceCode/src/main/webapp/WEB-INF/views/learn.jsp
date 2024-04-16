<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<script>
const fs = require('fs');


//글 읽기
fs.readFile('a.txt','utf8',(err,data)=>{
	if(err){
		consol.error(err);
		console.err;
		return;
	}
	console.log(data);
})


//글쓰기 (덮어씌워짐)
const content = "something interesting";
fs.writeFile('test.txt' , content, err=>{
	if(err){
		console.err;
		return;
	}
})

//글쓰기 (줄 안바뀐 상태로 뒤에 쓰여짐)
const content = "something interesting";
fs.appendFile('test.txt' , content, err=>{
	if(err){
		console.err;
		return;
	}
})


</script>


</body>
</html>