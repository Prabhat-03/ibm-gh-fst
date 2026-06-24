package fst_selenium;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;


public class Avtivity15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		
		driver.get(" https://training-support.net/webelements/dynamic-attributes");
		System.out.println("Title : " + driver.getTitle());
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement fname = driver.findElement(By.xpath("//input[contains(@id, 'full-name')]"));
		WebElement email = driver.findElement(By.xpath("//input[contains(@id, '-email')]"));
		WebElement date = driver.findElement(By.xpath("//input[contains(@name, '-event-date-')]"));
		WebElement textarea = driver.findElement(By.xpath("//textarea[contains(@id, '-additional-details-')]"));
		
		fname.sendKeys("Gold D Roger");
        email.sendKeys("goldDroger@onepiece.com");
        date.sendKeys("2025-06-26");
        textarea.sendKeys("I'm the only Pirate King!");
        
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        
        String msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation"))).getText();
		 
        System.out.println(msg);
		driver.quit();
		
	}

}
