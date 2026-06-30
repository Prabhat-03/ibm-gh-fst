package fst_selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.*;
import org.testng.annotations.*;

public class Activity2Test {
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/target-practice/");
	}


	@Test
	public void getTitle() {
		Assert.assertEquals(driver.getTitle(), "Selenium: Target Practice");
	}
	
	@Test
	public void findElement() {
		WebElement BlackButt = driver.findElement(By.xpath("//button[text()='Purple']"));
		Assert.assertTrue(BlackButt.isDisplayed());
		Assert.assertEquals(BlackButt.getText(), "black");
	}
	
	
	@Test(enabled = false)
	public void skipMethod() {
		System.out.println("Skip Test Example");
	}
	
    @Test
	
    public void testCase4() {
        // This test will be skipped and will be be shown as skipped
        throw new SkipException("Skipping test case");
	
    }
    
    
    
	@AfterClass
	public void clear() {
		driver.quit();
	}

}

