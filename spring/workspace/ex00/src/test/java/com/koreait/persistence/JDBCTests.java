package com.koreait.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) //테스트 코드가 스프링을 실행 (WAS가 아니라)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")//지정된 클래스나 문자열을 이용해서 필요한 객체들을 스프링 내에 객체로 등록
@Log4j //이건 pom.xml에 미리 설정해놓음 syso를 안쓰고 logger를 사용함
public class JDBCTests {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		//try(Statement) : try 소괄호 안에 close를 필요로하는 인스턴스를 작성하면 자동으로 close()를 실행해준다.
		//외부드라이버를 가져오면 항상 close를 해줘야한다.
		//이럴 때 try소괄호에 넣는것이다. 항상 close를 해줄 필요가 없다. 
		try(Connection conn =
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
						"hr",
						"hr")) {
			log.info(conn);
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
}
