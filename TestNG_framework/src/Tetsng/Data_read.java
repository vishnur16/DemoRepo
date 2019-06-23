package Tetsng;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Data_read {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		try {
	FileInputStream fi=new FileInputStream("C:\\Users\\vishnu\\Desktop\\JAVA_Selenium\\Data_file.xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(fi);
	XSSFSheet ws=wb.getSheet("Login");
	XSSFRow r=ws.getRow(0);
	int rc=ws.getLastRowNum();
    int cc=r.getLastCellNum();
    
    for(int i=1;i<=rc;i++)
    {
    	String username=ws.getRow(i).getCell(0).getStringCellValue();
    	String password=ws.getRow(i).getCell(1).getStringCellValue();
    	driver.get("https://opensource-demo.orangehrmlive.com/");
    	driver.findElement(By.id("txtUsername")).sendKeys(username);
    	driver.findElement(By.id("txtPassword")).sendKeys(password);
    	//driver.close();
    	
    	System.out.println(username+"    "+password);
    }
    driver.close();
fi.close();
wb.close();
	}
	
		catch(Throwable t)
	{
		System.out.println(t.getMessage());
	}
	}
	
}
