package aop003;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

public class MyAspect {
	
	public void before (JoinPoint joinPoint) { //joinpoint는 before 어노테이션에서 선언된 메서드 runSomthing()을 의미함 
		System.out.println("얼굴 인식 확인 : 문을 개방하라");
	}
	
	public void lockDoor (Joinpoint joinPoint) {
		System.out.println("주인님 나갔다 : 문잠그자! ");
	}
	
}
