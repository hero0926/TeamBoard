package kr.co.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.controller.BoardCommand;
import kr.co.dao.BoardDAO;
import kr.co.dto.BoardDTO;

public class BoardReplyUiCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sNum = request.getParameter("num");
		int num = Integer.valueOf(sNum);
		BoardDAO dao = new BoardDAO();
		BoardDTO data = dao.replyUi(num);
		
		request.setAttribute("data", data);
		RequestDispatcher dis = request.getRequestDispatcher("reply.jsp");
		dis.forward(request, response);
	}

}
