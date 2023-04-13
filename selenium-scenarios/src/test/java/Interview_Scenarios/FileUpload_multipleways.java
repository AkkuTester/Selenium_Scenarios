package Interview_Scenarios;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class FileUpload_multipleways {
	WebDriver driver;
	
	//using send keys and using absolute path of file
	@Test(priority = 1)
	public void usingSendKeys() throws InterruptedException {
		 driver = new EdgeDriver();
		Reporter.log("Driver luanched succesfully " + "<br>");
		String url = "https://www.foundit.in/";
		driver.get(url);
		Reporter.log("Went to desired url" + "<br>");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String xpath = "//div[@class = 'heroSection-buttonContainer_secondaryBtn__imgHolder']";
		WebElement upload_Resume = driver.findElement(By.xpath(xpath));	
		upload_Resume.click();
		Reporter.log("clicked on uppload resume button" + "<br>");
		//verifying the pop up
		String xpath1 = "//p[text() = 'Upload your resume to get started']";
		WebElement popUp = driver.findElement(By.xpath(xpath1));
		
		if(popUp!=null) {
			Reporter.log("pop verified" + "<br>");
			String actual = "Upload Resume";
			Assert.assertEquals(actual, "Upload Resume");
			Reporter.log("pop up text verified" + "<br>");

		}else {
			Reporter.log("Pop not verified" + "<br>");
			//screen shot code here
			Assert.assertTrue(false);
		}
	File file = new File(".//Data/resume.txt");
	driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys(file.getAbsolutePath());
	Reporter.log("file attached successfully !" + "<br>");
	
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//input[@id='pop_upload']")).click();
	Reporter.log("clicked on submit button successfully " + "<br>");
	
	}
	
	@Test (priority = 2)
	public void usingRobotClass() throws InterruptedException {
		driver = new EdgeDriver();
		Reporter.log("Driver luanched succesfully " + "<br>");
		String url = "https://www.foundit.in/";
		driver.get(url);
		Reporter.log("Went to desired url" + "<br>");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String xpath = "//div[@class = 'heroSection-buttonContainer_secondaryBtn__imgHolder']";
		WebElement upload_Resume = driver.findElement(By.xpath(xpath));	
		upload_Resume.click();
		Reporter.log("clicked on uppload resume button" + "<br>");
		//verifying the pop up
		String xpath1 = "//p[text() = 'Upload your resume to get started']";
		WebElement popUp = driver.findElement(By.xpath(xpath1));
		
		if(popUp!=null) {
			Reporter.log("pop verified" + "<br>");
			String actual = "Upload Resume";
			Assert.assertEquals(actual, "Upload Resume");
			Reporter.log("pop up text verified" + "<br>");

		}else {
			Reporter.log("Pop not verified" + "<br>");
			//screen shot code here
			Assert.assertTrue(false);
		}
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='uploadBtnCont']")).click();
		
		//
		try {
			//file to be uploaded. 
		String filePath = "C:\\Users\\Akash\\eclipse-workspace - Copy\\Interview_Selenium_Scenarios\\Data\\resume.txt";
		Robot robot = new Robot();
		robot.delay(2000);
		
		StringSelection ss = new StringSelection(filePath); 
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null); // for copying the file into the clip board.
		Reporter.log("file copied into the clip board " + "<br>");
		
		// CTRL + V
		robot.keyPress(KeyEvent.VK_CONTROL); // pressing the control button
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_V); // pressing the C button. (ctrl + v = pasting)
		robot.delay(2000);
		Reporter.log("file pasted on the window wizard" + "<br>");
		
		robot.keyRelease(KeyEvent.VK_V);	//releasing the keys
		robot.delay(2000);
		robot.keyRelease(KeyEvent.VK_CONTROL); 
		robot.delay(2000);
		
		// ENTER
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(2000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);
		Reporter.log("Entered pressed" + "<br>");
		
		} catch (AWTException e) {
			
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//input[@id='pop_upload']")).click();
		Reporter.log("clicked on submit button successfully " + "<br>");
		
	}
	
	@AfterMethod
	public void shutdown() throws InterruptedException {
		Thread.sleep(5000);
	driver.close();
	Reporter.log("driver closed succesfully!" + "<br>");
	}
}
