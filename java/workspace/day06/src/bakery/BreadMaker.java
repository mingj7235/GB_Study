package bakery;

public class BreadMaker implements Runnable{
	
	//싱글톤패턴
	BreadPlate plate = BreadPlate.getInstance();
	
	public BreadMaker() {
	}

	//main에서 주소값을 가져오도록.
	//new를하면 서로 다른 객체가 생기므로 공유를해줘야한다. 
//	public BreadMaker(BreadPlate plate) {
//		super();
//		this.plate = plate;
//	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			plate.makeBread();
			try {Thread.sleep(1000);} catch (InterruptedException e) {}
		}
		System.out.println("재료 소진");
	}
}
