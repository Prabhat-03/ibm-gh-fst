package fst_selenium;

import java.time.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
		driver.get("https://training-support.net/webelements/dynamic-controls");
		
		System.out.println("Page Title is : " + driver.getTitle());
		
		WebElement checkbox = driver.findElement(By.id("checkbox")); 	
		System.out.println("Checkbox Visibility : " + checkbox.isDisplayed());
		
		driver.findElement(By.xpath("//button[text()='Toggle Checkbox']")).click();
		wait.until(ExpectedConditions.invisibilityOf(checkbox));
		
		
		System.out.println("Checkbox Visibility : " + checkbox.isDisplayed());
		
		driver.findElement(By.xpath("//button[text()='Toggle Checkbox']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
		
		System.out.println("Checkbox is selected: " + checkbox.isSelected());
		
		driver.quit();
		
		
		
	}

}
