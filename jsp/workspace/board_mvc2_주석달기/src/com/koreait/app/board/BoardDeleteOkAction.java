package com.koreait.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.board.dao.BoardDAO;
import com.koreait.app.board.vo.BoardVO;

public class BoardDeleteOkAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		BoardDAO b_dao = new BoardDAO();
		ActionForward forward = new ActionForward();
		
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		int page = Integer.parseInt(req.getParameter("page"));
		
		b_dao.deleteBoard(boardNum);
		
		forward.setRedirect(true);
		forward.setPath(req.getContextPath() + "/board/boardList.bo?page="+page); //redirect로 날리기때문에 get방식으로 page를 넘긴다.
		
		return forward;
	}
}
