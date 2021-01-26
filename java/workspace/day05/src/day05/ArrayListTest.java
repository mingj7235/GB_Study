package day05;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<Integer> datas = new ArrayList<>();
		
		datas.add(10);
		datas.add(80);
		datas.add(90);
		datas.add(50);
		datas.add(70);
		datas.add(30);
		datas.add(60);
		datas.add(20);
		
		System.out.println(datas.size());
		System.out.println(datas.get(7));

		Collections.sort(datas);
		
		System.out.println(datas);
		
	}
}
