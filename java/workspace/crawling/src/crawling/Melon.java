package crawling;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
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
		
		Scanner sc = new Scanner(System.in);
		String searchMsg = "노래 제목 :";
		String lyricNumMsg = "곡 번호 :";
		
		driver.get(url);
		//검색 창 태그 가져오기
		//사용자가 입력한 키워드를 멜론 사이트 검색창에 넣어주기
		//태그객체.sendKeys(sc.next());
		//엔터 입력
		
		
		
		
	}
	
}
