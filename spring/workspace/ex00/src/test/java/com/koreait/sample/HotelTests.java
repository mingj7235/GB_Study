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
public class HotelTests {
	@Setter(onMethod_ = @Autowired)
	private Hotel hotel;
	
	@Test
	public void testExist () {
		assertNotNull(hotel);
		
		log.info(hotel);
		log.info("==================");
		log.info(hotel.getChef());
		
	}
}
