package com.koreait.app.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.member.dao.MemberDAO;
import com.koreait.app.member.vo.MemberVO;

//컨트롤러
public class MemberSignupOkAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		ActionForward forward = null;
		MemberVO m_vo = new MemberVO();
		MemberDAO m_dao = new MemberDAO();
		/*	CREATE TABLE TBL_STFORU_MEMBER(
			MEMBERID VARCHAR2(300),
			MEMBERNAME VARCHAR2(300),
			MEMBEREMAIL VARCHAR2(300),
			MEMBERPW VARCHAR2(300),
			MEMBERPHONE VARCHAR2(300),
			MEMBERGENDER VARCHAR2(50),
			MEMBERZIPCODE VARCHAR2(30),
			MEMBERADDRESS VARCHAR2(300),
			MEMBERADDRESSDETAIL VARCHAR2(300),
			CONSTRAINT STFORU_PK PRIMARY KEY (MEMBERID)
		);
		 */
		//사용자가 입력한 정보들
		System.out.println("정보를 담기전");
	    m_vo.setMemberId(req.getParameter("memberId"));
	    m_vo.setMemberName(req.getParameter("memberName"));
	    m_vo.setMemberEmail(req.getParameter("memberEmail"));
	    m_vo.setMemberPw(req.getParameter("memberPw"));
	    m_vo.setMemberPhone(req.getParameter("memberPhone"));
	    m_vo.setMemberGender(req.getParameter("memberGender"));
	    m_vo.setMemberZipcode(req.getParameter("memberZipcode"));
	    m_vo.setMemberAddress(req.getParameter("memberAddress"));
	    m_vo.setMemberAddressDetail(req.getParameter("memberAddressDetail"));
	    
	   /* System.out.println(req.getParameter("memberId"));
	    System.out.println(req.getParameter("memberName"));
	    System.out.println(req.getParameter("memberEmail"));
	    System.out.println(req.getParameter("memberPw"));
	    System.out.println(req.getParameter("memberPhone"));
	    System.out.println(req.getParameter("memberGender"));
	    System.out.println(req.getParameter("memberZipcode"));
	    System.out.println(req.getParameter("memberAddress"));
	    System.out.println(req.getParameter("memberAddressDetail"));
	    System.out.println("if문전");
	    System.out.println(m_dao.join(m_vo));*/
		if(m_dao.join(m_vo)) {
			//DB에서 INSERT 성공시
			System.out.println("인서트 성공 들어옴");
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/member/MemberLogin.me");
		}else {
			//직접 HTML문서로 응답
			System.out.println("인서트 실패 들어옴");
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html;charset=utf-8");
			out.println("<script>alert('서버가 불안정합니다. 잠시후 다시 시도해주세요.');</script>");
			out.close();
		}
		
		return forward; //페이지 이동이있으므로 forward를 리턴!
	}
}
