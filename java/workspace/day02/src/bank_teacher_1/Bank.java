package bank_teacher_1;

public class Bank {
	int money;
	String name;
	String account;
	String pw;
	String phone;
	
	public Bank() {	}
	
	/**
	 * 
	 * @param money
	 * throws ArithmeticException
	 */
	//입금
	void deposit (int money) {
		if(money < 0) {throw new ArithmeticException();}
		this.money += money;
	}
	
	//출금
	boolean withdraw (int money) {
		if(this.money-money < 0) {
			return false;
		}
		this.money -= money;
		return true;
	}
	
	//잔액조회ㅣ
	int getBalance () {
		return this.money;
	}
}
