package com.koreait.app.member;

import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.member.dao.MemberDAO;

public class MemberLoginOkAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ActionForward forward = null;
		
		String contextPath = req.getContextPath();
		String ok = "";
		MemberDAO dao = new MemberDAO();
		HashMap<String, String> map = new HashMap<>();
		map.put("memberId", req.getParameter("memberId"));
		map.put("memberPw", req.getParameter("memberPw"));
		
		//데이터를 map형태의 매개변수로 제공
		if(dao.login(map)) {
			//로그인 성공
			//세션에 ID를 저장
			req.setAttribute("memberId", map.get("memberId"));
			//세션에 ID 저장 확인
			//System.out.println(req.getAttribute("memberId"));
			ok = req.getAttribute("memberId")+"님 로그인 성공";
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/member/MemberLoginOk.me?ok="+ok);
		}else {
			//로그인 실패
//			PrintWriter out = resp.getWriter();
//			req.setCharacterEncoding("UTF-8");
//			resp.setCharacterEncoding("UTF-8");
//			out.print("<script>alert('ID/PW를 다시 확인해주세요.')</script>");
//			out.close();
			
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			
			forward = new ActionForward();
			forward.setRedirect(true);
			//절대 경로를 붙여야한다.
			forward.setPath(contextPath+"/app/member/login.jsp?check=false");
		}
		
		return forward;
	}
}
