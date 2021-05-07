package com.koreait.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.koreait.mapper.TimeMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) //테스트 코드가 스프링을 실행 (WAS가 아니라)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")//지정된 클래스나 문자열을 이용해서 필요한 객체들을 스프링 내에 객체로 등록
@Log4j
public class TimeMapperTests {
	
	/*
	 * MyBatis는 내부적으로 JDBC의 PreparedStatement를 이용해서 SQL을 처리한다.
	 * 따라서 SQL에 전달되는 파라미터는 JDBC에서와 같이 '?' 로 치환되어 처리된다. 
	 * 복잡한 SQL의 경우 '?'로 나오는 값이 제대로 되었는 지 확인하기 쉽지 않고 실행된 SQL의 내용을
	 * 정확히 확인하기 어렵기 때문에 log4jdbc-log4j2 라이브러리를 사용하여 어떤 값인지를
	 * 정확히 확인한다. 즉, 점점 편하게 개발하기위해 라이브러리를 사용하는 것이다.  
	 */
	
	@Setter (onMethod_ = @Autowired)
	private TimeMapper timeMapper;
	
	@Test
	public void testGetTime () {
		log.info(timeMapper.getTime2());
	}
//	@Test
//	public void testGetTime () {
//		log.info(timeMapper.getTime());
//	}
}
