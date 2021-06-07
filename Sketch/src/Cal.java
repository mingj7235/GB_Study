import java.util.Scanner;

public class Cal {
	
	public int plus (int num1, int num2) {
		
		return num1 + num2;
	}
	
	public int minus (int num1, int num2) {
		
		return num1 - num2;
	}
	
	public int multi (int num1, int num2) {
		
		return num1 * num2;
	}
	
	public String div (int num1, int num2) {
		
		String result = "";
		if (num2 == 0) {
			result = "0으로 나눌수 없음 닝겐";
		} else {
			result = num1 / num2 + "";
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Cal cal = new Cal();
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		
		while (flag) {
			String menues = "1. 덧셈 2. 뺄셈 3. 곱셈 4. 나눗셈";
			System.out.println("계산기임\n"
					+ "메뉴 선택하셈 " + menues);
			
			choice = sc.nextInt();
			
			switch (choice) {
			case 1: {
				System.out.println("덧셈입니다. 두개의 숫자를 순서대로 적어주세요");
				int num1, num2;
				num1 = sc.nextInt();
				num2 = sc.nextInt();
				int result = cal.plus(num1, num2);
				String check = "";
				System.out.println("결과 : " + result);
				System.out.println("계산기를 다시 실행시키시겠습니까? (y/n)");
				check = sc.next();
				if(check.equals("y") || check.equals("Y")) {
					flag = true;
				}else {
					System.out.println("계산기를 종료합니다");
					flag = false;
				}
				
				
			}
			default:
				
			}
			
			
		}
		
		
	}
	
}















