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
<h1>�α��� ��� ã��</h1>
	<form action="logsearch.do">
	<select name= "searchName">
		<option value="id">���̵�</option>
		<option value="name">�ۼ���</option>
		<option value="logtime">�α��� �ð���</option>
		</select>
	<input name="searchValue">
	<input type="submit" value="�˻�">
	</form>
	<table class="test_table">
		<tr>
			<th>���̵� </th>
			<th>�ۼ���</th>
			<th>�α��� �ð�</th>
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
