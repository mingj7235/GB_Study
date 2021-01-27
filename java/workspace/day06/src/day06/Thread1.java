package day06;

public class Thread1 extends Thread{
	private String data;
	
	public Thread1() {;}

	public Thread1(String data) {
		this.data = data;
	}
	
	@Override
	public void run() {
		//여기에 기술하는 것들이 모두 자원
		for (int i = 0; i < 10; i++) {
			System.out.println(data);
			try {sleep(500);} catch (InterruptedException e) {}
		}
	}
	
}
