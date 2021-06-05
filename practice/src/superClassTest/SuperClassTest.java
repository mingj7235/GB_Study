package superClassTest;

class Animal {
	void method () {
		System.out.println("동물");
	}
}

class Bird extends Animal{
	@Override
	void method() {
		super.method();
		System.out.println("조류");
		
	}
}

class Je extends Bird {
	@Override
	void method() {
		super.method();
		System.out.println("제비");
	}
}

class Be extends Je {
	@Override
	void method() {
		super.method();
		System.out.println("ㅠ");
	}
}



public class SuperClassTest {
	public static void main(String[] args) {
		Be je = new Be();
		je.method();
	}
	

}
