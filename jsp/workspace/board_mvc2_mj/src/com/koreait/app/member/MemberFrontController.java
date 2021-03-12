package com.koreait.app.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.ActionForward;
//HttpServlet을 상속 받는다는건 여기서 요청과 응답 모두를 한다는 것이다. 

//만약 요청한 응답 페이지가 흰 색 화면이 나온다면 문법 오류 혹은 페이지 이동 오류일 가능성이 높다. 
public class MemberFrontController extends HttpServlet {
   /**
    * JVM의 메모리에서만 머물러 있던 객체를 시스템이 종료되거나 네트워크로 통신을 할 때에도 그대로 사용할 수 있도록
    * 영구화 목적으로 직렬화를 사용한다.
    * 직렬화 된 객체는 byte형태로 변환되어 있으며, 다시 사용하고 싶을 때에는 역직렬화를 통해서 객체로 변환된다.
    * 이 때 SUID(serialVersionUID)라는 값을 고정시켜 구분점으로 사용해서 사용자가 원하는 객체가 맞는 지 판단하게 된다.
    * 자주 변경되는 클래스 객체에는 사용하지 않는 것이 좋다.
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
   protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //찐 로직
	  //클라이언트가 요청한 전체 URI
      String requestURI = req.getRequestURI();
      
      //도메인부터 계속 반복되는 URI 앞(헤드) 부분
      //사용자의 요청을 구분하기 위해서는 불필요한 부분이다. 그래서 이걸 substring으로 걸러내기 위해서 변수에 담음
      String contextPath = req.getContextPath();
      
      //불필요한 부분을 잘라낸 나머지 부분 즉, 사용자의 요청이 무엇인지를 판단할 수 있는 부분을 담는다. 
      String command = requestURI.substring(contextPath.length());
      
      //컨트롤러에서 응답할 정보를 담아줄 객체
      ActionForward forward = null;
      
      // /member/를 붙인 이유는 사용자의 요청이 어떤 소속인지를 나타내기 위함이다 (가독성)
      if(command.equals("/member/MemberJoin.me")) {
         try {
        	//사용자의 요청에 맞는 응답을 하기위해서
        	//컨트롤러를 메모리에 할당하고, 그 안에 있는 execute메소드를 사용해준다. 
            forward = new MemberJoinOkAction().execute(req, resp);
         } catch (Exception e) {;}
      }else if (command.equals("/member/MemberLogin.me")) {
			try {
				forward = new MemberLoginOkAction().execute(req,resp);
			} catch (Exception e) {;}
      }else if(command.equals("/member/MemberCheckIdOk.me")) {
         try {
            forward = new MemberCheckIdOkAction().execute(req, resp);
         } catch (Exception e) {;}
      }else {
    	  //만약 위의 모든 분기에 들어가지 않았다면, 요청한 URI가 잘못된 것이다.
    	  //따라서 컨트롤러를 호출할 필요없이 직접 404 오류 안내 페이지로 이동시켜준다. 
         forward = new ActionForward();
         forward.setRedirect(false);
         forward.setPath("/app/error/404.jsp");
      }
      
      //위의 분기처리가 끝난 후 응답을 일괄처리 해준다.
      if(forward != null) {
    	  //응답할 게 있다면 (forword가 null이 아니라는것)
         if(forward.isRedirect()) {
        	 //redirect 방식으로 새로운 세션을 열어 이전 request 객체 초기화 후 응답
            resp.sendRedirect(forward.getPath());
         }else {
            RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
            //forward 방식으로 기존 request, response 객체를 그대로 유지한 채 응답
            dispatcher.forward(req, resp);
         }
      }
   }
}











