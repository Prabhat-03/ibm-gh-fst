package fst_selenium;

import java.time.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Acitivity9 {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://training-support.net/webelements/dynamic-content");
		
		System.out.println("Title of Page : " + driver.getTitle());
		
		driver.findElement(By.id("genButton")).click();
		
		if (wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("word"), "release"))) {
			System.out.println("Word Found: " + driver.findElement(By.id("word")).getText());
		}
		
		driver.quit();
		
	}
}
