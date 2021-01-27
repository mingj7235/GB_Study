package day06_review;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.management.RuntimeErrorException;

public class FileTest {
	public static void main(String[] args) throws IOException{
//		BufferedWriter bw = new BufferedWriter(new FileWriter("test.txt", true));
//		bw.newLine();
//		bw.write("김민재");
//		bw.close();

		BufferedReader br = null;
		String line = null;
		
		
		try {
			br = new BufferedReader(new FileReader("test.txt"));
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
		
		
		
		
		
	}
}
