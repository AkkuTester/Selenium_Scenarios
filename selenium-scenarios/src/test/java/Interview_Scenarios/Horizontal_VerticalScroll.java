package Interview_Scenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Horizontal_VerticalScroll {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver","F:\\Libraries/msedgedriver.exe");
		
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.lambdatest.com/blog/scroll-a-webpage-in-selenium-using-java/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		Thread.sleep(2000);
		// to scroll the PGAE_RIGHT by somme pixel
		js.executeScript("window.scrollBy(1000, 0)");
		
		// to scroll the PAGE_LEFT by some pixels
		js.executeScript("window.scrollBy(-1000,0)"); 
		
		WebElement element = null;
		
		// to scroll upto the specific web element
		js.executeScript("arguments[0].scrollIntoView();", element);
		
	}

}
