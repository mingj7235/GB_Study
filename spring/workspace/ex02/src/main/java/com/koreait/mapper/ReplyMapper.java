package com.koreait.mapper;

import java.util.List;

import com.koreait.domain.ReplyVO;

public interface ReplyMapper {
	
	public int insert(ReplyVO reply);
	
	public ReplyVO read (Long rno);
	
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
