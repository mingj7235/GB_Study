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
   //비지니스 핵심 로직을 모아둔 메소드
   protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String requestURI = req.getRequestURI();
      String contextPath = req.getContextPath();
      String command = requestURI.substring(contextPath.length());
      
      ActionForward forward = null;
      
      
      //로그인 페이지 이동
      if(command.equals("/member/MemberLogin.me")) {
    	  forward = new ActionForward();
          forward.setRedirect(false);
          forward.setPath("/app/member/login.jsp");
      //홈페이지로 이동    
      } else if(command.equals("/member/MemberHome.me")) {
    	  forward = new ActionForward();
          forward.setRedirect(false);
          forward.setPath("/app/member/index.jsp");
      //회원가입 페이지로 이동
      } else if(command.equals("/member/MemberSignup.me")) {
    	  forward = new ActionForward();
          forward.setRedirect(false);
          forward.setPath("/app/member/signup.jsp");
      //아이디 찾기 페이지로 이동
      } else if(command.equals("/member/MemberFindId.me")) {
    	  forward = new ActionForward();
    	  forward.setRedirect(false);
    	  forward.setPath("/app/member/findid.jsp");
      //비밀번호 찾기 페이지로 이동
      } else if(command.equals("/member/MemberFindPw.me")) {
    	  forward = new ActionForward();
    	  forward.setRedirect(false);
    	  forward.setPath("/app/member/findpw.jsp");
    	  
      //아이디 중복체크
      } else if(command.equals("/member/MemberCheckIdOk.me")) {
    	  try {
			forward= new MemberCheckIdOkAction().execute(req, resp);
		} catch (Exception e) {;}
      
      //폰 번호 체크
      } else if(command.equals("/member/MemberCheckPhoneOk.me")) {
    	  try {
			forward= new MemberCheckPhoneOkAction().execute(req, resp);
		} catch (Exception e) {;}
      //인증번호 체크
      } else if(command.equals("/member/MemberCheckModifyOk.me")) {
    	  try {
    		  forward= new MemberCheckModifyOkAction().execute(req, resp);
    	  } catch (Exception e) {;}
      //회원가입
      } else if(command.equals("/member/MemberSignupOk.me")) {
    	  try {
    		forward = new MemberSignupOkAction().execute(req, resp);
    	  } catch (Exception e) {
    		 e.printStackTrace();
    	  }
      //로그인 // 실패, 성공여부를 아래 코드 보면서 한 번 더 확인해보기 
      } else if(command.equals("/member/MemberLoginOk.me")) {
    	  try {
    		forward = new MemberLoginOkAction().execute(req, resp);
    	  } catch (Exception e) {
    		 e.printStackTrace();
    	  }
      //아이디 찾기 로직
      } else if(command.equals("member/MemberCheckModifyFindIdOk.me")) {
	   try {
		   forward = new MemberCheckModifyFindIdOkAction().execute(req, resp);
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
	   
	   //비밀번호 찾기 로직
      } else if(command.equals("member/MemberCheckModifyFindPwOk.me")) {
	   try {
		   forward = new MemberCheckModifyFindPwOkAction().execute(req, resp);
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
      }
      
      
      
      
      /*if(command.equals("/member/MemberJoinOk.me")) {
         try {
            //사용자의 요청에 맞는 응답을 하기 위해서
            //컨트롤러를 메모리에 할당하고, 그 안에 있는 execute메소드를 사용해준다.
            forward = new MemberJoinOkAction().execute(req, resp);
         } catch (Exception e) {;}
         
      }else if(command.equals("/member/MemberJoin.me")) {
         forward = new ActionForward();
         forward.setRedirect(false);
         forward.setPath("/app/member/joinForm.jsp");
         
      }else if(command.equals("/member/MemberLogin.me")) {
    	 //전달받은 login 값을 가져온다. 
    	 String login = req.getParameter("login");
         forward = new ActionForward();
         forward.setRedirect(false);
         //로그인실패인지 아닌지를 파라미터로 가져오는 플래그로 판단 req객체로 담아서 파라미터로 가져오는거...이게 쩐다... 
         //login이라는 파라미터를 검사해서 !!
         //															만약 login에 false가 들어있다면 .jsp파일에도 전달해준다.
         //															하지만 login이 null이면, 파라미터를 전달하지 않는다. 
         forward.setPath("/app/member/loginForm.jsp?login=false" + (login!= null? "?login=false" : "" ));
         
      }else if(command.equals("/member/MemberLoginOk.me")) {
    	  try {
			forward = new MemberLoginOkAction().execute(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
      }else if(command.equals("/member/MemberCheckIdOk.me")) {
         try {
            forward = new MemberCheckIdOkAction().execute(req, resp);
         } catch (Exception e) {;}
      }else {
         //만약 위의 모든 분기에 들어가지 않았다면, 요청한 URI가 잘못된 것이다.
         //따라서 컨트롤러를 호출할 필요 없이 직접 404 오류 안내 페이지로 이동시켜준다.
         forward = new ActionForward();
         forward.setRedirect(false);
         forward.setPath("/app/error/404.jsp");
      }*/
      
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











