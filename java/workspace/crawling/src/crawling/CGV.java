package crawling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CGV {
	private WebDriver driver; 
	private WebElement el;
	
	public static final String WEB_DRIVER_ID ="webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH ="C:\\chromedriver.exe";
	
	public static void main(String[] args) {
		CGV cgv = new CGV();
		WebElement el1 = null;
		WebElement el2 = null;
		
		//드라이버 설정
		try {
			System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		//WebDriver설정
//		ChromeOptions options = new ChromeOptions();
		
//		cgv.driver = new ChromeDriver(options);
		//크롬에 관려된 옵션을 설정하기위해 options를 ChromeDriver 생성자에 넣어주고, (옵션이 있을 경우에 이렇게 씀) 
		//cgv의 드라이버에 넣어준다.
		//WebDriver가 부모 ChromeDriver가 자식. 업케스팅 하여 넣어준것이다. 
		
		cgv.driver = new ChromeDriver();
		String url = "http://www.cgv.co.kr/movies/";
		cgv.driver.get(url); //사이트로 가는것! 

		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} //컴파일러가 페이지 로딩보다 더 빠르기때문에 기다려주는것임
		
		//btn-more-fontbold (더보기 버튼 클래스명)
		
		el1 = cgv.driver.findElement(By.className("btn-more-fontbold")); //이 통째로가 CGV 사이트의 더보기 버튼임! 개쩐다..
		el1.click(); //클릭 자체가 다 가능한것이다.
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//sect-movie-chart  //영화정보가지고있는 div 태그 클래스명
		el2 = cgv.driver.findElement(By.className("sect-movie-chart"));
		
		
		//가져온 태그 안에 찾을 자식 태그가 있다면 또 한 번 findElement()를 사용할 수 있다. 
			//title 클래스가 웹페이지에 많음 (영화제목) 즉 그래서 복수로 findElements로
			//리스트 타입을 리턴하는 메소드로 가져와야한다.
		int rank = 0;
		for (WebElement film : el2.findElements(By.className("title"))){ 
			System.out.println(++rank + ". " + film.getText()); //film에 담긴 텍스트를 가져올 수 있다. 
		}
		
		//닫는 부분 try 처리 중요! 
		try {
			if(cgv.driver != null) {
				//드라이버 연결 종료
				cgv.driver.close(); //close : 드라이버 연결 해제. 메모리에서 해제
				
				//크롬 프로세서 종료 
				cgv.driver.quit(); // quit : 열린 브라우저를 닫는 메소드. 
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
	}
	
}



















