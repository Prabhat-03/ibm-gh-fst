package fst_selenium;

import java.util.Set;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Activity22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://training-support.net/webelements/popups");
		
		System.out.println("Title : " + driver.getTitle());
		
		driver.findElement(By.id("launcher")).click();
		
		WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
		WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
		
		username.sendKeys("admin");
		password.sendKeys("password");
		
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		//wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//h2[contains(@class, 'mt-5')]")));
		
		System.out.println("Msg : " + driver.findElement(By.xpath("//h2[contains(@class, 'mt-5')]")).getText());
	
		driver.quit();
	}

}
