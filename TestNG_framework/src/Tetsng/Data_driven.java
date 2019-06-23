package Tetsng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorksheetDocument;
import org.testng.annotations.AfterTest;

public class Data_driven {
	WebDriver driver;
	FileInputStream fi;
	Workbook wb;
	Sheet sh;
	Row r;
		
  @Test
  public void login()   {
	  try {
	  int rc =sh.getLastRowNum();
	  for(int i=1;i<=rc;i++)
	  {
		  
		  String usename=sh.getRow(i).getCell(0).getStringCellValue();
		  String password=sh.getRow(i).getCell(1).getStringCellValue();
		  
		  driver.navigate().to("http://newtours.demoaut.com/");
		  driver.manage().window().maximize();
		  Thread.sleep(4000);
		  driver.findElement(By.linkText("SIGN-ON")).click();
		  driver.findElement(By.name("userName")).sendKeys(usename);
		  driver.findElement(By.name("password")).sendKeys(password);
		  driver.findElement(By.name("login")).click();
		  Thread.sleep(4000);
		  
		  if(driver.getCurrentUrl().contains("reservation"))
		  {
			  sh.getRow(i).createCell(2).setCellValue("Pass");
			  sh.getRow(i).createCell(3).setCellValue("Success");
			  driver.findElement(By.linkText("SIGN-OFF")).click();
		  }
		  else
		  {
			  //String message=driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p/font/text()[1]")).getText();
			  Thread.sleep(4000);
			  sh.getRow(i).createCell(2).setCellValue("Fail");
			  sh.getRow(i).createCell(3).setCellValue("Invalid");
		  }		   
	  }
	  fi.close();
	  FileOutputStream fo=new FileOutputStream("C:\\Users\\vishnu\\Desktop\\JAVA_Selenium\\TestNG_framework\\output\\Result.xlsx");
	  wb.write(fo);
	  wb.close();
	  fo.close();
	  }catch(Throwable t)
	  {
		  System.out.println(t.getMessage());
	  }
  }
  @BeforeTest
  public void Launch() throws EncryptedDocumentException, InvalidFormatException, IOException {
	  fi= new FileInputStream("C:\\Users\\vishnu\\Desktop\\JAVA_Selenium\\TestNG_framework\\Input\\Data_file.xlsx");
	  wb=WorkbookFactory.create(fi);
	  sh=wb.getSheet("Login");
	  driver=new ChromeDriver();	  
  }

  @AfterTest
  public void Logout() {
	  driver.close();
  }

}
