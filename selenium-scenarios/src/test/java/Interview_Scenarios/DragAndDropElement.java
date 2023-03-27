package Interview_Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropElement {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver","F:\\Libraries/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://jqueryui.com/draggable/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.switchTo().frame(0); //frame
		
	WebElement dragable = driver.findElement(By.xpath("//div[@id='draggable']"));
	
	Actions act = new Actions(driver);
	Thread.sleep(1000);
	act.dragAndDropBy(dragable, 195, 108).build().perform();
	Thread.sleep(1000);
	act.release(dragable).perform();
	// Coming out of the frame
	driver.switchTo().defaultContent();
	Thread.sleep(1000);
	driver.findElement(By.linkText("Droppable")).click();
	}

}
