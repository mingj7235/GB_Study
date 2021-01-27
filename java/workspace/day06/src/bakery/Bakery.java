package bakery;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Bakery {
	public static void main(String[] args) {
		BreadMaker maker = new BreadMaker();
		BreadPlate plate = BreadPlate.getInstance();
		Thread makerThread = new Thread(maker);
		
		String [] menu = {"빵먹기", "나가기"};
		
		//사이즈 조정 : Image 클래스로 변환하여 세팅해야함 이건 참고!
		ImageIcon icon = new ImageIcon("src/img/main.gif");
		
		
		
		makerThread.start();
		
		
		while(true) {
			int choice = JOptionPane.showOptionDialog(null, "", "빵집", JOptionPane.DEFAULT_OPTION, 
					JOptionPane.PLAIN_MESSAGE, icon, menu,null);
			
			if(choice == 1 || choice == -1) {System.exit(0);}
			
			plate.eatBread();
			
			
		}
		
		
	}
}
