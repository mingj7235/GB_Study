package com.joshua.domain;

import lombok.Data;

/*
 * MEMBERID VARCHAR(200),
	MEMBERPW VARCHAR(200) NOT NULL,
	MEMBERNAME VARCHAR(200) NOT NULL,
	MEMBERAGE NUMBER(10),
	MEMBEREMAIL VARCHAR(200) NOT NULL UNIQUE,
	MEMBERZIPCODE NUMBER(10),
	MEMBERLOCATION VARCHAR(200),
	MEMBERLOCATIONDETAIL VARCHAR(200),
	MEMBERCANONE VARCHAR(200),
	MEMBERCANTWO VARCHAR(200),
	MEMBERCANTHREE VARCHAR(200),
	MEMBERWANTONE VARCHAR(200),
	MEMBERWANTTWO VARCHAR(200),
	MEMBERWANTTHREE VARCHAR(200)
 * 
 * */

@Data
public class MemberVO {
	String memberId;
	String memberPw;
	String memberName;
	int memberAge;
	String memberEmail;
	String memberZipcode;
	String memberLocation;
	String memberLocationDetail;
	String memberCanOne;
	String memberCanTwo;
	String memberCanThree;
	String memberWantOne;
	String memberWantTwo;
	String memberWantThree;
	
}
