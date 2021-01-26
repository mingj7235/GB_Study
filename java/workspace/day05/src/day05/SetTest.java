package day05;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest {
	public static void main(String[] args) {
		//spring framework를 위해서 카멜표기법으로만 작성한다. 
		HashSet<String> bloodTypeSet = new HashSet<>();
		
		bloodTypeSet.add("A");
		bloodTypeSet.add("B");
		bloodTypeSet.add("O");
		bloodTypeSet.add("AB");
		bloodTypeSet.add("AB");
		bloodTypeSet.add("AB");
		bloodTypeSet.add("AB");
		bloodTypeSet.add("AB");
		bloodTypeSet.add("AB");
		bloodTypeSet.add("AB");
		bloodTypeSet.add("AB");
		bloodTypeSet.add("AB");
		
		System.out.println(bloodTypeSet.size());
		System.out.println(bloodTypeSet);
		
		Iterator<String> iter = bloodTypeSet.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next() + "형");
		}
		
		System.out.println(bloodTypeSet.contains("AB")); //true
	}
}
