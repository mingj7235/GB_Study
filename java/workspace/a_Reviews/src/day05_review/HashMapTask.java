package day05_review;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapTask {
	public static void main(String[] args) {
		HashMap<Student, ArrayList<Integer>> gradeMap = new HashMap<>();
		ArrayList<Integer> arScore = new ArrayList<>();
		
		arScore.add(80);
		arScore.add(90);
		arScore.add(70);
		
		gradeMap.put(new Student (1, "김민재"), arScore);
		
		System.out.println(gradeMap.get(new Student(1, "김민재")));
	}
}
