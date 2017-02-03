package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.controller.BoardCommand;
import kr.co.dao.BoardDAO;

public class BoardReplyCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String reproot = request.getParameter("reproot");
		String repstep = request.getParameter("repstep");
		String repindent = request.getParameter("repindent");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String content = request.getParameter("content");
		String boardnum = request.getParameter("boardnum");
		BoardDAO dao = new BoardDAO();
		dao.reply(reproot, repstep, repindent, title, author, content, boardnum);
		
		response.sendRedirect("list.do");
	}

}
