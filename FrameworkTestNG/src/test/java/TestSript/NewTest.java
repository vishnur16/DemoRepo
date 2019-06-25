package TestSript;

import org.testng.annotations.Test;

import CommnFunctions.VerifyAdmin;
import Constants.Constantpage;
import PageClass.AddEmp;
import PageClass.UserSearch;
import Utils.ReadData;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

public class NewTest extends Constantpage{
	
	
	
  @Test
  public void SearchTest() 
  {
	  String inputpath="C:\\Users\\vishnu\\git\\DemoRepo\\FrameworkTestNG\\InputData\\Inputdata.xlsx";
	  String output="C:\\Users\\vishnu\\git\\DemoRepo\\FrameworkTestNG\\Output\\Output.xlsx";
	  ReadData exl=new ReadData(inputpath);
	  //ReadData exl=PageFactory.initElements(driver, ReadData.class);
	  String sheet="Search";
	  int rowcount=exl.rowCountNum(sheet);
	  int cellcount=exl.cellCount(sheet);
	  System.out.println(rowcount+"  "+cellcount);
	  for(int i=0;i<rowcount;i++)
	  {
		  String fname=exl.getCellData(sheet, i, 0);
		  String lname=exl.getCellData(sheet, i, 1);
			  System.out.println(fname+"   "+lname);
		  UserSearch userS = PageFactory.initElements(driver, UserSearch.class);
		  userS.user_search(fname, lname);
		  
		  String exp=driver.getCurrentUrl();
		  String act="viewSystemUsers";
		  if(exp.contains(act))
		  {
		  exl.setCellData(sheet, i, 2, "Pass", output); 
		  }
		  else
			  exl.setCellData(sheet, i, 2, "Fail", output);
	  }
	  
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
