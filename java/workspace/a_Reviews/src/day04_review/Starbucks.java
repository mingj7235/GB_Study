package day04_review;

import java.util.Random;

public class Starbucks {
	
	String [] arMenu;
	int [] arPrice;
	
	public void register(Cafe c) {
		arMenu = c.getMenu();
		arPrice = c.getPrice();
		
		if(arPrice == null) {
			System.out.println("무료나눔");
			return;
		}
		
		System.out.println("===확인중===");
		for (int i = 0; i < arMenu.length; i++) {
			System.out.println(arMenu[i] + " : " + arPrice[i] + "원");
		}
		
		System.out.println("메뉴/ 가격 이상없음");
		try {
			c.sell(arMenu [new Random().nextInt(arMenu.length)]);
			System.out.println("판매잘됨");
		} catch (Exception e) {
			System.out.println("메뉴 등록 실패");
			return;
		}
		System.out.println("등록 완료");
	}
	
}
