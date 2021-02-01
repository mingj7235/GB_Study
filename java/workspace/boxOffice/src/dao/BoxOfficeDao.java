package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.Box;

import vo.BoxOfficeVo;

public class BoxOfficeDao {
	
	//private 추가 (랭킹이 전달되지 않았을 때)
	private boolean append(BoxOfficeVo film) throws IOException {
		
		//외부에서 전달된 영화 정보가 없을 때 
		if(film == null) {return false;}
		
		//랭킹을 가져오는 것
		BufferedReader br = DBConnecter.getReader(); //null인지 판단해야함
		//해당 경로에 읽어올 파일이 없을때
		if(br==null) {return false;}
		
		//메모장 각 줄(라인) 문자열을 저장할 변수
		String line = null;
		
		//마지막 랭킹 번호를 저장할 변수
		int lastRanking = 0;
		
		//while문 종료 시 lastRanking에는 마지막 영화 순위가 저장된다. 500회면 500회까지 증가하여 마지막 랭킹을 구하는 것이다.  
		while((line = br.readLine()) != null) {
			//마지막 랭킹을 알아야 한다.
			lastRanking++ ; //마지막 순위가 담기게됨
		}
		br.close();
		
		//텍스트 파일에서 각 컬럼의 구분은 \t로 구성되어 있다. 
		//파일의 가장 마지막 문자가 \n인지 검사 (readAllBytes() 사용)
		
		String contents = new String (Files.readAllBytes(Paths.get(DBConnecter.getPath()))); //메모장 전체내용을 다 가지고옴
		
		//메모장 양식에 맞춰서 추가할 요소를 담아 줄 임시 저장공간
		String temp = ""; 
		
		//문자 배열의 인덱스에 접근함
		//가장 마지막에 줄바꿈이 있는지 검사하기 위해서 하는 것임. 
		//contents.length()는 전체의 길이인데 여기서 -1을 빼줘야 마지막 배열의 값에 찾아가는것임
		if(contents.charAt(contents.length() -1 ) != '\n') { //마지막 방. \n인지 검사
			//줄바꿈이 없다면 \n을 추가하고 시작한다. 왜냐? 새롭게 밑에 추가해야하니까!
			temp += "\n";
		}
		
		//새롭게 추가될 영화순위는 마지막 순위 +1이 된다. 
		temp += lastRanking + 1 + "\t"
				+ film.getFilmName() + "\t"
				+ film.getReleaseDate() +"\t"
				+ film.getIncome() + "\t"
				+ film.getGuestCnt() + "\t"
				+ film.getScreenCnt() + "\n"; //마지막 \n은 추가해도되고 빼도 된다. 
		
		BufferedWriter bw = DBConnecter.getAppend(); //이어 쓸 준비
		bw.write(temp);
		bw.close();
		
		return true;
	}
	
	
	
	//private 삽입 (랭킹이 전달되었을 때)
	private boolean insert(BoxOfficeVo film) throws IOException {
		if(film == null) {return false;}
		
		//전달받은 삽입할 랭킹을 newRanking에 담아준다. 
		int newRanking = film.getRanking(); //삽입은 랭킹이 전달되었다고 가정하고 구현하는 것임.
		
		BufferedReader br = DBConnecter.getReader();
		if(br == null) {return false;}
		
		String line = null;
		String temp = "";
		
		//삽입 여부 FLAG
		boolean check = false;
		
		while ( (line = br.readLine()) != null ) {
			//한줄씩 불러온건 원본, newRanking은 신규 
			
			//삽입할 순위를 기존 데이터와 비교
			//각각의 모든 영화의 순위를 불러와서 new Ranking과 비교
			if (Integer.parseInt(line.split("\t")[0]) == film.getRanking()) {
				//현재 순위와 삽입할 순위가 일치하면
				//기존 정보 이전에 새로운 삽입할 정보를 temp에 넣어준다. 
				temp += film.getRanking() + "\t"
					+ film.getFilmName() + "\t"
					+ film.getReleaseDate() +"\t"
					+ film.getIncome() + "\t"
					+ film.getGuestCnt() + "\t"
					+ film.getScreenCnt() + "\n";
				//이걸 film의 toString을 재정의해서 가져오면 temp += film으로 할수있음. (나중에할것)
				
				//삽입전과 후를 구분하기 위한것임!!! 
				check = true;
				//삽입 완료
				
			}
			if (check) {
				//삽입 후 나머지 랭킹에 모두 +1을 하여 수정해준다. 
				
				//line.subString(line.indexOf("\t") : 순위를 제외한 나머지 정보
				//반복을 돌면서 기존 newRanking들이 계속 들어와서 1씩 늘어나면서 temp에 저장이되는 것이다. 
				temp += ++newRanking + line.substring(line.indexOf("\t")) + "\n"; //readline은 줄바꿈을 안가져오므로 "\n"해야함
			}else { //삽입이 안된경우
				//삽입 전에는 순위를 그대로 유지해야 한다. 
				temp += line + "\n";
			}
		}
		br.close();
		
		BufferedWriter bw = DBConnecter.getWriter();
		bw.write(temp);
		bw.close();
		
		return true;
	}
	
	//INSERT
	//추가와 삽입을 메소드 하나에 넣기 -> 랭킹을 전달하느냐 않느냐를 기준으로 메소드를 구분  
	public boolean insertOrAppend(BoxOfficeVo film) throws IOException{
		//랭킹 유무 판단
		if(film.getRanking() == 0) {
			//추가 
			if (append(film)) {
				return true;
			} 
		}else {
			//삽입
			//전달받은 랭킹이 마지막 순위보다 클 때 (오류)
			String contents = new String (Files.readAllBytes(Paths.get(DBConnecter.getPath())));
			
			//영화가 500개면 arTemp의 length는 500.
			String[] arTemp = contents.split("\n");

			// 오류인 경우를 따지는 것임 
			//arTemp[arTemp.length-1].split("\t")[0] < 요건는
			if(Integer.parseInt(arTemp[arTemp.length-1].split("\t")[0]) 
					< film.getRanking()) {return false;} //추가가실패!
			
			if (insert(film)) {return true;}
		}
		
		return false;
	}
	
	//수정 (영화제목만 수정가능)
//	public boolean update (String filmName, String newFilmName) throws IOException{
//		//메모장에서 한 줄씩 가져온 후 수정할 영화 제목을 비교하여 검사한다.
//		
//		BufferedReader br = DBConnecter.getReader();
//		String temp = "";
//		boolean check = false;
//		
//		if (br == null) {return false;}
//		
//		while ((temp = br.readLine())!= null) {
//			if(temp.split("\t")[1].equals(filmName)) {
//				temp.split("\t")[1] = newFilmName;
//				check = true;
//			}
//		}
//		return check;
//	}
	public boolean update (String filmName, String newFilmName) throws IOException{
		//메모장에서 한 줄씩 가져온 후 수정할 영화 제목을 비교하여 검사한다.
	
		BufferedReader br = DBConnecter.getReader();
		if(br == null) {return false;}
		String temp= "";
		String line = null;
		
		//수정 완료 여부 FLAG
		boolean check = false;
		
		while ((line = br.readLine())!= null) {
			if(line.split("\t")[1].equals(filmName)) {
				
				//순위\t제목\t정보......
				//substring은 문자 하나하나가 인덱스임 그래서 +1 해주면 \t이후 제목이나온다! 
				
				//indexOf는 첫번째 \t의 인덱스를 알려준다. 
				//1) 그렇기때문에 stub는 첫번째 \t 이후 부터 가져온다. 이것을
				String stub = line.substring(line.indexOf("\t")+1);
//				//일치하는 영화제목이 있다면 새로운 영화제목으로 변경한다. 
				
				temp += line.split("\t")[0] + "\t"
						+newFilmName 
						//2) stub여기서 한번 더 indexOf로 잘라준다. "\t" 가 이제 원본에서는 2번째거다. 
						+stub.substring(stub.indexOf("\t")) + "\n";
				//수정되면 원본은 날려야하므로 continue
				check = true;
				continue;
				
			}
			temp += line + "\n";
		}
		br.close();
//		//수정이 되었다면 덮어쓴 후 true 리턴
		if(check) {
			BufferedWriter bw = DBConnecter.getWriter();
			bw.write(temp);
			bw.close();
			return true;
		}
		return false;
	}
	//삭제
	
	public boolean delete (String filmName) throws IOException{
		
		BufferedReader br = DBConnecter.getReader();
		if(br == null) {return false;}
		
		String line = null;
		String temp = "";
		int ranking = 0;
		boolean check = false;
		
		while ((line = br.readLine())!= null) {
			ranking ++;
			if(line.split("\t")[1].equals(filmName)) {
				ranking --;
				check = true;
				continue;
			}
			//ranking은 위에서 새로 하니까! 제외하고 붙여야한다.
			//3을 삭제한다고하면 continue가 붙어서 4가 다시 3이 ranking이 되어서 붙는다. 
			temp += ranking + line.substring(line.indexOf("\t")) + "\n";
		}
		
		br.close();
		
		if(check) {
			BufferedWriter bw = DBConnecter.getWriter();
			bw.write(temp);
			bw.close();
			return true;
		}
		return false;
	}
	//검색
	
	public ArrayList<BoxOfficeVo> select (String keyword) throws IOException {
		BufferedReader br = DBConnecter.getReader();
		ArrayList<BoxOfficeVo> filmList = new ArrayList<>();
		if(br == null) {return null;}
		
		String line = null;
		
		
		while((line = br.readLine()) != null) {
			String [] arTemp = line.split("\t");
			if(arTemp[1].contains(keyword)) {
				BoxOfficeVo film = new BoxOfficeVo();
				film.setRanking(Integer.parseInt(arTemp[0]));
				film.setFilmName(arTemp[1]);
				film.setReleaseDate(arTemp[2]);
				film.setIncome(changeToLong(arTemp[3]));
				film.setGuestCnt(changeToInteger(removeS(arTemp[4])));
				film.setScreenCnt(changeToInteger(removeS(arTemp[5])));
				
				filmList.add(film);
			}
		}
		br.close();
		return filmList;
	}
	
	//목록
	public ArrayList<BoxOfficeVo> selectAll () throws IOException {
		BufferedReader br = DBConnecter.getReader();
		ArrayList<BoxOfficeVo> filmList = new ArrayList<>();
		if(br == null) {return null;}
		String line = null;
		while((line = br.readLine()) != null) {
			String [] arTemp = line.split("\t");
			BoxOfficeVo film = new BoxOfficeVo();
			
			film.setRanking(Integer.parseInt(arTemp[0]));
			film.setFilmName(arTemp[1]);
			film.setReleaseDate(arTemp[2]);
			film.setIncome(changeToLong(arTemp[3]));
			film.setGuestCnt(changeToInteger(removeS(arTemp[4])));
			film.setScreenCnt(changeToInteger(removeS(arTemp[5])));
			
			filmList.add(film);
		
		}
		br.close();
		return filmList;
	}
	
	
	public int changeToInteger (String includedComma) {
		String [] arTemp = includedComma.split(",");
		String result = "";
		for (int i = 0; i < arTemp.length; i++) {
			result += arTemp[i];
		}
		if(includedComma.equals("")) {
			result = "0";
		}
		return Integer.parseInt(result);
	}
	
	public long changeToLong (String includedComma) {
		String [] arTemp = includedComma.split(",");
		String result = "";
		for (int i = 0; i < arTemp.length; i++) {
			result += arTemp[i];
		}
		if(includedComma.equals("")) {
			result = "0";
		}
		return Long.parseLong(result);
	}
	
	public String removeS (String screenCnt) {
		if(screenCnt.contains("S")) {
			screenCnt = screenCnt.substring(screenCnt.indexOf("S")+2);
		}
		return screenCnt;
	}
	
}













