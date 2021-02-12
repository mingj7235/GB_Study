package crawling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//네이버 로그인 -> 메일 목록 불러오기 연습
public class NaverCrawling {
	private WebDriver driver;
	private String url;
	public static final String WEB_DRIVER_ID ="webdriver.chrome.driver";
//	public static final String WEB_DRIVER_PATH ="C:\\Users\\joshua\\Desktop\\chromedriver\\chromedriver.exe ";
	public static final String WEB_DRIVER_PATH ="C:\\chromedriver.exe";
	
	public NaverCrawling() {
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		driver = new ChromeDriver(options);
		
		url = "https://www.naver.com/";
	}
	
	public void operate() {
		searchData();
		try {
			if (driver != null) {
				driver.close();
				driver.quit();
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public void searchData() {
		Scanner sc = new Scanner(System.in);
		WebElement element = null;
		driver.get(url);
		threadSleep();
		
		//네이버 가져와서, 로그인 (로그인 입력하도록 하고), 메일 누르고, 메일 내용 출력할수있도록 크롤링
		
		driver.findElement(By.className("link_login")).click();
		
		System.out.println("아이디를 입력하세요 : ");
		String id = sc.next();
		System.out.println("비밀번호를 입력하세요 : ");
		String pw = sc.next();
		
		element = driver.findElement(By.id("id"));
		element.sendKeys(id);
		
		element = driver.findElement(By.id("pw"));
		element.sendKeys(pw);
		element.sendKeys(Keys.RETURN);
		
		//배열로 가져오기 (메일를 누르는 버튼 자체가 배열로 접근해서 가져와야함
		
		List<WebElement> loginbox = driver.findElements(By.className("new_box"));
		loginbox.get(0).click();
		
		element = driver.findElement(By.id("list_for_view")); // 네이버 메일 리스트 정보
		
	}
	
	public void threadSleep () {
		try {Thread.sleep(1000);} catch (InterruptedException e) {}
	}
	
	
	public static void main(String[] args) {
		NaverCrawling naver = new NaverCrawling();
		naver.operate();
	}
}












