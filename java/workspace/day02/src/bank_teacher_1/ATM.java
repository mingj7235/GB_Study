package bank_teacher_1;

import java.util.Random;
import java.util.Scanner;

public class ATM {
	//참고
	/*
	 * int choice = 1;
	 * arrBank[choice-1][0] = arNewMeber[choice-1];
	 * 
	 * 계좌 개설시 필요한 정보
	 * 1. 예금주
	 * 2. 비밀번호 (4자리, 4자리입력할때까지 무한반복)
	 * 3. 계좌번호 (계좌번호는 6자리, 100000부터 시작. 중복검사후 중복아닐때까지 무한반복)
	 * new Random().nextInt()사용
	 * 4. 핸드폰번호 (-를 제외하고 입력, 중복검사)
	 * *중복검사는 해당 은행의 고객 수 만큼만 반복하여 검사 -> cnt배열 필요
	 * 
	 * 계좌번호 찾기 구현 : 핸드폰 번호와 비밀번호 입력한 후 일치하는 고객 계좌번호 재발급
	 */
	
	public static void main(String[] args) { 
		//선언부
		String mainMenu = "ATM을 이용해주셔서 감사합니다.\n은행을 선택해주세요."
				+ "\n1.국민은행"
				+ "\n2.신한은행"
				+ "\n3.우리은행"
				+ "\n4.ATM종료하기";
		
		String choiceMenu = "다음 메뉴를 선택해주세요."
				+ "\n1.계좌개설"
				+ "\n2.입금하기"
				+ "\n3.출금하기"
				+ "\n4.잔액조회"
				+ "\n5.뒤로가기";
		
		String errors = "오류입니다. 다시한번 확인해주세요.";
		
		String name = null;
		String account = null;
		String pw = null;
		String phone = null;

		Scanner sc = new Scanner(System.in);
		Random r = new Random();

		boolean check = false;

		int bankChoice = 0;
		int optionChoice = 0;
		
		// 배열을 각각 메모리 할당
		
		int customerNum = 100;
		
		Kookmin[] arK = new Kookmin[customerNum];
		Shinhan[] arS = new Shinhan[customerNum];
		Woori[] arW = new Woori[customerNum];
		
		for (int i = 0; i < customerNum; i++) {
			arK[i] = new Kookmin();
			arS[i] = new Shinhan();
			arW[i] = new Woori();
		}
		
		Bank[][] arrBank = {arK, arS, arW};
		//각 은행별 고객 수 
		int[] arCustomerCnt = {Kookmin.cnt,Shinhan.cnt,Woori.cnt};
		//ATM 로직 시작
		while (true) {
			System.out.println(mainMenu);
			bankChoice = sc.nextInt();
			if (bankChoice == 4) {
				System.out.println("ATM을 종료합니다.");
				break;
			}
			while (true) {
				System.out.println(choiceMenu);
				optionChoice = sc.nextInt();

				if(optionChoice == 5) { 
					System.out.println("뒤로 돌아갑니다.");
					break; 
				}
				switch (optionChoice) {
				//계좌 개설
				case 1:
					System.out.print("고객명 : ");
					name = sc.next();
					
					//계좌번호
					do {
						check = false;
						account = (r.nextInt(900000) + 100000) + "";
						
						for (int i = 0; i < arrBank.length; i++) {
							for (int j = 0; j < arCustomerCnt[i]; j++) {
								if (arrBank[i][j].account.equals(account)) {
									//중복된 경우 true로 바꿔서 무한반복 
									check = true;
								}
							}
						}
					} while (check);

					//패스워드
					do {
						System.out.print("고객님 계좌의 비밀번호 4자리를 적어주세요 : ");
						pw = sc.next();
						
					} while (pw.length() != 4);	
					
					//휴대폰 번호
					 do{
						System.out.print("고객님의 핸드폰 번호를 적어주세요 (-는 제외합니다) : ");
						phone = sc.next();
						try {
							Integer.parseInt(phone);
						} catch (Exception e) {
							System.out.println("숫자만 입력할 수 있습니다..");
							break;
						}
						
						check = false;
						for (int i = 0; i < arrBank.length; i++) {
							for (int j = 0; j < arCustomerCnt[i]; j++) {
								if(arrBank[i][j].phone.equals(phone)) {
									check = true;
								}
							}
						}
					}while (check);
					
					Bank customer = arrBank[bankChoice - 1][arCustomerCnt[bankChoice - 1]];
					
					customer.name = name;
					customer.account = account;
					customer.pw = pw;
					customer.phone = phone;
					System.out.println(name + "고객님의 "+ account+"계좌가 생성되었습니다.");
					arCustomerCnt[bankChoice - 1]++;
					break;
				
				//입금
				case 2:
					System.out.print("입금할 계좌 번호 : ");
					account = sc.next();
					System.out.print("비밀번호 4자리 : ");
					pw = sc.next();
					
					for (int i = 0; i < arCustomerCnt[bankChoice - 1]; i++) {
						if(arrBank[bankChoice - 1][i].account.equals(account)
								&& arrBank[bankChoice - 1][i].pw.equals(pw)) {
							check = true;
							System.out.print("입금하실 금액을 입력해주세요 : ");
							arrBank[bankChoice - 1][i].deposit(sc.nextInt());
							System.out.println(arrBank[bankChoice-1][i].name + "고객님의 잔액 : " 
									+ arrBank[bankChoice - 1][i].money + "원");
							break;
						}
					}//로그인 실패의 경우
					if(!check) {
						System.out.println("입금 계좌 번호, 비밀번호를 확인해주세요");
					}
					break;
					
				// 출금
				case 3:
					System.out.print("출금할 계좌 번호 : ");
					account = sc.next();
					
					System.out.print("비밀번호 4자리 : ");
					pw = sc.next();
					
					for (int i = 0; i < arCustomerCnt[bankChoice - 1]; i++) {
						if(arrBank[bankChoice - 1][i].account.equals(account)
								&& arrBank[bankChoice - 1][i].pw.equals(pw)) {
							check = true;
							System.out.print("출금할 금액을 입력해주세요 : ");
							if(arrBank[bankChoice - 1][i].withdraw(sc.nextInt())) {
								System.out.println(arrBank[bankChoice-1][i].name +"고객님의 잔액 : " 
										+ arrBank[bankChoice - 1][i].money + "원");
							}else {
								System.out.println("잔액부족으로 출금하지 못했습니다.");
							}
							break;
						}
					}//로그인 실패
					if(!check) {
						System.out.println("입금 계좌 번호, 비밀번호를 확인해주세요");
					}
					break;
				// 잔액조회
				case 4:
					System.out.print("조회할 계좌번호 : ");
					account = sc.next();
					
					System.out.print("비밀번호 4자리: ");
					pw = sc.next();
					
					for (int i = 0; i < arCustomerCnt[bankChoice - 1]; i++) {
						if(arrBank[bankChoice - 1][i].account.equals(account)
								&& arrBank[bankChoice - 1][i].pw.equals(pw)) {
							check = true;
							System.out.println("고객명 : " + arrBank[bankChoice - 1][i].name +
									"계좌번호 : " + arrBank[bankChoice - 1][i].account+
									"현재" +arrBank[bankChoice - 1][i].name+"님의 계좌 잔액 : " 
									+ arrBank[bankChoice - 1][i].getBalance() + "원");
							break;
						}
					}
					if(!check) {
						System.out.println("입금 계좌 번호, 비밀번호를 확인해주세요");
					}
					break;
	            case 5: //계좌번호 찾기
	                System.out.print("고객님 핸드폰 번호: ");
	                phone = sc.next();
	                
	                System.out.print("비밀번호 4자리: ");
	                pw = sc.next();
	                
	                Bank temp = null;
	                for (int i = 0; i < arrBank.length; i++) {
	                   for (int j = 0; j < arCustomerCnt[i]; j++) {
	                      if(arrBank[i][j].phone.equals(phone) && arrBank[i][j].pw.equals(pw)) {
	                         temp = arrBank[i][j];
	                      }
	                   }
	                }
	                if(temp == null) {
	                   System.out.println("조회된 결과가 없습니다.");
	                   break;
	                }
	                System.out.println("조회된 계좌번호 : "+temp.account);
	
					
				default:
					System.out.println(errors);
				}
			}
		}//end while
	}
}
