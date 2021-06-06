package expert001_02;

public class Car {
	Tire tire;
	
	public Car (Tire tire) {
		this.tire = tire;
	}
	
	public String getTireBrand () {
		return "This tire : " + tire.getBrand();
	}
}
