package com.koreait.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.koreait.domain.BoardVO;

public interface BoardMapper {
	
	//@Select("SELECT * FROM TBL_BOARD WHERE BNO > 0")
	public List<BoardVO> getList ();
	
	public void insert (BoardVO board);
	
	//인서트를 하면서 셀렉트를 할수 있다. 
	public void insertSelectKey_bno(BoardVO board);
	
	//read() 선언 후 테스트
	public BoardVO read (long bno);
	
	//delete() 선언후 테스트 : 게시글 삭제
	//게시글 삭제 시 1 이상의 값 리턴, 없으면 0 리턴
	public int delete (long bno);
	
	public int update (BoardVO board);
}
