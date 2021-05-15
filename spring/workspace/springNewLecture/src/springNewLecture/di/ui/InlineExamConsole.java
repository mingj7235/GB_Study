package springNewLecture.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import springNewLecture.di.entity.Exam;

public class InlineExamConsole implements ExamConsole {
	
	@Autowired (required = false)
		//required를 false를 주면 xml에서 그 찾는 객체가 없는경우에도
		//실행이된다. 즉, 옵션을 주고싶을때, 분기를 줘서 처리가능하다.
		//원래는 이 옵션을 주지않으면 오류가 난다. 
	@Qualifier("exam1")
	//기본생성자를 통해서 인젝션이 되는것이므로
	//기본생성자가 없으면 인젝션이 되지않는다.
	
	private Exam exam;
	
	public InlineExamConsole() {
		System.out.println("constructor");
	}
	
	//오버로딩된 생성자에 autowired를 사용할경우
	//매개변수에서 지정해야한다.
	//파라미터에서 몇가지의 파라미터가 있을 수 있기때문이다.

	//@Autowired
	public InlineExamConsole(/*@Qualifier("exam1")*/ Exam exam) {
		System.out.println("overloaded constructor");
		this.exam = exam;
	}

	@Override
	public void print() {
		if(exam == null) {
			System.out.printf("total is %d, avg is %f\n", 0, 0.0);
		}else {
			System.out.printf("total is %d, avg is %f\n", exam.total(), exam.avg());
		}
	}
	
	
	
	//@Autowired //자동으로 객체를 연결해달라! setting.xml 의 설정을 가져와준다.
	//근데 autowired는 대체 어떤 근거로 그 객체를 참조하여 세팅해주는가?
	
	/*autowired는 컨테이너에서 참조되는 객체를 즉, 인터페이스 (class)를
	 * 찾아서 참조한다. 그렇다면 동일한 타입이 xml에 선언되어잇다면 어떻게 참조하는가?
	 * 답 : 참조 못한다! 1개만 spring은 찾으려했는데 2개이상이면 식별하지 못한다. 
	 * 즉 모호하기때문에 못한다.
	 * 이럴때는 다시 id를 주어서 id로 명확하게 해주면 바인딩이 된다. 
	 * 그런데 xml에 선언된 id를 계속해서 변경해줘야하면 그것은 편하지 않다.
	 * 그럴때 나온게 바로 @Qualifier다.
	 * 
	 * */
	//@Qualifier ("exam1")
	/*
	 * 이곳에 알맞은 xml bean의 아이디를 지정해주면 올바르게 바인딩이된다.
	 * Autowired는 무엇을 기준으로하는지, 그리고 Qualifier를 왜쓰는지
	 * 이것을 중요하다!
	 * class로 autowired되지만 식별할 때 변수명으로 구분하고,
	 * 그것을 Qualifier로 구분해주는것ㅇ디ㅏ.
	 * */
	@Override
	public void setExam(Exam exam) {
		System.out.println("setter");
		this.exam = exam;
	}
	
}
