package com.koreait.app.board.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.app.board.vo.BoardVO;
import com.koreait.mybatis.config.SqlMapConfig;

public class BoardDAO {
	private static final int KEY = 3;
	
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession session;
	
	public BoardDAO() {
		//세션 팩토리로 세션을 열어주고 모든 쿼리문은 auto 커밋으로 설정
		session = sessionf.openSession(true);
	}
	
	//페이지 별 게시글 목록
	public List<BoardVO> getBoardList(int startRow, int endRow) {
		HashMap<String, Integer> pageMap = new HashMap<>();
		
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		
		return session.selectList("Board.listAll", pageMap);
	}
	
	public int getBoardCnt() {
		return session.selectOne("Board.getBoardCnt");
	}
	
	public void updateReadCount(int boardNum){
		session.update("Board.updateReadCount", boardNum);
	}
}














