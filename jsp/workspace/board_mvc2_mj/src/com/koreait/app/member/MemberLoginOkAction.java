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
		
		m_vo.setMemberId(req.getParameter("memberId"));
		m_vo.setMemberPw(req.getParameter("memberPw"));
/*		System.out.println("test1");
		System.out.println(m_dao.login(m_vo)); 왜안찍혀??*/
		if(m_dao.login(m_vo)) {
			//로그인 성공
			//세션에 ID 저장
			System.out.println("test2");
			req.setAttribute("memberId", m_vo.getMemberId());
			//확인
			forward = new ActionForward();
			forward.setRedirect(false);
			//아직 미구현 (로그인 성공하면 메인페이지로 이동)
			forward.setPath("/member/MemberLogin.me");
		} else {
			//로그인 실패
			System.out.println("test3");
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('로그인 실패. 아이디와 비밀번호를 다시확인해주세요');</script>");
			out.close();
			
		}
		return forward;
	}
}
