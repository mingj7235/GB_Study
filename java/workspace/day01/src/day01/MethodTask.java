package day01;

import java.util.Scanner;

public class MethodTask {
	
	//1~n까지의 합을 println()으로 출력하는 메소드
	
	public void sum (int n) {
		int result = 0;
		for (int i = 0; i < n; i++) {
			result += (i+1);
		}
		
		System.out.println("\n숫자의 합 : " + result);
	}
	
	//나눗셈을 구해주는 메소드
	
	public String divide (double num1, double num2) {
		
		if (num2 != 0) {
			return (num1 / num2)+ "";
		} else {
			return "0으로 나눌 수 없습니다. ";
		}
		
	}
	
	public static void main(String[] args) {
		
		MethodTask mt = new MethodTask();
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력해주세요");
		int n = sc.nextInt();
		
		mt.sum(n);
		
		System.out.println("정수를 두개 입력해주세요 ");
		int num1 = sc.nextInt();
		int num2 = sc. nextInt();
		System.out.println(mt.divide(num1, num2));
		
	}
}
