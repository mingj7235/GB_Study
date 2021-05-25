package com.koreait.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koreait.domain.Criteria;
import com.koreait.domain.ReplyPageDTO;
import com.koreait.domain.ReplyVO;
import com.koreait.mapper.BoardMapper;
import com.koreait.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor //ReplyService(ReplyMapper mapper) 로 생성자 초기화!
public class ReplyServiceImpl implements ReplyService {
	
	private ReplyMapper mapper;
	private BoardMapper board_mapper; //이부분 중요! 
	
	@Transactional //트랜젝션이 2개이상의 쿼리문이면, 하나의 쿼리가 실행되지 않을때 이렇게 해준다. 트랜젝션 2개가 연속적일때 사용된다 
	@Override
	public int register(ReplyVO reply) {
		log.info("register...." + reply);
		
		//두개이상의 트랜젝션 
		board_mapper.updateReplyCnt(reply.getBno(), 1); //amount자리에 1을 넣는것은 쿼리에서 1을 더해주니까! 
		return mapper.insert(reply);
	}

	@Override
	public ReplyVO get(Long rno) {
		log.info("get...." + rno);
		
		return mapper.read(rno);
	}
	
	@Transactional
	@Override
	public int remove(Long rno) {
		log.info("remove.." + rno);
		board_mapper.updateReplyCnt(mapper.read(rno).getBno(), -1); //bno을 rno를 통해서 가져오는방법!! 오오...
		
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
















