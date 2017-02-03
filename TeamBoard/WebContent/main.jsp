<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <link href="./css/style1.css" rel="stylesheet" type="text/css"/>
</head>
<%@ include file="header.jsp" %>
<% 
	Date date = new Date();
	SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy/MM/dd");
	String today = simpleDate.format(date);
%>
	<c:set var="today" value="<%=today%>"/>

<table border="1" width="100%">
	<tr>
		<td colspan="3"><img src="./img/main.jpg" ></td>
	</tr>
	<tr>
		<td class="blue-heading">
			 조회수 많은 게시글...<a href="list.do?boardnum=1">more</a><hr>
			<table>
			<c:forEach items="${list1 }" var="dto">
				<tr align="right">
					<td>${dto.getNum() }</td>
					<td align="left"><c:forEach begin="1" end="${dto.repindent }" step="1">&nbsp;</c:forEach>
					<a href="retrive.do?num=${dto.getNum() }">${dto.getTitle() }&nbsp;</a></td>
					<td align="center">${dto.getAuthor() }</td>
					<td align="center">${dto.getWriteday() }</td>
					<td><fmt:formatNumber value="${dto.getReadcnt() }" pattern="###,###,###" />
						<c:if test="${dto.writeday==today}">
							<img src="./img/new.gif"/>
						</c:if>
					</td>
					<td>${dto.readcnt }</td>
					<td><img src="./img/hot.png"/></td>
				</tr>
			</c:forEach>
			</table>
		</td>
		<td class="gongzi-heading">
			공지사항...<a href="list.do?boardnum=4">more</a><hr>
			<table>
			<c:forEach items="${list2 }" var="dto">
				<tr align="right">
					<td>${dto.getNum() }</td>
					<td align="left"><c:forEach begin="1" end="${dto.repindent }" step="1">&nbsp;</c:forEach>
					<a href="retrive.do?num=${dto.getNum() }">${dto.getTitle() }&nbsp;</a></td>
					<td align="center">${dto.getAuthor() }</td>
					<td align="center">${dto.getWriteday() }</td>
					<td><fmt:formatNumber value="${dto.getReadcnt() }" pattern="###,###,###" />
						<c:if test="${dto.writeday==today}">
							<img src="./img/new.gif"/>
						</c:if>
					</td>
					
				</tr>
			</c:forEach>
			</table>
		</td>
		<td rowspan="2"  class="yellow-heading">
			Q&A...<a href="list.do?boardnum=3">more</a><hr>
			<table>
			<c:forEach items="${list3 }" var="dto">
				<tr align="right">
					<td>${dto.getNum() }</td>
					<td align="left"><c:forEach begin="1" end="${dto.repindent }" step="1">&nbsp;</c:forEach>
					<a href="retrive.do?num=${dto.getNum() }">${dto.getTitle() }&nbsp;</a></td>
					<td align="center">${dto.getAuthor() }</td>
					<td align="center">${dto.getWriteday() }</td>
					<td><fmt:formatNumber value="${dto.getReadcnt() }" pattern="###,###,###" />
						<c:if test="${dto.writeday==today}">
							<img src="./img/new.gif"/>
						</c:if>
					</td>
					
				</tr>
			</c:forEach>
			</table>
		</td>
	</tr>
	<tr>
		<td class="green-heading">
			최신 순서 게시글...<a href="list.do?boardnum=1">more</a><hr>
			<table>
			<c:forEach items="${list4 }" var="dto">
				<tr align="right">
					<td>${dto.getNum() }</td>
					<td align="left"><c:forEach begin="1" end="${dto.repindent }" step="1">&nbsp;</c:forEach>
					<a href="retrive.do?num=${dto.getNum() }">${dto.getTitle() }&nbsp;</a></td>
					<td align="center">${dto.getAuthor() }</td>
					<td align="center">${dto.getWriteday() }</td>
					<td><fmt:formatNumber value="${dto.getReadcnt() }" pattern="###,###,###" />
						<c:if test="${dto.writeday==today}">
							<img src="./img/new.gif"/>
						</c:if>
					</td>
				</tr>
			</c:forEach>
			</table>
		</td>
		<td class="red-heading">
			faq...<a href="list.do?boardnum=2">more</a><hr>
			<table>
			<c:forEach items="${list5 }" var="dto">
				<tr align="right">
					<td>${dto.getNum() }</td>
					<td align="left"><c:forEach begin="1" end="${dto.repindent }" step="1">&nbsp;</c:forEach>
					<a href="retrive.do?num=${dto.getNum() }">${dto.getTitle() }&nbsp;</a></td>
					<td align="center">${dto.getAuthor() }</td>
					<td align="center">${dto.getWriteday() }</td>
					<td><fmt:formatNumber value="${dto.getReadcnt() }" pattern="###,###,###" />
						<c:if test="${dto.writeday==today}">
							<img src="./img/new.gif"/>
						</c:if>
					</td>
				</tr>
			</c:forEach>
			</table>
		</td>
	</tr>
</table>
	
<%@ include file="footer.jsp" %>
			