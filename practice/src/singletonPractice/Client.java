package singletonPractice;

public class Client {
	public static void main(String[] args) {
		//Singleton s = new Singleton(); //생성자가 private이므로 new를 통해 인스턴스 생성이불가하다. 
		
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		Singleton s3 = Singleton.getInstance();
		
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		
		s1 = null;
		s2 = null;
		s3 = null;
		
	}
}
