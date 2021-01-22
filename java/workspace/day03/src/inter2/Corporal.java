package inter2;

public class Corporal implements Soldier{

	@Override
	public void eat() {
		System.out.println("경치를 보며 식사한다. 후임들의 식판을 번갈아 본다.");
	}

	@Override
	public void sleep() {
		System.out.println("잘 잔다. 어디 간다.");
	}

	@Override
	public void salute() {
		System.out.println("ㅊㅅ");
	}

	@Override
	public void work() {
		System.out.println("후임들에게 일을 알려준다. 그러다 어디 간다. ");
	}

}
