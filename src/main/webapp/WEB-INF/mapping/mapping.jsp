<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>mapping</title>
	<jsp:include page="/include/bs5.jsp" />
</head>
<body>
<p><br></p>
<div class="container">
	<h2>확장자 패턴 연습하기</h2>
	<div class="row">
		<div class="col"><a href="boardList.do" class="btn btn-success mt-3">게시판리스트</a></div> 
		<div class="col"><a href="boardInput.do" class="btn btn-primary mt-3">게시판입력</a></div> 
		<div class="col"><a href="boardUpdate.do" class="btn btn-secondary mt-3">게시판수정</a></div> 
		<div class="col"><a href="boardDelete.do" class="btn btn-info mt-3">게시판삭제</a></div> 
	</div>
</div>
</body>
</html>