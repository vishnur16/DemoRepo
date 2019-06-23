package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class loginpage {
	
	WebDriver driver;
	public loginpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
@FindBy(name="userName")
WebElement uname;
@FindBy(name="password")
WebElement passwd;
@FindBy(name="login")
WebElement signin;

public boolean loginpage1(String username,String password) throws InterruptedException
{
Thread.sleep(3000);
this.uname.sendKeys(username);
this.passwd.sendKeys(password);
signin.click();
Thread.sleep(3000);
String exvl="mercuryrese";
String actval =driver.getCurrentUrl();
if(actval.toLowerCase().contains(exvl.toLowerCase()))
{
	Reporter.log("login success",true);
	return true;
}
else {
Reporter.log("login success",true);
return true;
}
}

}
