package Interview_Scenarios;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class RefreshPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.edge.driver","F:\\Libraries/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.amazon.in");
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Actions action = new Actions(driver);
		
		action.keyDown(Keys.CONTROL).sendKeys(Keys.F5).build().perform();
		
		driver.quit();
	}

}
