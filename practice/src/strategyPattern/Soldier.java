package strategyPattern;

public class Soldier {
	void runContext (String weaponSound) {
		System.out.println("전투시작");
		executeWeapon(weaponSound).runStrategy();
		System.out.println("전투끝");
	}
	
	private Strategy executeWeapon (final String weaponSound) {
		return new Strategy () {
			@Override
			public void runStrategy() {
				System.out.println(weaponSound);
			}
		};
	}
}
