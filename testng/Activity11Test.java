package fst_selenium;

import java.io.FileReader;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.*;
import org.testng.*;
import org.testng.annotations.*;

public class Activity11Test {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setup() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://training-support.net/webelements/simple-form");
		
	}
	
	
	public static List<List<String>> readXlsx(String filePath){
		List<List<String>> data = new ArrayList<>();
	
		Workbook file;
		try {
			file = new XSSFWorkbook(new FileInputStream(filePath));
			Sheet sheet = file.getSheetAt(0);
			
			for(Row rows: sheet) {
				if(rows.getRowNum()==0) {
					continue;
				}
				
				List<String> rowData = new ArrayList<>();
				for (Cell cells : rows) {	
					switch (cells.getCellType()) {
					case STRING:	
						rowData.add(cells.getStringCellValue().trim());
						break;
					case NUMERIC:
						if (DateUtil.isCellDateFormatted(cells)) {
							rowData.add(cells.getLocalDateTimeCellValue()
								.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
						} else {
							rowData.add(String.valueOf(cells.getNumericCellValue()));
						}
						break;
					default:
						rowData.add("-");
					}
				}
				data.add(rowData);
				file.close();
			}
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return data;
		
	}
	
	
	@DataProvider(name="xlsxData")
	public static Object[][] inputXlsx() throws Exception {
		List<List<String>> inputData = readXlsx("src/test/resources/Book1.xlsx");
		
		Object[][] data = new Object[inputData.size()][];
		for(int i = 0; i < inputData.size(); i++) {
			data[i] = inputData.get(i).toArray();
		}
		
		return data;
	}
	
	@Test(priority = 1)
	public void verifyPageTitle() {
		Assert.assertEquals(driver.getTitle(), "Selenium: Simple Form");
	
	}
	
	
	@Test(priority = 2 ,dataProvider = "xlsxData")
	public void simpleFormTest(String[] rows){
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
		driver.quit();

	}
}
