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
			아이디 또는 비밀번호를 다시 확인하세요
			<form action="login.do" method="post">
				<input type="text" name="id" placeholder="아이디">&nbsp;&nbsp;
				<input type="password" name="pw" placeholder="비밀번호">&nbsp;&nbsp;
				<input type="submit" value="로그인">
			</form>
			<a href="joinui.do">회원가입</a>
		</c:when>
		<c:otherwise>
			<form action="login.do" method="post">
				<input type="text" name="id" placeholder="아이디">&nbsp;&nbsp;
				<input type="password" name="pw" placeholder="비밀번호">&nbsp;&nbsp;
				<input type="submit" value="로그인">
				<a href="joinui.do">회원가입</a>
			</form>
		</c:otherwise>
	</c:choose>
	<br>
	
</body>
</html>