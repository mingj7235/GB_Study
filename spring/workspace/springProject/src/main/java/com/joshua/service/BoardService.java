package com.joshua.service;

import java.util.List;

import com.joshua.domain.BoardVO;
import com.joshua.domain.Criteria;

public interface BoardService {
	
	public List<BoardVO> getList();
	
	public List<BoardVO> getList(Criteria cri);
	
	public int getTotal (Criteria cri);
	
	public void register(BoardVO board);
	
	public BoardVO getBoard (long bno);
	
	public int delete (long bno);
	
	public int update(BoardVO board);
	
}
