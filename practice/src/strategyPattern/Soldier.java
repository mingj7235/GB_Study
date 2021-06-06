package strategyPattern;

public class Soldier {
	void runContext (String weaponSound, String practice, int num1, int num2) {
		//	num1 num2 => integer plus method in rusS
		System.out.println("test Start ");
		executeWeapon(weaponSound, practice).runStrategy();
		executeWeapon(weaponSound, practice).runStrategy();
		executeWeapon(weaponSound, practice).runStrategyPractice();
		System.out.println("test finished");
	}
	
	private Strategy executeWeapon (final String weaponSound, String practice, int num1, int num2) {
		return new Strategy () {
			@Override
			public void runStrategy() {
				System.out.println(weaponSound);
			}
			
			@Override
			public void runStrategyPractice() {
				System.out.println(practice);
			}
			
			@Override
			public void runStrategyExectution() {
				int result = num1 + num2;
				
				System.out.println(result);
			}
		};
	}
	
	private Strategy executeWeapon (String s1, String s2) {
		return new Strategy() {
			
			@Override
			public void runStrategyPractice() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void runStrategyExectution() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void runStrategy() {
				// TODO Auto-generated method stub
				
			}
		};
	}
}
