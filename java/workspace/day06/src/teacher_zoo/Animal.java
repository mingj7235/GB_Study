package teacher_zoo;

public class Animal implements Runnable{
	
	private String sound;
	
	
	public Animal() {
	}
	
	public Animal(String sound) {
		super();
		this.sound = sound;
	}

	public void makeSound() {
		System.out.println(sound);
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			makeSound();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
