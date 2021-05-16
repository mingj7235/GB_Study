package springNewLecture.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAroundAdvice implements MethodInterceptor{
	//Around 형태의 advice를 구현함 
	//구현해야할 invoke 
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		long start = System.currentTimeMillis();
		
		Object result = invocation.proceed(); //실제 실행되는 로직
		
		long end = System.currentTimeMillis();
		
		String message = (end - start) + "ms 걸렸습니다.";
		System.out.println(message);
		
		return result;
		
	}
}
