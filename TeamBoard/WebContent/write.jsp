<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>${boardinfo.title } �۾���</h1>
	<form action="write.do" method="post">
		<input type="hidden" name="boardnum" value="${boardinfo.boardnum }">
		<input type="hidden" name="author" value="${id }">
		����<input name="title"><br>
		�ۼ���:${name }<br>
		����<textarea rows="20" cols="50" name="content"></textarea><br>
		<input type="submit" value = "�Է�">
	</form>
	
	<a href="list.do">��Ϻ���</a>
</body>
</html>


<%@ include file="footer.jsp" %>