package com.koreait.app.member;

import java.io.PrintWriter;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.member.dao.MemberDAO;

import java.util.HashMap;
import java.util.Properties;
import java.util.Random;



//컨트롤러
public class MemberCheckModifyFindIdOkAction implements Action{
	//여기에 문자전송 api 만들기
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//전달받은 데이터 중 한글이 있다면 깨지지 않도록 방지
		req.setCharacterEncoding("UTF-8");
		String modifyInput = req.getParameter("modifyInput");
		MemberDAO m_dao = new MemberDAO();
		
		System.out.println(req.getParameter("modifyInput"));
		System.out.println(req.getParameter("memberEmail"));
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html;charset=utf-8");
		if(m_dao.MODIFYNUM.equals(modifyInput)) {
			//ok
			out.println("ok");
			//이메일 전송 메소드 사용
			String from = "joshuara7235@gmail.com";
			String to = req.getParameter("memberEmail");
			String subject = "회원 가입을 위한 이메일 인증 메일입니다.";
			String content = "이메일 인증 번호 : " + new SHA256().getSHA256(to);

			// SMTP에 접속하기 위한 정보를 기입합니다.
			Properties p = new Properties();
			p.put("mail.smtp.user", from);
			p.put("mail.smtp.host", "smtp.googlemail.com");
			p.put("mail.smtp.port", "465");
			p.put("mail.smtp.starttls.enable", "true");
			p.put("mail.smtp.auth", "true");
			p.put("mail.smtp.debug", "true");
			p.put("mail.smtp.socketFactory.port", "465");
			p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			p.put("mail.smtp.socketFactory.fallback", "false");

			 

			try{
			    Authenticator auth = new Gmail();
			    Session ses = Session.getInstance(p, auth);
			    ses.setDebug(true);
			    MimeMessage msg = new MimeMessage(ses); 
			    msg.setSubject(subject);
			    Address fromAddr = new InternetAddress(from);
			    msg.setFrom(fromAddr);
			    Address toAddr = new InternetAddress(to);
			    msg.addRecipient(Message.RecipientType.TO, toAddr);
			    msg.setContent(content, "text/html;charset=UTF-8");
			    Transport.send(msg);

			} catch(Exception e){
			    e.printStackTrace();
				PrintWriter out2 = resp.getWriter();
				out2.println("<script>");
				out2.println("alert('오류가 발생했습니다..');");
				out2.println("history.back();");
				out2.println("</script>");
				out2.close();		

			}
			
			
			
			
		}else {
			//not-ok
			out.println("not-ok");
		}
		out.close();
		return null;
	}

}














