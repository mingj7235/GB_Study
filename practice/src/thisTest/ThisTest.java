package thisTest;


class PenguinTest {
	int var = 10;
	int testNum = 20;
	
	void test () {
		int var = 20;
		testNum = 30; //지역변수가 아니라 객체변수의 값을 바꾼것임 즉, 초기화 
		
		System.out.println(var);
		System.out.println(this.var); //객체를 지칭한다. 객체!! 객체!!! 객체!!!!!
		
		System.out.println(testNum);
		System.out.println(this.testNum); //이건 객체 변수를 지역에서 재할당한것이다. 
		
	}
}

public class ThisTest {
	public static void main(String[] args) {
		PenguinTest je = new PenguinTest();
		je.test();
	}
}
