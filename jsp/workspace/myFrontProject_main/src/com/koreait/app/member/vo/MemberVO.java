package com.koreait.app.member.vo;

/*CREATE TABLE TBL_STFORU_MEMBER(
		MEMBERID VARCHAR2(300),
		MEMBERNAME VARCHAR2(300),
		MEMBEREMAIL VARCHAR2(300),
		MEMBERPW VARCHAR2(300),
		MEMBERPHONE VARCHAR2(300),
		MEMBERGENDER VARCHAR2(50),
		MEMBERZIPCODE VARCHAR2(30),
		MEMBERADDRESS VARCHAR2(300),
		MEMBERADDRESSDETAIL VARCHAR2(300),
		CONSTRAINT STFORU_PK PRIMARY KEY (MEMBERID)
	);*/

public class MemberVO {
	private String memberId;
	private String memberName;
	private String memberEmail;
	private String memberPw;
	private String memberPhone;
	private String memberGender;
	private String memberZipcode;
	private String memberAddress;
	private String memberAddressDetail;
	
	public MemberVO() {;}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
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
	
	
	
	
}
