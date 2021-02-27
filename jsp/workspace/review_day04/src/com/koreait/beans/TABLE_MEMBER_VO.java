package com.koreait.beans;

/*CREATE TABLE TABLE_MEMBER(
	NUM NUMBER PRIMARY KEY,
	ID VARCHAR2(500),
	NAME VARCHAR2(500),
	PASSWORD VARCHAR2(500),
	GENDER VARCHAR2(50),
	ZIPCODE VARCHAR2(50),
	ADDRESS VARCHAR2(500),
	ADDRESSDETAIL VARCHAR2(500),
	ADDRESSETC VARCHAR2(500)
);*/


public class TABLE_MEMBER_VO {
	private int num;
	private String id;
	private String name;
	private String password;
	private String gender;
	private String zipcode;
	private String address;
	private String addressDetail;
	private String addressEtc;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getAddressEtc() {
		return addressEtc;
	}

	public void setAddressEtc(String addressEtc) {
		this.addressEtc = addressEtc;
	}
	
	@Override
		public String toString() {
			String data = "id : " + id + ", name : " + name + ", password : " + password + ", address : " + address;
			return data;
		}
}


















