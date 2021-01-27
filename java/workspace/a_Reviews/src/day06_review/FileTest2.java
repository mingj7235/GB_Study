package day06_review;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileTest2 {
	public static void main(String[] args) throws IOException{
		String contents = new String (Files.readAllBytes(Paths.get("test.txt")));
		
		String [] datas = contents.split("\n");
		
		for (int i = 0; i < datas.length; i++) {
			System.out.print(datas[i] + ", ");
		}
		
		
	}
}
