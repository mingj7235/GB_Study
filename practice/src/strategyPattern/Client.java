package strategyPattern;

import java.util.Iterator;

public class Client {
	public static void main(String[] args) {
//		Strategy strategy = null;
//		Soldier rambo = new Soldier();
//		
//		strategy = new StrategyGun();
//		rambo.runContext(strategy);
//		
//		System.out.println();
//		
//		strategy = new StrategyBow();
//		rambo.runContext(strategy);
//		
//		System.out.println();
//		
//		strategy = new StrategySword();
//		rambo.runContext(strategy);
				
		
//		Soldier rambo = new Soldier();
//		
//		rambo.runContext("stratege", "practice");
//		
//		for (int i = 1; i < 10; i++) {
//			for (int j = 1; j < 10; j++) {
//				int result = i * j ;
//				System.out.println(i + "x" + j + "=" + result);
//			}
//		}
		
		
//		for(int i = 1; i < 10; i ++) {
//			System.out.print(" ");
//			for (int j = 10; j > i ; j --) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
//		for(int i = 1; i < 10; i ++) {
//			System.out.print("*");
//			for (int j = 1; j < i ; j ++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		
		for (int i=1 ; i < 10 ; i ++) {
			for (int j = 10 ; j > i ; j --) {
				System.out.print(j);
				System.out.print(" ");
			}
			System.out.println();
		}
		
	}
}
