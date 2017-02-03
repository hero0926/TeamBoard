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
<h1>${boardinfo.title } �� �ڼ��� ����</h1>

<table class="test_table">
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
<a href="list.do">��Ϻ���</a>&nbsp;&nbsp;&nbsp;&nbsp;
<c:if test="${data.author==id }">
<a href="updateUi.do?num=${data.num }">�����ϱ�</a>&nbsp;&nbsp;&nbsp;&nbsp;
</c:if>
<c:if test="${login=='Y' }">
	<c:if test="${boardinfo.repyn=='Y' }">
	<a href="replyUi.do?num=${data.num }">��۴ޱ�</a>&nbsp;&nbsp;&nbsp;&nbsp;
	</c:if>
</c:if>
<c:if test="${data.author==id }">
<a href="delete.do?num=${data.num }">�����ϱ�</a>
</c:if>
</body>
</html>

<%@ include file="footer.jsp" %>