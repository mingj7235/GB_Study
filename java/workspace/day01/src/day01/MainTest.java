package day01;

public class MainTest {
	public static void main(String[] args) {
	//중괄호가 열리면 선언이다. 
	
	if(args.length == 0) {
		System.out.println("None");
	}else {
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
	}
		
	}
}
