package inter;

public class ImplTest implements InterA, InterB{
	@Override
	public void printName() {
//		InterA.super.printName();
		InterB.super.printName();
	}
	
	public static void main(String[] args) {
		new ImplTest().printName();
	}
}
