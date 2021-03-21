package com.koreait.app.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.app.member.vo.MemberVO;
import com.koreait.mybatis.config.SqlMapConfig;

public class MemberDAO {
	
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession session;
	
	public MemberDAO () {
		//auto commit
		session = sessionf.openSession(true);
		
	}
	
	// 마이바티스와 연결되어 메소드 통신 
	
	public boolean join (MemberVO member) {
		return false;
	}
	

}
