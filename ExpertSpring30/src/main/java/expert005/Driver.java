package expert005;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.log4j.Log4j;

@Log4j
public class Driver {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("expert004/expert004.xml"); //Spring 종합쇼핑몰의 정보 
		
		Car car = context.getBean("car", Car.class); 
		
		
		
		System.out.println(car.getTireBrand());
		
	}
}
