package com.koreait.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect //aop다! 라고 알려주는것임
@Log4j
@Component //객체를 빈으로 사용하기 위해서 ! -> bean으로 스캔하기 위해서 root-context로가야한다. 
public class LogAdvice {
	
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
																						//메소드의 매개변수명을 매핑하기위해 args를 넣어
	@Before ("execution (* com.koreait.service.SampleService*.doAdd(String, String)) && args(str1, str2)")
	public void logBeforeWithParam(String str1, String str2) { //매개변수 자동으로 매핑이 되어서 들어감
		log.info("str1 :"  + str1);
		log.info("str2 :"  + str2);
	}
}

















