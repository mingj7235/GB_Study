package vo;
//USER_NUMBER NUMBER NOT NULL,
//ID VARCHAR2(100),
//PW VARCHAR2(100),
//NAME VARCHAR2(100),
//AGE NUMBER,
//PHONENUMBER VARCHAR2(15),

public class USER_TBL_VO {
	private int user_number;
	private String id;
	private String pw;
	private String name;
	private int age;
	private String phonenumber;
	
	public USER_TBL_VO() {;}

	public int getUser_number() {
		return user_number;
	}

	public void setUser_number(int user_number) {
		this.user_number = user_number;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	
}
