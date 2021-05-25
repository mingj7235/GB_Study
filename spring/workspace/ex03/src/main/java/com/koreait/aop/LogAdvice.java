package com.koreait.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect //aop다! 라고 알려주는것임
@Log4j
@Component //객체를 빈으로 사용하기 위해서 ! -> bean으로 스캔하기 위해서 root-context로가야한다. 
public class LogAdvice {
	//1.
	//AOP를 사용하기 위해서는 종단관심사에 Proxy설정이 되어야한다.
	//이는 root-context.xml에 auto로 설정을 해놓는다.
	
	//2.
	//횡단관심사에서 작성한 모듈은 Proxy설정이 되어있는 Target(주객체)에게 
	//언제 결합해야 되는 지를 알려주어야 하는데, 이를 pointcut이라고 한다. 
	
	//3.
	//Target(주객체)에 있는 종단관심사가 호출되면 pointcut에 작성된 Target(매소드)의
	//전체 정보를 가지고 올 수 있는 객체가 바로 JoinPoint이다. 
	
	//즉, joinpoint는 메소드의 전체 정보를 가지고 올 수 있는 객체다. 
	// 바로 그 때 ! 조인이 된다는 의미로 joinpoint라고 한다. pointcut과는 다르다.
	//pointcut은 결합이 될 때의 시점을 의미하는 것이다.
	//joinpoint는 실제로 결합이 되는 지점을 의미한다. 즉, 결합이되어잇으므로 결합된 전체 정보를 다같이 가져올 수 있다. 
	
	
	//execution.... 은 AspectJ의 표현식이며, 맨 앞의 * 은 접근제어자를 의미하고,
	//맨 마지막의 *은 클래스의 이름과 메소드의 이름을 의미한다.
	//..은 0개 이상이라는 의미이다. (매개변수)
	
	//모든 접근 제어자의 SampleService이름이 붙은 모든 클래스에서 모든 메소드 중 
	//매개변수가 0개 이상! 이라는 뜻이다. 
	
	//포인트 컷은 Before !! 
	@Before ("execution(* com.koreait.service.SampleService*.*(..))")
			//소괄호 있는 것을 실행해라! 
			//실행할건데, 접근자 상관없이, 이 경로에 있는 클래스 안에서 이름이 어떤 메소드든 상관없이, 매개변수 상관없이 메소드가 실행되면,
			//logBefore()를 실행해!
	
	public void logBefore () {
		log.info("=======before======");
	}
	
	
	@After ("execution(* com.koreait.service.SampleService*.*(..))")
	public void logAfter () {
		log.info("=======after======");
	}
	
	@AfterReturning ("execution(* com.koreait.service.SampleService*.*(..))")
	public void logAfterReturning () {
		log.info("=======afterReturning======");
	}
	
	//args (매개변수명, 매개변수명, ...)
	//호출된 종단관심사의 매개변수를 횡단관심사로 전달 받을 때에는 매개변수의 개수와 타입에 맞게
	//작성해 주어야 하며, args에 해당 매개변수의 이름을 동일하게 작성해주어야 한다. 
																						//메소드의 매개변수명을 매핑하기위해 args를 넣어
	@Before ("execution (* com.koreait.service.SampleService*.doAdd(String, String)) && args(str1, str2)")
	public void logBeforeWithParam(String str1, String str2) { //매개변수 자동으로 매핑이 되어서 들어감
		log.info("str1 :"  + str1);
		log.info("str2 :"  + str2);
	}
	
	//매개변수로 어떤예외를 받을지를 적어줘야한다.
	//pointcut :타겟이라는게 있는데, 타겟을 처리해주는게 pointcut이다. 
	
	//pointcut은 횡단관심사와 종단관심사의 결합되는 지점을 결정하는 것이다. 
	//proxy가 언제 연결해줄까? 라는 것에 답을 주는 것이 pointcut이다. 
	//pointcut이 타겟(pointcut에 설정한 메소드)을 설정해주고,
	
	
	@AfterThrowing (pointcut ="execution(* com.koreait.service.SampleService*.*(..))", throwing ="exceptionhaha")
	public void logException(Exception exceptionhaha) {
		log.info("Exception...");
		log.info("exception: " + exceptionhaha);
	}
	
	@Around("execution(* com.koreait.service.SampleService*.*(..))") 
	public Object logTime(ProceedingJoinPoint pjp) {//@Around를 썼을때 해당 메소드에대한 모든 정보를 가지고 있다. 즉, 타겟에 대해 관리가가능하다. 
		long start = System.currentTimeMillis();
		log.info("핵심 로직 : " + pjp.getTarget()); //타겟을 가져온다.
		log.info("파라미터 : " + Arrays.toString(pjp.getArgs())); //pjp.getArgs()의 리턴은 배열이다. 파라미터가 몇개인지 모르니까 배열값임
	
		Object result = null;
		
		try {
			result = pjp.proceed();//이걸 통해서 로직을 실행해줌 //produce는 타겟의 리턴값이다. 
							//즉, 호출된 타겟을 실행하는 것이다! 
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		long end = System.currentTimeMillis();
		
		log.info("걸린시간 : " + (end - start));
		
		return result;
	}
	
}

















