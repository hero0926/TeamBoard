package com.eh.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eh.dao.logsearchDAO;
import com.eh.dto.logsearchDTO;
import com.sh.dto.tmemberlogDTO;

import kr.co.controller.BoardCommand;


public class SearchCommand implements BoardCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		
		String searchName = request.getParameter("searchName");
		String searchValue = request.getParameter("searchValue");
		
		
		logsearchDAO dao = new logsearchDAO();
//    	logsearchDTO dto = new logsearchDTO();
		ArrayList<tmemberlogDTO> list = new ArrayList<>();
		
		list=dao.logsearch(searchName, searchValue);

		request.setAttribute("list", list);

		RequestDispatcher dis=request.getRequestDispatcher("historyui.jsp");
		dis.forward(request, response);
	
		
		
		
		
		
	}

}
