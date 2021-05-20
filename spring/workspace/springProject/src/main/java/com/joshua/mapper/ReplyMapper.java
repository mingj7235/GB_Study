package com.joshua.mapper;

import com.joshua.domain.ReplyVO;

public interface ReplyMapper {
	
	public int insert (ReplyVO reply) ;
	
	public ReplyVO read (long rno);

}
