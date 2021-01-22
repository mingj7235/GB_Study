package day03_bank;

public class Woori extends Bank{
	static int cnt;
	//잔액조회시 재산 반토막
	public Woori() {
	}
	
	public Woori(int money, String name, String account, String pw, String phone) {
		this.money = money;
		this.name = name;
		this.account = account;
		this.pw = pw;
		this.phone = phone;
	}
	
	@Override
	int getBalance() {
		this.money *= 0.5;
		return super.getBalance();
	}
}
