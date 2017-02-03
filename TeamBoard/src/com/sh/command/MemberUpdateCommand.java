package com.sh.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yu.dao.tmemberDAO;
import com.yu.dto.tmemberDTO;

import kr.co.controller.BoardCommand;

public class MemberUpdateCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = (String) request.getSession().getAttribute("id");
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		
		tmemberDAO dao = new tmemberDAO();
		dao.updatemember(id, name, pw);
		
		response.sendRedirect("main.do");	
		
		
		

	}

}
