package obj;

import java.util.Random;

public class ObjectTest {
	public static void main(String[] args) {
		
		
		String data1 = "ABC";
		String data2 = "ABC";
		String data3 = new String ("ABC");
		String data4 = new String ("ABC");
		
		// == 이면 무조건 주소비교다
		System.out.println(data1 == data2);
		System.out.println("====어떻게 컨스턴트 풀의 주소를 가져오는가? ======");
		System.out.println(data3 == data4);
		System.out.println(data3.intern() == data4.intern());
		System.out.println(data1 == data3.intern());
		System.out.println("==================================");
		System.out.println(data3.equals(data4));
		
		System.out.println("===========");
		System.out.println(data1.hashCode());
		System.out.println(data2.hashCode());
		System.out.println("===========");
		System.out.println(data3.hashCode());
		System.out.println(data4.hashCode());
		System.out.println("===========");
		
		//constant pool의 hashcode값이 나온것이다. 
		//constant pool의 값을 리턴해라!! -> String클래스에서 다 재정의 된 것임 
		
		
		Random r1 = new Random();
		Random r2 = new Random();
		
		System.out.println(r1 == r2);
		r1 = r2;
		System.out.println(r1.equals(r2));
		
		
	}
}
