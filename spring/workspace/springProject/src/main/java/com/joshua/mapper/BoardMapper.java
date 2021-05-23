package com.joshua.mapper;

import java.util.List;

import com.joshua.domain.BoardVO;
import com.joshua.domain.Criteria;

public interface BoardMapper {
	public List<BoardVO> getList();
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	public int getTotal (Criteria cri);
	
	public void insert (BoardVO board);
	
	public void insertSelectKey_bno(BoardVO board);
	
	public BoardVO read (Long bno);
	
	public int delete (Long bno);
	
	public int update (BoardVO board);
	

}
