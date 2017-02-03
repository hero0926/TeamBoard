package com.sh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.sh.dto.tmemberlogDTO;
import com.yu.dto.tmemberDTO;

public class tmemberlogDAO {
	
	//1. ������ ���̽��� �����Ѵ�.
	DataSource dataFactory;
	
	public tmemberlogDAO() {
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
	
	
	//2. �޼��带 �����.

	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn){
		// ������ �ݴ� ���ǿ� �޼���
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



	public ArrayList<tmemberlogDTO> loginselect() {
		// �α��� ����� ã�ƿ��� �޼���
		Connection conn = null;
		PreparedStatement pstmt = null;		
		ResultSet rs = null;
		
		String sql = "select a.mxlognum, a.memnum, b.id, b.name, a.loginday from tmember_log a, tmember b where a.memnum = b.memnum order by a.loginday desc";
		ArrayList<tmemberlogDTO> list = new ArrayList<>();
		tmemberlogDTO dto = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				String id = rs.getString("id");
				String name=rs.getString("name");
				int mxlognum =rs.getInt("mxlognum");
				int memnum = rs.getInt("memnum");
				String loginday = rs.getString("loginday");
				dto = new tmemberlogDTO(mxlognum, memnum, loginday, id, name);
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
