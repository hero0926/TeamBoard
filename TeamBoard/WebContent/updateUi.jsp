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
<br>
<h1>${boardinfo.title } �� ���� �ϱ�</h1>

<form action="update.do" method="post">
<input type="hidden" name="num" value="${data.num }">
<table class="test_table">
	<tr>
		<td>�۹�ȣ</td>
		<td>${data.num }</td>
		<td>��ȸ��</td>
		<td>${data.readcnt }</td>
	</tr>
	<tr>
		<td>����</td>
		<td colspan="3"><input name="title" value="${data.title }"></td>
	</tr>
	<tr>
		<td>�ۼ���</td>
		<td colspan="3">${data.author }</td>
	</tr>
	<tr>
		<td colspan="4"><textarea reows="20" cols="50" name="content">${data.content }</textarea></td>
	</tr>
</table>
<br>
<br>
<input type="submit" value="�����ϱ�">
</form>
</body>
</html>

<%@ include file="footer.jsp" %>