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
<h1>회원관리</h1>
	<table class="test_table">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>가입일자</th>
			<th>STATUS</th>
		</tr>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.id}</td>
				<td>${dto.name}</td>
				<td>${dto.regday}</td>
				<td align="center"><a href="memstatus.do?memnum=${dto.memnum}&status=${dto.status}">${dto.status}</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

<%@ include file="footer.jsp" %>
