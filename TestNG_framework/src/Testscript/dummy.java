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

public class dummy {
	
	WebDriver driver;
	Workbook wb;
	FileInputStream fi;
	Sheet ws;
	File screen;
  @Test(priority=0)
  public void Book() throws IOException, EncryptedDocumentException, InvalidFormatException
  {
	  fi= new FileInputStream("C:\\Users\\vishnu\\Desktop\\Inputdata.xlsx");
	  wb=WorkbookFactory.create(fi);
	  ws=wb.getSheet("data");
	  Row r=ws.getRow(0);
	  int rc=ws.getLastRowNum();
	  int cc=r.getLastCellNum();
	  for(int i=1;i<=rc;i++)
	  {
	  String trip=ws.getRow(i).getCell(0).getStringCellValue();
	  String deport=ws.getRow(i).getCell(1).getStringCellValue();
	  String fdate=ws.getRow(i).getCell(2).getStringCellValue();
	  String fday=ws.getRow(i).getCell(3).getStringCellValue();
	  String toarr=ws.getRow(i).getCell(4).getStringCellValue();
	  String tdate=ws.getRow(i).getCell(5).getStringCellValue();
	  String tday=ws.getRow(i).getCell(6).getStringCellValue();
	  String sclass=ws.getRow(i).getCell(7).getStringCellValue();
	  
	  Flight_book book=PageFactory.initElements(driver, Flight_book.class);
	  book.booking(trip, deport, fdate,fday, toarr, tdate, tday," First class", sclass, null);
	  
	  }
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
	  driver.get("http://newtours.demoaut.com");
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
