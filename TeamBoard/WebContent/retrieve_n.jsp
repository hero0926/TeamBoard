<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<br>
<h1>${boardinfo.title } �� �ڼ��� ����</h1>

<table border="1">
	<tr>
		<td>�۹�ȣ</td>
		<td>${data.num }</td>
		<td>��ȸ��</td>
		<td>${data.readcnt }</td>
	</tr>
	<tr>
		<td>����</td>
		<td colspan="3">${data.title }</td>
	</tr>
	<tr>
		<td>�ۼ���</td>
		<td colspan="3">${data.author }</td>
	</tr>
	<tr>
		<td colspan="4"><textarea reows="20" cols="50">${data.content }</textarea></td>
	</tr>
</table>
<br>
<br>
<a href="javascript:window.close()">�ݱ�</a>
</body>
</html>

