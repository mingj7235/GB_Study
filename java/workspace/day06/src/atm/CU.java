package atm;

public class CU {
	public static void main(String[] args) {
		ATM atm = new ATM();
		
		//자원을 공유해야하므로 ATM객체는 하나
		Thread mom = new Thread(atm, "엄마 (쓰레드명)");
		Thread son = new Thread(atm, "아들 (쓰레드명");
		
		mom.start();
		son.start();
		
	}
}
