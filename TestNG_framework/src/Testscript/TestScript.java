package Testscript;

import org.testng.annotations.Test;


import Pages.Flight_book;
import Pages.Profile;
import Pages.loginpage;
import Pages.logoutpage;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

public class TestScript {
	
	WebDriver driver;
		File screen;
		
  @Test(priority=0)
  public void Book() throws IOException, EncryptedDocumentException, InvalidFormatException
  {
	 
	 
	  Flight_book book=PageFactory.initElements(driver, Flight_book.class);
	  book.booking("3", "London", "February","13", "Seattle","February", "16", "Businessclass", "Unified Airlines", null);
	  
	 
  }
  @Test(priority=1)
  public void profile() throws IOException
  {
	  Profile create_profile=PageFactory.initElements(driver, Profile.class);
	  create_profile.create_profile("ramesh", "janki", "946893282", "abcds@gmail.com", "Kukatpally", "Hyderabad", "Telangana", "500018", "INDIA ");
	  screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(screen, new File("C:\\Users\\vishnu\\Desktop\\JAVA_Selenium\\Sceenshots\\profile.png"));
  }
  @BeforeMethod
  public void launch() throws InterruptedException {
	  driver=new ChromeDriver();
	  driver.get("http://newtours.demoaut.com/mercurywelcome.php");
	  driver.manage().window().maximize();
	  
	  loginpage login=PageFactory.initElements(driver, loginpage.class);
	  login.loginpage1("Admin", "mercury");
  
  }

  @AfterMethod
  public void afterMethod() {
	  logoutpage logout=PageFactory.initElements(driver, logoutpage.class);
	  logout.logout();
	  
  }

}
