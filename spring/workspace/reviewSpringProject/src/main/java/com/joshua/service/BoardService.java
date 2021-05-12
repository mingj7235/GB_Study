package com.joshua.service;

import java.util.List;

import com.joshua.domain.BoardVO;

public interface BoardService {
	//게시판 전체 목록
	public List<BoardVO> getList();
	
	//게시판 등록
	public void register(BoardVO board);
}
