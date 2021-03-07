package com.koreait.app.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.member.dao.MemberDAO;

public class MemberCheckIdOkAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String id = req.getParameter("id");
		//여기까지 들어옴
		MemberDAO dao = new MemberDAO();
		//여기부터 오류남
		
		PrintWriter out = resp.getWriter();
		
		resp.setContentType("text/html; charset=UTF-8");
		if(dao.checkId(id)) {
			out.print("not-ok");
		}else {
			out.print("ok");
		}
		out.close();
		return null;
	}
	
}
