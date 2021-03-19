package com.koreait.app.member.dao;

import java.util.HashMap;
import java.util.Random;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.app.member.Gmail;
import com.koreait.app.member.SHA256;
import com.koreait.app.member.vo.MemberVO;
import com.koreait.mybatis.config.SqlMapConfig;

import org.json.simple.JSONObject;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

import java.util.Properties;
import java.io.PrintWriter;
import javax.mail.Authenticator;
import javax.mail.Transport;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.Address;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;



public class MemberDAO {
   private static final int KEY = 3;
   public static String MODIFYNUM = "";
   SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
   SqlSession session;
   
   public MemberDAO() {
      //세션 팩토리로 세션을 열어주고 모든 쿼리문은 auto 커밋으로 설정
      session = sessionf.openSession(true);
   }
   
   //회원가입
   /**
    * 
    * @param member
    * @return
    * true : 가입 성공 <br> false : 가입 실패
    */
   public boolean join(MemberVO member) {
      member.setMemberPw(encrypt(member.getMemberPw()));
      return session.insert("Member.join", member) == 1;
   }
   
   //암호화
   /**
    * 
    * @param pw
    * @return
    * 비밀번호 암호화 
    */
   public String encrypt(String pw) {
      String en_pw = "";
      for (int i = 0; i < pw.length(); i++) {
         en_pw += (char)(pw.charAt(i) * KEY);
      }
      return en_pw;
   }
   
   //복호화
   /**
    * 
    * @param en_pw
    * @return
    * 비밀번호 복호화 
    */
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
   
   /**
    * 
    * @param member
    * @return
    * true : 로그인 가능
    */
   public boolean login(String id, String pw) {
	   HashMap<String, String> member = new HashMap<>();
	   member.put("id", id);
	   member.put("pw", encrypt(pw)); //암호화
	   return (Integer)session.selectOne("Member.login", member) == 1;
   }
   
   /**
    * 
    * @param memberPhone
    * @return
    * 문자 인증 메소드 (sdk API)
    */
   public String checkSms (String memberPhone) {
	   String api_key = "NCSRIPIHAZ3LQLSK";
	    String api_secret = "OWEK0BQ227DKKRGC3YXFGQJH1UZ1NW7A";
	    Message coolsms = new Message(api_key, api_secret);
	    Random r = new Random();
	    String tempIdentifyNum = ""+r.nextInt(100000);
	    System.out.println(tempIdentifyNum);
	    //스테틱으로 넣기
	    MODIFYNUM = tempIdentifyNum;
	    //인증번호 시간되면 스태틱말고 세션으로 변경해서 써보기
	    
	    // 4 params(to, from, type, text) are mandatory. must be filled
	    //인증번호확인을 위해 잠시 주석
	   /* HashMap<String, String> params = new HashMap<String, String>();
	    params.put("to", memberPhone);
	    params.put("from", "01064707235");
	    params.put("type", "SMS");
	    params.put("text", "인증번호 : " + tempIdentifyNum);
	    params.put("app_version", "test app 1.2"); // application name and version

	    try {
	      JSONObject obj = (JSONObject) coolsms.send(params);
	      System.out.println(obj.toString());
	    } catch (CoolsmsException e) {
	      System.out.println(e.getMessage());
	      System.out.println(e.getCode());
	    }*/
	    return tempIdentifyNum;
   }
   

   
}





































