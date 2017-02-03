package com.yu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.yu.dto.tmemberDTO;

import kr.co.dto.BoardDTO;

public class tmemberDAO {
	
	DataSource dataFactory;
	
	public tmemberDAO() {
		// TODO Auto-generated constructor stub
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public tmemberDTO inquiry(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from tmember where id=?";
		ResultSet rs = null;
		tmemberDTO dto = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				dto = new tmemberDTO(rs.getInt("memnum"), rs.getString("id"), rs.getString("name"), rs.getString("pw"), rs.getString("regday"), rs.getString("status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		
		return dto;
	}
	public void join(String id, String pw, String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into tmember (memnum, id, name, pw) values (tmember_seq.nextval, ?, ?, ?)";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, pw);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
	}
	public ArrayList<tmemberDTO> winquiry() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select memnum, id, name, pw, to_char(regday, 'YYYY/MM/DD') regday, status from tmember";
		ResultSet rs = null;
		ArrayList<tmemberDTO> list = new ArrayList<tmemberDTO>();
		tmemberDTO dto = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				dto = new tmemberDTO(rs.getInt("memnum"), rs.getString("id"), rs.getString("name"), rs.getString("pw"), rs.getString("regday"), rs.getString("status"));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		
		return list;
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
	public void memstatus(int memnum, String status) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update tmember set status=? where memnum=?";
		String s;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			if(status.equals("Y")){
				s = "N";
			}else{
				s = "Y";
			}
			
			pstmt.setString(1, s);
			pstmt.setInt(2, memnum);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
	}
	public void memberLog(tmemberDTO dto) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql="insert into tmember_log (mxlognum, memnum) values (tmember_log_seq.nextval, ?)";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getMemnum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
	}
	

	//회원 정보 수정해보자!
	public void updatemember(String id, String name, String pw) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "update tmember set "
				+ " name=?, "
				+ " pw = ? "
				+ " where id = ? ";
		System.out.println(sql);
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			System.out.println("연결");
			pstmt.setString(1, name);
			pstmt.setString(2, pw);
			pstmt.setString(3, id);
			System.out.println(name);
			System.out.println(pw);
			System.out.println(id);
			System.out.println("대입");
			pstmt.executeUpdate();
			System.out.println("실행");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(null, pstmt, conn);
		}
	}
	
	
}