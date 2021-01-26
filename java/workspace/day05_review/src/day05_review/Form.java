package day05_review;

import java.util.ArrayList;

public class Form {
	public static void main(String[] args) {
		UserField uf = new UserField();
		User user1 = new User("kmj", "1234");
		String msg = "";
		
		uf.signUp(user1);
		
		msg = uf.login("kmj", "1234") ? "로그인 성공" : "로그인 실패";
		System.out.println(msg);
		msg = uf.login("kms", "1234") ? "로그인 성공" : "로그인 실패";
		System.out.println(msg);
		
		
	}
}
