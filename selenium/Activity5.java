package fst_selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Activity5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		String url = "https://training-support.net/webelements/dynamic-controls";
		driver.get(url);
	
		
		System.out.println("Title of the Page : " + driver.getTitle());
		
		WebElement checkbox = driver.findElement(By.id("checkbox"));
		
		driver.findElement(By.xpath("//button[text()='Toggle Checkbox']")).click();
		System.out.println("Checkbox is Displayed : " + checkbox.isDisplayed());
		
		driver.findElement(By.xpath("//button[text() = 'Toggle Checkbox']")).click();
		System.out.println("Checkbox is Displayed : " + checkbox.isDisplayed());
		
				
		driver.quit();
	}
}