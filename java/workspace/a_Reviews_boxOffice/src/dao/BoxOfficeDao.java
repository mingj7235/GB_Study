package dao;

import java.io.BufferedReader;
import java.io.IOException;

import vo.BoxOfficeVo;

public class BoxOfficeDao {
	
	//영화 추가
	private boolean append (BoxOfficeVo film) throws IOException{
		//랭킹 가져오기

		if (film == null) {return false;}
		
		BufferedReader br = DBConnection.getReader();
		
		if(br == null) {return false;}
		
		String line = null;
		int lastRanking = 0;
		
		
		
		
		return false;
	}
	
	
	
	
	public void insertAndAppend() {
		
	}
	
	
}
