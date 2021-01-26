package day05;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapTask {
	public static void main(String[] args) {
		HashMap<Student, ArrayList<Integer>> gradeMap = new HashMap<>();
		ArrayList<Integer> scoreList = new ArrayList<>();
		
		scoreList.add(80); //국어
		scoreList.add(30); //영어
		scoreList.add(50); //수학
		
		gradeMap.put(new Student(1, "한동석"), scoreList);
		
		System.out.println(gradeMap.get(new Student(1,"한동석")));
		
		
		
		
	}
}
