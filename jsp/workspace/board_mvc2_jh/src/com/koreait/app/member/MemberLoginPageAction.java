package com.koreait.app.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;

public class MemberLoginPageAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		PrintWriter out = resp.getWriter();
		
		out.print(req.getAttribute("memberId")+"님 로그인 성공");
		
		
		
		
		return null;
	}
}
