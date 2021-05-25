package com.koreait.domain;

import lombok.Data;

/*
 * BNO NUMBER(10),
	TITLE VARCHAR2(200) NOT NULL,
	CONTENT VARCHAR2(2000) NOT NULL,
	WRITER VARCHAR2(200) NOT NULL,
	REGDATE DATE DEFAULT SYSDATE,
	UPDATEDATE DATE DEFAULT SYSDATE
 * */
@Data
public class BoardVO {
	//long타입을 쓰는 이유는 클래스타입을 쓰는것이 좋기때문이다.
	Long bno;
	private String title;
	private String content;
	private String writer;
	private String regDate;
	private String updateDate;
	private int replyCnt;
	
	
}
