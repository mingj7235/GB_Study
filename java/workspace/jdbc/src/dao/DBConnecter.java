package dao;
//JDBC : Java Database Connectivity

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnecter {
	public static Connection getConnection () {
		Connection conn = null;
		//url, id, pw : 연결의 가장 중요한 3대 요소 
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "hr";
			String pw = "hr";
			//연결하기위해서는 드라이버가 필요하다. 통신을위한 연결통로다
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("DB연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
		} catch (Exception e) {
			System.out.println("getConnection () 알수 없는 오류");
		}
		return conn;
	}
}
