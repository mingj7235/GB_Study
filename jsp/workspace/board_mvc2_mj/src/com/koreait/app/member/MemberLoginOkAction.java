package com.koreait.app.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.member.dao.MemberDAO;
import com.koreait.app.member.vo.MemberVO;

public class MemberLoginOkAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		ActionForward forward = null;
		MemberVO m_vo = new MemberVO();
		MemberDAO m_dao = new MemberDAO();
		
		if(m_dao.login(m_vo)) {
			//로그인 성공
			forward = new ActionForward();
			forward.setRedirect(false);
			//아직 미구현 (로그인 성공하면 메인페이지로 이동)
			forward.setPath("/member/MemberMain.me");
		} else {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html;charset=utf-8");
			out.println("<script>alert('로그인 실패. 아이디와 비밀번호를 다시확인해주세요');</script>");
			out.close();
			
		}
		return forward;
	}
}
