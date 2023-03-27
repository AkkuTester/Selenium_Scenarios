package Interview_Scenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DnyamicOrInfiniteScroll {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver","F:\\Libraries/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://the-internet.herokuapp.com/infinite_scroll");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	
	  long intialLength = (long) js.executeScript("return document.body.scrollHeight");
		
	while(true) {
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		Thread.sleep(2000);
		long currentLength = (long) js.executeScript("return document.body.scrollHeight");
		
		if(intialLength == currentLength) {
            break;
        }
		
		intialLength = currentLength;
	}
 }

}
