package inheritencePractice;

public class Penguin extends Animal{
	public String habitat;
	
	public void showHabitat() {
		System.out.printf("%s는 %s에 살아\n", name, habitat);
	}
	
	@Override
	public void showName() {
		System.out.println("엄허\n");
	}
	
	
	public void showName(String yourName) {
		System.out.println(yourName + "입니다");
	}
}
