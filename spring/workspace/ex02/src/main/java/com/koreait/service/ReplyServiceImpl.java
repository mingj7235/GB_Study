package com.koreait.service;

import org.springframework.stereotype.Service;

import com.koreait.domain.Criteria;
import com.koreait.domain.ReplyPageDTO;
import com.koreait.domain.ReplyVO;
import com.koreait.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor //ReplyService(ReplyMapper mapper) 로 생성자 초기화!
public class ReplyServiceImpl implements ReplyService {
	
	private ReplyMapper mapper;
	
	@Override
	public int register(ReplyVO reply) {
		log.info("register...." + reply);
		return mapper.insert(reply);
	}

	@Override
	public ReplyVO get(Long rno) {
		log.info("get...." + rno);
		
		return mapper.read(rno);
	}

	@Override
	public int remove(Long rno) {
		log.info("remove.." + rno);
		
		return mapper.delete(rno);
	}

	@Override
	public int modify(ReplyVO reply) {
		log.info("modify...." + reply);
		return mapper.update(reply);
	}

	@Override
	public ReplyPageDTO getListWithPaging(Criteria cri, Long bno) {
		log.info("get reply list of a board..." + bno);
		
		//댓글을 구현하기 위해 필요한 두개의 요소를 ReplyPageDTO에 전달한다. 
		return new ReplyPageDTO(mapper.getTotal(bno), mapper.getListWithPaging(cri, bno));
	}
	//테스트하는거 복습할때 해보자! 

}
















