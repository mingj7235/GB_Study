package com.koreait.mybatis.config;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//결국 이것의 목적은 factory를 만들기 위함이다. 어플리케이션 실행시!!!!!

public class SqlMapConfig {
	private static SqlSessionFactory sqlsession_f; //factory는 인터페이스이므로 메모리에 할당하기위해서는 builder가 클래스라서 new로 할당후 이것에 도움을 받는다.
	
	//static 초기화 블럭
	//static 필드에 작성한건 프로세스가 작동하면서 딱 1번만 할당된다. 
	// 프로그램 실행 시 단 한번만 실행되는 영역을 말한다. 
	static {
		try {
			//config.xml 경로 작성
			String resource = "./com/koreait/mybatis/config/config.xml";  //./은 자바리소스의 src경로다
			
			//해당경로에 있는 config.xml을 객체로 읽어오기
			Reader reader = Resources.getResourceAsReader(resource); //reader가 이제 config파일이 되는것이다. 오오오...
			
			//전달한 config.xml객체를 토대로 Factory를 빌드하기
			sqlsession_f = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("초기화 문제발생, SqlMapConfig.java");
		}
	}
	
	public static SqlSessionFactory getSqlMapInstance() {
		return sqlsession_f;
	}
}
