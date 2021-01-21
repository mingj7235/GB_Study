package day02;

class A {
	int data1;
	double data2;
	
	void setData1 (int data1) {
		this.data1 = data1;
		//앞에잇는건 저장공간, 뒤에있는건 값.
		//앞의 data1에 매개로 받는 data1을 넣고 싶은데, 사용되는 객체의 주소를 가지고 오기위해서 this를 접근하는 것이다.
		
		System.out.println("this: " + this);
	}
}

public class ClassTest1 {
	public static void main(String[] args) {
		A a = new A();
		A b = new A();
		
//		System.out.println(a.data1);
//		System.out.println(b.data1);
		
		System.out.println("a객체 : " +a);
		System.out.println("b객체 : " + b);
		a.setData1(10);
		b.setData1(100);
	}
}
