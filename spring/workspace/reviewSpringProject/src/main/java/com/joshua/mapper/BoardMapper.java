package com.joshua.mapper;

import java.util.List;

import com.joshua.domain.BoardVO;

public interface BoardMapper {
	public List<BoardVO> getList ();
	
	public void insert(BoardVO board);
}
