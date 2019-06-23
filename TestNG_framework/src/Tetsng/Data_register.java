package Tetsng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class Data_register {

	WebDriver driver;
	FileInputStream fi;
	FileOutputStream fo;
	Workbook wb;
	Sheet ws;
	Row r;
	File screen;
  @Test
  public void register() 
  {try {
  	fi=new FileInputStream("C:\\Users\\vishnu\\Desktop\\Data_register.xlsx");
  	wb=WorkbookFactory.create(fi);
  	ws=wb.getSheet("Register");
 		r=ws.getRow(0);
  	 	int rc= ws.getLastRowNum();
  	int cc=r.getLastCellNum();
  	Reporter.log("no of row"+rc +"    "+"no of collumn "+cc);
  	for(int i=1;i<=rc;i++)
  	{
  		driver.get("http://newtours.demoaut.com/");
		driver.findElement(By.partialLinkText("REG")).click();
		driver.manage().window().maximize();
		Thread.sleep(4000);
  		
  		String fname=ws.getRow(i).getCell(0).getStringCellValue();
  		String lname=ws.getRow(i).getCell(1).getStringCellValue();
  		if(wb.getSheet("Register").getRow(i).getCell(2).getCellType()==Cell.CELL_TYPE_NUMERIC)
  		{
  			int celldata=(int)wb.getSheet("Register").getRow(i).getCell(2).getNumericCellValue();
  			String phone=String.valueOf(celldata);
  			String email=ws.getRow(i).getCell(3).getStringCellValue();
  			String address1=ws.getRow(i).getCell(4).getStringCellValue();
  			String address2=ws.getRow(i).getCell(5).getStringCellValue();
  			String city=ws.getRow(i).getCell(6).getStringCellValue();
  			String state=ws.getRow(i).getCell(7).getStringCellValue();
  			if(wb.getSheet("Register").getRow(i).getCell(8).getCellType()==Cell.CELL_TYPE_NUMERIC)
  			{
  			int celldata1=(int)wb.getSheet("Register").getRow(i).getCell(8).getNumericCellValue();
  			String postalcode=String.valueOf(celldata1);
  			String country=ws.getRow(i).getCell(9).getStringCellValue();
  			String uname=ws.getRow(i).getCell(10).getStringCellValue();
  			String passwd=ws.getRow(i).getCell(11).getStringCellValue();
  			String cpasswd=ws.getRow(i).getCell(12).getStringCellValue();
  			
  			
  			driver.findElement(By.name("firstName")).sendKeys(fname);
  			driver.findElement(By.name("lastName")).sendKeys(lname);
  			driver.findElement(By.name("phone")).sendKeys(phone);
  			driver.findElement(By.name("userName")).sendKeys(email);
  			driver.findElement(By.name("address1")).sendKeys(address1);
  			driver.findElement(By.name("address2")).sendKeys(address2);
  			driver.findElement(By.name("city")).sendKeys(city);
  			driver.findElement(By.name("state")).sendKeys(state);
  			driver.findElement(By.name("postalCode")).sendKeys(postalcode);
  			driver.findElement(By.name("country")).sendKeys(country);
  			driver.findElement(By.name("email")).sendKeys(uname);
  			driver.findElement(By.name("password")).sendKeys(passwd);
  			driver.findElement(By.name("confirmPassword")).sendKeys(cpasswd);
  			driver.findElement(By.name("register")).click();
  			
  			if(passwd.equals(cpasswd))
  			{
  				screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
  				FileUtils.copyFile(screen, new File("C:\\Users\\vishnu\\Desktop\\JAVA_Selenium\\TestNG_framework\\Screenshots"+i+"Image.png"));
  			    String message=driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td")).getText();
  			    ws.getRow(i).getCell(13).setCellValue(message);
  			}
  			else
  			{
  				screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
  				FileUtils.copyFile(screen, new File("C:\\Users\\vishnu\\Desktop\\JAVA_Selenium\\TestNG_framework\\Screenshots"+i+"Image"));
  				ws.getRow(i).getCell(13).setCellValue("Invalid usename and passwd");
  			}
  			
  			
  			}
  		}
  		
  	}
  	fi.close();
  	fo=new FileOutputStream(new File("C:\\Users\\vishnu\\Desktop\\JAVA_Selenium\\TestNG_framework\\output\\Data_register.xlsx"));
  	wb.close();
  	fo.close();
  }catch(Throwable t)
  {
	  System.out.println(t.getMessage());
  }
  }
  @BeforeTest
  public void launch()
  {
  	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\vishnu\\Desktop\\JAVA_Selenium\\chromedriver.exe");
  	driver =new ChromeDriver();
  }

  @AfterTest
  public void logout()
  {
  	driver.close();
  }

}
