<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${login=='Y'}">
			<jsp:include page="login.jsp"></jsp:include>
		</c:when>
		<c:when test="${login=='N'}">
			���̵� �Ǵ� ��й�ȣ�� �ٽ� Ȯ���ϼ���
			<form action="login.do" method="post">
				<input type="text" name="id" placeholder="���̵�">&nbsp;&nbsp;
				<input type="password" name="pw" placeholder="��й�ȣ">&nbsp;&nbsp;
				<input type="submit" value="�α���">
			</form>
			<a href="joinui.do">ȸ������</a>
		</c:when>
		<c:otherwise>
			<form action="login.do" method="post">
				<input type="text" name="id" placeholder="���̵�">&nbsp;&nbsp;
				<input type="password" name="pw" placeholder="��й�ȣ">&nbsp;&nbsp;
				<input type="submit" value="�α���">
				<a href="joinui.do">ȸ������</a>
			</form>
		</c:otherwise>
	</c:choose>
	<br>
	
</body>
</html>