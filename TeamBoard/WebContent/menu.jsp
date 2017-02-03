<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>  
    
<!DOCTYPE html>
<html>
<head>
<link href="css/style1.css" rel="stylesheet" type="text/css"/>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr align="center">
			<td width="150" class="btn-gongzi"><a href="list.do?boardnum=4" class="big">공지사항</a></td>
			<td width="150" class="btn-blue"><a href="list.do?boardnum=1" class="big">게시판</a></td>
			<td width="150" class="btn-red"><a href="list.do?boardnum=2" class="big">FAQ</a></td>
			<td width="150" class="btn-yellow"><a href="list.do?boardnum=3" class="big">Q&A</a></td>	
			<% String sGubunName = (String)session.getAttribute("id");
				if(sGubunName==null){
					sGubunName = "";
				}else if(sGubunName.equals("admin")){
					%>
					<td width="150" class="btn-gongzi"><a href="memmanage.do" class="big"><b>회원관리</b></a></td>
			 		<td width="150" class="btn-gongzi"><a href="history.do" class="big"><b>로그인기록</b></a></td>
			<%	}else{
					%>							
			 <td width="150" class="btn-gongzi"><a href="memberupdateui.jsp" class="big"><b>회원정보수정</b></a></td>			
				
				<%} %>
				
				
		</tr>
	</table>
</body>
</html>
