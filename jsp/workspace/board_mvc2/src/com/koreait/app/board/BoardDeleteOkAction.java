package com.koreait.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.board.dao.BoardDAO;

public class BoardDeleteOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		BoardDAO b_dao = new BoardDAO();
		ActionForward forward = new ActionForward();
		
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		int page = Integer.parseInt(req.getParameter("page"));
		
		b_dao.deleteBoard(boardNum);
		
		forward.setRedirect(true);
		forward.setPath(req.getContextPath() + "/board/BoardList.bo?page=" + page);
		
		return forward;
	}

}











