package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import vo.BoxOfficeVo;

public class BoxOfficeDao {
	
	//영화 추가
	private boolean append (BoxOfficeVo film) throws IOException{

		if (film == null) {return false;}
		
		BufferedReader br = DBConnection.getReader();
		if(br == null) {return false;}

		String line = null;
		int lastRanking = 0;
		
		while ((line = br.readLine()) != null) {
			lastRanking ++;
		}
		br.close();
		
		String contents = new String (Files.readAllBytes(Paths.get(DBConnection.getPath())));
		
		String temp = "";
		
		if(contents.charAt(contents.length() -1) != '\n') {
			temp += "\n";
		}
		
		temp += lastRanking +1 + "\t"
				+ film.getFilmName() + "\t"
				+ film.getReleaseDate() +"\t"
				+ film.getIncome() + "\t"
				+ film.getWatchCnt() + "\t"
				+ film.getScreenCnt() + "\n";
		
		BufferedWriter bw = new DBConnection().getAppend();
		bw.write(temp);
		bw.close();
		
		return true;
	}
	
	private boolean insert (BoxOfficeVo film) throws IOException {
		
		if (film == null) {return false;}
		
		int newRanking = film.getRanking();
		
		BufferedReader br = DBConnection.getReader();
		if(br == null) {return false;}

		String line = null;
		String temp = "";
		boolean check = false;
		
		while ((line = br.readLine()) != null) {
			if(Integer.parseInt(line.split("\t")[0]) == newRanking) {
				temp += film.getRanking() +"\t"
						+ film.getFilmName() + "\t"
						+ film.getReleaseDate() +"\t"
						+ film.getIncome() + "\t"
						+ film.getWatchCnt() + "\t"
						+ film.getScreenCnt() + "\n";
				check = true;
			}
			
			
		}
		
		
		
		
		return true;
	}
	
	
	
	public void insertAndAppend() {
		
	}
	
	
}
