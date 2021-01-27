package file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileTest2 {
	public static void main(String[] args) throws IOException{
		
		//MAC은 (EUC-KR)으로 인코딩해야한다.
//		String contents = new String (Files.readAllBytes(Paths.get("test.txt")), "UTF-8");
		String contents = new String (Files.readAllBytes(Paths.get("test.txt")));
		
		System.out.println(contents);
		System.out.println(contents.split("\n")[0]);
		
	}
}
