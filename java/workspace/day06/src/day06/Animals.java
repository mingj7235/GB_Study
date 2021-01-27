package day06;

public class Animals implements Runnable{
	
	
	void sound_pig() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);
				System.out.println("꿀꿀");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	void sound_dog () {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);
				System.out.println("멍멍");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	void sound_duck() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);
				System.out.println("꽥");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public void run() {
		sound_pig();
		sound_dog();
		sound_duck();
	}
	
}
