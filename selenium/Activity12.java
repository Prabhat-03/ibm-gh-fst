package fst_selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		Actions builder = new Actions(driver);
		
		driver.get("https://training-support.net/webelements/drag-drop");
		
		System.out.println("Title : " + driver.getTitle());
		
		WebElement ball = driver.findElement(By.id("ball"));
		WebElement dz1 = driver.findElement(By.id("dropzone1"));
		WebElement dz2 = driver.findElement(By.id("dropzone2"));
		
		builder.clickAndHold(ball).moveToElement(dz1).build().perform();
		System.out.println(driver.findElement(By.xpath("//div[@id='dropzone1']//span")).getText());
		
		builder.clickAndHold(ball).moveToElement(dz2).build().perform();
		System.out.println(driver.findElement(By.xpath("//div[@id='dropzone2']//span")).getText());
		
		
		driver.quit();
		
		
	}

}
