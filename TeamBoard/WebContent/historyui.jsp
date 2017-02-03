<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link href="./css/style2.css" rel="stylesheet" type="text/css"/>
<title>Insert title here</title>
</head>
<body>
<h1>로그인 기록 찾기</h1>
	<form action="logsearch.do">
	<select name= "searchName">
		<option value="id">아이디</option>
		<option value="name">작성자</option>
		<option value="logtime">로그인 시간대</option>
		</select>
	<input name="searchValue">
	<input type="submit" value="검색">
	</form>
	<table class="test_table">
		<tr>
			<th>아이디 </th>
			<th>작성자</th>
			<th>로그인 시간</th>
		</tr>	
	<table class="test_table">
		<c:forEach items="${list }"  var="dto">
			<tr>
				<td>${dto.id }</td>
				<td>${dto.name }</td>
				<td>${dto.loginday}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

<%@ include file="footer.jsp" %>
