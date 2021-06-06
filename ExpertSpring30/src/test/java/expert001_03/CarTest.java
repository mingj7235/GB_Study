package expert001_03;

import org.junit.Test;

public class CarTest {

	
	@Test
	public void test () {
		Tire tire1 = new KoreaTire();
		
		Car car = new Car();
		
		car.setTire(tire1);
		
		
		
	}
}
