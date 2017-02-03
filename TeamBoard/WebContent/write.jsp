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
<h1>${boardinfo.title } 글쓰기</h1>
	<form action="write.do" method="post">
		<input type="hidden" name="boardnum" value="${boardinfo.boardnum }">
		<input type="hidden" name="author" value="${id }">
		제목<input name="title"><br>
		작성자:${name }<br>
		내용<textarea rows="20" cols="50" name="content"></textarea><br>
		<input type="submit" value = "입력">
	</form>
	
	<a href="list.do">목록보기</a>
</body>
</html>


<%@ include file="footer.jsp" %>