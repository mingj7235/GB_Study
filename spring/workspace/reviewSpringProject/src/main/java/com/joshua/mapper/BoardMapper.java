package com.joshua.mapper;

import java.util.List;

import com.joshua.domain.BoardVO;
import com.joshua.domain.Criteria;

public interface BoardMapper {
	public List<BoardVO> getList ();
	
	public List<BoardVO> getListWithPaging (Criteria cri);
	
	public void insert(BoardVO board);
}
