package com.koreait.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.board.dao.BoardDAO;
import com.koreait.app.board.vo.BoardVO;

public class BoardViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		
		BoardDAO b_dao = new BoardDAO();
		BoardVO b_vo = null;
		
		ActionForward forward = null;
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		
		int page = Integer.parseInt(req.getParameter("page"));
		
		b_vo = b_dao.getDetail(boardNum);
		
		if(b_vo != null) {
			b_dao.updateReadCount(boardNum);
			req.setAttribute("b_vo", b_vo);
			req.setAttribute("page", page);
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/board/boardView.jsp");
		}
		return forward;
	}
}

















