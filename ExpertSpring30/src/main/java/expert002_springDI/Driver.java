package expert002_springDI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.log4j.Log4j;

@Log4j
public class Driver {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("expert002_springDI/expert002.xml"); //Spring 종합쇼핑몰의 정보 
		
		Car car = context.getBean("car", Car.class); //상품에 해당하는 Car와 Tire를 구매하는 코드
		Tire tire = context.getBean("tire", Tire.class);
		
		car.setTire(tire);
		
		System.out.println(car.getTireBrand());
		
	}
}
