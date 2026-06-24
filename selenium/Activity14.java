package fst_selenium;

import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		Actions builder = new Actions(driver);
		
		driver.get("https://training-support.net/webelements/tables");
		
		System.out.println("Title : " + driver.getTitle());
		
		List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/thead/tr/th"));
        System.out.println("Number of columns: " + cols.size());

        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr"));
        System.out.println("Number of rows: " + rows.size());
        
        WebElement cellValue = driver.findElement(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr[5]/td[2]"));
        System.out.println("Book name before sorting: " + cellValue.getText());
        
        driver.findElement(By.xpath("//table[contains(@class, 'table-auto')]/thead/tr/th[5]")).click();

        cellValue = driver.findElement(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr[5]/td[2]"));
        System.out.println("Book Name after sorting: " + cellValue.getText());

        driver.quit();
	}

}
