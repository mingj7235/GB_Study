package com.joshua.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.joshua.domain.Criteria;
import com.joshua.domain.ReplyPageDTO;
import com.joshua.domain.ReplyVO;

public interface ReplyMapper {
	
	public int insert (ReplyVO reply) ;
	
	public ReplyVO read (Long rno);
	
	public int update (ReplyVO reply);
	
	public int delete (Long rno);
	
	public List<ReplyVO> getListWithPaging (@Param("cri") Criteria cri, @Param("bno") Long bno);
	
	public int getTotal(Long bno);
}
