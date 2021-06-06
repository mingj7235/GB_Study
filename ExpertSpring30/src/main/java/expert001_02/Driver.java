package expert001_02;

public class Driver {
	public static void main(String[] args) {
		Tire tire = new KoreaTire(); //사용하는 쪽에서 부품을 낄 수 있음 
		
		Car car = new Car (tire); //생성자로 주입받을 수 잇음 
		
		//즉, 사용자가 고를 수 있도록 Car를 설계할때는 생성자로 받을 수 잇게끔만 설계해놓는것 
		
		car.getTireBrand();
	}
}
