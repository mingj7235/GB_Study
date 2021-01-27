package bakery;

import javax.swing.JOptionPane;

public class Bakery {
	public static void main(String[] args) {
		BreadMaker maker = new BreadMaker();
		BreadPlate plate = BreadPlate.getInstance();
		Thread makerThread = new Thread(maker);
		
		String [] menu = {"빵먹기", "나가기"};
		
		makerThread.start();
		
		
		while(true) {
			int choice = JOptionPane.showOptionDialog(null, "", "빵집", JOptionPane.DEFAULT_OPTION, 
					JOptionPane.PLAIN_MESSAGE, null, menu,null);
			
			if(choice == 1 || choice == -1) {System.exit(0);}
			
			plate.eatBread();
			
			
		}
		
		
	}
}
