package com.koreait.app.board;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.board.dao.BoardDAO;
import com.koreait.app.board.vo.BoardVO;

public class BoardModifyOkAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		
		BoardDAO b_dao = new BoardDAO();
		try {
			BoardVO b_vo = new BoardVO();
			int page = Integer.parseInt(req.getParameter("page"));
			b_vo.setBoardNum(Integer.parseInt(req.getParameter("boardNum")));
			b_vo.setBoardTitle(req.getParameter("boardTitle"));
			b_vo.setBoardContent(req.getParameter("boardContent"));
			
			b_dao.updateBoard(b_vo);
			
			forward.setRedirect(true);
			forward.setPath(req.getContextPath() + "/board/BoardView.bo?boardNum=" + b_vo.getBoardNum() + "&page="+page);
			
		} catch (Exception e) {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('게시글 수정 실패. 다시 시도해주세요.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return null;
		}
		return forward;
	}

}














