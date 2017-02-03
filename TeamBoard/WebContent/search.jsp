<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="header.jsp" %>
			
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link href="./css/style2.css" rel="stylesheet" type="text/css"/>
<title>Insert title here</title>
</head>
<body>
�˻����
<hr>
	<table class="test_table">
		<tr>
			<td colspan="8">
				<form action="search.do?boardnum=${boardnum}" method="post">
					<select name="searchName">
						<option value="author">�ۼ���</option>
						<option value="title">�� ����</option>
					</select>
					<input name="searchValue">
					<input type="submit" value="ã��">
				</form>
			</td>
		</tr>
		<tr>
			<th>��ȣ</th>
			<th width="200">����</th>
			<th>�ۼ���</th>
			<th>��¥</th>
			<th>��ȸ��</th>
			<th>root</th>
			<th>step</th>
			<th>indent</th>
		</tr>
	<c:forEach items="${list }" var="dto">
		<tr align="right">
			<td>${dto.getNum() }</td>
			<td align="left"><a href="retrive.do?num=${dto.getNum() }">${dto.getTitle() }&nbsp;</a></td>
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
<a href="list.do">��� ����</a>

</body>
</html>

<%@ include file="footer.jsp" %>