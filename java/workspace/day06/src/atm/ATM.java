package atm;

public class ATM implements Runnable{
	
	int money = 10000;
	
	@Override
	//run에 싱크로나이즈드를 걸면 단일 스레드와 똑같음.
	//이럴바에는 목적이 다름 동기화의 목적이 다름!
	//동기화는 특정부분만 단일로 사용할때 필요한것이다. 이게 바로 목적임!!
	public /*synchronized*/ void run() {
		for (int i = 0; i < 5; i++) {
			
			//동기화블럭
//			synchronized (this) {
				withdraw(1000);
//			}
			try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();
			}
		}
	}
	
	//동기화 키워드 
	public synchronized void withdraw (int money) { //하나의 쓰레드가 다되어야 다음 쓰레드가 들어오도록 동기화
		this.money -= money;
		System.out.println(Thread.currentThread().getName() + "이(가) " + money + "원 출금");
		System.out.println("현재 잔액 : " + this.money + "원");
	}
}





















