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
<h1>${boardinfo.title } 글 자세히 보기</h1>

<table class="test_table">
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
<a href="list.do">목록보기</a>&nbsp;&nbsp;&nbsp;&nbsp;
<c:if test="${data.author==id }">
<a href="updateUi.do?num=${data.num }">수정하기</a>&nbsp;&nbsp;&nbsp;&nbsp;
</c:if>
<c:if test="${login=='Y' }">
	<c:if test="${boardinfo.repyn=='Y' }">
	<a href="replyUi.do?num=${data.num }">댓글달기</a>&nbsp;&nbsp;&nbsp;&nbsp;
	</c:if>
</c:if>
<c:if test="${data.author==id }">
<a href="delete.do?num=${data.num }">삭제하기</a>
</c:if>
</body>
</html>

<%@ include file="footer.jsp" %>