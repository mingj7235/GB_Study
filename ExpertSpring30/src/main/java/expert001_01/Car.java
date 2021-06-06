package expert001_01;

public class Car {
	Tire tire;
	
	public Car() {
		tire = new KoreaTire(); //의존관계를 가진다. 
				
	}
	
	public String getTireModel () {
		return "Tire brand : " + tire.getBrand();
	}
}
