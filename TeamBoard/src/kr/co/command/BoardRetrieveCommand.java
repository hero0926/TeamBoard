package kr.co.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.controller.BoardCommand;
import kr.co.dao.BoardDAO;
import kr.co.dto.BoardDTO;

public class BoardRetrieveCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sTarget = request.getParameter("target");
		String sNum = request.getParameter("num");
		int num = Integer.valueOf(sNum);
		BoardDAO dao = new BoardDAO();
		BoardDTO data = dao.retrive(num);
		
		String disPage = "retrieve.jsp"; 
		request.setAttribute("data", data);
		if (sTarget!=null&&sTarget.equals("new")) {
			disPage = "retrieve_n.jsp";
		}
		RequestDispatcher dis = request.getRequestDispatcher(disPage);
		dis.forward(request, response);
	}

}
