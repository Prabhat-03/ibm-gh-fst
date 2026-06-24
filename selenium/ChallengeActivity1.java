package fst_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ChallengeActivity1 {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
	
		driver.get("https://www.google.com");
	
		System.out.println(driver.findElement(By.id("APjFqb")));
		
		WebElement element = driver.findElement(By.id("APjFqb"));
		String a = element.getAttribute("id");
		System.out.println(a);
	
		WebElement element1 = driver.findElement(By.className("gLFyf"));
		String b = element.getAttribute("class");
		System.out.println(b);
		
		WebElement element2 = driver.findElement(By.name("q"));
		String c = element.getAttribute("name");
		System.out.println(c);
		
		driver.quit();
	
	
	}
	
}
