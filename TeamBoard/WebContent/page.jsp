<%@page import="kr.co.dto.PageTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	PageTO to = (PageTO)request.getAttribute("to");
	int curPage = to.getCurPage();
	int perPage = to.getPerPage();
	int totalCount = to.getTotalCount();
	
	int totalPage = totalCount/perPage;
	if(totalPage%perPage!=0){
		totalPage++;
	}
	
	int naviSize = 10;
	
	int startN = ((curPage-1)/naviSize)*naviSize+1;
	int endN = (startN-1)+naviSize;
	if (endN>totalPage){
		endN = totalPage;
	}
	if(startN>naviSize){
		out.print("<a href='list.do?curPage=1'><<</a>&nbsp;&nbsp;");
		out.print("<a href='list.do?curPage="+(startN-1)+"'><</a>&nbsp;&nbsp;");
	}
	for(int i=startN;i<=endN;i++){
		pageContext.setAttribute("i", i);
		if (curPage==i){
			//out.print("<font size='10' color='red'>"+i+"</font>&nbsp;&nbsp;");
		%>
			<font size='5' color='red'>${i }</font>&nbsp;&nbsp;
		<%} else { 
			//out.print("<a href='list.do?curPage="+i+"'>"+i+"</a>&nbsp;&nbsp;");
		%>
			<a href='list.do?curPage=${i }'>${i }</a>&nbsp;&nbsp;
		<%}
	}
	if (totalPage>endN){
		out.print("<a href='list.do?curPage="+(endN+1)+"'>></a>&nbsp;&nbsp;");
		out.print("<a href='list.do?curPage="+totalPage+"'>>></a>&nbsp;&nbsp;");
	}
%>