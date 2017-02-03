package kr.co.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eh.command.SearchCommand;
import com.sh.command.HistoryCommand;
import com.sh.command.MemberUpdateCommand;
import com.yu.command.JoinCommand;
import com.yu.command.LoginCommand;
import com.yu.command.LogoutCommand;
import com.yu.command.MemManageCommand;
import com.yu.command.MemStatusCommand;

import kr.co.command.BoardDeleteCommand;
import kr.co.command.BoardListCommand;
import kr.co.command.BoardMainCommand;
import kr.co.command.BoardPageCommand;
import kr.co.command.BoardReplyCommand;
import kr.co.command.BoardReplyUiCommand;
import kr.co.command.BoardRetrieveCommand;
import kr.co.command.BoardSearchCommand;
import kr.co.command.BoardUpdateCommand;
import kr.co.command.BoardUpdateUiCommand;
import kr.co.command.BoardWriteCommand;

/**
 * Servlet implementation class BoardFrontController
 */
@WebServlet("*.do")
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String uri = request.getRequestURI();
		String ctx = request.getContextPath();
		String com = uri.substring(ctx.length());
		BoardCommand command = null;

		if(com.equalsIgnoreCase("/list.do")){
			//command = new BoardListCommand();
			command = new BoardPageCommand();
		} else if(com.equalsIgnoreCase("/write.do")){
			command = new BoardWriteCommand();
		} else if(com.equalsIgnoreCase("/writeui.do")){
			response.sendRedirect("write.jsp");
			return;
		} else if(com.equalsIgnoreCase("/retrive.do")){
			command = new BoardRetrieveCommand();
		} else if(com.equalsIgnoreCase("/updateui.do")){
			command = new BoardUpdateUiCommand();
		} else if(com.equalsIgnoreCase("/update.do")){
			command = new BoardUpdateCommand();
		} else if(com.equalsIgnoreCase("/delete.do")){
			command = new BoardDeleteCommand();
		} else if(com.equalsIgnoreCase("/search.do")){
			command = new BoardSearchCommand();
		} else if(com.equalsIgnoreCase("/replyUi.do")){
			command = new BoardReplyUiCommand();
		} else if(com.equalsIgnoreCase("/reply.do")){
			command = new BoardReplyCommand();
		} else if(com.equalsIgnoreCase("/main.do")){
			command = new BoardMainCommand();
		} else if(com.equalsIgnoreCase("/login.do")){
			//command = new BoardListCommand();
			command = new LoginCommand();
			//command.execute(request, response);
		} else if(com.equalsIgnoreCase("/logout.do")){
			command = new LogoutCommand();
		} else if(com.equalsIgnoreCase("/joinui.do")){
			System.out.println(com);
			response.sendRedirect("joinui.jsp");
			return;
		} else if(com.equalsIgnoreCase("/join.do")){
			command = new JoinCommand();
			//command.execute(request, response);
		} else if(com.equalsIgnoreCase("/history.do")){
			command = new HistoryCommand();
			//command.execute(request, response);
		} else if(com.equalsIgnoreCase("/memmanage.do")){
			command = new MemManageCommand();
			//command.execute(request, response);
			//System.out.println("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
		}else if(com.equalsIgnoreCase("/memstatus.do")){
			command = new MemStatusCommand();
			//command.execute(request, response);
		 }else if (com.equalsIgnoreCase("/logsearch.do")){
			   command = new SearchCommand(); 
		 }else if(com.equalsIgnoreCase("/memberupdate.do")){
			 command = new MemberUpdateCommand();
		 }
		else {
			command = new BoardMainCommand();
		}
		command.execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
