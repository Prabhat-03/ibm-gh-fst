package fst_selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.*;
import org.testng.annotations.*;

public class SuiteDemo1 {
	 @Test
	 public void firstTestCase() {
		 System.out.println("I'm in first test case from demoOne Class");
	 }

	 @Test
	 public void secondTestCase() {
	     System.out.println("I'm in second test case from demoOne Class");
	 }
}
