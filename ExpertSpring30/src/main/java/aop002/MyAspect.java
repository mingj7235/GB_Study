package aop002;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//@Aspect //이 클래스를 AOP에서 사용하겠다는 의미
public class MyAspect {
	
	//@Before는 대상 메서드 실행전에 이 메서드를 실행하겠다는 것임 즉 Boy의 runSomthing()실행하기 직전에 실행하겠다는 것임 
	//@Before ("execution (* runSomething())")
	public void before (JoinPoint joinPoint) { //joinpoint는 before 어노테이션에서 선언된 메서드 runSomthing()을 의미함 
		System.out.println("얼굴 인식 확인 : 문을 개방하라");
		System.out.println("joinpoint : " + joinPoint);
	}
	
}
