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

public class BoardInfoDAO {
	private DataSource dataFactory;
	
	public BoardInfoDAO() {
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

	public ArrayList<BoardInfoDTO> menu() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select boardnum, title, repyn from teamboardinfo order by 1";
		ArrayList<BoardInfoDTO> infoList = new ArrayList<BoardInfoDTO>();
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				infoList.add(new BoardInfoDTO(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		return infoList;
	}

	public BoardInfoDTO selectByBnum(int boardnum) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select boardnum, title, repyn from teamboardinfo where boardnum = ? ";
		
		BoardInfoDTO infoDto = new BoardInfoDTO();
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardnum);
			
			rs = pstmt.executeQuery();
			if (rs.next()){
				infoDto = new BoardInfoDTO(boardnum, rs.getString("title"), rs.getString("repyn"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return infoDto;
	}
	
	
	
}
