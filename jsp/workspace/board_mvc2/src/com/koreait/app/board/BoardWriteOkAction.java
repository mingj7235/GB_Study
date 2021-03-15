package com.koreait.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.board.dao.BoardDAO;
import com.koreait.app.board.vo.BoardVO;

public class BoardWriteOkAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		
		BoardVO b_vo = new BoardVO();
		BoardDAO b_dao = new BoardDAO();
		ActionForward forward = null;
		
		b_vo.setBoardTitle(req.getParameter("boardTitle"));
		b_vo.setBoardId(req.getParameter("boardId"));
		b_vo.setBoardContent(req.getParameter("boardContent"));
		
		if(b_dao.insertBoard(b_vo)) {
			//첨부파일 추가
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath(req.getContextPath() + "/board/BoardList.bo");
		}
		return forward;
	}
}


















