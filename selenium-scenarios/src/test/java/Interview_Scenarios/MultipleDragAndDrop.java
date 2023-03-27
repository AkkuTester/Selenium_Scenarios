package Interview_Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MultipleDragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver","F:\\Libraries/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml5_draganddrop");
		
		driver.switchTo().frame("iframeResult");
		
	WebElement drag = driver.findElement(By.id("drag1")); //src
	WebElement drop	= driver.findElement(By.id("div1")); //destination
	
	Actions actions = new Actions(driver);
	
 Action act	= actions.clickAndHold(drag)
			.moveToElement(drop)
			.release()
			.build();
 Thread.sleep(3000);
	act.perform();
	}

}
