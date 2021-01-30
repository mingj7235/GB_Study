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
		//line = br.readLine()은 한줄씩 가져오고, 여기에 새로받은 랭킹과 기존의 랭킹을 비교
		//그다음 boolean으로 check를해서 플래그를 세운다움에 밑에서 비교
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
			
			//반복을 돌면서 계속 중복된 랭킹들이 생기게 되고 그이후로는 newRanking에 
			//1씩 계속 등가해서 들어가게된다. 
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
	
	// 랭킹을 전달 하느냐 않느냐를 기준으로 구분한다. ..?
	public boolean insertAndAppend(BoxOfficeVo film) throws IOException{
		
		//전달받은 랭킹이 없는 경우. 즉 밑에 바로 추가되는 경우
		if(film.getRanking() == 0) {
			if(append (film)) {
				return true;
			}
		}else {
			//랭킹을 전달받은 경우 -> 삽입
			
			String contents = new String (Files.readAllBytes(Paths.get(DBConnection.getPath())));
			
			//배열의 각 요소들은 한줄. 즉 영화의 컨텐츠들이다. \n을 기준으로 잘랐기 때문이다.
			//arTemp 배열은 각각의 영화의 내용이담긴것임
			String [] arTemp = contents.split("\n");
			
			//랭킹이 최대값보다 더 큰 경우의 오류를 잡기위해 랭킹을 비교해준다.
			if(Integer.parseInt(arTemp[arTemp.length-1].split("\t")[0]) 
					< film.getRanking() ) {
				return false;
			}
			if (insert(film)) {return true;}
			
		}
		
		return false;
		
	}
	
	public boolean update (String filmName, String newFilmName) throws IOException {
		
		BufferedReader br = DBConnection.getReader();
		if (br == null) {return false;}
		
		String line = null;
		String temp = "";
		boolean check = false;
		while ((line = br.readLine()) != null) {
			if(line.split("\t")[1].equals(filmName)) {
				
				//"\t"를 한 것에 1을 증가시킨 인덱스번호는 영화 제목 이후의 부분을 가져오는 것이다.
				//즉 stub는 영화제목을 포함하지않은 그 다음의 정보들을 가져오게된다. 
				String stub = line.substring(line.indexOf("\t")+1);
				
				temp += line.split("\t")[0] + "\t"
						+ newFilmName
						+ stub.substring(stub.indexOf("\t")) +"\n";
				check = true;
				continue;
			}
			temp += line + "\n";
		}
		
		br.close();
		
		if(true) {
			BufferedWriter bw = DBConnection.getWriter();
			bw.write(temp);
			bw.close();
			return true;
		}
		
		
		return false;
		
		
	}
	
	public boolean delete (String filmName) throws IOException {
		
		BufferedReader br = DBConnection.getReader();
		if( br == null) {return false;}
		
		String line = null;
		String temp ="";
		int ranking = 0;
		boolean check = false;
		
		while ((line = br.readLine()) != null) {
			//일단 랭킹을 밑에서 재조립할것임. 그니까 0부터시작하고 하나씩 증가시켜준다. 
			ranking ++;
			if(line.split("\t")[1].equals(filmName)) {
				ranking --;
				check = true;
				continue;
			}
			temp += ranking 
					+line.substring(line.indexOf("\t")) + "\n";
			
		}
		br.close();
		
		//재조립된것이 여기로 온것임
		if(check) {
			BufferedWriter bw = DBConnection.getWriter();
			bw.write(temp);
			bw.close();
			return true;
		}
		return false;
	}
	
	
	
}
 