package kr.co.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.controller.BoardCommand;
import kr.co.dao.BoardDAO;
import kr.co.dao.BoardInfoDAO;
import kr.co.dto.BoardInfoDTO;
import kr.co.dto.PageTO;

public class BoardPageCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoardInfoDTO infoDto = null;
		HttpSession session = request.getSession();
		int boardnum = 1;
		String sBoardnum = request.getParameter("boardnum");
		if (sBoardnum!=null){
			boardnum = Integer.valueOf(sBoardnum);
		} else {
			infoDto = (BoardInfoDTO) session.getAttribute("boardinfo");
			if(infoDto!=null){
				boardnum = infoDto.getBoardnum();
			}			
		}
		
		int curPage = 1;
		String sCurPage = request.getParameter("curPage");
		if(sCurPage!=null){
			curPage = Integer.valueOf(sCurPage);
		}
		BoardDAO dao = new BoardDAO();
		PageTO to = dao.page(curPage, boardnum);
		
		BoardInfoDAO infoDao = new BoardInfoDAO();
		infoDto = infoDao.selectByBnum(boardnum);
		request.setAttribute("boardnum", boardnum);
		System.out.println(boardnum);
		session.setAttribute("boardinfo", infoDto);
		
		request.setAttribute("list", to.getList());
		request.setAttribute("to", to);
		RequestDispatcher dis = request.getRequestDispatcher("listPage.jsp");
		dis.forward(request, response);
		
	}

}
