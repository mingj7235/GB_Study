package com.koreait.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.koreait.domain.Criteria;
import com.koreait.domain.ReplyVO;

public interface ReplyMapper {
	
	public int insert(ReplyVO reply);
	
	public ReplyVO read (Long rno);
	
	public int delete (Long rno);
	
	public int update (ReplyVO reply);
	
	/*
	 * 기존의 게시물 페이징 처리 + 특정 게시물 번호를 전달해야한다. -> Criteria와 bno를 넘긴것이다.
	 * MyBatis는 두 개 이상의 데이터를 파라미터로 전달하기 위해서는
	 * 별도의 객체를 구성하거나 Map을 이용했다. 
	 * 그런데 또 어노테이션을 이용하는 방법이있다 -> @Param
	 * 즉, 3가지 방버이 있는것이다!
	 * @Param을 담아서 보낼거면 key값을 알려줘야한다. 그러므로 매개에 키를 넣어주는것이다.! 이걸MyBatis가 아는거다.
	 * 이 key값을 활용하여 MyBatis에서 사용하는것이다.
	 * */
	public List<ReplyVO> getListWithPaging (@Param("cri") Criteria cri, @Param("bno") Long bno); //mapper.xml에서 매개변수의 필드를 사용함. 페이징 처리위해서 cri가 필요하다! 
	public int getTotal (Long bno);
	
	
	
	
//	public int insert(ReplyVO reply) ;
//	
//	public ReplyVO read(Long rno);
//	
//	public List<ReplyVO> getListWithPaging(Long bno);
//	
//	public int delete(Long rno);
//	
//	public int update (ReplyVO reply);
}
