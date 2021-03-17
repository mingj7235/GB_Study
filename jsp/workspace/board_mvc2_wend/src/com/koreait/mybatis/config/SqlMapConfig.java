package com.koreait.mybatis.config;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {
	private static SqlSessionFactory sqlsession_f;
	
	//static 초기화 블럭
	//프로그램 실행 시 단 한번만 실행되는 영역
	static {
		try {
			//config.xml 경로 작성
			String resource = "./com/koreait/mybatis/config/config.xml";
			//해당 경로에 있는 config.xml을 객체로 읽어오기
			Reader reader = Resources.getResourceAsReader(resource);
			//전달한 config.xml객체를 토대로 Factory 빌드
			sqlsession_f = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("초기화 문제 발생, SqlMapConfig.java");
		}
	}
	
	public static SqlSessionFactory getSqlMapInstance() {
		return sqlsession_f;
	}
}


















