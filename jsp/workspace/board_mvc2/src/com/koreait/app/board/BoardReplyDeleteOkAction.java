package com.koreait.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.board.dao.BoardDAO;

public class BoardReplyDeleteOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		BoardDAO r_dao = new BoardDAO();
		ActionForward forward = new ActionForward();
		
		int page = Integer.parseInt(req.getParameter("page"));
		int replyNum = Integer.parseInt(req.getParameter("replyNum"));
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		
		r_dao.deleteReply(replyNum);
	
		forward.setRedirect(true);
		forward.setPath(req.getContextPath() + "/board/BoardView.bo?page=" + page + "&boardNum=" + boardNum);
		
		return forward;
	}

}












