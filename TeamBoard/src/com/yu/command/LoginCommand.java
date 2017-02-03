package com.yu.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.controller.BoardCommand;
import com.yu.dao.tmemberDAO;
import com.yu.dto.tmemberDTO;

public class LoginCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		tmemberDAO dao = new tmemberDAO();
		tmemberDTO dto = new tmemberDTO();
		
		dto = dao.inquiry(id);
		if(id!=null && pw!=null && dto!=null){
			if(id.equals(dto.getId()) && pw.equals(dto.getPw())){
				HttpSession session = request.getSession();
				if(dto.getStatus().equals("N")){
					session.setAttribute("login", "N");
					response.sendRedirect("main.do");
					return;
				}
				session.setMaxInactiveInterval(1*60*60);
				
				session.setAttribute("id", dto.getId());
				session.setAttribute("name", dto.getName());
				session.setAttribute("login", "Y");
				
				dao.memberLog(dto);
				if(dto.getId().equals("admin")){
					response.sendRedirect("main.do");
				}else{
					response.sendRedirect("main.do");
				}
			}else{
				request.setAttribute("login", "N");
				RequestDispatcher dis = request.getRequestDispatcher("main.do");
				dis.forward(request, response);
			}
		}else{
			request.setAttribute("login", "N");
			RequestDispatcher dis = request.getRequestDispatcher("main.do");
			dis.forward(request, response);
		}
	}
	
}