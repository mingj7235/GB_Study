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

public class Investing {
	private WebDriver driver;
	private String url;
	public static final String WEB_DRIVER_ID ="webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH ="C:\\Users\\joshua\\Desktop\\chromedriver\\chromedriver.exe ";
	
	public Investing() {
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		driver = new ChromeDriver(options);
		
		url ="https://www.investing.com/";
	}
	
	public void operate () {
		searchData();
		try {
			if(driver!= null) {
				driver.close();
				driver.quit();
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public void searchData () {
		Scanner sc = new Scanner(System.in);
		WebElement element = null;
		driver.get(url);
		try {Thread.sleep(1000);} catch (InterruptedException e) {}
		
		element = driver.findElement(By.className("js-main-search-bar"));
		System.out.print("검색할 티커 명 : ");
		element.sendKeys(sc.nextLine());
		element.sendKeys(Keys.RETURN);
		
		try {Thread.sleep(1000);} catch (InterruptedException e) {}
		
		try {
			element = driver.findElement(By.className("js-inner-all-results-quotes-wrapper"));
			
			List<WebElement> stockList = element.findElements(By.className("second"));
			
			List<WebElement> stockListDetail = element.findElements(By.className("fourth"));
			
			int num = 0;
			for (int i = 0; i < stockList.size(); i++) {
				System.out.println(++num + "주식 티커 : " + stockList.get(i).getText() +
						", 상장 시장 : " + stockListDetail.get(i).getText());
			}
			
			System.out.print("상세정보 확인 (해당 티커 번호 입력) : ");
			try {
				element.findElements(By.className("js-inner-all-results-quote-item")).get(num-1).click();
				try {Thread.sleep(1000);} catch (InterruptedException e) {;}
				
				String stockname = driver.findElement(By.className("float_lang_base_1")).getText();
				String price = driver.findElement(By.id("last_last")).getText();
				System.out.println("주식 명 : " + stockname + "현재가격 : " + price);
			} catch (NoSuchElementException e) {
				System.out.println("티커 번호를 다시 확인해주세요");
			}
		} catch (NoSuchElementException e) {
			System.out.println("검색 결과가 없습니다.");
		}
		
	}
	
	public static void main(String[] args) {
		Investing invest = new Investing();
		invest.operate();
	}
}

















