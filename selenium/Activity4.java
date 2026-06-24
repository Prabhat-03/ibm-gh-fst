package fst_selenium;


import org.openqa.selenium.support.Color;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		
		String url = "https://training-support.net/webelements/target-practice";
		driver.get(url);
		
		System.out.println("Title of the Page : " + driver.getTitle());
		
		System.out.println("3rd header of the Page : " + driver.findElement(By.xpath("//h3[contains(text(), '#3')]")));
		
//		System.out.println("5th Header of the Page : " + driver.findElement(By.tagName("h5")).getCssValue("color"));
		
		Color fifthHeaderColor = Color.fromString(driver.findElement(By.xpath("//h5[contains(text(), '#5')]")).getCssValue("color"));
		System.out.println("Fifth Header Color as Hex: " + fifthHeaderColor.asHex());
		System.out.println("Fifth Header Color as RGB: " + fifthHeaderColor.asRgb());
		System.out.println("Fifth Header Color as RGBA:" + fifthHeaderColor.asRgba());
		System.out.println("Normal Fifth Header Color : " + fifthHeaderColor);
		
		
		System.out.println("Purple Button Classes : " + driver.findElement(By.xpath("//button[text()='Purple']")).getAttribute("class"));
		
		System.out.println("Slate Button Text : " + driver.findElement(By.xpath("//button[contains(@class, 'slate')]")).getText());
		
		
		
		driver.quit();
		
	}
}
