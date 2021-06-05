package abstractPractice;

public class MouseDriver {
	public static void main(String[] args) {
		
		Mouse.countOfTail = 3 ;
		
		Mouse micky = new Mouse();
		Mouse jerry = new Mouse ();
		Mouse mightyMouse = new Mouse();
		
		System.out.println(micky.countOfTail);
		System.out.println(jerry.countOfTail);
		System.out.println(mightyMouse.countOfTail);
		
	}
}
