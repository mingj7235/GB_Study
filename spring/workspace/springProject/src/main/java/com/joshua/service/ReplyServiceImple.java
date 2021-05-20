package com.joshua.service;

import org.springframework.stereotype.Service;

import com.joshua.domain.ReplyVO;
import com.joshua.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class ReplyServiceImple implements ReplyService{
	
	private ReplyMapper mapper;
	
	@Override
	public int register(ReplyVO reply) {
		return mapper.insert(reply);
	}
	
	@Override
	public ReplyVO getReply(long rno) {
		return mapper.read(rno);
	}
}
