package day02;

public class SuperCar extends Car{
	String mode;
	
	public SuperCar() {
		super(); //부모클래스의 생성자를 호출하는 것이다. 
		
	}
	
	@Override
	void engineStart() {
		System.out.println("음성으로 시동 킴");
		super.engineStart(); //부모의 기존 메소드의 소스코드를 호출하는 것임
	}
	@Override
	void engineStop() {
		System.out.println("음성으로 시동 끔");
	}
	
	void openRoof() {
		System.out.println("뚜껑열림");
	}
	void closeRoof() {
		System.out.println("뚜껑닫힘");
	}
}
