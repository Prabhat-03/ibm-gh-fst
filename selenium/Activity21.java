package fst_selenium;

import java.util.Set;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Activity21 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://training-support.net/webelements/tabs");
		
		System.out.println("Title : " + driver.getTitle());
		System.out.println("Current Tab: " + driver.getWindowHandle());
	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Open A New Tab']"))).click();
		
		String tab1 = driver.getWindowHandle();
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		System.out.println("Current Open Tabs : " + driver.getWindowHandles());
		
		Set<String> handles = driver.getWindowHandles();
		for(String i: handles) {
			if (i!=tab1)
				driver.switchTo().window(i);

		}
		
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Open Another One']"))).click();
		
		System.out.println("Current Tab: " + driver.getWindowHandle());
		System.out.println("Title of the Current Page : " + driver.getTitle());
		System.out.println("Message: " + driver.findElement(By.xpath("//h2[contains(@class, 'mt-5')]")).getText());
		
		
		String tab2 = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[text()='Open Another One']")).click();
		
//		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		handles = driver.getWindowHandles();
		for(String i: handles) {
				Thread.sleep(1000);
				driver.switchTo().window(i);
				System.out.println("Message: " + driver.findElement(By.xpath("//h2")).getText());
				System.out.println("Title of the Current Page : " + driver.getTitle());
		}
		
		driver.quit();
	
	}

}
