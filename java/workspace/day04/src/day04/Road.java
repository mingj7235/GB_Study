package day04;

import java.util.Scanner;

public class Road {
	Scanner sc = new Scanner(System.in);
	String choice = sc.next();
	
	public static void main(String[] args) {
		
		Starbucks kangnam = new Starbucks();
		kangnam.register(new Cafe() {
			
			@Override
			public void sell(String menu) throws Exception {
				String [] arMenu = getMenu();
				boolean isOk = false;
				for (int i = 0; i < arMenu.length; i++) {
					if(arMenu[i].equals(menu)) {
						isOk = true;
					}
				}
				if (!isOk) {throw new Exception();}
			}
			
			@Override
			public int[] getPrice() {
				int [] arPrice = {3000, 5000, 8000};
				return arPrice;
			}
			
			@Override
			public String[] getMenu() {
				String [] arMenu = {"아메리카노", "카페라떼", "콜라"};
				return arMenu;
			}
		});
		
	}
}
