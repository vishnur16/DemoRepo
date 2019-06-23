package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class logoutpage {
	WebDriver driver;
	public logoutpage(WebDriver driver)
	{
		this.driver=driver;
	}
@FindBy(linkText="SIGN-OFF")
WebElement sinoff;
public void logout()
{
	sinoff.click();
	driver.close();
}
}
