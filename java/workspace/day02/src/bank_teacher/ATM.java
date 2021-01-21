package bank_teacher;

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

		int choice = 0;
		int optionChoice = 0;
		int customerNum = 100;
		
		Kookmin[] arK = new Kookmin[customerNum];
		Shinhan[] arS = new Shinhan[customerNum];
		Woori[] arW = new Woori[customerNum];
		
		// 배열을 각각 메모리 할당
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
			choice = sc.nextInt();
			if (choice == 4) {
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
					while (true) {
						System.out.print("고객님의 핸드폰 번호를 적어주세요 (-는 제외합니다) : ");
						phone = sc.next();
						try {
							//�޴��� ��ȣ�� ������ ����ȯ �� ������ �߻����� �ʴ´ٸ� ���� �Է�
							Integer.parseInt(phone);
							//�����Է½� break �ߵ�
							break;
						} catch (NumberFormatException e) {
							//���� �Է��� �ƴ� �� ���ܰ� �߻��Ͽ� ����
							System.out.println("���ڸ� �Է��� �� �ֽ��ϴ�.");
						}
					}
					
					//�ű� �� �ʵ��� �ּҸ� temp�� ����ش�.
					//(��)choice - 1 : ����ڰ� ������ ����
					//(��)arUserCnt[choice - 1] : ����ڰ� ������ ������ ȸ�� ��(6�϶� 6��° �ε����� �ű�ȸ���ڸ�)
					Bank temp = arrBank[choice - 1][arCustomerCnt[choice - 1]];
					
					temp.name = name;
					temp.account = account;
					temp.pw = pw;
					temp.phone = phone;
					
					System.out.println("�������մϴ١�");
					System.out.println(name + "���� ���¹�ȣ : " + account);
					System.out.println("�������� ���� �̿� �����մϴ�^^");
					
					//���� �Ϸ�� �ش� ���� ȸ�� �� 1����
					arCustomerCnt[choice - 1]++;
					break;
				//���¹�ȣ�� ��й�ȣ�� �Է��ؾ� ���� �̿��� �����ϴ�.
				// �Ա��ϱ�
				case 2:
					System.out.print("���¹�ȣ : ");
					account = sc.next();
					
					System.out.print("��й�ȣ : ");
					pw = sc.next();
					
					//arUserCnt[choice - 1] : �ش� ������ ȸ����ŭ�� �ݺ�
					for (int i = 0; i < arCustomerCnt[choice - 1]; i++) {
						//�α��� �˻�
						if(arrBank[choice - 1][i].account.equals(account)
								&& arrBank[choice - 1][i].pw.equals(pw)) {
							//�α��� ������ check�� true
							check = true;
							System.out.print("�Աݾ� : ");
							arrBank[choice - 1][i].deposit(sc.nextInt());
							//�Ա� �� ���� �ܾ� ǥ��
							System.out.println("���� �ܾ� : " + arrBank[choice - 1][i].money + "��");
							break;
						}
					}
					if(!check) {
						System.out.println("���¹�ȣ Ȥ�� ��й�ȣ�� Ȯ�����ּ���");
					}
					break;
				// ����ϱ�
				case 3:
					System.out.print("���¹�ȣ : ");
					account = sc.next();
					
					System.out.print("��й�ȣ : ");
					pw = sc.next();
					
					//arUserCnt[choice - 1] : �ش� ������ ȸ����ŭ�� �ݺ�
					for (int i = 0; i < arCustomerCnt[choice - 1]; i++) {
						//�α��� �˻�
						if(arrBank[choice - 1][i].account.equals(account)
								&& arrBank[choice - 1][i].pw.equals(pw)) {
							//�α��� ������ check�� true
							check = true;
							System.out.print("��ݾ� : ");
							if(arrBank[choice - 1][i].withdraw(sc.nextInt())) {
								//��� �� ���� �ܾ� ǥ��
								System.out.println("���� �ܾ� : " + arrBank[choice - 1][i].money + "��");
							}else {
								System.out.println("��� ���� / �ܾ� ����");
							}
							break;
						}
					}
					if(!check) {
						System.out.println("���¹�ȣ Ȥ�� ��й�ȣ�� Ȯ�����ּ���");
					}
					break;
				// �ܾ���ȸ
				case 4:
					System.out.print("���¹�ȣ : ");
					account = sc.next();
					
					System.out.print("��й�ȣ : ");
					pw = sc.next();
					
					//arUserCnt[choice - 1] : �ش� ������ ȸ����ŭ�� �ݺ�
					for (int i = 0; i < arCustomerCnt[choice - 1]; i++) {
						//�α��� �˻�
						if(arrBank[choice - 1][i].account.equals(account)
								&& arrBank[choice - 1][i].pw.equals(pw)) {
							//�α��� ������ check�� true
							check = true;
							System.out.println("������ : " + arrBank[choice - 1][i].name);
							System.out.println("���¹�ȣ : " + arrBank[choice - 1][i].account);
							System.out.println("���� �ܾ� : " + arrBank[choice - 1][i].getBalance() + "��");
							break;
						}
					}
					if(!check) {
						System.out.println("���¹�ȣ Ȥ�� ��й�ȣ�� Ȯ�����ּ���");
					}
					break;
				default:
					System.out.println(errors);
				}
			}

		}//end while

	}
}
