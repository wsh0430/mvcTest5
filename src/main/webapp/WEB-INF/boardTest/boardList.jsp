<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>title</title>
	<jsp:include page="/include/bs5.jsp" />
	<style>
		.container{
			margin:auto;
			text-align: center;
		}
		table{
			margin:auto;
			padding: 8px;
			border-collapse: collapse;
		}
		th, td{
			border:1px solid #000;
			padding:10px;
		}
		th{
			background-color: #ccc;
		}
		
	</style>
</head>
<body>
<p><br/></p>
<div class="container">
	<h2>게시판 리스트 연습입니다</h2>
	<br/>
	<div class="mb-3"><a href="boardInput" class="btn btn-success">글쓰기</a></div>
	<table class="table table-hover">
		<tr class="table-secondary text-center">
			<th class="p-3">번호</th>
			<th class="p-3">글제목</th>
			<th class="p-3">글쓴이</th>
			<th class="p-3">글쓴날짜</th>
			<th class="p-3">조회수</th>
		</tr>
		<c:forEach var="vo" items="${vos}" varStatus="st">
			<tr class="text-center">
				<%-- <td>${vo.idx }</td> <!-- idx는 getter를 의미함 --> --%>
				<td>${st.count}</td>
				<td class="text-start"><a href="boardContent?idx=${vo.idx}" class="text-dark link-primary link-underline-opacity-0 link-underline-opacity-100-hover">${vo.title}</a></td>
				<td>${vo.name }</td>
				<td>${vo.wDate }</td>
				<td>${vo.readNum }</td>
			</tr>
		</c:forEach>
		
		
	</table>
</div>
</body>
</html>
