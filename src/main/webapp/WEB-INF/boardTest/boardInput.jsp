<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>title</title>
	<%@ include file="/include/bs5.jsp" %>
</head>
<body>
<p><br/></p>
<div class="container">
	<h2>게시판 글올리기</h2>
	<br/>
	<!-- submit 누르면 action으로 감 -->
	<!-- <form method="post" action="boardInputOk.jsp"> -->
	
	<!-- submit 누르면 url에 나오는 컨트롤러로 감(BoardInputController의 doPost) -->
	<form method="post">
		<table class="table table-bordered">
			<tr>
				<th class="text-center align-middle bg-body-secondary">글쓴이</th>
				<td><input type="text" name="name" autofocus placeholder="글쓴이를 입력하세요" required class="form-control"/></td>
			</tr>
			<tr>
				<th class="text-center align-middle bg-body-secondary">글제목</th>
				<td><input type="text" name="title" size="58" placeholder="글제목을 입력하세요" required class="form-control"/></td>
			</tr>
			<tr>
				<th class="text-center align-middle bg-body-secondary">글내용</th>
				<td><textarea rows="8" name="content" required class="form-control"></textarea></td>
			</tr>
		</table>
		<br/>
		<div class="text-center row"> <!-- row:하나의 행으로 취급 -->
			<div class="col text-start"><input type="submit" value="글올리기" class="btn btn-success"/> </div>
			<div class="col text-end"><input type="button" value="돌아가기" onclick="location.href='boardList'" class="btn btn-primary"/></div>
		</div>
		<%-- <input type="hidden" name="hostIp" value="<%=request.getRemoteAddr()%>"/> <!-- 클라이언트 ip 가져오기 --> --%>
		<input type="hidden" name="hostIp" value="${pageContext.request.remoteAddr}"/> <!-- 클라이언트 ip 가져오기, EL태그로 바꿈 -->
	</form>
</div>
</body>
</html>