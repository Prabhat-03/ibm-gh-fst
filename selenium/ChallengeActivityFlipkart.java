package fst_selenium;

import java.time.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChallengeActivityFlipkart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div/span")));
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		
		WebElement searchBox = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div/div/header/div[1]/div[1]/form/div/div/input"));

		searchBox.sendKeys("Iphone 17 pro");
		action.sendKeys(Keys.ENTER).build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='hZ3P6w DeU9vF'])[3]")));
		action.keyDown(Keys.ESCAPE).build().perform();
		
		System.out.println(driver.findElement(By.xpath("(//div[@class='hZ3P6w DeU9vF'])[3]")).getText());
		driver.close();
		
		

	}

}
