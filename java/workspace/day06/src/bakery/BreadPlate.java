package bakery;

public class BreadPlate {
	
	int breadCnt;
	int eatCnt;
	
	//싱글톤패턴 
	
	//static은 메모리에 가장 먼저 할당되고, 그 이후로 재할당되지 않는다. 
	private static BreadPlate plate;
	private BreadPlate() {;}
	
	public static BreadPlate getInstance() {
		//이미 값을 가지고 있다면
		if(plate != null) {
			//그대로 리턴
			return plate;
		}
		//값을 가지고 있지 않다면 new를 사용해서 할당한다.
		//static이 붙어있기 때문에 제할당되지 않는다. 
		plate = new BreadPlate();
		return plate; 
	}
	
	public synchronized void makeBread() {
		if(breadCnt > 9) {
			System.out.println("빵이 가득 찼습니다.");
			//직접 멈추는 것임
			try {
				wait();  } catch (InterruptedException e) {;}
		}
		breadCnt ++;
		System.out.println("빵을 1개 만들었습니다. 총 : " + breadCnt + "개");
	}
	
	public synchronized void eatBread() {
		if(eatCnt == 20) {
			System.out.println("빵이 다 떨어졌습니다");
		}else if (breadCnt <1) {
			System.out.println("빵이 없습니다. 만들 때까지 기다려주세요");
		}else {
			breadCnt--;
			eatCnt++;
			System.out.println("빵을 1개 먹었습니다. 총 : " + breadCnt + "개");
			this.notify(); //자고있는 애를 깨워줘야한다. 
		}
	}
}
