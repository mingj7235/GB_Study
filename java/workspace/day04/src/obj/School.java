package obj;

import java.util.HashSet;
import java.util.Set;

public class School {
	public static void main(String[] args) {
		Student 한동석 = new Student(1, "한동석");
		Set<Student> stdSet = new HashSet<>();
		stdSet.add(한동석);
		stdSet.add(new Student(1, "한동석"));
		
		System.out.println(stdSet.size());
		
//		System.out.println(한동석.equals(new Student(1, "한동석")));
		
	}
}
