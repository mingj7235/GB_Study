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
		
		return true;
		
	}
	
	private boolean insert (BoxOfficeVo film) throws IOException {
		
		if (film == null) {return false;}
		
		//이미 랭킹을 전달받은 것임. 
		int newRanking = film.getRanking();
		
		BufferedReader br = DBConnection.getReader();
		if( br == null) {return false;}
		
		String line = null;
		String temp = "";
		//newRanking이 어디에 삽입될건지 찾는 것임. 이제 여기에 걸리면 그 이전은 다 랭킹을 +1 시켜야함
		boolean check = false;
		
		//한줄씩 이걸 가지고 올것이고, 
		while ( (line = br.readLine()) != null) {
			if (Integer.parseInt(line.split("\t")[0]) == newRanking) {
				temp += film.getRanking() + "\t"
						+ film.getFilmName() + "\t"
						+ film.getReleaseDate() +"\t"
						+ film.getIncome() + "\t"
						+ film.getWatchCnt() + "\t"
						+ film.getScreenCnt() + "\n";
				check = true;
			}
			
			if (check) {
				temp += ++newRanking + line.substring(line.indexOf("\t")) + "\n";
			}else {
				temp += line +"\n";
			}
		}
		
		br.close();
		
		BufferedWriter bw = DBConnection.getWriter();
		bw.write(temp);
		bw.close();
		
		
		return true;
		
	}
	
	public void insertAndAppend() {
		
	}
	
	
}
 