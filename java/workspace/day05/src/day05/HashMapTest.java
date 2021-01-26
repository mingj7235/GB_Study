
package day05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class HashMapTest {
	public static void main(String[] args) {
		HashMap<String, Integer> fruitMap = new HashMap<>();
		
		fruitMap.put("사과", 3500);
		fruitMap.put("배", 4000);
		fruitMap.put("자두", 1500);
		fruitMap.put("수박", 8000);
		
		System.out.println(fruitMap);
		System.out.println(fruitMap.get("수박"));
		
		//KEY분리 : keySet()
		Iterator<String> fruitNames = fruitMap.keySet().iterator();
		while(fruitNames.hasNext()) {
			fruitMap.get(fruitNames.next());
			System.out.println(fruitNames.next());
		}
		
		//Value 분리 : values()
		//과일 평균 가격 출력 (내가쓴거)
		int sum = 0;
		double avg = 0.0;
		Iterator<String> fruits = fruitMap.keySet().iterator();
		while(fruits.hasNext()) {
			sum += fruitMap.get(fruits.next());
		}
		avg = (sum / fruitMap.size());
		System.out.println("과일의 평균값 : "  + avg + "원");
		
		
		//선생님 방법
		int total = 0;
		fruitMap.values().forEach(price -> {
			//다른 영역의 변수에 연산을 할 수 없다. 
			System.out.println(price);
		});
		
		for(Integer value : fruitMap.values()) {
			total += value;
		}
		
		double avg2 = Double.parseDouble(String.format
				("%.2f", (double) total / fruitMap.size()));
		
		System.out.println("과일 평균 : " + avg2 + "원");
		
		
		//메뉴판
		//한 쌍씩 분리 (entrySet())
		
		Iterator <Entry<String, Integer>> iter = fruitMap.entrySet().iterator();
		
		while (iter.hasNext()) {
			//이렇게 쓰면 절대안된다. 
			//왜? next()를 쓰는순간 다음으로 넘어가버려서 첫번째키와 두번째 밸류를 가져오게된다. 
//			iter.next().getKey();
//			iter.next().getValue();
			
			//entry타입으로 저장하여서 가져와야한다. 
			Entry<String, Integer> entry = iter.next();
			System.out.println(entry.getKey() + " : " + entry.getValue() +"원");
		}
		
		
	}
}
