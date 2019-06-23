package Tetsng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class Newtour2 {
	WebDriver driver;
	Properties p;
	FileInputStream fi;
  @Test
  public void login()
  {
  	driver.findElement(By.xpath(p.getProperty("objuser"))).sendKeys("Admin");
  	driver.findElement(By.xpath(p.getProperty("objpass"))).sendKeys("mercury");
  	driver.findElement(By.xpath(p.getProperty("login"))).click();
  }
  @Test
  public void register() throws InterruptedException
  {
  	driver.findElement(By.xpath(p.getProperty("Reg"))).click();
  	Thread.sleep(4000);
  	driver.findElement(By.xpath(p.getProperty("Fname"))).sendKeys("AJAY");
  	driver.findElement(By.xpath(p.getProperty("Lname"))).sendKeys("kumar");
  	driver.findElement(By.xpath(p.getProperty("Phone"))).sendKeys("9846736542");
  	driver.findElement(By.xpath(p.getProperty("mail"))).sendKeys("AJAY@gmail.com");
  	driver.findElement(By.xpath(p.getProperty("address"))).sendKeys("Kukatpally");
  	driver.findElement(By.xpath(p.getProperty("city"))).sendKeys("Hyderabad");
  	driver.findElement(By.xpath(p.getProperty("state"))).sendKeys("Telangana");
  	driver.findElement(By.xpath(p.getProperty("postal"))).sendKeys("500028");
  	
  	Select list=new Select(driver.findElement(By.xpath(p.getProperty("country"))));
  	list.selectByIndex(2);
  	driver.findElement(By.xpath(p.getProperty("username"))).sendKeys("AJAY@gmail.com");
  	driver.findElement(By.xpath(p.getProperty("password"))).sendKeys("12345");
  	driver.findElement(By.xpath(p.getProperty("cpassword"))).sendKeys("12345");
  }
  @BeforeMethod
  public void launch() throws IOException, InterruptedException
  {
  	driver =new ChromeDriver();
  	p=new Properties();
  	fi=new FileInputStream("C:\\Users\\vishnu\\Desktop\\JAVA_Selenium\\TestNG_framework\\Xpath.properties");
  	p.load(fi);
  	driver.get(p.getProperty("url"));
  	Thread.sleep(4000);
  	Reporter.log("inside the method");
  }

  @AfterMethod
  public void logout()
  {
  	driver.close();
  }
}
