package practice;

import java.util.Iterator;

public class Practice05 extends Thread{
	static int share;
	
	public static void main(String[] args) {
		
		Practice05 t1 = new Practice05();
		Practice05 t2 = new Practice05();
		
		t1.start();
		t2.start();
		
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(share++);
			
			try {sleep(10000);}
			catch (InterruptedException e) {}
		}
		
	}
}
