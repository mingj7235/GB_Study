package expert005;


import javax.annotation.Resource;

public class Car {
	@Resource
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
