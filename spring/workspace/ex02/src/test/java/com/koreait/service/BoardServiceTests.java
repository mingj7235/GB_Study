package com.koreait.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.koreait.domain.BoardVO;
import com.koreait.persistence.JDBCTests;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) //테스트 코드가 스프링을 실행
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")//지정된 클래스나 문자열을 이용해서 필요한 객체들을 스프링 내에 객체로 등록
@Log4j
public class BoardServiceTests {
	
	//BoardServiceImple이 아니라 BoardService를 주입하는 이유는 유연하게 쓰기 위함이다
	//느슨한 결합성을 위해서 사용
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
/*	@Test
	public void testExist() {
		assertNotNull(service);
		log.info(service);
	}*/
	
	@Test
	public void testList() {
		service.getList();
	}
	
	
//	@Test
//	public void testRegister() {
//		BoardVO board = new BoardVO();
//		
//		service.register(board);
//	}
}
