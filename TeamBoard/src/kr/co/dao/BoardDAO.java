package kr.co.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.dto.BoardDTO;
import kr.co.dto.BoardInfoDTO;
import kr.co.dto.PageTO;

public class BoardDAO {
	private DataSource dataFactory;
	
	public BoardDAO() {
		// TODO Auto-generated constructor stub
		
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public ArrayList<BoardDTO> list() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		String sql = "select num, author, title, content, to_char(writeday,'yyyy/MM/dd') writeday,"
					+ " readcnt, reproot, repstep, repindent, boardnum "
					+ " from teamboard"
					+ " order by reproot desc, repstep";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
			}
			System.out.println(rs.getFetchSize());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		return list;
	}
	
	public void write(String title, String author, String content, String boardnum){
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "insert into teamboard (num, author, title, content, "
				+ " readcnt, reproot, repstep, repindent, boardnum) "
				+ " values(teamboard_seq.nextval, ?, ?, ?, "
				+ " 0, teamboard_seq.currval, 0, 0, ?)";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, author);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setInt(4, Integer.valueOf(boardnum));
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}		
		
	}

	public BoardDTO retrive(int num) {
		// TODO Auto-generated method stub
		readCnt(num);
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		BoardDTO board = null;
		String sql = "select author, title, content, to_char(writeday,'yyyy/MM/dd') writeday, "
				+" readcnt, reproot, repstep, repindent, boardnum"
				+" from teamboard"
				+" where num = ?  ";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				board = new BoardDTO(num, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return board;
	}
	
	private void readCnt(int num){
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "update teamboard set readcnt = readcnt + 1"
				+" where num = ?  ";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		
	}

	public BoardDTO updateui(int num) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		BoardDTO board = null;
		String sql = "select author, title, content, to_char(writeday,'yyyy/MM/dd') writeday, "
				+" readcnt, reproot, repstep, repindent, boardnum"
				+" from teamboard"
				+" where num = ?  ";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				board = new BoardDTO(num, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return board;
	}

	public void update(int num, String title, String content) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "update teamboard set "
				+ " title=?, "
				+ " content = ? "
				+ " where num = ? ";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, num);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}		
	}

	public void delete(int num) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "delete from teamboard "
				+ " where num = ? ";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}		
	}

	public ArrayList<BoardDTO> searchList(String searchNaame, String searchValue, int boardnum) {
		// TODO Auto-generated method stub
		if(!searchNaame.equals("author")&&!searchNaame.equals("title")){
			return null;
		}
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		String sql = "select num, author, title, content, to_char(writeday,'yyyy/MM/dd') writeday,"
					+ " readcnt, reproot, repstep, repindent, boardnum"
					+ " from teamboard"
					+ " where boardnum=? and " + searchNaame + " like ? "
					+ " order by reproot desc, repstep";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			String temp = "%" + searchValue + "%";
			pstmt.setInt(1, boardnum);
			pstmt.setString(2, temp); 
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
			}
			System.out.println(rs.getFetchSize());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		return list;
	}

	public BoardDTO replyUi(int num) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		BoardDTO board = null;
		String sql = "select author, title, content, to_char(writeday,'yyyy/MM/dd') writeday, "
				+" readcnt, reproot, repstep, repindent, boardnum "
				+" from teamboard"
				+" where num = ?  ";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				board = new BoardDTO(num, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return board;
	}

	public void reply(String reproot, String repstep, String repindent, String title, String author, String content, String boardnum) {
		// TODO Auto-generated method stub

		addRepStep(Integer.valueOf(reproot), Integer.valueOf(repstep));

		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "insert into teamboard (num, author, title, content, "
				+ " readcnt, reproot, repstep, repindent, boardnum) "
				+ " values(teamboard_seq.nextval, ?, ?, ?, "
				+ " 0, ?, ?, ?, ?)";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, author);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			
			pstmt.setInt(4, Integer.valueOf(reproot));
			pstmt.setInt(5, Integer.valueOf(repstep)+1);
			pstmt.setInt(6, Integer.valueOf(repindent)+1);
			pstmt.setInt(7, Integer.valueOf(boardnum));
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}	
	}
	
	private void addRepStep(int repRoot, int repStep){
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "update teamboard set repstep = repstep + 1 "
				+ " where reproot = ? "
				+ " and repstep > ? ";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, repRoot);
			pstmt.setInt(2, repStep);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}	
	}

	public PageTO page(int curPage, int boardnum) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
/*		String sql = "select * from ( "
			+"	select rownum as rnum, num, author, title, "
			+"	content, to_char(writeday,'yyyy/MM/dd') writeday, "
			+"	readcnt, reproot, repstep, repindent "
			+"	from ( "
			+"		select * "
			+"		from teamboard "
			+"		order by reproot desc, repstep "
			+"	) "
			+") where rnum between ? and ? ";*/
		String sql1 = "select * from teamboard where boardnum = ? order by reproot desc, repstep";
		String sql2 = "select rownum as rnum, num, author, title, content, to_char(writeday,'yyyy/MM/dd') writeday, readcnt, reproot, repstep, repindent, boardnum from ";
		String sql3 = "select * from";
		String sql4 = "where rnum between ? and ? ";
		String sql = sql3 +" ( "+ sql2 +" ( "+sql1+" ) ) "+sql4;
		
		PageTO to = new PageTO();
		to.setCurPage(curPage);
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		int totalCount = totalCount(boardnum);
		to.setTotalCount(totalCount);
		
		int sn = (curPage-1)*to.getPerPage()+1;
		int en = curPage*to.getPerPage();
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardnum);
			pstmt.setInt(2, sn);
			pstmt.setInt(3, en);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new BoardDTO(rs.getInt("num"), rs.getString("author"), rs.getString("title"), rs.getString("content"),
						rs.getString("writeday"), rs.getInt("readcnt"), rs.getInt("reproot"), rs.getInt("repstep"), rs.getInt("repindent"), rs.getInt("boardnum")));
			}
			to.setList(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		return to;
	}

	private int totalCount(int boardnum) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from teamboard where boardnum = ? ";
		int totalCount = -1;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardnum);
			rs = pstmt.executeQuery();
			if(rs.next()){
				totalCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		return totalCount;
	}

	public ArrayList<BoardDTO> mainList(int boardnum, String order, int count) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from ("
				+ " select rownum, num, title, writeday, readcnt from (" 
				+" select num, substr(title, 1, 20) title,"
				+ "to_char(writeday,'yyyy/MM/dd') writeday, readcnt from teamboard where boardnum = ? order by " + order
				+" )) where rownum < ?";
		System.out.println(sql);
		
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardnum);
			pstmt.setInt(2, count+1);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new BoardDTO(rs.getInt("num"), "", rs.getString("title"), "", rs.getString("writeday"), rs.getInt("readcnt"), 0, 0, 0, boardnum));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		
		return list;
	}
	
}
