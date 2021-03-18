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
public class MemberCheckPhoneOkAction implements Action{
	//여기에 문자전송 api 만들기
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//전달받은 데이터 중 한글이 있다면 깨지지 않도록 방지
		req.setCharacterEncoding("UTF-8");
		String memberPhone = req.getParameter("memberPhone");
		MemberDAO m_dao = new MemberDAO();
		
		PrintWriter out = resp.getWriter();
		
		resp.setContentType("text/html;charset=utf-8");
		
		//Ajax에서 요청한 데이터를 DB에서 조회한 후
		//text로 출력하여 응답해준다.
		if(!m_dao.checkPhone(memberPhone)) {
			//not-ok
			out.println("ok");
			m_dao.checkSms(memberPhone);
		}else {
			//ok
			out.println("not-ok");
			//인증번호 api
		}
		out.close();
		//페이지 이동을 하지 않는다.
		return null;
	}

}














