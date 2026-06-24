package fst_selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class Activity7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/webelements/dynamic-controls");
		
		System.out.println("Title : " + driver.getTitle());
		
		WebElement textbox = driver.findElement(By.id("textInput"));
		
		System.out.println("Textbox is Enabled: " + textbox.isEnabled());
		
		driver.findElement(By.id("textInputButton")).click();
		
		System.out.println("Textbox is Enabled : " + textbox.isEnabled());
		
		
		textbox.sendKeys("Yshesshhh");
		System.out.println("Text recieved from the textbox: " + textbox.getAttribute("value"));
		
		driver.close();
	}

}
