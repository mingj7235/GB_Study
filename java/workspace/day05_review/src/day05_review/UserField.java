package day05_review;

import java.util.ArrayList;

public class UserField {
	
	ArrayList<User> members = new ArrayList<>();
	
	final int KEY = 8;
	//중복검사

	public User userCheck (String id) {
		for (int i = 0; i < members.size(); i++) {
			if(members.get(i).id.equals(id)) {
				//아이디가 있을 경우
				return members.get(i);
			}
		}
		//중복된 아이디가 없을경우
		return null;
	}
	
	//회원가입
	
	public boolean signUp (User user) {
		if (userCheck(user.id) == null) {
			user.pw = encrypt(user.pw);
			members.add(user);
			return true;
		}
		return false;
		
	}
	
	//로그인
	
	public boolean login (String id, String pw) {
		User user = userCheck(id);
		if( user != null ) {
			if( decrypt(user.pw).equals(pw)) {
				return true;
			}
		}
		return false;
	}
	
	//암호화
	public String encrypt(String pw) {
		String en_pw = "";
		for (int i = 0; i < pw.length(); i++) {
			en_pw += (char)(pw.charAt(i) * KEY);
		}
		return en_pw;
	}
	
	public String decrypt (String en_pw) {
		String de_pw = "";
		for (int i = 0; i < en_pw.length(); i++) {
			de_pw += (char)(en_pw.charAt(i) / KEY);
		}
		return de_pw;
	}
	
	
	
	//복호화
	
	
	
	
}
