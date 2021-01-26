package obj;

import java.util.Random;

public class ObjectTest {
	public static void main(String[] args) {
		
		
		String data1 = "ABC";
		String data2 = "ABC";
		String data3 = new String ("ABC");
		String data4 = new String ("ABC");
		
		// == �̸� ������ �ּҺ񱳴�
		System.out.println(data1 == data2);
		System.out.println("====��� ������Ʈ Ǯ�� �ּҸ� �������°�? ======");
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
		
		//constant pool�� hashcode���� ���°��̴�. 
		//constant pool�� ���� �����ض�!! -> StringŬ�������� �� ������ �� ���� 
		
		
		Random r1 = new Random();
		Random r2 = new Random();
		
		System.out.println(r1 == r2);
		r1 = r2;
		System.out.println(r1.equals(r2));
		
		
	}
}