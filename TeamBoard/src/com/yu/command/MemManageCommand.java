package com.yu.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.controller.BoardCommand;
import com.yu.dao.tmemberDAO;
import com.yu.dto.tmemberDTO;

public class MemManageCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		tmemberDAO dao = new tmemberDAO();
		ArrayList<tmemberDTO> list = dao.winquiry();
		
		request.setAttribute("list", list);
		RequestDispatcher dis = request.getRequestDispatcher("memmanageui.jsp");
		dis.forward(request, response);
	}

}