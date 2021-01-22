package day03;

//상속을 막아주는 final 키워드 사용 
public final class Rect extends Shape{

	@Override
	public double getArea(double w, double h) {
		area = w*h;
		return area;
	}
	

}
