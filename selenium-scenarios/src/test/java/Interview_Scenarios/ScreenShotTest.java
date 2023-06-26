package takeSS;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;

import web_Common_Functions.CaptureScreenshot;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class ScreenShotTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
	driver	= new EdgeDriver();
	}
	
	
	@Test
	public void testCase1() throws InterruptedException {
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("selenium");
		Thread.sleep(1500);
		Assert.assertTrue(false);
	}

	@Test
	public void testCase2() throws InterruptedException {
		driver.get("https://www.instagram.com/");
		Thread.sleep(1500);
		Assert.assertTrue(false);
	}
	
	@Test
	public void testCase3() {
		
		driver.get("https://www.linkedin.com/");
	}
	
	@AfterMethod
	public void shutDown(ITestResult result) throws IOException, InterruptedException {
		//if test case failed
		if(ITestResult.FAILURE == result.getStatus()) {
				CaptureScreenshot.captureScreenshot(driver, result.getName());
			System.out.println("Test Failed.. Screenshot captured");
		}
		Thread.sleep(1500);
		driver.close();
	}
}
