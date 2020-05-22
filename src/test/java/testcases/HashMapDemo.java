package testcases;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.Base;
import resources.HashMapExcelDemo;

public class HashMapDemo extends Base {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver=initialisation();
		
	}
	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}

	@Test
	public void verifyCredentials() throws IOException {
		
		driver.get("https://www.duda.co/login");
		LinkedHashMap<String,String> map=HashMapExcelDemo.mapExcelDemo("DataWords","Login");
		driver.findElement(By.name("userName")).sendKeys(map.get("username"));;
		driver.findElement(By.name("pwd")).sendKeys(map.get("password"));;
		driver.findElement(By.id("login-submit")).click();
	}
	public void teardown()
	{
		driver.close();
	}
}