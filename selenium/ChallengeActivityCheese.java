package fst_selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChallengeActivityCheese {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		Actions builder = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(180));
		
		driver.get("https://www.google.com/");
		
		WebElement element = driver.findElement(By.id("APjFqb"));
		element.sendKeys("Cheese");
		builder.sendKeys(Keys.ENTER).build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='R1QWuf'])[13]")));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds()); 
		WebElement tools = driver.findElement(By.xpath("(//span[@class='R1QWuf'])[13]"));
		tools.click();

		System.out.println(driver.findElement(By.xpath("//div[contains(@id, 'result-stats')]")).getText());
		
		
		driver.quit();
	}

}
