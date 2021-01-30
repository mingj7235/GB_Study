package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import vo.BoxOfficeVo;

public class BoxOfficeDao {
	
	//영화 추가
	private boolean append (BoxOfficeVo film) throws IOException{
		if (film == null) {return false;}
		BufferedReader br = DBConnection.getReader();
		if (br == null) {return false;}
		String line = null;
		int lastRanking = 0;
		while ( (line = br.readLine()) != null ) {
			lastRanking ++;
			//마지막 랭킹이 담기게된다.
		}
		br.close();
		
		String contents = new String (Files.readAllBytes(Paths.get(DBConnection.getPath())));
		
		String temp = "";
		
		if(contents.charAt(contents.length() - 1) != '\n') {
			temp += 'n';
		}
		
		temp += lastRanking + 1 + "\t"
				+film.getFilmName()+ "\t"
				+ film.getReleaseDate() +"\t"
				+ film.getIncome() + "\t"
				+ film.getWatchCnt() + "\t"
				+ film.getScreenCnt() + "\n";
		
		BufferedWriter bw = DBConnection.getAppend();
		bw.write(temp);
		bw.close();
		
		return false;
		
	}
	
	private boolean insert (BoxOfficeVo film) throws IOException {
		
		
	}
	
	
	
	public void insertAndAppend() {
		
	}
	
	
}
 