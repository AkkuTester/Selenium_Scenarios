package Interview_Scenarios;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;


public class Broken_Link {

	public static void main(String[] args) throws IOException {
		// To check broken link
		System.setProperty("webdriver.edge.driver","F:\\Libraries/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.instagram.com/");
		
		List<WebElement> links =  driver.findElements(By.tagName("a"));
		
		for(WebElement link:links) {
			
			String href= link.getAttribute("href");
		try {	
			URL url = new URL(href);
			HttpURLConnection httpConnect = (HttpURLConnection)url.openConnection();
			httpConnect.connect();
			
			if(httpConnect.getResponseCode()>=400) {
				System.out.println(href + " is a broken link");
				System.out.println(httpConnect.getResponseMessage());
			}
		} catch (Exception e) {
			// TODO: handle exception
			}
		}
	}
}
