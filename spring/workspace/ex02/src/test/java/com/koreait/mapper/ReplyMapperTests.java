package com.koreait.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.koreait.domain.BoardVO;
import com.koreait.domain.Criteria;
import com.koreait.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import oracle.net.aso.r;

//SpringRunner는 SpringJUnit4ClassRunner의 자식이며
//4.3버전 이상부터 사용가능한 확장판이다.
@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;

	@Setter(onMethod_ = @Autowired)
	private BoardMapper board;
	
	//게시글 번호 배열
	//테스트용으로 bno을 보내준다.

	private Long[] arBno = {3670020L,3670001L, 3670008L, 3670007L, 3670006L};
//	

//	@Test
//	public void testUpdate () {
//		ReplyVO reply = new ReplyVO();
//		reply.setReply("댓글수정");
//		reply.setRno(10L);
//		log.info("update count : " + mapper.update(reply));
//		
//	}
	
//	@Test
//	public void testDelete() {
//		log.info(mapper.delete(1L));
//	}
	
//	@Test
//	public void testDelete () {
//		log.info(mapper.delete(4L));
//	}
	
	
//	@Test
//	public void testGetListWithPaging() {
//		mapper.getListWithPaging(arBno[0]).forEach(reply -> log.info(reply));
//		
//	}
	
	//그 게시물의 전체 댓글 목록 불러오기
//	@Test
//	public void testGetListWithPaging () {
//		mapper.getListWithPaging(arBno[0]).forEach(reply -> log.info(reply));
//		
//	}
	
	
//	@Test
//	public void testRead() {
//		log.info(mapper.read(1L));
//
//	@Test
//	public void testRead () {
//		log.info(mapper.read(2L));
//	}
	
	
//	@Test
//	public void testInsert () {
//		List<BoardVO> boards = board.getListWithPaging(new Criteria(1, 5));
//
//		//5개의 게시글에 2개씩 댓글달기 (IntStream을 사용해서 반복한다)
//		IntStream.rangeClosed(1, 20).forEach(i -> {
//			ReplyVO reply = new ReplyVO();
//			reply.setReply("댓글 테스트" + i);
//			reply.setReplyer("댓글 단 사람" + i);
//			//0~n : n+1로 나눈 나머지
//			reply.setBno(boards.get(i % 5).getBno()); //이게 list의 인덱스가 되어야한다.
//			mapper.insert(reply);
//		});
//	}

//	@Test
//	public void testListfor () {
//		List<BoardVO> boards = board.getListWithPaging(new Criteria(1, 5));
//		
//		IntStream.rangeClosed(1, 10).forEach(i -> {
//			ReplyVO reply = new ReplyVO();
//			reply.setReply("추가된 댓글" + i);
//			reply.setReplyer("추가된 댓글쓴사람" + i);
//			reply.setBno(boards.get(i % 5).getBno());
//			mapper.insert(reply);
//		});
//	}
	
	
//	@Test
//	public void testInsert () {
//		
//		ReplyVO reply = new ReplyVO();
//		reply.setBno(arBno[1]);
//		for (int i = 0; i < 5; i++) {
//			reply.setReply("댓글입니다" + i);
//			reply.setReplyer("댓글달사람" +i);
//			log.info(mapper.insert(reply));
//		}
//		
//	}
	
//	
//	@Test
//	public void testMapper() {
//		log.info(mapper);
//	}
}
