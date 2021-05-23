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
	public int getTotal(Criteria cri) {
		return mapper.getTotal(cri);
	}
	
	@Override
	public void register(BoardVO board) {
		mapper.insertSelectKey_bno(board);
	}
	
	@Override
	public BoardVO getBoard(Long bno) {
		return mapper.read(bno);
	}
	
	
	@Override
	public int delete(Long bno) {
		return mapper.delete(bno);
	}
	
	@Override
	public int update(BoardVO board) {
		return mapper.update(board);
	}
	

	
	
}
