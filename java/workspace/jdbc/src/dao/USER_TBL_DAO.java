package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.USER_TBL_VO;

public class USER_TBL_DAO {
	
	//session을 대체하기위해 만들어 놓음. 프로그램종료하기전까지 id를 보관하는것임
	public static String session_id;
	
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
	
	private static final int KEY = 5; //모든 dao객체가 공유할 수 있게끔 static을 해주는 것이다. 
	
	//id 검사
	public boolean checkId (String id) {
		//COUNT(컬럼명) 
		//COUNT(*) : 결과 행의 개수
		String query = "SELECT COUNT(*) FROM USER_TBL WHERE ID = ?";
		boolean check = false;
		try {
			//커넥션 객체 가져오기
			conn = DBConnecter.getConnection(); //연결해주고
			//가져온 커넥션 객체를 통해 prepareStatement 실행 후 pstm객체에 넣기
			pstm = conn.prepareStatement(query); // 연결한 객체에서 pstm을 담아주는것임. 쿼리를 담기만 한것임. 아직 ?가있기때문에 실행불가
			//?에 들어갈 값 설정
			pstm.setString(1, id); //이제 ?에 들어갈 값을 알려주고, 쿼리문이 완성이 되는것이다.
			//완성된 커리문을 실행, 결과가 있다면 rs객체에 넣기
			rs = pstm.executeQuery(); // 이제 들어간 것을 실행해주고, 그 결과값을 rs에 담아주는 것이다. 
			
			//행부터 접근!! 2차원배열을 기억하자. 테이블도 2차원 배열이라고 생각하면된다. !!
			rs.next(); //행 (결과 행 1개 불러오기)
			if (rs.getInt(1) == 1) { //열 (첫번 째 결과 열 가져오기)
				//1인경우가 바로 id가 있는 경우 ! 즉 count(*)가 1인경우. 
				check = true; //아이디 검사 후 존재한다면 1, 존재하지 않으면 0 이다. (count 함수를 썼으므로!)
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
	
	//회원가입 (암호화 후 DB추가)
	
	public boolean join (USER_TBL_VO user) {
		//insert
		//회원 번호는 seq사용
		//USER_SEQ.NEXTVAL : 시퀀스 가져오기
		String query = "INSERT INTO USER_TBL VALUES (USER_SEQ.NEXTVAL,?,?,?,?,?)";
		boolean check = false;
		//사용자가 입력한 아이디를 DB에서 검사한다.
		
		//view에서 사용
//		if (checkId(user.getId())) {
//			return check;
//		}
		
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			//SELECT외의 INSERT, UPDATE, DELETE쿼리문은 결과 건수를 가져와 확인하면된다.
			//executeQuery () : SELECT의 결과를 리턴해주는 메소드 (ResultSet 타입)
			//executeUpdate() : UPDATE, INSERT, DELETE의 결과 건수를 리턴해주는 메소드 (int 타입)
			int idx = 0;
			pstm.setString(++idx, user.getId());
			pstm.setString(++idx, encrypt(user.getPw()));
			pstm.setString(++idx, user.getName());
			pstm.setInt(++idx, user.getAge());
			pstm.setString(++idx, user.getPhonenumber());
			
			if(pstm.executeUpdate() == 1) {
				check = true;
			};
		} catch (SQLException e) {
			System.out.println("join() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("join() 알수 없는 오류");
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return check;
	}
		
	//로그인
	
	public boolean login(String id, String pw) {
		//로그인메소드에서는 로그인 성공, 실패만 생각하자!! 
		String query = "SELECT COUNT(*) FROM USER_TBL WHERE ID = ? AND PW = ?"; //0 또는 1 이 나온다. 로그인성공 1, 실패는0 이나온다. 
		boolean check = false;
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			pstm.setString(2, encrypt(pw));
			rs = pstm.executeQuery(); //select니까 익스큐트 쿼리 !! 저거 자체가 값이다
			
			rs.next(); //행
			if(rs.getInt(1) == 1) { //열
				//로그인 성공 ! 
				check = true;
				//로그인된 회원의 id를 스테틱변수로 저장. 로그인 후에 그 아이디를 기억하기 위해서 하는 것임. 
				session_id = id;
			}
			
		} catch (SQLException e) {
			System.out.println("login() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("login() 알 수 없는 오류");
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
	
	//로그아웃
	
	public boolean logout () {
		if(session_id != null) {
			session_id = null;
			return true;
		}
		return false;
	}
	
	//검색 (마이페이지, 조회) //한명조회면 모델객체, 한명이상조회면 어레이리스트로 리턴!
	public USER_TBL_VO select (String pw) { //비밀번호를 확인해서 입력받고 맞으면 마이페이지 조회
		//view단에서는 이 메소드를 가져와서 (하나의 유저의 객체를 가져오게되는것임) 이걸로 뷰단에서 요리하면됌
		//select 메소드의 목적은 로그인된 유저객체를 가지고 오는 것이다. !! 
		
		//view에서 처리
//		if(session_id == null) {
//			return null;
//		}
		
		USER_TBL_VO user = null;
		String query = "SELECT * FROM USER_TBL WHERE ID =? AND PW =?";
		
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, session_id);
			pstm.setString(2, encrypt(pw));
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				//비밀번호 잘 입력했을 경우 
				user = new USER_TBL_VO();
				user.setId(rs.getString("ID"));
				user.setPw(rs.getString("PW"));
				user.setName(rs.getString("NAME"));
				user.setAge(rs.getInt("AGE"));
				user.setPhonenumber(rs.getString("PHONENUMBER"));
			}
			
		} catch (SQLException e) {
			System.out.println("select() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("select() 알 수 없는 오류");
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
		
		return user;
		
	}
	
	//목록 (회원 전체목록 가져오기)
	
//	public ArrayList<USER_TBL_VO> selectAll () {
//		ArrayList<USER_TBL_VO> users = null;
//		String query = "SELECT * FROM USER_TBL";
//		try {
//			conn = DBConnecter.getConnection();
//			pstm = conn.prepareStatement(query);
//			rs = pstm.executeQuery();
//			
//			while (rs.next()) {
//				users = new ArrayList<>();
//				users.add(
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
//		return users;
//	}
	
	public ArrayList<USER_TBL_VO> selectAll() {
		String query = "SELECT * FROM USER_TBL";
		ArrayList<USER_TBL_VO> userList = new ArrayList<>();
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				USER_TBL_VO user = new USER_TBL_VO();
				user.setId(rs.getString("ID"));
				user.setPw(rs.getString("PW"));
				user.setName(rs.getString("NAME"));
				user.setAge(rs.getInt("AGE"));
				user.setPhonenumber(rs.getString("PHONENUMBER"));
				userList.add(user);
			}
			
		} catch (SQLException e) {
			System.out.println("selectAll() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("selectAll() 알 수 없는 오류");
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
		return userList;
	}
	
	
	
	
	//삭제 (회원 탈퇴)
	
	public boolean delete (String pw) {//아이디를 session에 스테틱으로 저장해놨으므로 pw만 받으면된다.
		String query = "DELETE FROM USER_TBL WHERE ID = ? AND PW = ?";
		boolean check = false;
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, session_id);
			pstm.setString(2, encrypt(pw));
			if(pstm.executeUpdate() ==1) {
				check = true;
			}
			
		} catch (SQLException e) {
			System.out.println("delete() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("delete() 알 수 없는 오류");
		} finally { //외부저장소를 열었으니까 이제 마지막으로 닫아줘야한다. 닫을때는 역순으로 닫아줘야한다. conn -> pstm -> rs로 열었으니 닫을때는 반대
			try {
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
	
	//아이디 찾기
	//핸드폰 번호와 비밀번호로 아이디 조회
	
//	public boolean findId (String pw, String phonenum) {
//		
//		String query = "SELECT COUNT(*) FROM USER_TBL WHERE PW = ? AND PHONENUM = ?";
//		boolean check = false;
//		try {
//			conn = DBConnecter.getConnection();
//			pstm = conn.prepareStatement(query);
//			pstm.setString(1, pw);
//			pstm.setString(2, phonenum);
//			rs = pstm.executeQuery();
//			rs.next();
//			if(rs.getInt(1) == 1) {
//				check = true;
//			}
//		} catch (SQLException e) {
//			System.out.println("findId() 쿼리문 오류");
//		} catch (Exception e) {
//			System.out.println("findId() 알 수 없는 오류");
//		} finally { //외부저장소를 열었으니까 이제 마지막으로 닫아줘야한다. 닫을때는 역순으로 닫아줘야한다. conn -> pstm -> rs로 열었으니 닫을때는 반대
//			try {
//				if(pstm != null) {
//					pstm.close();
//				}
//				if(conn != null) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				//닫는곳에서 오류나면 심각한 일이일어날수있으므로 강제종료를 시켜줘야한다.
//				//그러므로 이렇게 오류를 던져줘야한다. 
//				throw new RuntimeException(e.getMessage());
//			}
//		}
//		
//		return check;	
//		
//	}
	
	public String findId(String phoneNumber, String pw) {
		
		String query = "SELECT ID FROM USER_TBL WHERE PHONENUMBER = ? AND PW = ?";
		String id = null;
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			
			pstm.setString(1, phoneNumber);
			pstm.setString(2, encrypt(pw));
			
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				id = rs.getString(1);
			}
			
		} catch (SQLException e) {
			System.out.println("findId() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("findId() 알 수 없는 오류");
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
		
		return id;
		
	}
	
	//수정 (비밀번호 변경 : 로그인된 상태에서)
		//현재 비밀번호, 새로운 비밀번호를 전달 받는다.
	public boolean changePw (String pw, String new_pw) {
		String query = "UPDATE USER_TBL SET PW = ? WHERE ID =? AND PW = ?";
		boolean check = false;
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, encrypt(new_pw));
			pstm.setString(2, session_id);
			pstm.setString(3, encrypt(pw));
			
			if (pstm.executeUpdate() ==1 ) {
				check = true;
			}
		} catch (SQLException e) {
			System.out.println("changePw() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("changePw() 알 수 없는 오류");
		} finally { //외부저장소를 열었으니까 이제 마지막으로 닫아줘야한다. 닫을때는 역순으로 닫아줘야한다. conn -> pstm -> rs로 열었으니 닫을때는 반대
			try {
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
	
	
	//수정 (비밀번호 변경 : 임시비밀번호로 변경)
		//회원번호를 통해 임시비밀번호로 비밀번호 변경
	
	//비번 찾기 (아이디와 핸드폰 번호를 전달 받는다)
		//임시 비밀번호 6자리 생성(Random)
		//SMS API를 사용하여 JSON으로 데이터(수신번호, 발신번호, 내용 등) 전송
		//전송된 임시 비밀번호로 UPDATE
		//본인 핸드폰에 온 문자 확인 후 임시 비밀번호 확인
	
	//암호화
	
	public String encrypt (String pw) {
		String en_pw = "";
		for (int i = 0; i < pw.length(); i++) {
			en_pw += (char)(pw.charAt(i) * KEY);
		}
		return en_pw;
	}
}
