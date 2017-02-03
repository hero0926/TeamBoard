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
import kr.co.dto.BoardInfoDTO;

public class BoardMainCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoardDAO dao = new BoardDAO();
		
		ArrayList<BoardDTO> list1 = dao.mainList(1, "readcnt desc", 10);
		ArrayList<BoardDTO> list2 = dao.mainList(4, "writeday desc", 10);
		ArrayList<BoardDTO> list3 = dao.mainList(3, "writeday desc", 20);
		ArrayList<BoardDTO> list4 = dao.mainList(1, "writeday desc", 10);
		ArrayList<BoardDTO> list5 = dao.mainList(2, "writeday desc", 10);
		
		//홈피 게시판 게시글들
		request.setAttribute("list1", list1);
		request.setAttribute("list2", list2);
		request.setAttribute("list3", list3);
		request.setAttribute("list4", list4);
		request.setAttribute("list5", list5);
		
		RequestDispatcher dis = request.getRequestDispatcher("main.jsp");
		dis.forward(request, response);
	}

}
