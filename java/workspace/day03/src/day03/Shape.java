package day03;

public abstract class Shape {
	
	public double area;
	
	public Shape() {}
	
	public abstract double getArea(double w, double h); 
	
	
	//메소드는 저장공간이다.
	//메소드 안에 있는 코드의 주소값을 다른 곳에서 변경하지 못하도록
	//final 키워드를 작성해준다.
	//이를 final 메소드라고 부른다. 
	public final String getIntro () {
		return "도형입니다";
	}
	
}
