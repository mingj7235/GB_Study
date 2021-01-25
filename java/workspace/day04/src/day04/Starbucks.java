package day04;

import java.util.Random;

public class Starbucks {
	//신규 매장의 메뉴판
	String [] arMenu;
	
	//신규 매장의 가격표
	int [] arPrice;
	
	//신규 매장 등록하기 
	//Cafe는 인터페이스 이기 때문에 외부에서 값을 전달 받으려면
	//모든 추상메소드가 구현이 되어야 한다.
	//이를 이용하여, 신규 매장이라면 반드시 Cafe에 선언된 기능들을 구현해야 한다. 
	//외부에서 기능이 모두 구현된 필드의 주소값이 c객체로 전달되므로, 해당 필드에 접근하여
	//구현된 메소드를 사용해준다. 
	public void register(Cafe c) {
		arMenu = c.getMenu();
		arPrice = c.getPrice();
		
		//만약 가격 부분을 구현하지 않은 매장이라면 무료 나눔 매장 
		if(arPrice == null) {
			System.out.println("무료 나눔 확인 완료");
			return;
		}
		
		System.out.println("=======확인중========");
		for (int i = 0; i < arMenu.length; i++) {
			System.out.println(arMenu[i] + " : " + arPrice[i]+"원");
			
		}
		System.out.println("메뉴/가격 이상 없음");
		try {
			c.sell(arMenu[new Random().nextInt(arMenu.length)]);
			System.out.println("판매 방식 이상 없음");
		} catch (Exception e) {
			System.out.println("등록 실패. 본사에 문의해주세요");
			return;
		}
		System.out.println("정상 등록 되었습니다. ");
	}
}
