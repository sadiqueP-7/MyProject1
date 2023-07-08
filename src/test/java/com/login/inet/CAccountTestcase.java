package com.login.inet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CAccountTestcase {

	WebDriver driver;
	
/*@BeforeTest (groups= {"Smoke"})
	
	public void TestAccess() throws InterruptedException {
		

		WebDriverManager.chromedriver().setup();
		ChromeOptions co= new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
	     driver=new ChromeDriver(co);*/
		/*WebDriver driver=new ChromeDriver();*/
		/*driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/v4/");
		driver.findElement(By.name("uid")).sendKeys("mngr508144");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("YbadYjU",Keys.ENTER);
		Thread.sleep(5000);}*/
	
	@Test(dependsOnMethods= {"com.login.inet.BasicLoginAccess.TestAccess"})
	
	public void Accountcreation() throws InterruptedException
	{
		driver.findElement(By.cssSelector("a[href='addAccount.php']")).click();
		Thread.sleep(2000);
	}
}
