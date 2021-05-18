package com.joshua.service;

import java.util.List;

import com.joshua.domain.BoardVO;
import com.joshua.domain.Criteria;

public interface BoardService {
	
	public List<BoardVO> getList();
	
	//override
	public List<BoardVO> getList(Criteria cri);
	
	public void register(BoardVO board);
	
	public int getTotal (Criteria cri);
	
}
