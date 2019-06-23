package Tetsng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Switchto {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("http://primusbank.qedgetech.com");
		  driver.manage().window().maximize();
		  Thread.sleep(4000);
		  driver.findElement(By.name("txtuId")).sendKeys("Admin");
		  driver.findElement(By.name("txtPword")).sendKeys("Adming");
		  driver.findElement(By.name("login")).click();
		  Thread.sleep(4000);
		  String url=driver.getCurrentUrl();
		  System.out.println(url);
		  String message=driver.switchTo().alert().getText();
		  System.out.println(message);
		  driver.switchTo().alert().accept();
		  driver.close();
	}

}
