<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link href="./css/style2.css" rel="stylesheet" type="text/css"/>
<title>Insert title here</title>
</head>
<body>
<h1>${boardinfo.title } ��۴ޱ�</h1>
<form action="reply.do" method="post">
	<input type="hidden" name="reproot" value="${data.reproot }">
	<input type="hidden" name="repstep" value="${data.repstep }">
	<input type="hidden" name="repindent" value="${data.repindent }">
	<input type="hidden" name="num" value="${data.num }">
	<input type="hidden" name="boardnum" value="${boardinfo.boardnum }">
	<input type="hidden" name="author" value="${id }">
<table class="test_table">
	<tr>
		<td>���۹�ȣ</td>
		<td>${data.num }</td>
	</tr>
	<tr>
		<td>����</td>
		<td><input name="title" value="re:${data.title }"></td>
	</tr>
	<tr>
		<td>�ۼ���</td>
		<td>�ۼ���:${name }<br></td>
	</tr>
	<tr>
		<td colspan="2"><textarea name="content" rows="20" cols="50"></textarea>
		</td>
	</tr>
</table>
<a href="list.do">��Ϻ���</a>&nbsp;&nbsp;<input type="submit" value = "�Է�">
</form>

	
</body>
</html>

			
<%@ include file="footer.jsp" %>