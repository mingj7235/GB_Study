package com.koreait.app.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.ActionForward;

public class MemberFrontController extends HttpServlet {
	/**
	 * JVM의 메모리에서만 머물러 있던 객체를 시스템이 종료되거나 네트워크로 통신을 할 때에도 그대로 사용할 수 있도록
	 * 영구화 목적으로 직렬화를 사용한다. 
	 * 직렬화 된 객체는 byte형태로 변환되어 있으며, 다시 사용하고 싶을 때에는 역직렬화를 통해서 객체로 변환된다. 
	 * 이 때 SUID (serailVersionUID)라는 값을 고정시켜(ex 1L) 구분점으로 사용해서 사용자가 원하는 객체가 맞는 지 판단하게 된다. (암호화같이되어있음) 
	 * 자주 변경되는 클래스 객체에는 사용하지 않는 것이 좋다. 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	//각각의 doGet과 doPost에 똑같이 사용할 것을 여기에 만드는것임
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//이걸 이제 2번째로 분석하기위함. 확장자는 web.xml에서 구분했다.
		String requestURI = req.getRequestURI(); //경로가 아니라, 우리가 만든 데이터이므로 URL이아니라 URI로 가는것임
		String contextPath = req.getContextPath(); //반복되어지는 URI를 가져옴 www.naver.com/news 에서 www.naver.com을 contextPath에 담음것임
		String command = requestURI.substring(contextPath.length()); //이게 사용자가 원하는 news 라는 것!! substring으로 contextPath를 잘라내는것임
		
		ActionForward forward = null;
		
		if(command.equals("/member/MemberJoin.me")) { //사용자가 요청한 거 즉, join을 요청한것임 
			try {
				forward = new MemberJoinOkAction().execute(req, resp);
			} catch (Exception e) {

			}
		}else {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/error/404.jsp");
		}
		
		//페이지 이동하겠다는 것임
		if(forward != null) {
			if(forward.isRedirect()) {
				resp.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, resp);
			}
		}
		
	}
}

























