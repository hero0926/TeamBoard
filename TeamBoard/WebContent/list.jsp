<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
${boardinfo.title } 목록
<hr>
	<table border="1">
		<tr>
			<td colspan="8">
				<form action="search.do">
					<select name="searchName">
						<option value="author">작성자</option>
						<option value="title">글 제목</option>
					</select>
					<input name="searchValue">
					<input type="submit" value="찾기">
				</form>
			</td>
		</tr>
		<tr>
			<th>번호</th>
			<th width="200">제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
			<th>root</th>
			<th>step</th>
			<th>indent</th>
		</tr>
	<c:forEach items="${list }" var="dto">
		<tr align="right">
			<td>${dto.getNum() }</td>
			<td align="left"><c:forEach begin="1" end="${dto.repindent }" step="1">&nbsp;</c:forEach>
			<a href="retrive.do?num=${dto.getNum() }">${dto.getTitle() }&nbsp;</a></td>
			<td align="center">${dto.getAuthor() }</td>
			<td align="center">${dto.getWriteday() }</td>
			<td><fmt:formatNumber value="${dto.getReadcnt() }" pattern="###,###,###" /></td>
			<td>${dto.getReproot() }</td>
			<td>${dto.getRepstep() }</td>
			<td>${dto.getRepindent() }${dto.repindent }</td>
		</tr>
	</c:forEach>
	</table>
	
	<hr>
<a href="writeui.do">글쓰기</a>

</body>
</html>