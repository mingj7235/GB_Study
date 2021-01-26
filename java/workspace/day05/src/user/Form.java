package user;

public class Form {
	public static void main(String[] args) {
		UserField uf = new UserField();
		
		User user = new User();
		String msg = null;
		user.id = "3mins1";
		user.pw = "7235";
		
//		if (uf.join(user)) {
//			System.out.println("회원가입 성공");
//		}else {
//			System.out.println("회원가입 실패");
//		}
		//이걸 삼항연산자로
		//회원가입
		msg = uf.join(user) ? "회원가입 성공" : "회원가입 실패";
		System.out.println(msg);
		
		msg = uf.join(user) ? "회원가입 성공" : "회원가입 실패";
		System.out.println(msg);
		
		//로그인
		msg = uf.login("3mins1", "7235") ? "로그인 성공" : "로그인실패";
		System.out.println(msg);
		
	}
}
