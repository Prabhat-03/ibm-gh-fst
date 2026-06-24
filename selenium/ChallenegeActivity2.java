package fst_selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ChallenegeActivity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.amazon.in/");
		
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

		searchBox.sendKeys("Iphone 17 pro");
		
		WebElement search = driver.findElement(By.id("nav-search-submit-button"));
		search.click();
		
//		System.out.println("The Price of the fourth phone is : " + driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[5]/div/div/span/div/div/div/div[2]/div/div/div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span/span[2]/span[2]")).getText());

		System.out.println("The Price of the fourth phone is : " + driver.findElement(By.xpath("//span[@class='aprice-whole'])[4]")).getText());
		
		//"/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[5]/div/div/span/div/div/div/div[2]/div/div/div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span/span[2]/span[2]")
		
		
	
		driver.quit();
	}

}
