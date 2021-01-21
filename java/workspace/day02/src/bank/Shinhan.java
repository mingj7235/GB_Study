package bank;

import java.util.Scanner;

public class Shinhan extends Bank{
	
	@Override
	public int withdraw(int account, int money) {
		return (int) ((account-money) - (money*0.5));
	}
	
	public static void main(String[] args) {
		Shinhan sh = new Shinhan();
		Scanner sc = new Scanner(System.in);
		System.out.println("현재 잔고를 적어주세요");
		int account = sc.nextInt();
		
		System.out.println("출금할 금액을 적어주세요");
		int money = sc.nextInt();
		
		
		System.out.println("현재잔액 : "+ sh.withdraw(account, money) );
		
		
	}
	
	//출금시 수수료 50%
}
