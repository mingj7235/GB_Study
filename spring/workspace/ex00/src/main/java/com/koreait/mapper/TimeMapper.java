package com.koreait.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	//spring에서 쿼리문을 이렇게 어노테이션으로 쓸수있다. 
	//간단한 쿼리문은 이렇게 쓸수가있다. (간단하지않은것은 xml만들어야한다.)
	
//	@Select("SELECT SYSDATE FROM DUAL")
//	public String getTime();
	
	/*
	 * SQL이 복잡하거나 길어지는 경우에는 어노테이션보다는 XML을 이용하는 방식을 더 선호하게 된다. 
	 * MyBatis-Spring의 경우 Mapper인터페이스와 XML을 동시에 이용할 수 있다. 
	 * 
	 */
	
	@Select ("SELECT SYSDATE FROM DUAL")
	public String getTime();

	public String getTime2();
	

}
