package com.koreait.app.member.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.app.member.vo.MemberVO;
import com.koreait.mybatis.config.SqlMapConfig;

public class MemberDAO {
	private static final int KEY = 3;
	
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession session;
	
	public MemberDAO() {
		session = sessionf.openSession(true);
	}
	
	public String encrypt(String pw) {
		String en_pw = "";
		for (int i = 0; i < pw.length(); i++) {
			en_pw += (char)(pw.charAt(i) * KEY);
		}
		return en_pw;
	}
	
	public String decrypt(String en_pw) {
		String de_pw = "";
		for (int i = 0; i < en_pw.length(); i++) {
			de_pw += (char)(en_pw.charAt(i) * KEY);
		}
		return de_pw;
	}
	
	/**
	 * 
	 * @param member
	 * @return
	 * 
	 * true면 성공, false면 실패
	 */
	public boolean join(MemberVO member) {
		return session.insert("Member.join", member) == 1;
	}
	
	/**
	 * 
	 * @param memberId
	 * @return
	 * 
	 * true면 중복<br>false면 사용가능
	 */
	public boolean checkId(String memberId) {
		return (Integer)session.selectOne("Member.checkId", memberId) == 1;
	}
	
	/**
	 * 
	 * @param member
	 * @return
	 * 
	 * true면 성공<br>false면 실패
	 */
	public boolean login(HashMap<String, String> map) {
		return (Integer)session.selectOne("Member.login", map) == 1;
	}
}
