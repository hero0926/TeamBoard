package kr.co.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.controller.BoardCommand;
import kr.co.dao.BoardDAO;
import kr.co.dto.BoardDTO;

public class BoardListCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> list = dao.list();
		
		request.setAttribute("list", list);
		System.out.println(list.size());
		RequestDispatcher dis = request.getRequestDispatcher("list.jsp");
		dis.forward(request, response);
		
	}

}
