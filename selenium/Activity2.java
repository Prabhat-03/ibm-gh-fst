package fst_selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		
		String url = "https://training-support.net/webelements/login-form/";
		
		driver.get(url);
		
		System.out.println("Page Title: " + driver.getTitle());
		
		driver.findElement(By.id("username")).sendKeys("admin");
		
		driver.findElement(By.id("password")).sendKeys("password");
		
		//------ USING ABSOLUTE PATH -----------//
//		driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/form/button")).click();

		//------ USING CSS SELECTOR -----------//
//		driver.findElement(By.cssSelector("button.svelte-1pdjkmx")).click();
		
		//------ USING RELATIVE XPATH ---------//
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		System.out.println("New Page Title : " + driver.getTitle());
		
		String msg = driver.findElement(By.tagName("h1")).getText();
		System.out.println(msg);
			
		driver.quit();
		
	}

}
