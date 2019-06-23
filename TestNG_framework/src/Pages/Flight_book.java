package Pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Flight_book {

	WebDriver driver;
	Select select;
	File screen;
	
	public Flight_book(WebDriver driver)
	{
		this.driver=driver;
	}
@FindBy(name="tripType")
WebElement triptype;
@FindBy(name="passCount")
WebElement passengers;
@FindBy(name="fromPort")
WebElement fromdept;
@FindBy(name="fromMonth")
WebElement month;
@FindBy(name="fromDay")
WebElement fday;
@FindBy(name="toPort")
WebElement toarr;
@FindBy(name="toMonth")
WebElement tomon;
@FindBy(name="toDay")
WebElement tday;
@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font")
WebElement economy;
@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[1]")
WebElement bussiness;
@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[2]")
WebElement first;
@FindBy(name="airline")
WebElement airline;
@FindBy(name="findFlights")
WebElement continu;
String class1= "Economyclass";
String class2= "Businessclass";
String class3= "Firstclass";

public void booking(String passc,String From,String fmonth,String day,String to,String tmonth,String tday,String sclass,String airline,String flight) throws IOException
{
	
	this.triptype.click();
	new Select(passengers).selectByValue(passc);
	new Select(fromdept).selectByVisibleText(From);
	new Select(month).selectByVisibleText(fmonth);
	new Select(fday).selectByVisibleText(day);
	new Select(toarr).selectByVisibleText(to);
	new Select(tomon).selectByVisibleText(tmonth);
	new Select(this.tday).selectByVisibleText(tday);
	//new Select(this.sclass).selectByVisibleText(sclass);
	if(class1.equalsIgnoreCase(sclass))
	{
	this.economy.click();
	}
	else if(class2.equalsIgnoreCase(sclass))
	{
		this.bussiness.click();
	}
	else
		this.first.click();
	new Select(this.airline).selectByVisibleText(airline);
	screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(screen, new File("C:\\Users\\vishnu\\Desktop\\JAVA_Selenium\\Sceenshots\\book.png"));
	continu.click();
	
	
}

}
