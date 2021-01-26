package day04_review;

public class Road {
	public static void main(String[] args) {
		
		Starbucks kangnam = new Starbucks();
		System.out.println("<<강남매장>>");
		kangnam.register(new Cafe() {

			@Override
			public String[] getMenu() {
				String [] arMenu = {"아메리", "카페라", "콜라"};
				return arMenu;
			}

			@Override
			public int[] getPrice() {
				int [] arPrice = {3000, 5000, 4000};
				return arPrice;
			}

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
			
		});
		
	}
}
