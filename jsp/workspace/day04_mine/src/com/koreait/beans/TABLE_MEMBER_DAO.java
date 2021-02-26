package com.koreait.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TABLE_MEMBER_DAO {
	//아이디 중복검사
	
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	
	/**
	 * 
	 * @param id
	 * @return
	 * 중복이면 true, 중복이 없으면 false
	 */
	
	public boolean checkId (String id) {
		
		String query = "SELECT COUNT(*) FROM TABLE_MEMBER WHERE ID = ?";
		boolean check = false;
		
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			
			rs.next();
			if(rs.getInt(1) == 1) {
				check = true;
			}
			
		} catch (SQLException e) {
			System.out.println("checkId() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("checkId() 알 수 없는 오류");
		} finally { 
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				 
				throw new RuntimeException(e.getMessage());
			}
		
		}
		return check;
	}
	/*CREATE TABLE TABLE_MEMBER(
	NUM NUMBER PRIMARY KEY,
	ID VARCHAR2(500),
	NAME VARCHAR2(500),
	PASSWORD VARCHAR2(500),
	GENDER VARCHAR2(50),
	ZIPCODE VARCHAR2(50),
	ADDRESS VARCHAR2(500),
	ADDRESSDETAIL VARCHAR2(500),
	ADDRESSETC VARCHAR2(500)
);*/
	public boolean join (TABLE_MEMBER_VO user) {
		String query = "INSERT INTO USER_TBL VALUES (USER_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
		boolean check = false;
		
		if(checkId(user.getId())) {
			return check;
		}
		
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			int idx = 0;
			pstm.setString(++idx, user.getId());
			pstm.setString(++idx, user.getName());
			pstm.setString(++idx, user.getPassword());
			pstm.setString(++idx, user.getGender());
			pstm.setString(++idx, user.getZipcode());
			pstm.setString(++idx, user.getAddress());
			pstm.setString(++idx, user.getAddressDetail());
			pstm.setString(++idx, user.getAddressEtc());
			
			if(pstm.executeUpdate() == 1) {
				check = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("join() 알 수 없는 오류");
		} finally { 
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				 
				throw new RuntimeException(e.getMessage());
			}
		
		}
		return check;
	
	}
}
