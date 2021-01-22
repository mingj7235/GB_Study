package day03;

public class Access1 {
	
	int data1= 10; //default
	public int data2 = 11; //public
	protected int data3 = 12; //protected
	private int data4 = 13; //private
	
	public Access1() {
	}
	
	//생성자로 private변수를 초기화하는 방법  -> 이건 스프링 프레임워크때 배울것 
	public Access1(int data4) {
		this.data4 = data4;
	}
	
	//게터 세터 만드는 단축키 : alt + shift + s, r, 객체 선택 후 , alt + r
	public int getData4() {
		return data4;
	}
	public void setData4(int data4) {
		this.data4 = data4;
	}
	
	
}
