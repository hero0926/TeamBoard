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
<h1>${boardinfo.title } 글 자세히 보기</h1>

<table border="1">
	<tr>
		<td>글번호</td>
		<td>${data.num }</td>
		<td>조회수</td>
		<td>${data.readcnt }</td>
	</tr>
	<tr>
		<td>제목</td>
		<td colspan="3">${data.title }</td>
	</tr>
	<tr>
		<td>작성자</td>
		<td colspan="3">${data.author }</td>
	</tr>
	<tr>
		<td colspan="4"><textarea reows="20" cols="50">${data.content }</textarea></td>
	</tr>
</table>
<br>
<br>
<a href="javascript:window.close()">닫기</a>
</body>
</html>

