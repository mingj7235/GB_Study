package bank;

public class Bank {

	//객체
	//돈
	int money;
	int account; 
	public Bank() {
	}
	
	public Bank(int money) {
		this.money = money;
	}
	//메소드
	//입금
	public int input (int account, int money) {
		return this.account = account + money;
	}
	
	//출금
	
	public int withdraw (int account, int money) {
		
		if (this.account > money) {
			this.account = account- money;
			
		} else {
			System.out.println("출금 불가");
		}
		return this.account;
		
	}
	//잔액조회
	
	public int look (int account, int money) {
		this.account = account;
		return this.account;
		
		
	}
}
