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
			forward.setRedirect(true); //setAttribute가 없고, req에 담아서 전달하게없으니까 redirect로 보내도된다.
			forward.setPath(req.getContextPath()+"/board/BoardList.bo"); //페이지전달안한채로 바로 전달. 1페이지로 이동하게된다.
		}
		
		return forward;
	}
}













