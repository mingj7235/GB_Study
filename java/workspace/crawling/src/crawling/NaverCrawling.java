package crawling;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//네이버 로그인 -> 메일 목록 불러오기 연습
public class NaverCrawling {
	private WebDriver driver;
	private String url;
	public static final String WEB_DRIVER_ID ="webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH ="C:\\Users\\joshua\\Desktop\\chromedriver\\chromedriver.exe ";
	
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
	}
	
	public void threadSleep () {
		try {Thread.sleep(1000);} catch (InterruptedException e) {}
	}
	
	
	
}












