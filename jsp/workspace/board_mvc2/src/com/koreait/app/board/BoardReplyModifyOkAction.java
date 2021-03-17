package com.koreait.app.board;

import java.io.PrintWriter;

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
		
		PrintWriter out = resp.getWriter();
		
		int replyNum = Integer.parseInt(req.getParameter("replyNum"));
		String replyContent = req.getParameter("content");
		
		
		r_vo.setReplyNum(replyNum);
		r_vo.setReplyContent(replyContent);
		
		if(r_dao.updateReply(r_vo)) {
			out.println("수정성공");
		}else {
			out.println("수정실패");
		}
		out.close();
		//forward.setRedirect(true);
		//forward.setPath(req.getContextPath() + "/board/BoardView.bo?page=" + page + "&boardNum=" + boardNum);
		
		return null;
	}
}














