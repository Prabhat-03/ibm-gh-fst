package fst_selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class Activity16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/webelements/selects");
		System.out.println("Title : " + driver.getTitle());
	
		WebElement drop = driver.findElement(By.xpath("//select[contains(@class, 'h-10')]"));
		Select sel = new Select(drop);
		
		sel.selectByVisibleText("Two");
		System.out.println("The selected option is: " + sel.getFirstSelectedOption().getText());
		
		sel.selectByIndex(3);
		System.out.println("The selected option is : " + sel.getFirstSelectedOption().getText());
		
		sel.selectByValue("four");
		System.out.println("The selected option is : " + sel.getFirstSelectedOption().getText());
		
		List<WebElement> selectall = sel.getOptions();
		for(WebElement i: selectall) {
			System.out.println("Option -> " + i.getText());
		}
		
		
		driver.quit();
		
	
	}

}
