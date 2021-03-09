package com.koreait.app.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.member.dao.MemberDAO;

import java.util.HashMap;
import java.util.Random;



//컨트롤러
public class MemberCheckModifyOkAction implements Action{
	//여기에 문자전송 api 만들기
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//전달받은 데이터 중 한글이 있다면 깨지지 않도록 방지
		req.setCharacterEncoding("UTF-8");
		String modifyInput = req.getParameter("modifyInput");
		MemberDAO m_dao = new MemberDAO();
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html;charset=utf-8");
		if(m_dao.MODIFYNUM.equals(modifyInput)) {
			//ok
			out.println("ok");
		}else {
			//not-ok
			out.println("not-ok");
		}
		out.close();
		return null;
	}

}














