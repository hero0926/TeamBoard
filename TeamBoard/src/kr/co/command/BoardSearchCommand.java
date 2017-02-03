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

public class BoardSearchCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String searchName = request.getParameter("searchName");
		String searchValue = request.getParameter("searchValue");
		int boardnum = Integer.valueOf(request.getParameter("boardnum"));
		
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> list = dao.searchList(searchName, searchValue, boardnum);
		
		request.setAttribute("list", list);
		request.setAttribute("boardnum", boardnum);
		RequestDispatcher dis = request.getRequestDispatcher("search.jsp");
		dis.forward(request, response);
	}

}
