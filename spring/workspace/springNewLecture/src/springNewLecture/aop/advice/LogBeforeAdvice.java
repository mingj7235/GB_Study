package springNewLecture.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class LogBeforeAdvice implements MethodBeforeAdvice{
	
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		
		//before advice는 자동적으로 앞에 꽂히기때문에 그 로직만 만들어주면 core concern은 안써도된다.
		System.out.println("앞에서 실행될 로직");
		
	}
	
}
