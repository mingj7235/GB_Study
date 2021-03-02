package com.koreait.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.mybatis.config.SqlMapConfig;

public class MemberDAO { //memberdao는 선언이다!!
	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance(); //만들어놓은걸 가져오는것!! sqlMapConfig.java 에서 만들어놨자나!!
	SqlSession sqlsession;

	/*
	 * JSP에서 memberDao를 객체화해서 사용한다. 
	 * sqlsession 을 기본생성자에 해놓기때문에, 객체화를 하자마자 sqlsession이 메모리에할당된것이다.
	 * 그러므로 어떤 메소드를 불러오든지, 기본생성자에 sqlsession 을 넣어놨으므로 메소드를 불러올때마다 할당할 필요가없다. 
	 * */
	
	public MemberDAO() {
		//기본생성자를 통해 만든다. 
		sqlsession = sqlsession_f.openSession(true); //default는 false다. 자동 커밋 여부를 묻는 것이다. true를 쓰면 자동 커밋이 된다.true를 쓰는게 좋다. 커밋을 잊을 수 있으니!
	}
	
	//아이디 중복검사
	public boolean checkId (String id) {
		return (Integer)sqlsession.selectOne("Member.checkId", id) == 0; //첫번째 매개변수 : 매퍼에서 어떤 테그냐 인지를 써야함!! 두번재 매개변수 : 그 매퍼에 넘길 값
		//Integer타입으로 다운캐스팅해야한다. 왜? member.xml에서 resultType이 _int이므로 !! 
	}
	
	public boolean login (String id, String pw) {
		return (Integer)sqlsession.select("Member.login", id, pw) == 0;
	}
}
