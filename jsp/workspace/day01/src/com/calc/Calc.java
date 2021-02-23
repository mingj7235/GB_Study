package com.calc;

public class Calc {

	public Calc() {
	}
	
	public int calc (int num1, int num2, String oper) {
		int result = 0;
		
		if(oper.equals("+")) {
			result = num1 + num2;
		}else if (oper.equals("-")) {
			result = num1 - num2;
		}else if (oper.equals("*")) {
			result = num1 * num2;
		}else if (oper.equals("/")) {
			result = num1 / num2;
		}
		
		return result;
		
	}
}
