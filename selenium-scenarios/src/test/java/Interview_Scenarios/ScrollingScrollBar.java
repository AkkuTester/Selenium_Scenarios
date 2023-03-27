package Interview_Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class ScrollingScrollBar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		

		System.setProperty("webdriver.edge.driver","F:\\Libraries/msedgedriver.exe");
		
		WebDriver driver = new EdgeDriver();
		driver.get("https://the-internet.herokuapp.com/horizontal_slider");
		
	WebElement element =	driver.findElement(By.tagName("input"));
	Thread.sleep(2000);
	element.sendKeys(Keys.END);
	
	}

}
