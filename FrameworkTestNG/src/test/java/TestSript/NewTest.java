package TestSript;

import org.testng.annotations.Test;

import CommnFunctions.VerifyAdmin;
import Constants.Constantpage;
import PageClass.AddEmp;
import PageClass.UserSearch;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

public class NewTest {
	
	WebDriver driver;
	
  @Test
  public void SearchTest() 
  {
	  UserSearch userS = PageFactory.initElements(driver, UserSearch.class);
	  userS.user_search("Admin", "Thomas Fleming");
  }
  @Test
  public void addEmp()
  {
	  AddEmp addemp=PageFactory.initElements(driver, AddEmp.class);
	  addemp.add_User("Jhon", "Smith", "0948");
  }
  @BeforeMethod
  public void Launch() 
  {
	  
	  Constantpage launch=PageFactory.initElements(driver, Constantpage.class);
	  launch.lauchPage();
	  VerifyAdmin admin=PageFactory.initElements(driver, VerifyAdmin.class);
	  
	  admin.verify_Admin("Admin", "admin123");
	  
	  
  }

  @AfterMethod
  public void afterMethod()
  {
	  Constantpage launch=PageFactory.initElements(driver, Constantpage.class);
	  launch.logOut();
	  
  }

}
