package com.yu.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yu.dao.tmemberDAO;

import kr.co.controller.BoardCommand;
import kr.co.dao.BoardDAO;

public class MemStatusCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int memnum = Integer.valueOf(request.getParameter("memnum"));
		String status = request.getParameter("status");
		tmemberDAO dao = new tmemberDAO();
		dao.memstatus(memnum, status);
		
		response.sendRedirect("memmanage.do");
	}

}