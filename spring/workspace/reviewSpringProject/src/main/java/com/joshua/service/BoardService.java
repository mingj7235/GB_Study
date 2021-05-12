package com.joshua.service;

import java.util.List;

import com.joshua.domain.BoardVO;
import com.joshua.domain.Criteria;

public interface BoardService {
	//게시판 전체 목록
	public List<BoardVO> getList();
	
	//페이지 전달
	public List<BoardVO> getList(Criteria cri);
	
	//게시판 등록
	public void register(BoardVO board);
}
