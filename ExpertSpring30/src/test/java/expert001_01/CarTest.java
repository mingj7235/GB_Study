package expert001_01;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarTest {

	@Test
	public void test() {
		Car car = new Car();
		
		
		assertEquals("Tire brand : KoreaTire ", car.getTireModel());
	}
	
}
