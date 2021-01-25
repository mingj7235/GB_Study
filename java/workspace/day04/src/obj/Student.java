package obj;

public class Student {
	public int num;
	public String name;
	
	public Student() {
	}

	public Student(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}
	
	//반드시 equals를 재정의할때는 hashCode도 재정의 해야한다. 
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
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
