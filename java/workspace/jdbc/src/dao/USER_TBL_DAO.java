package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class USER_TBL_DAO {
	//Statement vs PreparedStatement 
	
	//String id = "hds";
	//[Statement]
	//String query = "SELECT * FROM USER_TBL WHERE ID = \'" + id + "\'"; << 극혐!
	
	//[PreparedStatement]
	//String query = "SELECT * FROM USER_TBL WHERE ID = ?"; << 훨씬 간편해짐!
	//pstm.setString (1, id);
	
	Connection conn;//접속에 성공한 DB의 연결 객체
	PreparedStatement pstm;//java에서 문자열로 작성한 쿼리문을 저장하고, 
						   //?에 필요한 값을 채운 후 쿼리를 실행시켜 준다. 
						   //다 완성하지 않고 준비시키는거 ! prepared ! 시키는 것이 preparedstatement다. 
	ResultSet rs; //조회 결과값을 담을 수 있는 객체
	
	//id 검사
	public boolean checkId (String id) {
		//COUNT(컬럼명) 
		//COUNT(*) : 결과 행의 개수
		String query = "SELECT COUNT(*) FROM USER_TBL WHERE ID = ?";
		boolean check = false;
		try {
			conn = DBConnecter.getConnection(); //연결해주고
			pstm = conn.prepareStatement(query); // 연결한 객체에서 pstm을 담아주는것임. 쿼리를 담기만 한것임. 아직 ?가있기때문에 실행불가
			pstm.setString(1, id); //이제 ?에 들어갈 값을 알려주고, 쿼리문이 완성이 되는것이다.
			rs = pstm.executeQuery(); // 이제 들어간 것을 실행해주고, 그 결과값을 rs에 담아주는 것이다. 
			
			//행부터 접근!! 2차원배열을 기억하자. 테이블도 2차원 배열이라고 생각하면된다. !!
			rs.next(); //행
			if (rs.getInt(1) == 1) { //열
				//1인경우가 바로 id가 있는 경우 ! 즉 count(*)가 1인경우. 
				check = true;
			}
			
		} catch (SQLException e) {
			System.out.println("checkId() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("checkId() 알 수 없는 오류");
		} finally { //외부저장소를 열었으니까 이제 마지막으로 닫아줘야한다. 닫을때는 역순으로 닫아줘야한다. conn -> pstm -> rs로 열었으니 닫을때는 반대
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
				//닫는곳에서 오류나면 심각한 일이일어날수있으므로 강제종료를 시켜줘야한다.
				//그러므로 이렇게 오류를 던져줘야한다. 
				throw new RuntimeException(e.getMessage());
			}
		}
		return check;
	}
	
	
	//회원가입
	
	//로그인
	
	//수정
	
	//삭제
	
	//검색
	
	//목록
	
	//아이디 찾기
	
	//비번 찾기
}
