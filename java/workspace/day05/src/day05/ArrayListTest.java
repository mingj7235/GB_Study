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
		
		ArrayList<Integer> datas2 = new ArrayList<>();
		
		datas2.add(10);
		datas2.add(10);
		datas2.add(20);
		datas2.add(10);
		
		//마지막 10을 삭제한다. 
		System.out.println(datas2.lastIndexOf(10));
		
		//두번째 10을 삭제한다. 
		//1. 정렬후 10을 찾고 +1 번째 인덱스
		//2. 정렬하지 않고 -> 반복을 돌리고 
		
		//값만 필요할때
//		for (int data : datas2) {
//	
//		}
//		int cnt = 0;
//		for (int i = 0; i < datas2.size(); i++) {
//			if(datas2.get(i) == 10) {
//				cnt++;
//				if(cnt == 2) {
//					datas2.remove(cnt);
//				}
//			}
//		}	
	
		//arraylist를 하나 더 만들어서 원하는 번째의 10을 삭제하는 방법 
		
		//찾는 값이 여러 개 있을 때 각 값의 인덱스 번호를 저장할 List
		ArrayList<Integer> idxs = new ArrayList<>();
		
		for (int i = 0; i < datas2.size(); i++) {
			//10이라는 값일 때 idxs에 인덱스 번호를 저장
			if(datas2.get(i) == 10) {
				idxs.add(i);
			}
		}
//		System.out.println(idxs);
		
		try {
			//remove(int idx)를 사용하기 위해서는 Integer를 int로 unboxing해야한다.
			//따라서 idxs.get(1).intValue()를 통해 int타입으로 unboxing을해주면,
			//remove(int idx)로 인식되어 해당 인덱스에 있는 값이 삭제된다. 
			datas2.remove(idxs.get(1).intValue());
			System.out.println(datas2);
		} catch (Exception e) {
			System.out.println("존재하지 않는 인덱스 입니다.");
			e.printStackTrace();
		}	
	}
}
