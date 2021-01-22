package inter;

public class ImplTest2 extends SuperImplTest2 implements InterA{
	
	//앞에 InterA로 언급해주면 추상을 가져오고,
	//생략하고 바로그냥 super로가면 자동으로 부모로가져옴 
//	@Override
//	public void printName() {
//		InterA.super.printName();
//	}
	
	public static void main(String[] args) {
		new  ImplTest2().printName();
	}
}
