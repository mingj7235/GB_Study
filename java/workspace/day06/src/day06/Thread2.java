package day06;

public class Thread2 implements Runnable{
	private String data;
	
	public Thread2() {
	}
	
	public Thread2(String data) {
		super();
		this.data = data;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(data);
			try {Thread.sleep(500);} catch (InterruptedException e) {;}
		}
	}
}
