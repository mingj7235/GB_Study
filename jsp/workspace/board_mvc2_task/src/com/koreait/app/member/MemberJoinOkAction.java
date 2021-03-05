package com.koreait.app.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.member.dao.MemberDAO;
import com.koreait.app.member.vo.MemberVO;

public class MemberJoinOkAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		ActionForward forward = null;
		MemberVO m_vo = new MemberVO();
		MemberDAO m_dao = new MemberDAO();
		
	    m_vo.setMemberId(req.getParameter("memberId"));
	    m_vo.setMemberPw(req.getParameter("memberPw"));
	    m_vo.setMemberName(req.getParameter("memberName"));
	    m_vo.setMemberAge(Integer.parseInt(req.getParameter("memberAge")));
	    m_vo.setMemberGender(req.getParameter("memberGender"));
	    m_vo.setMemberEmail(req.getParameter("memberEmail"));
	    m_vo.setMemberZipcode(req.getParameter("memberZipcode"));
	    m_vo.setMemberAddress(req.getParameter("memberAddress"));
	    m_vo.setMemberAddressDetail(req.getParameter("memberAddressDetail"));
	    m_vo.setMemberAddressEtc(req.getParameter("memberAddressEtc"));
	    
	    if(m_dao.join(m_vo)) {
	    	//Insert실패시
	    	PrintWriter out = resp.getWriter();
	    	resp.setContentType("text/html;charset=utf-8");
	    	out.println("<script>alert('서버가불안정');</script>");
	    	out.close();
	    } else {
	    	//insert성공
	    	forward = new ActionForward();
	    	
	    	forward.setRedirect(false);;
	    	forward.setPath("/member/MemberLogin.me");
	    }
		
		
		return forward;
	}
}
