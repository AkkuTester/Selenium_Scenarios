package general_Scenarios;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class ProgressBar {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

	System.setProperty("webdriver.edge.driver", "F:\\Libraries/msedgedriver.exe");
	WebDriver driver = new EdgeDriver();
	driver.get("https://jqueryui.com/progressbar/");
	
	Thread.sleep(1000);
	driver.findElement(By.linkText("Download Dialog")).click();
	//switch into the frame
	Thread.sleep(1000);
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[@id='downloadButton']")).click();
	//when progress bar would be on 50% take screen shot
	
	WebElement progressBar = driver.findElement(By.xpath("//div[@class='progress-label']"));
	
	while(true) {
		
		if(progressBar.getText().equals("Current Progress: 52%")) {
			System.out.println("true"); 
			// code for screenshot
			TakesScreenshot ts = (TakesScreenshot)driver;
	File scr =		ts.getScreenshotAs(OutputType.FILE);
	File dest = new File(".//screenshot/one.png");
	FileUtils.copyFile(scr, dest);
			break;
		}else if(progressBar.getText().equals("Complete!")) {
			System.out.println("false");
			break;
		}
		
	}
	}

}
