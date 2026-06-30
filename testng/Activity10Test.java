package fst_selenium;

import java.io.FileReader;
import java.time.*;
import java.util.List;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.*;
import org.testng.*;
import org.testng.annotations.*;

import com.opencsv.CSVReader;

public class Activity10Test {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setup() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://training-support.net/webelements/simple-form");
		
	}
	
	
	@DataProvider(name="csvData")
	public static Object[][] csvRead() throws Exception{
		CSVReader reader = new CSVReader(new FileReader("src/test/resources/SampleData.csv"));
		reader.skip(1);
		
		List<String[]> rowsList = reader.readAll();
		
		// For creating output Dataset:---->
		Object[][] data = new Object[rowsList.size()][];
		for(int i = 0; i < rowsList.size(); i++) {
			data[i] = rowsList.get(i);
		}
		reader.close();
		
		return data;
	}
	
	
	@Test(dataProvider = "csvData")
	public void simpleFormTest(String[] rows) {
		driver.findElement(By.id("full-name")).sendKeys(rows[0]);
		driver.findElement(By.id("email")).sendKeys(rows[1]);
		driver.findElement(By.name("event-date")).sendKeys(rows[2]);
		driver.findElement(By.id("additional-details")).sendKeys(rows[3]);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		String msg = driver.findElement(By.xpath("//h3[@id='action-confirmation']")).getText();
		Assert.assertEquals(msg, "Your event has been scheduled!");
		driver.navigate().refresh();
	}
	
	
	
	@AfterClass
	public void cleanup() {
		driver.close();

	}
}
