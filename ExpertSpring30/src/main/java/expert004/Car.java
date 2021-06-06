package expert004;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {
	@Autowired
	Tire tire;
	
//	public Tire getTire() {
//		return tire;
//	}
//
//	public void setTire(Tire tire) {
//		this.tire = tire;
//	}

	public String getTireBrand () {
		return "This tire : " + tire.getBrand();
	}
}
