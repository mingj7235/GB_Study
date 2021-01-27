package day06_review;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest3 {
	public static void main(String[] args) throws IOException{
//		BufferedWriter bw = new BufferedWriter(new FileWriter("feeling.txt"));
//		
//		bw.write("기쁨\n");
//		bw.write("사랑\n");
//		bw.write("행복\n");
//		bw.write("감사\n");
//		bw.close();
//		
////		이어쓰기
//		
//		BufferedWriter rbw = new BufferedWriter(new FileWriter("feeling.txt", true));
//		rbw.write("찬양\n");
//		rbw.close();
		
		//수정
		
		BufferedReader br = null;
		String temp = "";
		
		try {
			br = new BufferedReader(new FileReader("feeling.txt"));
			String line = null;

			while ( (line = br.readLine()) != null ) {
				if(line.equals("사랑")) {
					temp += "슬픔";
					continue;
				}
				temp += line + "\n";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if ( br != null) {
					br.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("feeling.txt"));
		bw.write(temp);
		bw.close();
		
		
		
		
		
	}
}
