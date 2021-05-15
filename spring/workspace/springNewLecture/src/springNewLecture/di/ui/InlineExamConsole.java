package springNewLecture.di.ui;

import org.springframework.beans.factory.annotation.Autowired;

import springNewLecture.di.entity.Exam;

public class InlineExamConsole implements ExamConsole {
	
	private Exam exam;
	
	public InlineExamConsole() {
	}
	
	public InlineExamConsole(Exam exam) {
		this.exam = exam;
	}

	@Override
	public void print() {
		System.out.printf("total is %d, avg is %f\n", exam.total(), exam.avg());
	}
	
	@Autowired //자동으로 객체를 연결해달라! setting.xml 의 설정을 가져와준다.
	@Override
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
}
