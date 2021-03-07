package com.koreait.mybatis.config;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {
	private static SqlSessionFactory sqlsession_f;
	
	static {
		try {
			String resource = "com/koreait/mybatis/config/config.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlsession_f = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
	
	public static SqlSessionFactory getSqlMapInstance() {
		return sqlsession_f;
	}
}
