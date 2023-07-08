package com.login.inet;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseAccess {

	public WebDriver driver;;
	
	@Before
	
	public void AccessProject() throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions co= new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
	     driver=new ChromeDriver(co);
		/*WebDriver driver=new ChromeDriver();*/
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/v4/");
		driver.findElement(By.name("uid")).sendKeys("mngr512697");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("qYbAhYt",Keys.ENTER);
		Thread.sleep(5000);
		}
	}


