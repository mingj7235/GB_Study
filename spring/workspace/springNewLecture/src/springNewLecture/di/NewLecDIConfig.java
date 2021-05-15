package springNewLecture.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springNewLecture.di.entity.Exam;
import springNewLecture.di.entity.NewlecExam;

@ComponentScan("springNewLecture.di.ui")
@Configuration
public class NewLecDIConfig {
	@Bean
	//메서드의 이름을 id처럼 사용한다. configuration에서는 메서드는 동사가 아니다.
	public Exam exam () {
		return new NewlecExam();
	}
}
