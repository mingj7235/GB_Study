package day06_review;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest3 {
	public static void main(String[] args) throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter("feeling.txt"));
		
		bw.write("기쁨\n");
		
		
	}
}
