package fst_selenium;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://training-support.net/webelements/alerts");
		
		System.out.println("Title : " + driver.getTitle());
		
		driver.findElement(By.id("prompt")).click();
		
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert = driver.switchTo().alert();
		
		System.out.println(alert.getText());
		
		alert.sendKeys("Awwwsomeeee!");
		alert.accept();
		
		System.out.println(driver.findElement(By.id("result")).getText());
		
		driver.close();
	}

}
