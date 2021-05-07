package com.koreait.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	//spring에서 쿼리문을 이렇게 어노테이션으로 쓸수있다. 
	//간단한 쿼리문은 이렇게 쓸수가있다. (간단하지않은것은 xml만들어야한다.)
	@Select("SELECT SYSDATE FROM DUAL")
	public String getTime();
}
