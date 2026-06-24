package fst_selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Activity6 {
	public static void main(String[] args) {
		
		String url = "https://training-support.net/webelements/dynamic-controls";
		
		WebDriver driver = new FirefoxDriver();
		driver.get(url);
		
		WebElement checkbox = driver.findElement(By.id("checkbox"));
		checkbox.click();
		
		
		System.out.println("Checkbox is selected : " + checkbox.isSelected());
		checkbox.click();
		
		System.out.println("Checkbox is selected : " + checkbox.isSelected());
		
		driver.close();
		
		
	}
}
