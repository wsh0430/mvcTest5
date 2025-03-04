<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>index</title>
	<jsp:include page="/include/bs5.jsp" />
	<script>
		//location.href = "/mvcTest5/boardList";
	</script>
</head>
<body>
<p><br></p>
<div class="container">
	<h2>선택해주세요.</h2>
	<p>
		<a href="/mvcTest5/boardList" class="btn btn-success mt-4 me-4">게시판 연습</a>
		<a href="/mvcTest5/mapping" class="btn btn-primary mt-4">매핑(확장자패턴) 연습</a>
	</p>
</div>
</body>
</html>