package springNewLecture.di;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springNewLecture.di.entity.Exam;
import springNewLecture.di.entity.NewlecExam;
import springNewLecture.di.ui.ExamConsole;

public class Program {
	public static void main(String[] args) {
		
		/* 스프링에게 지시하는 방법으로 코드를 변경 -> 그 지시서가 바로 xml이다.
		Exam exam = new NewlecExam();
		Exam exam = new NewlecExam(10, 10, 10, 10); //생성자로 값을 생성하는것
//		ExamConsole console = new InlineExamConsole(exam); //이게 의존성주입이다. exam을 조립한다. 
															//이걸 내가 직접하려면 코드를 이렇게 작성해야하는데, 이걸 대신해주는게 spring이다. 
		ExamConsole console = new GridExamConsole();	//이 작업을 spring이 대신해줄것이다. 
		
		console.setExam(exam);
		*/
		
		
//		ApplicationContext를 통해 스프링 지시서가 잘 전달되었다면,
		//setting.xml을 통해 객체가 생성이되고, 이것들이 IoC컨테이너에 잘 담겨있을것이다.
		/*
		 * 꺼내서 사용가능하다!!
		 * 그 그릇, 즉 IoC의 이름은 context로 선언된것이다. 
		 * */
//		ApplicationContext context = 
//				new ClassPathXmlApplicationContext("springNewLecture/di/setting.xml");
		
		//java configuration 을 사용하겠다라고 하면 이걸로 설정
		ApplicationContext context =
				new AnnotationConfigApplicationContext(NewLecDIConfig.class);
		
		
		//Exam exam = context.getBean(Exam.class);
		//System.out.println(exam.toString());
		
		ExamConsole console = (ExamConsole) context.getBean("console");
		//ExamConsole console = context.getBean(ExamConsole.class);
		console.print();
		
		//List<Exam> exams = (List<Exam>) context.getBean("exams"); //new ArrayList<>();
		//exams.add(new NewlecExam(1,1,1,1));
		
//		for(Exam e : exams) {
//			System.out.println(e);
//		}
				
		
	}
}















