/*package com.koreait.app.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.app.member.vo.MemberVO;
import com.koreait.mybatis.config.SqlMapConfig;

public class MemberDAO {
	
	private static final int KEY = 3;
	
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession session;
	
	public MemberDAO() {
		//세션 팩토리로 세션을 열어주고 모든 쿼리문은 auto커밋으로 설정 (true)
		session = sessionf.openSession(true);
	}
	
	//회원가입
	public boolean join (MemberVO member) {
		member.setMemberPw(encrypt(member.getMemberPw()));
		return session.insert("Member.join", member) == 1;
	}
	
	//암호화
	public String encrypt(String pw) {
		String en_pw = "";
		for (int i = 0; i < pw.length(); i++) {
			en_pw +=(char)(pw.charAt(i) * KEY);
		}
		return en_pw;
	}
	//복호화
	public String decrypt(String en_pw) {
		String de_pw = "";
		for (int i = 0; i < en_pw.length(); i++) {
			de_pw +=(char)(en_pw.charAt(i) / KEY);
		}
		return de_pw;
	}
	
	//아이디 검사
	*//**
	 * 
	 * @param memberId
	 * @return
	 * true : 중복된 아이디 <br>false : 사용 가능한 아이디
	 *//*
	public boolean checkId (String memberId) {
		return (Integer) session.selectOne("Member.checkId", memberId) == 1;
	}
}*/


package com.koreait.app.member.dao;

import java.util.HashMap;
import java.util.Random;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.app.member.vo.MemberVO;
import com.koreait.mybatis.config.SqlMapConfig;

import org.json.simple.JSONObject;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class MemberDAO {
   private static final int KEY = 3;
   
   SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
   SqlSession session;
   
   public MemberDAO() {
      //세션 팩토리로 세션을 열어주고 모든 쿼리문은 auto 커밋으로 설정
      session = sessionf.openSession(true);
   }
   
   //회원가입
   public boolean join(MemberVO member) {
      member.setMemberPw(encrypt(member.getMemberPw()));
      return session.insert("Member.join", member) == 1;
   }
   
   //암호화
   public String encrypt(String pw) {
      String en_pw = "";
      for (int i = 0; i < pw.length(); i++) {
         en_pw += (char)(pw.charAt(i) * KEY);
      }
      return en_pw;
   }
   
   //복호화
   public String decrypt(String en_pw) {
      String de_pw = "";
      for (int i = 0; i < en_pw.length(); i++) {
         de_pw += (char)(en_pw.charAt(i) / KEY);
      }
      return de_pw;
   }
   
   //아이디 검사
   /**
    * 
    * @param memberId
    * @return
    * 
    * true : 중복된 아이디<br>false : 사용 가능한 아이디
    * 
    */
   public boolean checkId(String memberId) {
      return (Integer)session.selectOne("Member.checkId", memberId) == 1;
   }
   /**
    * 
    * @param memberPhone
    * @return
    * ture : 중복된 번호<br>false : 사용가능한 번호이므로 인증번호 전송할수있게끔
    */
   public boolean checkPhone (String memberPhone) {
	   return (Integer)session.selectOne("Member.checkPhone", memberPhone) == 1;
   }
   
   public boolean login(MemberVO member) {
	  /* System.out.println(member.getMemberId() + member.getMemberPw());*/
	   return (Integer)session.selectOne("Member.checkId", member) == 1;
   }
   
   public void smsCheck (String memberPhone) {
	   String api_key = "NCSRIPIHAZ3LQLSK";
	    String api_secret = "OWEK0BQ227DKKRGC3YXFGQJH1UZ1NW7A";
	    Message coolsms = new Message(api_key, api_secret);
	    Random r = new Random();
	    String tempIdentifyNum = "" + r.nextInt(100000);
	    System.out.println(tempIdentifyNum);
	    
	    // 4 params(to, from, type, text) are mandatory. must be filled
	    HashMap<String, String> params = new HashMap<String, String>();
	    params.put("to", memberPhone);
	    params.put("from", "01064707235");
	    params.put("type", "SMS");
	    params.put("text", "송송 인증번호 가나요?" + tempIdentifyNum +"♥");
	    params.put("app_version", "test app 1.2"); // application name and version

	    try {
	      JSONObject obj = (JSONObject) coolsms.send(params);
	      System.out.println(obj.toString());
	    } catch (CoolsmsException e) {
	      System.out.println(e.getMessage());
	      System.out.println(e.getCode());
	    }
   }
}





































