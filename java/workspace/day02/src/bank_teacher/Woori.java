package bank_teacher;

public class Woori extends Bank{
	//잔액조회시 재산 반토막
	public Woori() {
	}
	
	@Override
	int getBalance() {
		this.money *= 0.5;
		return super.getBalance();
	}
}
