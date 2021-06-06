package expert001_03;

public class Driver {
	public static void main(String[] args) {
		Car car = new Car();
		
		Tire koreaTire = new KoreaTire();
		
		car.setTire(koreaTire);
		
		System.out.println(car.getTireBrand());
		
		
	}
}
