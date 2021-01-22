package day03_bank;

import java.util.Random;
import java.util.Scanner;

public class ATM_teacher {
	public static void main(String[] args) {
	      // 각 은행별로 최대 100명의 고객을 유치할 수 있다.
	      Shinhan[] arS = new Shinhan[100];
	      Kookmin[] arK = new Kookmin[100];
	      Woori[] arW = new Woori[100];

	      int[] arMemberCount = { 0, 0, 0 };

	      Bank[][] arrBank = { arS, arK, arW };

	      // 메인메뉴 : 은행 선택(신한, 국민, 우리)
	      String main_menu = "1.신한은행\n2.국민은행\n3.우리은행\n4.나가기";
	      // 사용자 메뉴 : 계좌개설, 입금하기, 출금하기, 잔액조회, 계좌번호 찾기, 돌아가기
	      String user_menu = "1.계좌개설\n2.입금하기\n3.출금하기\n4.잔액조회\n5.계좌번호 찾기\n6.돌아가기";

	      Scanner sc = new Scanner(System.in);

	      int bank_choice = 0;
	      int user_choice = 0;

	      Random r = new Random();
	      // 계좌 개설 시 필요한 정보
	      // 1. 예금주
	      String name = null;
	      // 2. 비밀번호(비밀번호는 4자리이고, 4자리를 입력할 때 까지 무한반복)
	      String pw = null;
	      // 3. 계좌번호(계좌번호는 6자리이며, 100000부터 시작한다. 중복검사 후 중복이 없을 때 까지 무한반복)
	      String account = null;
	      // new Random().nextInt() 사용
	      // 4. 핸드폰 번호(-를 제외하고 입력받으며, 중복검사 후 중복이 없을 때 까지 무한 반복)
	      String phone = null;
	      
	      //사용자가 원하는 금액을 담을 변수
	      int money = 0;
	      
	      //계좌번호 FLAB
	      boolean isDupAccount = false;
	      
	      //고객을 담아줄 임시 저장소
	      Bank temp = null;

	      // ※ 중복검사는 해당 은행의 고객 수 만큼만 반복하여 검사한다.

	      // 계좌번호 찾기 구현방법
	      // 핸드폰 번호와 비밀번호를 입력한 후 일치하는 고객의 계좌번호를 재발급해준다.

	      while (true) {
	         System.out.println(main_menu);
	         bank_choice = sc.nextInt();

	         if (bank_choice == 4) {
	            break;
	         }

	         while (true) {
	            System.out.println(user_menu);
	            user_choice = sc.nextInt();

	            if (user_choice == 6) {
	               break;
	            }

	            // 사용자 메뉴 : 계좌개설, 입금하기, 출금하기, 잔액조회, 계좌번호 찾기, 돌아가기
	            switch (user_choice) {
	            // 계좌개설
	            case 1:
	               // 현재 개설된 통장 개수와 은행에서 발급할 수 있는 통장의 개수가 일치하면
	               // 더 이상 계좌 개설을 할 수가 없다.
	               if (arMemberCount[bank_choice - 1] == arrBank[bank_choice - 1].length) {
	                  System.out.println("정원 초과입니다.");
	                  break;
	               }

	               System.out.print("예금주 : ");
	               name = sc.next();

	               while (true) {
	                  System.out.print("비밀번호(4자리) : ");
	                  pw = sc.next();
	                  // 4자리를 입력하지 않으면 무한반복
	                  if (pw.length() == 4) {
	                     break;
	                  }
	               }

	               // 계좌번호(계좌번호는 6자리이며, 100000부터 시작한다. 중복검사 후 중복이 없을 때 까지 무한반복)
	               while (true) {
	                  isDupAccount = false;
	                  // 100000 ~ 999999
	                  // 0 ~ 899999 + 100000
	                  // nextInt(10) : 0 ~ 9
	                  account = r.nextInt(900000) + 100000 + ""; // 6자리 랜덤한 계좌번호

	                  // 모든 은행 수 만큼 반복(신한, 국민, 우리 총 3개)
	                  // arMemberCount.length, arrBank.length : 둘 다 은행 개수
	                  for (int i = 0; i < arMemberCount.length; i++) {
	                     // 각 은행별 고객 수만큼 반복
	                     for (int j = 0; j < arMemberCount[i]; j++) {

	                        // 모든 회원의 계좌번호를 방금 생성한 계좌번호화 같은 지 비교
	                        if (arrBank[i][j].account.equals(account)) {
	                           // 중복 있음
	                           isDupAccount = true;
	                           break;
	                        }
	                     }
	                     // 중복이 있다면 더 이상 검사할 의미가 없기 때문에 for문을 탈출한다.
	                     if (isDupAccount) {
	                        break;
	                     }
	                  }
	                  // 중복이 없을 때 탈출
	                  if (!isDupAccount) {
	                     break;
	                  }
	               }

	               while (true) {
	                  boolean isRightPhoneNumber = false;
	                  boolean isDupPhone = false;

	                  System.out.print("핸드폰 번호 : ");
	                  phone = sc.next();

	                  // 입력받은 핸드폰 번호 개수 만큼 반복(문자 하나하나 검사하기 위해서)
	                  for (int i = 0; i < phone.length(); i++) {
	                     char c = phone.charAt(i);
	                     // 아스키 코드로 정수라면 48 ~ 57이다.
	                     if (c < 48 || c > 57) {
	                        // 정수가 아닌 문자가 포함되어 있을 때
	                        isRightPhoneNumber = true;
	                        break;
	                     }
	                  }

	                  if (isRightPhoneNumber) {
	                     continue;
	                  }

	                  // 중복검사
	                  for (int i = 0; i < arrBank.length; i++) {
	                     for (int j = 0; j < arMemberCount[i]; j++) {
	                        if(arrBank[i][j].phone.equals(phone)) {
	                           //중복있음
	                           isDupPhone = true;
	                           break;
	                        }
	                     }
	                     if(isDupPhone) {break;}
	                  }
//	                  if(!isDupPhone) {break;}  //이렇게 사용해도 되지만 안전하게 아래의 코드로 작성을 한다.
	                  if(!isDupPhone && !isRightPhoneNumber) {break;}
	               }
	               
	               //현재 회원이 없는 곳에는 null이 저장되어 있으므로,
	               //계좌 개설 후 정보를 저장하기 위해서는 해당 필드를 메모리에 할당해야 한다.
	               //사용자가 선택한 은행에 맞는 필드를 메모리에 할당하기 위해서 3개의 필드를 준비한다.
	               Bank[] arNewMember = { new Shinhan(), new Kookmin(), new Woori() };
	               
	               arrBank[bank_choice - 1][arMemberCount[bank_choice - 1]] = arNewMember[bank_choice - 1];

	               temp = arrBank[bank_choice - 1][arMemberCount[bank_choice - 1]];
	               
	               temp.name = name;
	               temp.account = account;
	               temp.pw = Bank.encrypt(pw);
	               temp.phone = phone;
	               
	               
	               System.out.println("예금주 : " + temp.name);
	               System.out.println("계좌번호 : " + temp.account);
	               System.out.println("암호화 : " + temp.pw);
	               System.out.println("복호화 : " + Bank.decrypt(temp.pw));
	               System.out.println("폰번호 : " + temp.phone);
	               
	               //내 이전 고객의 정보도 출력해보기
	               if(arMemberCount[bank_choice - 1] != 0) {
	                  temp = arrBank[bank_choice - 1][arMemberCount[bank_choice - 1] - 1];
	                  System.out.println("==========이전 고객=========");
	                  System.out.println("예금주 : " + temp.name);
	                  System.out.println("계좌번호 : " + temp.account);
	                  System.out.println("암호화 : " + temp.pw);
	                  System.out.println("복호화 : " + Bank.decrypt(temp.pw));
	                  System.out.println("폰번호 : " + temp.phone);
	               }
	               
	               //계좌 개설  정상 종료 후 해당 은행 고객 수 1 증가
	               arMemberCount[bank_choice - 1]++;
	               break;
	            // 입금하기
	            case 2:
	            	//사용자에게 계좌번호와 비밀번호를 입력받은 후 검사한다.
	            	//입금액을 입력받아서 일치하는 사용자의 통장으로 넣어준다.
	            	isDupAccount = false;
	            	
	            	System.out.println("계좌 번호 : ");
	            	account = sc.next();
	            	
	            	//모든 고객의 계좌번호와 비교
	            	for(int i = 0 ; i<arMemberCount.length; i++) {
	            		for(int j = 0; j <arMemberCount[i]; j++) {
	            			if (arrBank[i][j].account.equals(account)) {
	            				//유효한 계좌번호
	            				isDupAccount = true;
	            				temp = arrBank[i][j];
	            				break;
	            			}
	            		}
	            		if(isDupAccount) {break;}
	            	}
	            	if(!isDupAccount) {System.out.println("잘못된 계좌번호 입니다."); continue;}
	            	
	            	//비밀번호 비교 
	            	System.out.print("비밀번호 : ");
	            	pw = sc.next();
//	            	//암호화된pw
//	            	pw = Bank.encrypt(pw); 
//	            	
//	            	//암호화된 pw끼리 비교
//	            	if(temp.pw.equals(pw)) {
//	            		
//	            	}
	            	//복호화 후 pw비교
	            	if(Bank.decrypt(temp.pw).equals(pw)) {
	            		System.out.print("입금액 : ");
	            		money = sc.nextInt();
	            		
	            		if(money < 1) {
	            			System.out.println("해당 금액은 입금하실 수 없습니다.");
	            			continue;
	            		}
	            		temp.deposit(money);
	            		System.out.println("입금 성공!");
	            	}else {
	            		System.out.println("잘못된 비밀번호 입니다.");
	            	}
	            	
	               break;
	               
	            // 출금하기
	            case 3:
	            	isDupAccount = false;
	            	
	            	System.out.println("계좌 번호 : ");
	            	account = sc.next();
	            	
	            	//모든 고객의 계좌번호와 비교
	            	for(int i = 0 ; i<arMemberCount.length; i++) {
	            		for(int j = 0; j <arMemberCount[i]; j++) {
	            			if (arrBank[i][j].account.equals(account)) {
	            				//유효한 계좌번호
	            				isDupAccount = true;
	            				temp = arrBank[i][j];
	            				break;
	            			}
	            		}
	            		if(isDupAccount) {break;}
	            	}
	            	if(!isDupAccount) {System.out.println("잘못된 계좌번호 입니다."); continue;}
	            	
	            	//비밀번호 비교 
	            	System.out.print("비밀번호 : ");
	            	pw = sc.next();
//	            	//암호화된pw
//	            	pw = Bank.encrypt(pw); 
//	            	
//	            	//암호화된 pw끼리 비교
//	            	if(temp.pw.equals(pw)) {
//	            		
//	            	}
	            	//복호화 후 pw비교
	            	if(Bank.decrypt(temp.pw).equals(pw)) {
	            		System.out.print("출금액 : ");
	            		money = sc.nextInt();
	            		
	            		if(money < 1) {
	            			System.out.println("해당 금액은 출금하실 수 없습니다.");
	            			continue;
	            		}
	            		if(temp.withdraw(money)) {
	            			System.out.println("출금 성공!");
	            		}else {
	            			System.out.println("출금 실패 / 잔액 부족");
	            		}
	            	}else {
	            		System.out.println("잘못된 비밀번호 입니다.");
	            	}
	               break;
	               
	            // 잔액조회
	            case 4:
	            	isDupAccount = false;
	            	
	            	System.out.println("계좌 번호 : ");
	            	account = sc.next();
	            	
	            	//모든 고객의 계좌번호와 비교
	            	for(int i = 0 ; i<arMemberCount.length; i++) {
	            		for(int j = 0; j <arMemberCount[i]; j++) {
	            			if (arrBank[i][j].account.equals(account)) {
	            				//유효한 계좌번호
	            				isDupAccount = true;
	            				temp = arrBank[i][j];
	            				break;
	            			}
	            		}
	            		if(isDupAccount) {break;}
	            	}
	            	if(!isDupAccount) {System.out.println("잘못된 계좌번호 입니다."); continue;}
	            	
	            	//비밀번호 비교 
	            	System.out.print("비밀번호 : ");
	            	pw = sc.next();
//	            	//암호화된pw
//	            	pw = Bank.encrypt(pw); 
//	            	
//	            	//암호화된 pw끼리 비교
//	            	if(temp.pw.equals(pw)) {
//	            		
//	            	}
	            	//복호화 후 pw비교
	            	if(Bank.decrypt(temp.pw).equals(pw)) {
	            		System.out.println("현재잔액 : "  + temp.getBalance() + "원");
	            	}else {
	            		System.out.println("잘못된 비밀번호 입니다.");
	            	}
	            	
	               break;
	            // 계좌번호 찾기
	            case 5:
	            	boolean isDupPhone = false;
	            	//핸드폰 번호와 비밀번호로 찾기
	            	
	            	System.out.print("핸드폰 번호 (-제외) :");
	            	phone = sc.next();
	            	
	            	//유효성 검사
	            	for(int i = 0; i < arMemberCount.length; i++) {
	            		for(int j = 0 ; j< arMemberCount[i]; j++) {
	            			if(arrBank[i][j].phone.equals(phone)) {
	            				isDupPhone = true;
	            				temp = arrBank[i][j];
	            				break;
	            			}
	            		}
	            		if(isDupPhone) {break;}
	            	}
	            	if(!isDupPhone) {
	            		System.out.println("잘못된 핸드폰 번호입니다.");
	            		continue;
	            	}
	            	
	            	System.out.print("비밀번호 : ");
	            	pw = Bank.encrypt(sc.next());
	            	
	            	//암호화된 pw끼리 비교
	            	if(temp.pw.equals(pw)) {
	            		//새로운 계좌부여
	            		while(true) {
	            			isDupAccount = false;
	            			account = r.nextInt(900000)+100000 + ""; //6자리 랜덤한 계좌번호
	            			
	            			//중복검사
	            			for(int i = 0; i<arMemberCount.length; i++) {
	            				for(int j = 0; j<arMemberCount[i]; j++) {
	            					if(arrBank[i][j].account.equals(account)) {
	            						//중복이 있다는 의미
	            						isDupAccount = true;
	            						break;
	            					}
	            				}
	            				if(isDupAccount) {break;}
	            			}
	            			//중복이 없을 때 while문 탈출 
	            			if(!isDupAccount) {break;}
	            		}
	            		//중복 없는 계좌번호 생성
	            		temp.account = account;
	            		System.out.println("본인 인증이 완료 되었습니다. ");
	            		System.out.println(temp.name + "님의 새로운 계좌번호 : " + temp.account);
	            		
	            	}else {
	            		System.out.println("잘못된 비밀번호 입니다. ");
	            	}
	            	
	               break;
	            // 그 외
	            default:
	            	System.out.println("다시 시도해주세요. ");
	               break;
	            }
	         }
	      }
	}
}
 