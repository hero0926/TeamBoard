<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link href="./css/style2.css" rel="stylesheet" type="text/css"/>
<title>Insert title here</title>
</head>
<body>
<h1>${boardinfo.title } 목록</h1>
<table class="test_table">
	<tr>
		<td colspan="4">
			<form action="search.do?boardnum=${boardnum}" method="post">
				<select name="searchName">
					<option value="author">작성자</option>
					<option value="title">글 제목</option>
				</select>
				<input name="searchValue">
				<input type="submit" value="찾기">
			</form>
		</td>
	</tr>
	<tr>
		<th >번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>조회수</th>
	</tr>
	<c:forEach items="${list }" var="dto">
		<tr>
			<td>${dto.num}</td>
			<td>
				<c:forEach begin="1" end="${dto.repindent }">
					&nbsp;&nbsp;&nbsp;
				</c:forEach>
				<a href="retrive.do?num=${dto.num }">${dto.title }</a>
				<c:if test="${dto.readcnt>=20}">
					<img src="./img/hot.png"/>
				</c:if>
				<% 
					Date date = new Date();
					SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy/MM/dd");
					String today = simpleDate.format(date);
				%>
				<c:set var="today" value="<%=today%>"/>
				<c:if test="${dto.writeday==today}">
					<img src="./img/new.gif"/>
				</c:if>
			</td>
			<td>${dto.author }</td>
			<td>${dto.readcnt }</td>
		</tr>	
	</c:forEach>
	
	<tr>
		<td colspan="4"><jsp:include page="page.jsp"/></td>
	</tr>
</table>
<c:if test="${boardinfo.boardnum<4||id=='admin' }">
	<c:if test="${login=='Y' }">
	<a href="writeUi.do">글쓰기</a>
	</c:if>
</c:if>
</body>
</html>
<%@ include file="footer.jsp" %>