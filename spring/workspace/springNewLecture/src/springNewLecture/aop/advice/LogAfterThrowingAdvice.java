package springNewLecture.aop.advice;

import org.springframework.aop.ThrowsAdvice;

public class LogAfterThrowingAdvice implements ThrowsAdvice{
	//throwsAdvice는 구현할 메소드가 정해질 수 가 없다.
	//왜냐하면, 어떠한 예외가 발생할지 모르기때문이다.
	//그 예외에 따라 메소드의 인자가 다르기때문이다. 
	
	public void afterThrowing(IllegalArgumentException e) throws Throwable {
		//예외에 따라서 매개변수 예외 클래스가 달라진다. 
		//현재는 임의로 IllegalArgumentException을 주어서 넘겼다. (program의 total메소드)
		System.out.println("예외가 발생하였습니다." + e.getMessage());
	}
	
}
