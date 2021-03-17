package com.koreait.app.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.board.dao.BoardDAO;
import com.koreait.app.board.dao.FilesDAO;
import com.koreait.app.board.vo.BoardReplyVO;
import com.koreait.app.board.vo.BoardVO;
import com.koreait.app.board.vo.FilesVO;

public class BoardViewAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		BoardDAO b_dao = new BoardDAO();
		BoardDAO r_dao = new BoardDAO();
		BoardVO b_vo = null;
		FilesDAO f_dao = new FilesDAO();
		
		ActionForward forward = null;
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		int page = Integer.parseInt(req.getParameter("page"));
		b_vo = b_dao.getDetail(boardNum);
		
		List<FilesVO> fileList = f_dao.getFileList(boardNum);
		List<BoardReplyVO> replyList = r_dao.getReplyList(boardNum);
		
		if(b_vo != null) {
			b_dao.updateReadCount(boardNum);
			req.setAttribute("replies", replyList);
			req.setAttribute("b_vo", b_vo);
			req.setAttribute("page", page);
			if(fileList != null) {
				req.setAttribute("files", fileList);
			}
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/board/boardView.jsp");
		}
		return forward;
	}
}

















