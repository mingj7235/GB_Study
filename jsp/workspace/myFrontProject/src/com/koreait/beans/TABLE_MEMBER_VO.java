package com.koreait.beans;

/*CREATE TABLE TBL_STFORU_MEMBER (
	NUM NUMBER PRIMARY KEY,
	ID VARCHAR2(500) UNIQUE,
	NAME VARCHAR2(500),
	EMAIL VARCHAR2(500),
	PASSWORD VARCHAR2(500),
	PHONENUM VARCHAR2(500),
	GENDER VARCHAR2(50),
	ZIPCODE VARCHAR2(50),
	ADDRESS VARCHAR2(500),
	ADDRESSDETAIL VARCHAR2(500),
	TALENT01 VARCHAR2(500),
	TALENT01DETAIL VARCHAR2(500),
	TALENT02 VARCHAR2(500),
	TALENT02DETAIL VARCHAR2(500),
	TALENT03 VARCHAR2(500),
	TALENT03DETAIL VARCHAR2(500),
	INTEREST01 VARCHAR2(500),
	INTEREST01DETAIL VARCHAR2(500),
	INTEREST02 VARCHAR2(500),
	INTEREST02DETAIL VARCHAR2(500),
	INTEREST03 VARCHAR2(500),
	INTEREST03DETAIL VARCHAR2(500)
);*/


public class TABLE_MEMBER_VO {
	private int num;
	private String id;
	private String nameMember;
	private String email;
	private String password;
	private String phonenum;
	private String gender;
	private String zipcode;
	private String address;
	private String addressDetail;
	private String talent01;
	private String talent01Detail;
	private String talent02;
	private String talent02Detail;
	private String talent03;
	private String talent03Detail;
	private String interest01;
	private String interest01Detail;
	private String interest02;
	private String interest02Detail;
	private String interest03;
	private String interest03Detail;
	
	
	public TABLE_MEMBER_VO() {}

	
	
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




	public String getNameMember() {
		return nameMember;
	}



	public void setNameMember(String nameMember) {
		this.nameMember = nameMember;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getPhonenum() {
		return phonenum;
	}



	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getZipcode() {
		return zipcode;
	}



	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getAddressDetail() {
		return addressDetail;
	}



	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}



	public String getTalent01() {
		return talent01;
	}



	public void setTalent01(String talent01) {
		this.talent01 = talent01;
	}



	public String getTalent01Detail() {
		return talent01Detail;
	}



	public void setTalent01Detail(String talent01Detail) {
		this.talent01Detail = talent01Detail;
	}



	public String getTalent02() {
		return talent02;
	}



	public void setTalent02(String talent02) {
		this.talent02 = talent02;
	}



	public String getTalent02Detail() {
		return talent02Detail;
	}



	public void setTalent02Detail(String talent02Detail) {
		this.talent02Detail = talent02Detail;
	}



	public String getTalent03() {
		return talent03;
	}



	public void setTalent03(String talent03) {
		this.talent03 = talent03;
	}



	public String getTalent03Detail() {
		return talent03Detail;
	}



	public void setTalent03Detail(String talent03Detail) {
		this.talent03Detail = talent03Detail;
	}



	public String getInterest01() {
		return interest01;
	}



	public void setInterest01(String interest01) {
		this.interest01 = interest01;
	}



	public String getInterest01Detail() {
		return interest01Detail;
	}



	public void setInterest01Detail(String interest01Detail) {
		this.interest01Detail = interest01Detail;
	}



	public String getInterest02() {
		return interest02;
	}



	public void setInterest02(String interest02) {
		this.interest02 = interest02;
	}



	public String getInterest02Detail() {
		return interest02Detail;
	}



	public void setInterest02Detail(String interest02Detail) {
		this.interest02Detail = interest02Detail;
	}



	public String getInterest03() {
		return interest03;
	}



	public void setInterest03(String interest03) {
		this.interest03 = interest03;
	}



	public String getInterest03Detail() {
		return interest03Detail;
	}



	public void setInterest03Detail(String interest03Detail) {
		this.interest03Detail = interest03Detail;
	}



	@Override
		public String toString() {
			String data = "id : " + id + ", name : " + nameMember + ", password : " + password + ", address : " + address;
			return data;
		}
}


















