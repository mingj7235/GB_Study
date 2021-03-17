package com.koreait.app.board;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.board.dao.BoardDAO;
import com.koreait.app.board.vo.BoardReplyVO;

public class BoardReplyListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		
		PrintWriter out = resp.getWriter();
		BoardDAO r_dao = new BoardDAO();
		
		JSONArray arReply = new JSONArray();
		
		List<BoardReplyVO> replys = r_dao.getReplyList(boardNum);
		
		for(BoardReplyVO r_vo : replys) {
			JSONObject reply = new JSONObject();
			reply.put("replyNum", r_vo.getReplyNum());
			reply.put("memberId", r_vo.getMemberId());
			reply.put("replyContent", r_vo.getReplyContent());
			arReply.add(reply);
		}
		out.println(arReply.toJSONString());
		out.close();
		return null;
	}

}


















