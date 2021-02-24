package com.koreait.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	//커넥터
	Connection conn;
	//pstm
	PreparedStatement pstm;
	//rs
	ResultSet rs;
	MemberVO member;
	
	//이름으로 전체 정보를 가져오기
	public ArrayList<MemberVO> select (String name) {
		//가져온 '생년월일시분초'를 '월-일'로 변경해서 저장
		String query = "SELECT * FROM TBL_MEMBER WHERE NAME = ?";
		ArrayList<MemberVO> memberList = new ArrayList<>();
		
		
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, name);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				MemberVO member = new MemberVO();
				String month = rs.getString("BIRTHDAY").substring(5,7);
				String day = rs.getString("BIRTHDAY").substring(8,10);
				member.setName(rs.getString("NAME"));
				member.setBirthday(month + "월" + day + "일");
				memberList.add(member);
			}
			
		} catch (SQLException e) {
			System.out.println("쿼리문 오류");
		} catch (Exception e) {
			System.out.println("알수 없는 오류");
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
				
		return memberList;
	}
}
