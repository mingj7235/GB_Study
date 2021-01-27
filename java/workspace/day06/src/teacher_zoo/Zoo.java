package teacher_zoo;

public class Zoo {
	
	public static void main(String[] args) {
		Animal lion = new Animal("어흥");
		Animal duck = new Animal("꽥꽥");
		Animal cat = new Animal("야옹");
		
		
		Thread lionThread = new Thread(lion);
		Thread duckThread = new Thread(duck);
		Thread catThread = new Thread(cat);
		
		lionThread.start();
		duckThread.start();
		
		try {
			lionThread.join();
			duckThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//마지막에 빼야한다. 그래야 마지막에 실행이된다. 
		catThread.start();
				
		
		
	}
	

}
