package com.koreait.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.board.dao.BoardDAO;
import com.koreait.app.board.vo.BoardReplyVO;

public class BoardReplyModifyOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		BoardReplyVO r_vo = new BoardReplyVO();
		BoardDAO r_dao = new BoardDAO();
		ActionForward forward = new ActionForward();
		
		int page = Integer.parseInt(req.getParameter("page"));
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		int replyNum = Integer.parseInt(req.getParameter("replyNum"));
		String replyContent = req.getParameter("content"+req.getParameter("seq"));
		
		r_vo.setReplyNum(replyNum);
		r_vo.setReplyContent(replyContent);
		
		r_dao.updateReply(r_vo);
		
		forward.setRedirect(true);
		forward.setPath(req.getContextPath() + "/board/BoardView.bo?page=" + page + "&boardNum=" + boardNum);
		
		return forward;
	}

}
