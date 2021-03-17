package com.koreait.app.board;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.board.dao.BoardDAO;
import com.koreait.app.board.vo.BoardReplyVO;

public class BoardReplyOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
		BoardReplyVO r_vo = new BoardReplyVO();
		BoardDAO r_dao = new BoardDAO();
		ActionForward forward = new ActionForward();
		
		//게시글 번호, 아이디, 컨텐츠
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		String memberId = (String)session.getAttribute("session_id");
		String replyContent = req.getParameter("replyContent");
		
		r_vo.setBoardNum(boardNum);
		r_vo.setMemberId(memberId);
		r_vo.setReplyContent(replyContent);
		
		if(r_dao.insertReply(r_vo)) {
			out.println("추가 성공");
		}else {
			out.println("추가 실패");
		}
		
		out.close();
		
//		forward.setRedirect(true);
//		forward.setPath(req.getContextPath() + "/board/BoardView.bo?boardNum=" + boardNum + "&page=" + req.getParameter("page"));
		
//		return forward;
		return null;
	}
}








