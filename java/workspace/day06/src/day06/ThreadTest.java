package day06;

public class ThreadTest {
	public static void main(String[] args) {
		
		Runnable t1 = new Thread2("?"); //업케스팅
		Thread2 t2 = new Thread2("!");
		
		//start()메소드로 스케쥴하기 위해서 Thread타입 객체가 필요하다.
		//Thread 생성자에 run메소드가 재정의된 객체를 전달해주면
		//스케쥴링 시 해당 run메소드가 자원으로 할당된다. 
		Thread thread1 = new Thread(t1);
		Thread thread2 = new Thread(t2);
		
		thread1.start();
		thread2.start();
		
		
		
		
		
		
		//Thread1 확인
		
//		Thread1 t1 = new Thread1("☆");
//		Thread1 t2 = new Thread1("♥");
//		
////		t1.run();
////		t2.run();
//		
//		//start는 멀티스레드를 스케쥴링해준다
//		
//		t1.start();
//		t2.start();
//
//		//먼저사용할 쓰레드에 join을 해주면 나머지를 대기상태로 만들어주고. 실행한다. 
//		try {
//			//먼저 사용할 스레드에 join메소드를 사용하면
//			//다른 스레드는 전부 대기상태로 전환되며, 해당 스레드가 모두 종료되어야
//			//다른 스레드가 실행된다. 
//			t1.join();
//			t2.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println("메인쓰레드 종료");
//		//메인쓰레드가 항상 우선순위가 높기때문에 
		
	}
}
