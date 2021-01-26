package day05;


public class Student {
	int num;
	String name;
	
	public Student() {;}

	public Student(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			//student타입으로 downcasting
			Student std = (Student) obj;
			if(this.hashCode() == std.hashCode()) {
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
