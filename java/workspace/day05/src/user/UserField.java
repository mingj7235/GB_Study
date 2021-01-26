package user;

import java.util.ArrayList;
import java.util.Scanner;

public class UserField {
	//ArrayList 내부 저장소로 구현
	//회원의 정보는 아이디, 비밀번호 2개이다.
	
	ArrayList<User> users = new ArrayList<>();
	//아이디 중복검사
	
//	public void check (String id, String pw) {
//		boolean check = false;
//		for (int i = 0; i < users.size(); i++) {
//			if(users.get(i).id.equals(id)) {
//				System.out.println("중복된 아이디가 있습니다.");
//				check = true;
//			}else {
//				users.add(i, element);
//			}
//		}
//	}
	public User checkUser (String id) {
		for (int i = 0; i < users.size(); i++) {
			if(users.get(i).id.equals(id)) {
				return users.get(i);
			}
		}
		return null;
	}
	
	//회원가입
	public boolean join(User user) {
		if(checkUser(user.id) == null) {
			users.add(user);
			return true;
		}
		return false;
	}
	
	//로그인
	
	//암호화
	
	//복호화
}
