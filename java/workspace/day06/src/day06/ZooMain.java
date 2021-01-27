package day06;

public class ZooMain {
	public static void main(String[] args) {
		
		Animals pig = new Animals();
		Animals dog = new Animals();
		Animals duck = new Animals();
		
		
		Thread t1 = new Thread(pig);
		Thread t2 = new Thread(dog);
		Thread t3 = new Thread(pig);
				
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t3.start();
	}
}
