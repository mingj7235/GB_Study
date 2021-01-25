package day04;

import java.util.Random;

public class Starbucks {
	//메뉴를 받기 
	
	String [] arMenu;
	int [] arPrice;
	
	
	public void register(Cafe c) {
		arMenu = c.getMenu();
		arPrice = c.getPrice();
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
