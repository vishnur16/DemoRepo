package CommnFunctions;

import org.openqa.selenium.By;

import Constants.Constantpage;

public class VerifyAdmin extends Constantpage{
	
	public boolean verify_Admin(String username,String passwd)
	{
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(passwd);
		driver.findElement(By.id("btnLogin")).click();
		String Acturl="dashboard";
		String url=driver.getCurrentUrl();
		if(url.contains(Acturl))
		{
			return true;
		}
		else
			return false;
	}

}
