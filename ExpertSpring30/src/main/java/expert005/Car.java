package expert005;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Car {
	@Autowired
	@Qualifier("tire1")
	Tire tire;
	//@Resource (name = "tire1")
	
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
