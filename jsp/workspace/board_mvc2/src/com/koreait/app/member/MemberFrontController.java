package com.koreait.app.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.ActionForward;

//만약 요청한 응답 페이지가 흰 색 화면이 나온다면 문법 오류 혹은 페이지 이동 오류일 가능성이 높다.
public class MemberFrontController extends HttpServlet {
	/**
	 * JVM의 메모리에서만 머물러 있던 객체를 시스템이 종료되거나 네트워크로 통신을 할 때에도 그대로 사용할 수 있도록
	 * 영구화 목적으로 직렬화를 사용한다.
	 * 직렬화 된 객체는 byte형태로 변환되어 있으며, 다시 사용하고 싶을 때에는 역직렬화를 통해서 객체로 변환된다.
	 * 이 때 SUID(serialVersionUID)라는 값을 고정시켜 구분점으로 사용해서 사용자가 원하는 객체가 맞는 지 판단하게 된다.
	 * 자주 변경되는 클래스 객체에는h 사용하지 않는 것이 좋다.
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//doGet 또는 doPost가 실행될 때 모두 같은 로직이 실행되어야 하므로
		//doProcess메소드 선언 후 재사용한다.
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	//비지니스 핵심 로직을 모아둔 메소드
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//클라이언트가 요청한 전체 URI
		String requestURI = req.getRequestURI();
		//도메인부터 계속 반복되는 URI 앞(헤드)부분
		//사용자의 요청을 구분하기 위해서는 불필요한 부분이다.
		String contextPath = req.getContextPath();
		//불필요한 부분을 잘라낸 나머지 부분 즉, 사용자의 요청이 무엇인지를 판단할 수 있는 부분을 담는다.
		String command = requestURI.substring(contextPath.length());
		//컨트롤러에서 응답할 정보를 담아줄 객체
		ActionForward forward = null;
		
		// /member/를 붙인 이유는 사용자의 요청이 어떤 소속인지를 나타내기 위함이다(가독성).
		if(command.equals("/member/MemberJoinOk.me")) {
			try {
				//사용자의 요청에 맞는 응답을 하기 위해서
				//컨트롤러를 메모리에 할당하고, 그 안에 있는 execute메소드를 사용해준다.
				forward = new MemberJoinOkAction().execute(req, resp);
			} catch (Exception e) {System.out.println(e);}
			
		}else if(command.equals("/member/MemberJoin.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/member/joinForm.jsp");
			
		}else if(command.equals("/member/MemberLogin.me")) {
			//전달받은 login 값을 가져온다.
			String login = req.getParameter("login");
			forward = new ActionForward();
			forward.setRedirect(false);
			//																		만약 login에 false가 들어 있다면 .jsp파일에도 전달해준다.
			//																		하지만 login이 null이면 파라미터를 전달하지 않는다.
			forward.setPath("/app/member/loginForm.jsp" + (login != null ? "?login=false" : ""));
			
		}else if(command.equals("/member/MemberLoginOk.me")) {
			try {
				forward = new MemberLoginOkAction().execute(req, resp);
			} catch (Exception e) {;}
		}else if(command.equals("/member/MemberCheckIdOk.me")) {
			try {
				forward = new MemberCheckIdOkAction().execute(req, resp);
			} catch (Exception e) {;}
		}else if(command.equals("/member/MemberLogout.me")) {
			try {
				forward = new MemberLogoutAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
				;}
		}else {
			//만약 위의 모든 분기에 들어가지 않았다면, 요청한 URI가 잘못된 것이다.
			//따라서 컨트롤러를 호출할 필요 없이 직접 404 오류 안내 페이지로 이동시켜준다.
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/error/404.jsp");
		}
		
		//위의 분기처리가 끝난 후 응답을 일괄처리 해준다.
		if(forward != null) {
			//응답할 게 있다면,
			if(forward.isRedirect()) {
				//redirect 방식으로 새로운 세션을 열어 이전 request 객체 초기화 후 응답
				resp.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
				//forward 방식으로 기존 request, respone객체를 그대로 유지한 채 응답
				dispatcher.forward(req, resp);
			}
		}
	}
}










 