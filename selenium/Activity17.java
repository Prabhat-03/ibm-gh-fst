package fst_selenium;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class Activity17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/webelements/selects");
		System.out.println("Title : " + driver.getTitle());
		
		
		WebElement drop = driver.findElement(By.xpath("//select[contains(@class, 'h-80')]"));
		Select multisel = new Select(drop);
		
		multisel.selectByVisibleText("HTML");
//		System.out.println("Selected Option: " + multisel.getFirstSelectedOption().getText());
		
		for(int i = 3; i <= 5; i++) {
			multisel.selectByIndex(i);
		}
		
		multisel.selectByValue("nodejs");
		
		List<WebElement> selectedOpt = multisel.getAllSelectedOptions();
		for (WebElement i: selectedOpt) {
			System.out.println(i.getText());
		}
		
		multisel.deselectByIndex(5);
		
		selectedOpt = multisel.getAllSelectedOptions();
		for (WebElement i: selectedOpt) {
			System.out.println("After Deselection : " + i.getText());
		}
		
		driver.quit();
		
		
	}

}
