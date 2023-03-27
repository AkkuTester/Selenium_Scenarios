package Interview_Scenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TillBottom {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.edge.driver","F:\\Libraries/msedgedriver.exe");
		
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.lambdatest.com/blog/scroll-a-webpage-in-selenium-using-java/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//scrolling down till the end of the web page
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, -document.body.scrollHeight)");
		
	}

}
