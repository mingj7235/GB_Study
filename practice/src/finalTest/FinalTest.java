package finalTest;

public class FinalTest {
	final static int finalnum1 = 1;
	final static int finalnum2;
	
	static {
		
		finalnum2 = 2;
		
	}
	
	
	public static void main(String[] args) {
		
			
		System.out.println(finalnum1);
		
	}
}
