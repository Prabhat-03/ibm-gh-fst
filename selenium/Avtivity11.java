package fst_selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class Avtivity11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		Actions builder = new Actions(driver);
		
		driver.get("https://training-support.net/webelements/keyboard-events");
		
		System.out.println("Title : " + driver.getTitle());
		
		builder.sendKeys("Yo Yo Yo, 3 to the 3 to the 6 to the 9. Representin ABQ. WHATTS UPP!").build().perform();
		
		System.out.println(driver.findElement(By.xpath("//h1[@class='mt-3 text-4xl font-semibold text-center text-black']")).getText());
		
		
		driver.quit();
		
	}

}
