package fst_selenium;

import java.time.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.*;
import org.testng.*;
import org.testng.annotations.*;

public class Activity6Test {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setup() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://training-support.net/webelements/login-form/");
	}

	@Test
	@Parameters({"username","password", "message"})
	void loginTest(String username, String password, @Optional("Login Success!") String message) {
		WebElement Username = driver.findElement(By.id("username"));
		WebElement Password = driver.findElement(By.id("password"));
		
		Username.sendKeys(username);
		Password.sendKeys(password);
		
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		wait.until(ExpectedConditions.titleContains("Success"));
		
		String msg = driver.findElement(By.xpath("//h2[@class='mt-5 text-center text-4xl font-semibold text-gray-800']")).getText();
		Assert.assertEquals(msg, "Welcome Back, Admin!");
		
		
	}
	
	
	@AfterClass
	public void cleanup() {
		driver.close();

	}
}
