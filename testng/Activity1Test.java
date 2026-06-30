package fst_selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Activity1Test {
	WebDriver driver;
	
	@BeforeClass
	public void createInstance() {
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net");
	}
	
	
	@Test(priority=1)
	public void titleTest() {
		Assert.assertEquals(driver.getTitle(), "Training Support");
		driver.findElement(By.linkText("About Us")).click();
	}
	
	@Test(priority = 2)
	public void aboutUsTest() {
		Assert.assertEquals(driver.getTitle(), "About Training Support");
	}
	
	@AfterClass
	public void tear() {
		driver.quit();
	}
	
	
}
