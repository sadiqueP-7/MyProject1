package com.login.inet;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BasicLoginAccess {
WebDriver driver;
	
	@BeforeClass
	
	public void TestAccess() throws InterruptedException {
		

		WebDriverManager.chromedriver().setup();
		ChromeOptions co= new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
	     driver=new ChromeDriver(co);
		/*WebDriver driver=new ChromeDriver();*/
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/v4/");
		driver.findElement(By.name("uid")).sendKeys("mngr508144");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("YbadYjU",Keys.ENTER);
		Thread.sleep(5000);
		}
	
	@Test 
	public void Averifytitle()
	{
		
		
		String Actualtitle=driver.getTitle();
		String Expectedtitle="Guru99 Bank Manager HomePage";
		System.out.println("title is "+Actualtitle);
		Assert.assertTrue(Actualtitle.equalsIgnoreCase(Expectedtitle), "Page title not matched");
	    /* Assert.assertEquals(Expectedtitle,"page title is incorrect:Actual title is"+Actualtitle);
	    System.out.println("Page title is coreect"+Actualtitle);*/
		
	}
	
	@Test 
	public void BNewCustomer() throws InterruptedException
	{
		 
		driver.findElement(By.cssSelector("a[href='addcustomerpage.php']")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.name("name")).sendKeys("Bsmi Asma");
		WebElement genderRadioButton=driver.findElement(By.xpath("//input[@value='f']"));
		genderRadioButton.click();
		
		WebElement DOBcalender=driver.findElement(By.id("dob"));
		DOBcalender.sendKeys("10-02-1992");
		WebElement address=driver.findElement(By.name("Bddr"));
		address.sendKeys("12th street federalway waynis");
	
		driver.findElement(By.name("city")).sendKeys("Fwderal");
		driver.findElement(By.name("state")).sendKeys("London");
		driver.findElement(By.name("pinno")).sendKeys("675593");
		driver.findElement(By.name("telephoneno")).sendKeys("859525750");
		driver.findElement(By.name("emailid")).sendKeys("Bsmiasmakp123@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Password1234");
		
		driver.findElement(By.name("sub")).click();	
		WebElement confirmation01=driver.findElement(By.className("heading3"));
		String Msgtext=confirmation01.getText();
		String ExpectedMsg="Customer Registered Successfully!!!";
		Assert.assertEquals(Msgtext, ExpectedMsg);
	}
	
	@Test
	public void CEditCustomer() throws InterruptedException
	{
		WebElement editbutton=driver.findElement(By.cssSelector("a[href='EditCustomer.php']"));
		editbutton.click();
		Thread.sleep(10000);
		driver.findElement(By.name("cusid")).sendKeys("47316");
		WebElement accsubmit=driver.findElement(By.name("AccSubmit"));
		accsubmit.click();
		Thread.sleep(2000);
		WebElement StateText=driver.findElement(By.name("state"));
		StateText.clear();
		StateText.sendKeys("Gemen State");
		driver.findElement(By.name("sub")).click();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
	}
	@Test
	public void StatVerify() throws InterruptedException
	{
	
        driver.findElement(By.name("cusid")).sendKeys("47316");
		WebElement accsubmit2=driver.findElement(By.name("AccSubmit"));
		accsubmit2.click();
		Thread.sleep(2000);
		WebElement StateText1=driver.findElement(By.name("state"));
		String actualText=StateText1.getAttribute("value");
		
		String expectedText="Gemen State";
		Assert.assertEquals(actualText, expectedText, "Saved text is incorrect");
		Thread.sleep(1000);
	}
		
		
		
	}
	
	



