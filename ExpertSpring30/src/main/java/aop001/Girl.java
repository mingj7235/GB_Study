package aop001;

public class Girl {
public void runSomething() {
		
		System.out.println("열쇠로 문을 열고 집에 들어간다");
		
		try {
			System.out.println("요리를 한다 ");
		} catch (Exception e) {
			if(e.getMessage().equals("집에 불남")) {
				System.out.println("119에 신고");
			}
		}finally {
			System.out.println("소등 후 잠 ");
		}
		System.out.println("문잠그고 나가기");
	}
}
