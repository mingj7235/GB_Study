package springNewLecture.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springNewLecture.aop.entity.Exam;
import springNewLecture.aop.entity.NewlecExam;

public class Program {
	public static void main(String[] args) {
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("springNewLecture/aop/setting.xml");

		Exam exam = (Exam) context.getBean("exam"); //setting.xml에있는 proxy bean을 가져온다.
		
		System.out.printf("total is %d\n", exam.total()); //빵또아처럼 AOP로 꽂은 로직
		System.out.printf("avg is %f\n", exam.avg()); //빵또아처럼 AOP로 꽂은 로직
		
		
		//java configuration 을 사용하겠다라고 하면 이걸로 설정
//		ApplicationContext context =
//				new AnnotationConfigApplicationContext(NewLecDIConfig.class);

		
		
		
		
		/*Exam exam = new NewlecExam(1,1,1,1);
		//proxy는 곁다리 업무를 포함하고 있다. 즉 가짜 라고 생각하면된다.
		Exam proxy = (Exam) Proxy.newProxyInstance(NewlecExam.class.getClassLoader(), //실제로 load할 객체 
				new Class[] {Exam.class}, //interfaces즉, load할 객체가 다수의 인터페이스를 구현할수 있으므로 배열로
				new InvocationHandler() { // 3번재 매개변수는 곁다리 업무를 꽂는 곳이다. 익명클래스로 구현한다.
					
					@Override //invoke가 핵심이다. 여기서 코드를 작성해준다.
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						long start = System.currentTimeMillis();
							
						//여기에실제 업무에 대한 로직을 쓰는 것이다. 빵또아느낌! 
						//그것이 invoke의 2번째 매개변수인 method다
						
						Object result = method.invoke(exam, args); // exam은 실제로 업무를 실행하는 객체
						
						long end = System.currentTimeMillis();
						
						String message = (end - start) + "ms 걸렸습니다.";
						System.out.println(message);
						
						return result;
					}
				}
			); */
		/*System.out.printf("total is %d\n", proxy.total()); //빵또아처럼 AOP로 꽂은 로직
		System.out.printf("total is %d\n", exam.total()); //실제로직
		System.out.printf("avg is %f\n", proxy.avg()); //빵또아처럼 AOP로 꽂은 로직
		System.out.printf("avg is %f\n", exam.avg()); //실제로직
		*/
		
	}
}
