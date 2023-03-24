package general_Scenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

public class Open_Five_Links_From_Footer {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.edge.driver", "F:\\Libraries/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String originalTab =driver.getWindowHandle();
		Thread.sleep(1000);
	//number of all links present -
	List<WebElement> allLiknks = driver.findElements(By.xpath("//tr/descendant::a"));
	System.out.println("Number of links = " +allLiknks.size());
	
	//now openig first five links in new tab
	for(int i=1; i<=5; i++) {
	Thread.sleep(1000);
	WebElement link = driver.findElement(By.xpath("//tr/descendant::a["+ i +"]"));
	String url = link.getAttribute("href");
	driver.switchTo().newWindow(WindowType.TAB);
	Thread.sleep(1000);
	driver.get(url);
	Thread.sleep(1000);
	//switching back to original windows where all of this links are available, 
	// otherwise it will show noSuchElementException
	driver.switchTo().window(originalTab);
	
	}
	driver.quit();
	}
}
