package fst_selenium;

import java.time.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class Activity10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		Actions builder = new Actions(driver);
		
		driver.get("https://training-support.net/webelements/mouse-events");
		
		System.out.println("Title : " + driver.getTitle());
		
		WebElement cargolock = driver.findElement(By.xpath("//h1[text()='Cargo.lock']"));
		WebElement cargotoml = driver.findElement(By.xpath("//h1[text()='Cargo.toml']"));
		WebElement src = driver.findElement(By.xpath("//h1[text()='src']"));
		WebElement target = driver.findElement(By.xpath("//h1[text()='target']"));
		
		builder.click(cargolock).moveToElement(cargotoml).click(cargotoml).build().perform();
		
		System.out.println("Message 1 : " + driver.findElement(By.id("result")).getText());
		
		builder.doubleClick(src).pause(1000).moveToElement(target).contextClick(target).build().perform();
		
		System.out.println("Message 2 : " + driver.findElement(By.id("result")).getText());
		
//		builder.click(driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/div[2]/div/ul/li[1]/button"))).pause(1000).build().perform();
		
		builder.click(driver.findElement(By.xpath("//div[@id='menu']/div/ul/li[1]"))).pause(1000).build().perform();
		
		System.out.println("Message 3 : " + driver.findElement(By.id("result")).getText());
		
		driver.quit();

	}

}
