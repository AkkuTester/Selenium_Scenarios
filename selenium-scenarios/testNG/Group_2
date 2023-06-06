package testNG_Attr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Groups2 {

	@Test (groups = {"Searching"})
	public void instaVisit() throws InterruptedException {
WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.instagram.com/");
		
		Thread.sleep(4000);
		driver.close();
	}
	
	@Test (groups = {"Searching"})
	public void twitterVisit() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.twitter.com/");
		
		Thread.sleep(4000);
		driver.close();
	}
	
	@Test (groups = {"tinderSearch"})
	public void tinderSearch() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.tinder.com/");
		
		Thread.sleep(4000);
		driver.close();		
	}
}
