package day05;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Speed {
	public static void main(String[] args) {
		final int size = 10_000_000;
		final List<Integer> arrayList = new ArrayList<Integer>(size);
		final Set<Integer> hashSet = new HashSet<>(size);
		final int data = 9_000_000;
		
		IntStream.range(0, size).forEach(value ->{
			arrayList.add(value);
			hashSet.add(value);
		});
		
		Instant start = Instant.now();
		arrayList.contains(data);
		Instant end = Instant.now();
		
		long elapsedTime = Duration.between(start, end).toMillis();
//		System.out.println("arrayList search time : " + elapsedTime + " 밀리초");
		System.out.println("arrayList search time : " + elapsedTime *0.001 + " 초");
		
		start = Instant.now();
		hashSet.contains(data);
		end = Instant.now();
		
		elapsedTime = Duration.between(start, end).toMillis();
		System.out.println("hashSet search time : " + elapsedTime * 0.001+ " 밀리초");
	}
}
