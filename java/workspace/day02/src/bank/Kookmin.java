package bank;

import java.util.Scanner;

public class Kookmin extends Bank{
	
	@Override
	public int input(int account, int money) {
		return (int) (super.input(account, money) - (money*0.5));
	}
	//입금시 수수료 50%
	public static void main(String[] args) {
		Kookmin km = new Kookmin();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("현재 잔고를 적어주세요");
		int account = sc.nextInt();
		
		System.out.println("입금할 금액을 적어주세요");
		int money = sc.nextInt();
		
		
		System.out.println("현재잔액 : "+ km.withdraw(account, money) );
	}
}
