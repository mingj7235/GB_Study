package com.koreait.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) //테스트 코드가 스프링을 실행 (WAS가 아니라)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")//지정된 클래스나 문자열을 이용해서 필요한 객체들을 스프링 내에 객체로 등록
@Log4j //이건 pom.xml에 미리 설정해놓음 syso를 안쓰고 logger를 사용함
public class SampleTests {
	
	@Setter (onMethod_ = @Autowired)
	private Restaurant restaurant;
	
	@Test //테스트 대상이라는 어노테이션임
	public void testExist() {
		assertNotNull(restaurant); //restarunat가 null이 아니어야만 테스트 성공
		
		log.info(restaurant);
		log.info("================");
		log.info(restaurant.getChef());
		
//		INFO : com.koreait.sample.SampleTests - Restaurant(chef=Chef())
//		INFO : com.koreait.sample.SampleTests - ================
//		INFO : com.koreait.sample.SampleTests - Chef()
		
		/*
		 * 1. 테스트 코드가 실행되기 위해서는 스프링 프레임워크가 동작
		 * 2. 동작하는 과정에서 필요한 객체들이스프링에 등록
		 * 3. 의존성 주입이 필요한 객체는 자동으로 주입이 이루어짐
		 */
	}
}
