package PageClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;



public class UserSearch {
	
	Actions ac;
	WebDriver driver=null;
	public UserSearch(WebDriver driver)
	{
		this.driver=driver;
	}

@FindBy (xpath="//*[@id=\"menu_admin_viewAdminModule\"]/b")
WebElement admin;
@FindBy (id="menu_admin_UserManagement")
WebElement userMang;
@FindBy (id="menu_admin_viewSystemUsers")
WebElement user;
@FindBy (id="searchSystemUser_userName")
WebElement uname;
@FindBy (id="searchSystemUser_employeeName_empName")
WebElement Ename;
@FindBy (id="searchBtn")
WebElement Search;
	public void user_search(String Uname,String Ename) 
	{
		try
		{
			System.out.println("I am inside");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		ac =new Actions(driver);
		ac.moveToElement(admin).click().build().perform();
		ac.moveToElement(userMang).click().build().perform();
		ac.moveToElement(user).click().build().perform();
		
		this.uname.sendKeys(Uname);
		this.Ename.sendKeys(Ename);
		this.Search.click();
		}
		catch(Throwable t)
		{
			System.out.println(t.getMessage());
		}
		
		
	}
}
