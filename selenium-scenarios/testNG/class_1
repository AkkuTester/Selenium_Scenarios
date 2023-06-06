package testNG_Attr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Groups_Demo {

	@Test(groups = "googleSearching")
	public void googleSearch() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		Thread.sleep(4000);
		driver.close();
	}
	
	@Test (groups = "bingSearching")
	public void bingSearch() throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.bing.com/");
		
		Thread.sleep(4000);
		driver.close();
	}

	@Test (groups = {"fbSearching"})
	public void fbSearch() throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.facebook.com/");
		
		Thread.sleep(4000);
		driver.close();
	}
}
