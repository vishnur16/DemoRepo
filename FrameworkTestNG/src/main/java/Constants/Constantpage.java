package Constants;

import java.io.FileInputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Constantpage {

	public static WebDriver driver;
	public static FileInputStream fi;
	
	public void lauchPage()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\vishnu\\\\Desktop\\\\JAVA_Selenium\\\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
	}
	public void logOut()
	{
		driver.close();
	}
}
