package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.controller.BoardCommand;
import kr.co.dao.BoardDAO;

public class BoardUpdateCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String snum = request.getParameter("num");
		int num = Integer.valueOf(snum);
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		BoardDAO dao = new BoardDAO();
		dao.update(num, title, content);
		
		response.sendRedirect("list.do");
	}

}
