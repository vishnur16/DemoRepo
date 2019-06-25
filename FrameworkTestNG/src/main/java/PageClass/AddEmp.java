package PageClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddEmp {
	WebDriver driver=null;
	Actions ac;
	public AddEmp(WebDriver driver)
	{
		this.driver=driver;
	}

@FindBy (id="menu_pim_viewPimModule")
WebElement pim;
@FindBy (id="menu_pim_addEmployee")
WebElement addemp;
@FindBy (id="firstName")
WebElement Fname;
@FindBy (id="lastName")
WebElement Lname;
@FindBy (id="employeeId")
WebElement Eid;
@FindBy (id="photofile")
WebElement file;
@FindBy (id="btnSave")
WebElement save;

public void add_User(String Fname, String Lname,String Eid)
{
	System.out.println(driver);
	driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	
	ac=new Actions(driver);
	ac.moveToElement(pim).click().build().perform();
	ac.moveToElement(addemp).click().build().perform();
	
	this.Fname.sendKeys(Fname);
	this.Lname.sendKeys(Lname);
	this.Eid.sendKeys(Eid);
	this.save.click();
}

}
