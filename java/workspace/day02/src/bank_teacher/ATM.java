package bank_teacher;

import java.util.Random;
import java.util.Scanner;

public class ATM {
	
	int money;
	String name;
	String account;
	String pw;
	String phone;
	
	Scanner sc = new Scanner(System.in);
	Random r = new Random();
	void menu (Bank bank) {
		while (true) {
			System.out.print("1. 입금하기"
					+ "\n2. 출금하기"
					+ "\n3. 잔액조회"
					+ "\n4. 계좌번호 찾기"
					+ "\n5. 뒤로가기"
					+ "사용하실 메뉴를 선택해주세요 : ");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				deposit (int money);
				break;
			case 2:
				withdraw ();
				break;
			case 3:
				getBalance();
				break;
			case 4:
				search();
				break;
			case 5:
				System.out.println("뒤로갑니다.");
				break;
			}//end switch
			
			
		}//end while
	}
	
	void insertInfo (Bank [][] arrBank) {
		System.out.print("고객님의 성함 : ");
		String name = sc.next();
		
		String account = r.nextInt()+"";
		System.out.println("고객님의 계좌 번호 : " + account); //이름 + 전화번호 조합
		
		System.out.println("계좌 비밀 번호 :");
		String pw = sc.next();
		
		System.out.println("고객님 전화번호 : ");
		String phone = sc.next();
		
		System.out.println("초기 입금액 : ");
		int money = sc.nextInt();
		
		bank.name = name;
		bank.account = account;
		bank.pw = pw;
		bank.phone = phone;
		bank.money = money;
	}
	
	void createAccount () {
		//참고
		//int choice = 1;
		//arrBank[choice-1][0] = arNewMember[choice-1];
		
		//계좌 개설 시 필요한 정보
				//1. 예금주
				//2. 비밀번호 (비밀번호는 4자리이고, 4자리를 입력할 때 까지 무한반복)
				//3. 계좌번호 (계좌번호는 6자리이며, 100000 부터 시작한다. 중복검사 후 중복이 없을 때 까지 무한반복)
				//new Random().nextInt() 사용
				//4. 핸드폰번호 (-를 제외하고 입력받으며, 중복검사 후 중복이 없을 때 까지 무한 반복) / 아스키코드
				//* 중복검사는 해당 은행의 고객 수 만크만 반복하여 검사한다. -> cnt 배열필요 
		
		
		Shinhan [] arS = new Shinhan[100];
		Kookmin [] arK = new Kookmin[100];
		Woori [] arW = new Woori[100];
		// => Casting이 필요 ! 
		Bank [][] arrBank = {arS, arK, arW};
		Bank [] arNewMember = {new Shinhan(), new Kookmin(), new Woori()};
		
		
		while (true) {
			System.out.println("개설할 은행을 선택 해 주세요"
					+ "\n1. 신한은행"
					+ "\n2. 국민은행"
					+ "\n3. 우리은행"
					+ "\n4. 뒤로가기"
					+ "\n선택 :");
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1 :
				insertInfo();
				break;
			case 2 :
				
				break;
			case 3 :
				
				break;
			case 4 :
				
				break;
			}
		}
	}
	
	void deposit (int money) {
		if(money < 0) {throw new ArithmeticException();}
		this.money += money;
	}
	
	boolean withdraw (int money) {
		if(this.money-money < 0) {
			return false;
		}
		this.money -= money;
		return true;
	}
	
	int getBalance () {
		return this.money;
	}
	
	void search () {
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ATM atm = new ATM();
		//각 은행별로 최대 100명의 고객을 유치할 수 있다. 
		
		System.out.println("ATM기기를 이용해주셔서 감사합니다.");
		
		while(true) {
			System.out.println("이용하실 은행을 선택해주세요\n"
					+ "0. 계좌 개설"
					+ "\n1. 신한은행"
					+ "\n2. 국민은행"
					+ "\n3. 우리은행"
					+ "\n4. 돌아가기"
					+ "\n선택 : ");
			int choice = sc.nextInt();
			
			switch(choice) {
			//신한은행
			case 0 : 
				atm.createAccount();
				break;
			case 1: 
				break;
			//국민은행
			case 2: 
				break;
				
			//우리은행
			case 3:
				break;
				
			//돌아가기
			case 4:
				break;
			}
			
		}//end while
		
		//계좌번호 찾기 구현방법
		//핸드폰 번호와 비밀번호를 입력한 후 일치하는 고객의 계좌번호를 재발급해준다. 
		
		
		
	}
}
