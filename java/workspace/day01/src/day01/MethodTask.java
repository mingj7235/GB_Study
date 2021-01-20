package day01;

import java.util.Scanner;

public class MethodTask {
	
	//1~n까지의 합을 println()으로 출력하는 메소드
	/**
	 * 
	 * @param n
	 * @throws ArithmeticException
	 */
	public void sum (int n) {
		if (n < 1) {
			throw new ArithmeticException();
			//예외 발생시키기
		}
		
		int result = 0;
		for (int i = 0; i < n; i++) {
			result += (i+1);
		}
		
		System.out.println("\n숫자의 합 : " + result);
	}
	
	//나눗셈을 구해주는 메소드
	
	/**
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 * @throws ArithmeticException
	 */
	public double divide (double num1, double num2) {
		return num1/ num2;
	}
	
	public static void main(String[] args) {
		MethodTask mt = new MethodTask();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자를 입력해주세요");
		int n = sc.nextInt();
		try {
			mt.sum(n);
		} catch (ArithmeticException e) {
			System.out.println("1보다 큰 수를 입력해주세요");
		}
		
		
		System.out.println("정수를 두개 입력해주세요 ");
		try {
			mt.divide(10, 20);
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수없습니다. ");
		}
		
	}
}
