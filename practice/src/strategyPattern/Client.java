package strategyPattern;

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
				
		
		Soldier rambo = new Soldier();
		
		rambo.runContext("총입니다 \n");
		rambo.runContext("활입니다 \n");
		rambo.runContext("도끼입니다 \n");
		
		
		
	}
}
