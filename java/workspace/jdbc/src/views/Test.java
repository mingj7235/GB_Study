package views;

import dao.USER_TBL_DAO;
import vo.USER_TBL_VO;

public class Test {
	public static void main(String[] args) {
		USER_TBL_DAO dao = new USER_TBL_DAO();
		USER_TBL_VO vo = new USER_TBL_VO();
		//회원가입 테스트 성공
//		vo.setAge(10);
//		vo.setId("joshuara7777");
//		vo.setName("김민재");
//		vo.setPhonenumber("01064707235");
//		vo.setPw("7235");
//		
//		if(dao.join(vo)) {
//			System.out.println("회원가입 성공");
//		}else {
//			System.out.println("회원가입 실패");
//		}
		
		//로그인, 로그아웃, 회원탈퇴 성공
		
//		if(dao.login("joshuara7235", "7235")) {
//			System.out.println("로그인 성공");
//			System.out.println(USER_TBL_DAO.session_id + "님 환영합니다.");
//			
//			if(dao.delete("7235")) {
//				System.out.println("회원탈퇴 성공");
//				dao.logout();
//			}
//			
//			if(dao.logout()) {
//				System.out.println("로그아웃 성공");
//			}else {
//				System.out.println("로그인 후 이용가능합니다.");
//			}
//		}else {
//			System.out.println("로그인 실패");
//		}
		
		//비밀번호 변경 성공
//		if(dao.login("joshuara7777", "7235")) {
//			System.out.println("로그인 성공");
//			if(dao.changePw("7235", "7777")) {
//				System.out.println("비밀번호 변경 다시 로그인해주세요");
//				dao.logout();
//				
//				if(dao.login("joshuara7777", "7777")) {
//					System.out.println("로그인 성공");
//					System.out.println(USER_TBL_DAO.session_id + "님 환영합니다.");
//				}else {
//					System.out.println("비밀번호 확인해주세요");
//				}
//			}
//		}
		
		//아이디 찾기 성공
//		System.out.println(dao.findId("01064707235", "7777"));
		
//		dao.findPw("joshuara7777", "01064707235");
		
		
		if(dao.login("joshuara7777", "9d7)?t")) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
		
	}
}
