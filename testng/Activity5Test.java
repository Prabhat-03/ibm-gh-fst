package fst_selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.*;
import org.testng.annotations.*;

public class Activity5Test {
	WebDriver driver;
	
	@BeforeClass (alwaysRun = true)
	public void setup() {
		driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/target-practice");
	}
	
	
	@Test (groups = {"HeaderTests", "ButtonTests"})
	public void pageTitleTest() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Selenium: Target Practice");
	}
	
	
	@Test (dependsOnMethods = {"pageTitleTest"}, groups = {"HeaderTests"})
	public void HeaderTest1() {
		String header = driver.findElement(By.xpath("//h3[contains(text(), '#3')]")).getText();
		Assert.assertEquals(header, "Heading #3");
	}
	
	
	@Test (dependsOnMethods = {"pageTitleTest"}, groups = {"HeaderTests"})
	public void HeaderTest2() {
		Color fifthHeaderColor = Color.fromString(driver.findElement(By.xpath("//h5[contains(text(), '#5')]")).getCssValue("color"));
		Assert.assertEquals(fifthHeaderColor.asRgb(), "rgb(147, 51, 234)");
	}
	
	
	@Test (dependsOnMethods = {"pageTitleTest"}, groups = {"ButtonTests"})
	public void ButtonTest1() {
		WebElement emerald = driver.findElement(By.xpath("//button[text()='Emerald']"));
		Assert.assertEquals("Emerald", emerald.getText());
	}
	
	
	@Test (dependsOnMethods = {"pageTitleTest"}, groups = {"ButtonTests"})
	public void ButtonTest2() {
		Color firstButton = Color.fromString(driver.findElement(By.xpath("//button[text()='Purple']")).getCssValue("color"));
		System.out.println(firstButton);
		Assert.assertEquals(firstButton.asRgba(), "rgba(88, 28, 135, 1)");
	}
	
	@AfterClass (alwaysRun = true)
	public void cleanup() {
		driver.close();
	}
}
