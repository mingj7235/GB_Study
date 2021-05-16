package springNewLecture.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class LogAfterReturningAdvice implements AfterReturningAdvice{
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		//returnValue가 있는 이유는 
		//핵심로직에서 리턴된 값을 활용할 수 있기 때문이다. 
		
		System.out.println("returnValue : " + returnValue + ", method : " + method.getName());
	}
}
