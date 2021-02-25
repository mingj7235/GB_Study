package com.koreait.beans;

/*CREATE TABLE TABLE_MEMBER (
		NUM NUMBER PRIMARY KEY,
		ID VARCHAR2 (200)
	);*/

public class TABLE_MEMBER_VO {
	private int num;
	private String id;
	
	public TABLE_MEMBER_VO() {
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
