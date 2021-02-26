package com.koreait.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class TABLE_MEMBER_DAO {
	//아이디 중복검사
	
	Context context; //naming 페키지에 있는 Context
	DataSource dataSource; //sql패키지에 있는 Datasource
	
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	
	public boolean login(String id, String pw) {
		boolean check = false;
		
		//메모리 효율이 jdbc사용보다 훨씬 좋다.
		try {
			context = new InitialContext(null);
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle"); //context.xml에 있는 name의 경로와 함께 쓰는것임
						//다운캐스팅
			
			conn = dataSource.getConnection();
			String query = "SELECT COUNT(*) FROM TABLE_MEMBER WHERE ID = ? AND PASSWORD = ? ";
			
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			pstm.setString(2, pw);
			
			rs = pstm.executeQuery();
			
			rs.next();
			if(rs.getInt(1) ==1) {
				check = true;
			}
			
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("login() 알 수 없는 오류");
		} finally { 
			try {
				
				//커넥션 풀에서 close()의 역할은 해제가 아니라 반납이다. 
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
