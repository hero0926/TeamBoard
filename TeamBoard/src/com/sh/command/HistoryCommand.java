package com.sh.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.dao.tmemberlogDAO;
import com.sh.dto.tmemberlogDTO;

import kr.co.controller.BoardCommand;

public class HistoryCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		tmemberlogDAO dao= new tmemberlogDAO();
		tmemberlogDTO dto= new tmemberlogDTO();
		
		ArrayList<tmemberlogDTO> list = new ArrayList<>();
		
		list = dao.loginselect();
		
		request.setAttribute("list", list);
		RequestDispatcher dis = request.getRequestDispatcher("historyui.jsp");
		dis.forward(request, response);
		
		
		
		
	}

}