package day05_review;

public class Student {
	int num;
	String name;
	
	public Student() {;}

	public Student(int num, String name) {
		this.num = num;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		//obj가 student 타입인지 비교
		if(obj instanceof Student) {
			Student std = (Student) obj;
			if(this.num == std.num) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.num;
	}
	
	
}
