package day04;

public interface Cafe {
	//메뉴
	String [] getMenu ();
	//가격
	int [] getPrice();
	//판매방식
	void sell (String menu) throws Exception;
}
