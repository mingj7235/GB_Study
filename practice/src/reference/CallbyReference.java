package reference;

public class CallbyReference {
	public static void main(String[] args) {
		Animal ref_a = new Animal();
		Animal ref_b = ref_a;
		
		//Animal()로 한번 주소값이 출력되었으므로 
		//참조변수의 값의 call은 복사가 주소의 변수도복사된것 ! 
		
		ref_a.age = 10;
		ref_b.age = 20;
		
		
		System.out.println(ref_a.age);
		System.out.println(ref_b.age);
		ref_a = null;
		
		System.out.println(ref_a);
		System.out.println(ref_b);
		//reference.Animal@7dc5e7b4
		//reference.Animal@7dc5e7b4
		
	}
}

class Animal {
	
	public int age;
}
