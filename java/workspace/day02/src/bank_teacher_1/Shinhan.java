package bank_teacher_1;

public class Shinhan extends Bank{
	static int cnt;
	
	//출금 시 수수료 50%
	public Shinhan() {
	}
	
	public Shinhan(int money, String name, String account, String pw, String phone) {
		this.money = money;
		this.name = name;
		this.account = account;
		this.pw = pw;
		this.phone = phone;
	}

	
	@Override
	boolean withdraw(int money) {
		//출금 수수료가 50%이기 때문에 출금할 금액에 1.5배를 부모의 withdraw로 전달한다. 
		money *= 1.5;
		return super.withdraw(money);
	}
	
}
