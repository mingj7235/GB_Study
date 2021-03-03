package com.koreait.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.mybatis.config.SqlMapConfig;
import com.koreait.vo.MemberVO;

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
	//로그인
/*	public boolean login (String id, String pw) {
		//헤쉬맵에 담아야한다. 
		HashMap<String, String> datas = new HashMap<>();
		datas.put("id", id); //hashmap의 형태로 member.xml에 join 으로 넘기는것이다. 키와 밸류로 !! 
		datas.put("pw", pw);
		return (Integer)sqlsession.selectOne("Member.login", datas) == 1; //1이면 로그인성공 true 
	}*/
	
	//로그인 위에꺼를 더 단축하면 이렇게된다. 
	/**
	 * 
	 * @param datas {id='id', pw ='pw'}
	 * @return
	 */
	public boolean login (HashMap<String, String> datas) {
		return (Integer)sqlsession.selectOne("Member.login", datas) == 1;
	}
	
	//회원가입
	
	/*public boolean signup (MemberVO member){
		return (Integer)sqlsession.insert("Member.signup", member) == 1;
	}*/
	
	public boolean join (MemberVO member) {
		return sqlsession.insert("Member.join", member) == 1;
	}
	
	//회원 조회 (회원번호) 
	public MemberVO getMember (int num) {
		return sqlsession.selectOne("Member.getMember", num);
	}
	
	//회원 번호를 조회 (아이디로)
	public int getNum (String id) {
		return sqlsession.selectOne("Member.getNum", id);
	}
	
	//비밀번호 조회 (아이디로)
	public String getPw (String id) {
		return sqlsession.selectOne("Member.getPw", id);
		
		
	}
	
	//아이디조회 (회원번호로)
	public String getId (int num) {
		return sqlsession.selectOne("Member.getId", num);
	}
	
	//비밀번호 조회 (회원번호로) // 메소드명이 같아도 오버로딩이된다. 
	public String getPwNum (int num) {
		return sqlsession.selectOne("Member.getPwNum", num);
	}
	
	//전체회원조회 
	public List<MemberVO> getMemberList () {
		return sqlsession.selectList("Member.getMemberList");
	}
	
	//회원 이름 수정 (회원번호로 찾고, 새로운 이름으로 바꾸기)
	public boolean modify(MemberVO member) {
		return sqlsession.update("Member.modify", member) == 1;
	}
	
	//회원삭제 (회원번호)
	public boolean delete (int num) {
		return sqlsession.delete("Member.delete", num) == 1;
	}
}























