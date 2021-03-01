package com.koreait.beans;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TABLE_MEMBER_DAO {
	
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	
	/**
	 * 
	 * @param id
	 * @return
	 * 중복이면 true, 중복이 없으면 false
	 */
	//아이디 중복검사
	public boolean checkId(String id) {
		String query = "SELECT COUNT(*) FROM TBL_STFORU_MEMBER WHERE ID = ?";
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
			System.out.println("checkId(String) 쿼리 오류 " + e.getMessage());
		} catch (Exception e) {
			System.out.println("checkId(String) 오류 " + e.getMessage());
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
	
	
	/*CREATE TABLE TBL_STFORU_MEMBER (
	NUM NUMBER PRIMARY KEY,
	ID VARCHAR2(500) UNIQUE,
	NAME VARCHAR2(500),
	EMAIL VARCHAR2(500),
	PASSWORD VARCHAR2(500),
	PHONENUM VARCHAR2(500),
	GENDER VARCHAR2(50),
	ZIPCODE VARCHAR2(50),
	ADDRESS VARCHAR2(500),
	ADDRESSDETAIL VARCHAR2(500),
	TALENT01 VARCHAR2(500),
	TALENT01DETAIL VARCHAR2(500),
	TALENT02 VARCHAR2(500),
	TALENT02DETAIL VARCHAR2(500),
	TALENT03 VARCHAR2(500),
	TALENT03DETAIL VARCHAR2(500),
	INTEREST01 VARCHAR2(500),
	INTEREST01DETAIL VARCHAR2(500),
	INTEREST02 VARCHAR2(500),
	INTEREST02DETAIL VARCHAR2(500),
	INTEREST03 VARCHAR2(500),
	INTEREST03DETAIL VARCHAR2(500)
);*/
	
	
	//회원가입
	public boolean join(TABLE_MEMBER_VO member) {
		String query = "INSERT INTO TBL_STFORU_MEMBER(MEMBER_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		boolean check = false;
		
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			int idx = 0;
			pstm.setString(idx++, member.getId());
			pstm.setString(idx++, member.getNameMember());
			pstm.setString(idx++, member.getEmail());
			pstm.setString(idx++, member.getPassword());
			pstm.setString(idx++, member.getPhonenum());
			pstm.setString(idx++, member.getGender());
			pstm.setString(idx++, member.getZipcode());
			pstm.setString(idx++, member.getAddress());
			pstm.setString(idx++, member.getAddressDetail());
			pstm.setString(idx++, member.getTalent01());
			pstm.setString(idx++, member.getTalent01Detail());
			pstm.setString(idx++, member.getTalent02());
			pstm.setString(idx++, member.getTalent02Detail());
			pstm.setString(idx++, member.getTalent03());
			pstm.setString(idx++, member.getTalent03Detail());
			pstm.setString(idx++, member.getInterest01());
			pstm.setString(idx++, member.getInterest01Detail());
			pstm.setString(idx++, member.getInterest02());
			pstm.setString(idx++, member.getInterest02Detail());
			pstm.setString(idx++, member.getInterest03());
			pstm.setString(idx++, member.getInterest03Detail() );
			
			if(pstm.executeUpdate() == 1) {
				check = true;
			}
			
		} catch (SQLException e) {
			System.out.println("join(TABLE_MEMBER_VO) 쿼리 오류 " + e.getMessage());
		} catch (Exception e) {
			System.out.println("join(TABLE_MEMBER_VO) 오류 " + e.getMessage());
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


















