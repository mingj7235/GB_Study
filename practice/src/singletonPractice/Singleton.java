package singletonPractice;

public class Singleton {
	
	static Singleton singletonObject; //정적 참조 변수 
	
	private Singleton () {
		//생성자가 private이다.
		//new를 통해 외부에서 객체를 생성할 수 없다. 
	}
	
	public static Singleton getInstance() {
		
		if (singletonObject == null) { //다른 인스턴스가 없이 유일하다면
			singletonObject = new Singleton(); //이때 유일하게 할당한번 할것 
		}
		
		return singletonObject;
	}
}
