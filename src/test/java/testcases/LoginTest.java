package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import resources.Base;

public class LoginTest extends Base {
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
	public void loginTest()
	{
		
		driver.get("https://mvnrepository.com/artifact/com.aventstack/extentreports/4.1.5");
		System.out.println(driver.getTitle());
		driver.close();
	}
}
