package com.joshua.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.joshua.domain.BoardVO;
import com.joshua.domain.Criteria;
import com.joshua.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class BoardServiceImple implements BoardService{
	
	//AllArgsConstructor 어노테이션을 통해서 생성자로 초기화 시킴 
	private BoardMapper mapper;
	
	@Override
	public List<BoardVO> getList() {
		return mapper.getList();
	}
	
	@Override
	public List<BoardVO> getList(Criteria cri) {
		return mapper.getListWithPaging(cri);
	}

	@Override
	public void register(BoardVO board) {
		mapper.insert(board);
	}

}
