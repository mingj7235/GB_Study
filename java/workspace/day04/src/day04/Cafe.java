package day04;

//사용자가 어떤 기능을 구현할 지 알 수 없으므로
//반드시 구현해야 하는 틀만 선언하여 제공해준다.(강제성 부여)

public interface Cafe {
	//메뉴
	String [] getMenu ();
	//가격
	int [] getPrice();
	//판매방식
	void sell (String menu) throws Exception;
}
