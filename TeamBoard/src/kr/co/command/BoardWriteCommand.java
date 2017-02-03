package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.controller.BoardCommand;
import kr.co.dao.BoardDAO;

public class BoardWriteCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String content = request.getParameter("content");
		String boardnum = request.getParameter("boardnum");
		BoardDAO dao = new BoardDAO();
		dao.write(title, author, content, boardnum);
		
		response.sendRedirect("list.do");
	}

}
