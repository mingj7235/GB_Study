package com.koreait.app.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.member.dao.MemberDAO;
import com.koreait.app.member.vo.MemberVO;

public class MemberLoginOkAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		
		//세션넣기
		HttpSession session = req.getSession();
		
		ActionForward forward = new ActionForward();
		
		MemberDAO m_dao = new MemberDAO();
		String id = req.getParameter("memberId");
		String pw = req.getParameter("memberPw");
		System.out.println(req.getParameter("memberId"));
		System.out.println(req.getParameter("memberPw"));
		
		if(m_dao.login(id, pw)) {
			//로그인 성공 시
			System.out.println("로그인성공");
			session.setAttribute("session_id", id); //세션아이디에 담기
			forward.setRedirect(true); //세션에 담을 것이기 때문에 request가 필요가없다.
			//forward.setPath(req.getContextPath() + "/board/BoardList.bo"); //사라지기 전에 req객체로 주소를 담아줘야한다.
			forward.setPath(req.getContextPath() + "/member/MemberHome.me"); //사라지기 전에 req객체로 주소를 담아줘야한다.
		}else {
			//로그인 실패
			System.out.println("로그인실패");
			forward.setRedirect(false); //그전의 정보를 지킬정보가 아니고 냅둬도되니까 false
			//로그인 실패 시 경고창을 출력해주기 위해서 login 파라미터를 같이 전송해준다. 
			forward.setPath("/member/MemberLogin.me?login=false"); //다시 로그인 페이지로 이동 
			//login=false <<이거는 프론트에서 파라미터로 받아서 분기점이 된다. 
		}
		
		return forward;
	}
}
