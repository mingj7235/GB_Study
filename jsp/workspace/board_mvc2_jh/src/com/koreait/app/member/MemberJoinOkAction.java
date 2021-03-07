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
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		vo.setMemberId(req.getParameter("memberId"));
		vo.setMemberPw(req.getParameter("memberPw"));
		vo.setMemberName(req.getParameter("memberName"));
		vo.setMemberAge(req.getParameter("memberAge"));
		vo.setMemberGender(req.getParameter("memberGender"));
		vo.setMemberEmail(req.getParameter("memberEmail"));
		vo.setMemberZipcode(req.getParameter("memberZipcode"));
		vo.setMemberAddress(req.getParameter("memberAddress"));
		vo.setMemberAddressDetail(req.getParameter("memberAddressDetail"));
		vo.setMemberAddressEtc(req.getParameter("memberAddressEtc"));
		if(dao.join(vo)) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/member/MemberLogin.me");
		}else {
			PrintWriter out = resp.getWriter();
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			out.print("<script>alert('서버 오류')</script>");
			out.close();
		}

		return forward;
	}
}
