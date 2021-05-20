package com.joshua.service;

import com.joshua.domain.ReplyVO;

public interface ReplyService {
	
	public int register (ReplyVO reply);
	
	public ReplyVO getReply (long rno);

}
