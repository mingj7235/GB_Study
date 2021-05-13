package springNewLecture.di;

import springNewLecture.di.entity.Exam;
import springNewLecture.di.entity.NewlecExam;
import springNewLecture.di.ui.ExamConsole;
import springNewLecture.di.ui.GridExamConsole;
import springNewLecture.di.ui.InlineExamConsole;

public class Program {
	public static void main(String[] args) {
		
		Exam exam = new NewlecExam();
		ExamConsole console = new InlineExamConsole(exam); //이게 의존성주입이다. exam을 조립한다. 
															//이걸 내가 직접하려면 코드를 이렇게 작성해야하는데, 이걸 대신해주는게 spring이다. 
//		ExamConsole console = new GridExamConsole(exam);	//이 작업을 spring이 대신해줄것이다. 
		console.print();
		
		
	}
}
