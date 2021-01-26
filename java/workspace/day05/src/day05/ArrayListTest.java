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
//		System.out.println(datas.get(7));

		//collections에 다양한 자료구조들의 메소드를 제공해준다. 
		Collections.sort(datas);
		System.out.println(datas);
		
		
		//CRUD
		//Create
		//Read
		//Update
		//Delete
		
		int idx = 0;
		String msg = null;
		//추가 (40 추가)
		datas.add(40);
		
		//삽입 (10 뒤에 15삽입)
		idx = datas.indexOf(10); //10이 있는 위치
		if (datas.contains(10)) {
			datas.add(idx + 1 , 15);
			msg = "추가성공 : " + datas.toString();
		}else {
			msg = "추가 실패 : 값을 찾지 못했습니다.";
		}
		System.out.println(msg);
		
		//수정 (20을 200으로 수정)
		
		//1.일단 검색
		idx = datas.indexOf(20);
		if(datas.contains(20)) {
			datas.set(idx, 200);
			
		}else {
			System.out.println("수정실패");
		}
		//삭제 (50 삭제)
//		datas.remove(50);
		if (datas.remove(new Integer(50))) {//이렇게 박싱을 해야 삭제가 된다.
			System.out.println("삭제성공");
		}else {
			System.out.println("삭제 실패");
		}
		
		
	}
}
