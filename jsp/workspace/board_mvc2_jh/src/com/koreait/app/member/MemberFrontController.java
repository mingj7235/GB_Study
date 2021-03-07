package com.koreait.app.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.ActionForward;

public class MemberFrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		ActionForward forward = null;

		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = uri.substring(contextPath.length());

		if (command.equals("/member/MemberJoin.me")) {
			try {
				forward = new MemberJoinOkAction().execute(req, resp);
			} catch (Exception e) {
				;
			}
		} else if (command.equals("/member/MemberCheckIdOk.me")) {
			try {
				forward = new MemberCheckIdOkAction().execute(req, resp);
			} catch (Exception e) {;}
		} else if (command.equals("/member/MemberLogin.me")) {
			//ID/PW를 입력하고 로그인을 누르면 이쪽으로 이동함
			try {
				forward = new MemberLoginOkAction().execute(req, resp);
			} catch (Exception e) {;}
		} else if (command.equals("/member/MemberLoginOk.me")) {
			System.out.println("로그인 성공");
			try {
				forward = new MemberLoginPageAction().execute(req, resp);
			} catch (Exception e) {;}
		} else {

			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/member/404.jsp");
		}

		if (forward != null) {
			if (forward.isRedirect()) {
				resp.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, resp);
			}
		}

	}
}
