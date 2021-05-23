package com.joshua.service;

import java.util.List;

import com.joshua.domain.Criteria;
import com.joshua.domain.ReplyPageDTO;
import com.joshua.domain.ReplyVO;

public interface ReplyService {
	
	public int register (ReplyVO reply);
	
	public ReplyVO getReply (Long rno);
	
	public int update (ReplyVO reply);
	
	public int delete (Long rno);
	
	public ReplyPageDTO getListWithPaging (Criteria cri, Long bno);

}
