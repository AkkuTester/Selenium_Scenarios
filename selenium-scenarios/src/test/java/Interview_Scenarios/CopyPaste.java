package Interview_Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class CopyPaste {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver","F:\\Libraries/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.facebook.com/");
		
	WebElement email = driver.findElement(By.name("email"));
	WebElement password = driver.findElement(By.name("pass"));
	
	Thread.sleep(3000);
	email.sendKeys("nifty");
	
	Actions action = new Actions(driver);
	
	Thread.sleep(3000);
	
	//selecting the text to copy + copying the selected text
	action.keyDown(Keys.CONTROL)
			.sendKeys("a")
			.keyDown(Keys.CONTROL)
			.sendKeys("c").build().perform();
	
	//now move cursor(focus) on the password field

	Thread.sleep(3000);
	action.keyDown(password, Keys.CONTROL)
			.sendKeys("v")
			.keyUp(password, Keys.CONTROL).build().perform();
					
	}

}
