package inter;

public interface InterA {
	
//	final static int data = 10;
	int data = 10;
	
//	abstract void getData();
//	void getData();
	
	default void printName() {
		System.out.println("한동석 InterA");
	}
}
