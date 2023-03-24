package guru99;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

public class Guru99Bank_Login {
	WebDriver driver; String url;
	
	@BeforeMethod
	public void luanchBrowser() throws IOException {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");

		//System.setProperty("webdriver.chrome.driver", "F:\\Libraries/msedgedriver.exe" );
		driver = new ChromeDriver(co);
		url = FileData_Reader.readData_fromPropFile("url");
	}
	@Test
	public void verifyLoginSection_SS1() {
		Reporter.log("edge browser lanch sussecfully" +"<br>");
		driver.get(url);
		Reporter.log("Redirected to desired url" + "<br>");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Reporter.log("The amount of time the driver should wait when searching for a GUI element has been specified"+ "<br>");
		
		try {
			driver.findElement(By.name("uid")).sendKeys(FileData_Reader.readData_fromPropFile("uname"));
			Reporter.log("Valid Username entered" +"<br>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			driver.findElement(By.name("password")).sendKeys(FileData_Reader.readData_fromPropFile("password"));
			Reporter.log("Valid Password entered" +"<br>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.name("btnLogin")).click();
		Reporter.log("Clicked on button" +"<br>");
		String actualTitle = "Guru99 Bank Manager HomePage";
		Assert.assertEquals(actualTitle, driver.getTitle().trim());
		Reporter.log("Title of the home page verified" +"<br>");
	boolean managerId_Display =	driver.findElement(By.xpath("//td[text() = 'Manger Id : mngr486317']")).isDisplayed();
		Assert.assertTrue(managerId_Display);
		Reporter.log("Login with valid credientials passed" + "<br>");
	}
	
	
	@Test
	public void invalid_user_valid_password_ss2() throws IOException {
		Reporter.log("TC for invalid user id and valid password has been started" +"<br>");
		Reporter.log("edge browser lanch sussecfully" +"<br>");
		driver.get(url);
		Reporter.log("Redirected to desired url" + "<br>");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	WebElement username =	driver.findElement(By.name("uid"));
	username.clear();
	username.sendKeys(FileData_Reader.readData_fromPropFile("invalidUsername"));
	Reporter.log("Invalid Username entered" +"<br>");
		
	WebElement pass =driver.findElement(By.name("password"));
	pass.clear();
	pass.sendKeys(FileData_Reader.readData_fromPropFile("validPassword"));
	Reporter.log("Valid Password entered" +"<br>");
	
	driver.findElement(By.name("btnLogin")).click();
	Reporter.log("Clicked on button" +"<br>");
	
	//checking alert has poped up or not
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	Reporter.log("validated alert is present" +"<br>");
		
	if(alert!=null) {
		alert = driver.switchTo().alert();
		String alertText = alert.getText();
		String ActualText = "User or Password is not valid";
		Assert.assertEquals(ActualText, alertText);
		Reporter.log("Pop up is validated" +"<br>");
		Reporter.log("TC Passed" + "<br>");
	} else {
		Assert.assertTrue(false);
		Reporter.log("TC failed" + "<br>");
	}
	}
	@Test
	public void valid_user_Invalid_password_ss2() throws IOException {
		Reporter.log("TC for invalid user id and valid password has been started" +"<br>");
		Reporter.log("edge browser lanch sussecfully" +"<br>");
		driver.get(url);
		Reporter.log("Redirected to desired url" + "<br>");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	WebElement username =	driver.findElement(By.name("uid"));
	username.clear();
	username.sendKeys(FileData_Reader.readData_fromPropFile("validUsername"));
	Reporter.log("Invalid Username entered" +"<br>");
		
	WebElement pass =driver.findElement(By.name("password"));
	pass.clear();
	pass.sendKeys(FileData_Reader.readData_fromPropFile("invalidPassord"));
	Reporter.log("Valid Password entered" +"<br>");
	
	driver.findElement(By.name("btnLogin")).click();
	Reporter.log("Clicked on button" +"<br>");
	
	//checking alert has poped up or not
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	Reporter.log("validated alert is present" +"<br>");
		
	if(alert!=null) {
		alert = driver.switchTo().alert();
		String alertText = alert.getText();
		String ActualText = "User or Password is not valid";
		Assert.assertEquals(ActualText, alertText);
		Reporter.log("Pop up is validated" +"<br>");
		Reporter.log("TC Passed" + "<br>");
	} else {
		Assert.assertTrue(false);
		Reporter.log("TC failed" + "<br>");
	}
	}
	
	@Test
	public void verifyManagerID() throws IOException {
		Reporter.log("edge browser lanch sussecfully" +"<br>");
		driver.get(url);
		Reporter.log("Redirected to desired url" + "<br>");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	WebElement username =	driver.findElement(By.name("uid"));
	username.clear();
	username.sendKeys(FileData_Reader.readData_fromPropFile("uname"));
	Reporter.log("Invalid Username entered" +"<br>");
		
	WebElement pass =driver.findElement(By.name("password"));
	pass.clear();
	pass.sendKeys(FileData_Reader.readData_fromPropFile("password"));
	Reporter.log("Valid Password entered" +"<br>");
	
	driver.findElement(By.name("btnLogin")).click();
	Reporter.log("Clicked on button" +"<br>");
	WebElement managerID = driver.findElement(By.xpath("(//td)[7]"));
	
	Assert.assertTrue(managerID.isDisplayed());
	Reporter.log("Validated Manager id is displayed" +"<br>");
	
	String actualMsg = "Manger Id : mngr486317";
	String capturedMsg = managerID.getText();
	Reporter.log("Manager Id captured" + "<br>");
	Assert.assertEquals(actualMsg, capturedMsg);
	Reporter.log("Validated Manager id " +"<br>");
	
	TakesScreenshot ts = (TakesScreenshot) driver;
		File src =	ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".//Screenshot/managerId.png");
		FileUtils.copyFile(src, dest);
	}
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.quit();
	}
	
}

// user id - mngr486317
//password - ytYpadU