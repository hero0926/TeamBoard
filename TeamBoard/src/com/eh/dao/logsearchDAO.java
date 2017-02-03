package com.eh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.eh.dto.logsearchDTO;
import com.sh.dto.tmemberlogDTO;

import kr.co.dto.BoardDTO;

public class logsearchDAO {

	DataSource dataFactory;
	
	public logsearchDAO() {
		// TODO Auto-generated constructor stub
		
		Context ctx;
		
		try {
			ctx = new InitialContext();
			
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void closeAll(ResultSet rs, Connection conn, PreparedStatement pstmt){
		
		if(rs !=null){
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
		if(conn !=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(pstmt !=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	

	public ArrayList<tmemberlogDTO> logsearch(String searchName, String searchValue) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select b.id, b.name, a.loginday "
			+" from tmember_log a, tmember b "
			+" where a.memnum = b.memnum "
			+" and "+searchName+" like ? "
			+" order by a.loginday desc ";
		
		//System.out.println(sql);
		ArrayList<tmemberlogDTO> list =new ArrayList<>();
		tmemberlogDTO dto = null;
		
		
//		if(searchName.equalsIgnoreCase("name")){
//			sql+="name like ?";
//		}else if(searchName.equalsIgnoreCase("id")){
//			sql+= "id like ?";
//		}else{
//			sql+="logtime like ?";
//		}
		try {
			conn=dataFactory.getConnection();
			pstmt= conn.prepareStatement(sql);
			System.out.println("연결");
			pstmt.setString(1, "%"+searchValue+"%");
			rs=pstmt.executeQuery();
			System.out.println("실행");
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String loginday = rs.getString("loginday");
				System.out.println("읽기");
				dto = new tmemberlogDTO(0, 0, loginday, id, name);
				list.add(dto);
				System.out.println("쓰기");

				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(rs, conn, pstmt);
		}
		return list;
	}

//	public ArrayList<logsearchDTO> logsearch() {
//		// TODO Auto-generated method stub
//		
//		
//		
//		return null;
//	}
	
}
