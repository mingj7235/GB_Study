package day02;

public class Road {
		//null은 아직 어떤 주소값을 할당할 지 모를 때 쓰는 주소 초기값이다. 
		//선언 후 누적연결 사용 시 초기화 방법
//		String data = "";
		//선언 후 대입 사용시 초기화 방법
//		String data1 = null;
//		data1 = "10";
//		data1 += "안녕";
		//null은 주소값을 초기화하는 것!
	
	
	public static void main(String[] args) {
		Car myCar = new Car("벤틀리", "white", 30000);
		Car dadyCar = new Car("벤츠", "black",15000);
		Car momCar = new Car("yellow", 50000);
		
	}
}
