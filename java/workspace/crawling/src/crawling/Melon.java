package crawling;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Melon {
	private WebDriver driver;
	private String url;
	
	public static final String WEB_DRIVER_ID ="webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH ="C:\\chromedriver.exe";
	
	public Melon() {
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		driver = new ChromeDriver(options);
		
		url ="https://www.melon.com/";
	}
	
	public void operate() {
		searchSong();
		//드라이버 종료
		try {
			if(driver!= null) {
				driver.close();
				driver.quit();
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	//태그를 객체로 보는 것이 익숙해져야한다. 
	//내가 원하는 태그를 정확히 가져오는 연습을 해야 앞으로 배울 Javascript도 쉽게 다룰 수 있다. 
	public void searchSong () {
		//메인 로직
		
		//노래 제목을 Scanner로 입력받고, 검색 결과를 뿌려준 후 사용자가 선택한 노래의 가사를 출력해준다.
		
		//1. 사용자가 입력한 키워드를 멜론 사이트 검색창에 넣어주기
		//2. 입력한 값으로 검색(엔터)해준다.
		//※ 엔터입력 : 태그 객체.sendKeys(Keys.RETURN);
		//3. 검색 결과가 없다면 알맞는 메세지 출력
		//NoSuchElementException(셀레니움 패키지에 있는 오류인거 잊지말기. 자바에도 동일한 이름의 예외가 있으므로 잘확인해야한다.)
		//4. 사용자에게 검색된 곡 정보들을 출력해준다. (10개)
		//5. 사용자가 입력한 번호에 맞는 곡의 가사를 출력해준다. 
		//6. 가사가 없거나 성인곡이라면 알맞는 메세지를 출력해준다. 
		
//		WebElement top = null;
//		WebElement search = null;
//		String songname = null;
//		
//		System.out.print(searchMsg);
//		songname = sc.next();
//		
//		try {
//			top = driver.findElement(By.id("gnb"));
//			search = top.findElement(By.className("ui-autocomplete-input"));
//			search.sendKeys(songname);
//			search.sendKeys(Keys.RETURN);
//		} catch (NoSuchElementException e) {
//			System.out.println("찾는 곡이 없습니다. ");
//		}
//		
//		WebElement searchSongTBL = null;
//		
//		searchSongTBL = driver.findElement(By.id("frm_searchSong"));
//		for (WebElement songs : searchSongTBL.findElements(By.className("fc_gray"))) {
//			System.out.println(songs.getText());
//		}
//		
//		System.out.print(lyricNumMsg);
//		int songnum = 0;
//		songnum = sc.nextInt();
////		WebElement songNumEle = null;
//		
//		for (WebElement temp : searchSongTBL.findElement(By.tagName("tbody")).findElements(By.tagName("tr"))) {
//			if (songnum == Integer.parseInt(temp.getText())) {
//				songnum = Integer.parseInt(temp.getText());
//			}
//		}

		Scanner sc = new Scanner(System.in);
		String searchMsg = "노래 제목 :";
		String lyricNumMsg = "곡 번호 :";
		WebElement element = null;
		//변수의 재사용
		//1. 메모리 효율, 절약  
		//2. 가독성이 떨어진다. 
		
		driver.get(url);
		try {Thread.sleep(1000);} catch (InterruptedException e) {}
		//검색 창 태그 가져오기 ui-autocomplete-input
		element = driver.findElement(By.className("ui-autocomplete-input"));
		
		//사용자가 입력한 키워드를 멜론 사이트 검색창에 넣어주기
		System.out.print(searchMsg);
//		sc.next(); //사용자가 입력한 문자열 값
		
		//태그객체.sendKeys(sc.next());
		element.sendKeys(sc.nextLine()); //노래 제목에 공백이 포함될 수 있기 때문에 nextLine()사용
		
		//엔터 입력
		element.sendKeys(Keys.RETURN);

		//검색 결과 페이지 로딩 대기
		try {Thread.sleep(1000);} catch (InterruptedException e) {}
		
		//예외처리하기
		try {
			//곡명으로 검색된 결과를 담고 있는 form 태그 객체   frm_searchSong
			element = driver.findElement(By.id("frm_searchSong"));
			
			//곡 번호 가져오기
			List<WebElement> numList = element.findElements(By.className("no"));

			//곡명 가져오기
			List<WebElement> titleList = element.findElements(By.className("fc_gray"));
			
			//아티스트 가져오기 artistName(부모 div태그)
			List<WebElement> artistList = element.findElements(By.id("artistName"));
			
			//가져온 데이터를 통해 목록 출력
			for (int i = 0; i < numList.size(); i++) { //3개의 list가 인덱스를 모두 공유한다. 
				System.out.println(numList.get(i).getText() + ". " + 
					titleList.get(i).getText() + ", 아티스트 : " + artistList.get(i).getText());
			}
			
			//번호 입력 받기
			System.out.print(lyricNumMsg);
			int num = sc.nextInt();
			
			//입력한 번호의 가사 보기 버튼 클릭 (입력한 번호 -1번재 방의 가사 버튼) btn_icon_detail
			element.findElements(By.className("btn_icon_detail")).get(num-1).click(); //이게 사용자가 원하는 가사 태그. 오....
			try {Thread.sleep(1000);} catch (InterruptedException e) {;}
			
			//가사가 없는 노래를 먼저 찾고(d_register 버튼을 먼저 찾기) 만약에 가사가 있는 노래면 catch로 들어간다. 
			try {
				//가사등록하기 버튼이 있다면
				driver.findElement(By.className("d_register"));
				//가사가 없는 날이다.
				System.out.println("가사가 없는 곡입니다.");
			} catch (NoSuchElementException e) {
				//가사 등록하기 버튼이 없다면 가사가 있는 곡이거나 성인 노래다.
				
				//가사 펼치기 클릭 button_more
				
				//가사가 없는 노래는 아닌데, 성인인증일경우가 있을수 이므로, 다시 한번 try를 잡는 것이다.
				try {
					//가사 펼치기가 있다면 해당 가사를 출력해준다.
					driver.findElement(By.className("button_more")).click();
					try {Thread.sleep(1000);} catch (InterruptedException e1) {;}
					
					//가사 가져와서 출력하기 lyric
					element = driver.findElement(By.className("lyric"));
					System.out.println(element.getText());
				} catch (Exception e1) {
					//가사 펼치기 버튼이 없다면 성인 노래이다.
					System.out.println("성인 노래 가사는 열람하실 수 없습니다. ");
				}
			}
		} catch (NoSuchElementException e) {
			System.out.println("검색 결과가 없습니다.");
		}
		
		//예외처리
		
	}
	public static void main(String[] args) {
		Melon melon = new Melon();
		melon.operate();
	}
}
