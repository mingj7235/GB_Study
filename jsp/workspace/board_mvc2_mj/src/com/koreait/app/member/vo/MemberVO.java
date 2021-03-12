package com.koreait.app.member.vo;

/*CREATE TABLE TABLE_MEMBER(
		memberId VARCHAR2(300),
		memberPw VARCHAR2(300),
		memberName VARCHAR2(300),
		memberAge NUMBER(3),
		memberGender VARCHAR2(20),
		memberEmail VARCHAR2(200),
		memberZipcode VARCHAR2(20),
		memberAddress VARCHAR2(300),
		memberAddressDetail VARCHAR2(300),
		memberAddressEtc VARCHAR2(100),
		CONSTRAINT MEMBER_PK PRIMARY KEY(memberId)
	);*/


public class MemberVO {
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberAge;
	private String memberGender;
	private String memberEmail;
	private String memberZipcode;
	private String memberAddress;
	private String memberAddressDetail;
	private String memberAddressEtc;
	
	public MemberVO() {;}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberZipcode() {
		return memberZipcode;
	}

	public void setMemberZipcode(String memberZipcode) {
		this.memberZipcode = memberZipcode;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public String getMemberAddressDetail() {
		return memberAddressDetail;
	}

	public void setMemberAddressDetail(String memberAddressDetail) {
		this.memberAddressDetail = memberAddressDetail;
	}

	public String getMemberAddressEtc() {
		return memberAddressEtc;
	}

	public void setMemberAddressEtc(String memberAddressEtc) {
		this.memberAddressEtc = memberAddressEtc;
	}
}















