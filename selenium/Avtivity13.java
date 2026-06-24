package fst_selenium;


import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Avtivity13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/webelements/tables");
		
		System.out.println("Title : " + driver.getTitle());
		
		List<WebElement> cols = driver.findElements(By.xpath("//table[@class = 'w-full table-auto border-separate border-spacing-y-1 text-center']/thead/tr/th"));
		System.out.println("Column size : " + cols.size());
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class = 'w-full table-auto border-separate border-spacing-y-1 text-center']/tbody/tr"));
		System.out.println("Row Size : " + rows.size());
		
		List<WebElement> third = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr[3]"));
		for(WebElement i: third) {
			System.out.println(i.getText());
		}
		
		List<WebElement> srowscol = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr[2]/td[2]"));
		for(WebElement i: srowscol) {
			System.out.println(i.getText());
		}
		
		driver.quit();
		
	}

}
