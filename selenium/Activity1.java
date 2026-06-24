package fst_selenium;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Activity1  {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/");
		System.out.println("Page Title : " + driver.getTitle());
		
		driver.findElement(By.linkText("About Us")).click();
		Thread.sleep(1);
		
		System.out.println("About Page title is : "+ driver.getTitle());
		
		driver.quit();
		
		
	}

}
