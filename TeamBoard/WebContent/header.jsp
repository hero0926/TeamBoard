<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


<%
/* 	session.setAttribute("id", "");
	session.setAttribute("name", "");
	session.setAttribute("login", ""); */

/* 	session.setAttribute("id", "61");
	session.setAttribute("name", "홍길동");
	session.setAttribute("login", "Y"); */	
	
%>
<!-- header start -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Team Board</title>
</head>
<body>
<table width="100%">
	<tr height="30">
		<td colspan="3" align="right"><jsp:include page="loginUI.jsp"/></td>
	</tr>
	<tr height="70">
		<td width="200"><a href="main.do"><img src="./img/team2.png" height="90" width="280" ></a></td>
		<td colspan="2"><jsp:include page="menu.jsp"/> </td>
	</tr>
	<tr height="700">
		<td valign="top" align="center" colspan="3">
<!-- header end -->