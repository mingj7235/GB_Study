package com.koreait.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.koreait.domain.BoardVO;
import com.koreait.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) //테스트 코드가 스프링을 실행
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")//지정된 클래스나 문자열을 이용해서 필요한 객체들을 스프링 내에 객체로 등록
@Log4j
public class BoardMapperTests {
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	
//	@Test
//	public void testGetListWithPaging() {
//		Criteria cri = new Criteria();
//		cri.setPageNum(1);
//		mapper.getListWithPaging(cri).forEach(board -> log.info(board.getBno()));
//	}
	
/*	@Test
	public void update () {
		BoardVO board = new BoardVO();
		board.setBno(3L);
		board.setTitle("수정된 글제목");
		board.setContent("수정된 글 내용");
		board.setWriter("admin");
		
		log.info("UPDATE COUNT : " + mapper.update(board));
	}*/
	
	
	@Test
	public void testDelete () {
		long bno = 2L;
		log.info("delete count : " + mapper.delete(3670011L));
//		log.info("delete count : " + mapper.delete(bno));
	}
	
	//read 테스트
/*	@Test
	public void testRead () {
		long bno = 2L;
		log.info(mapper.read(bno));
	}*/
	
	//2중 sql문 해서 보드넘버 가져오기 테스트
/*	@Test
	public void insertSelectKey_bno() {
		
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성한 글 제목2");
		board.setContent("새로 작성한 글 내용2");
		board.setWriter("newbie2");
		
		mapper.insertSelectKey_bno(board);
		log.info(board);
	}*/
	
	
/*	@Test
	public void testInsert() {
		//메소드안에서는 의존성 주입이안된다. 전역변수에만 의존성을 주입하는거싱다. 그러므로 메소드안에서는 new를 해주는것이다.
		//의존성은 해당 클래스의 필드에만 적용되므로 메소드 안에서는 new로 할당해야하는 것이다. 
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성한 글 제목");
		board.setContent("새로 작성한 글 내용");
		board.setWriter("newbie");
		
		mapper.insert(board);
		log.info(board);
	}
*/	
/*	@Test
	public void testGetList () {
		//람다식
		mapper.getList().forEach(board -> log.info(board));
	}*/
}
