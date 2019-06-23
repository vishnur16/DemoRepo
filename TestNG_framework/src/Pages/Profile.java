package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Profile {
	
	WebDriver driver;
	Select select;
	public Profile(WebDriver driver)
	{
		this.driver=driver;
		}
	
@FindBy(linkText="PROFILE")
WebElement click_profile;
@FindBy(name="firstName")
WebElement fname;
@FindBy(name="lastName")
WebElement lname;
@FindBy(name="phone")
WebElement phone;
@FindBy(name="email")
WebElement email;
@FindBy(name="address1")
WebElement address1;
@FindBy(name="city")
WebElement city;
@FindBy(name="state")
WebElement state;
@FindBy(name="postalCode")
WebElement pcode;
@FindBy(name="country")
WebElement stcoutry;
@FindBy(tagName="a")
WebElement submit;

public void create_profile(String firstname,String Lastname,String Phon,String mail,String addess,String city,String state,String pcode,String country)
{
	this.click_profile.click();
	this.fname.sendKeys(firstname);
	this.lname.sendKeys(Lastname);
	this.phone.sendKeys(Phon);
	this.email.sendKeys(mail);
	this.address1.sendKeys(addess);
	this.city.sendKeys(city);
	this.state.sendKeys(state);
	this.pcode.sendKeys(pcode);
	new Select(stcoutry).selectByVisibleText(country);
	//submit.click();
}


}
