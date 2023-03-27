package general_Scenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class Launch_Drivers_Without_SystemSetProperty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//	WebDriver driver = new EdgeDriver(); //using edge
		
		//using chrome
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	
	WebDriver driver = new ChromeDriver(options);
	driver.get("https://www.google.com/");

	
	}

}
