package testcases;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import resources.Base;

public class FileUpload extends Base {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = initialisation();
	}

	@Test
	public void uploadFileTest() throws IOException, InterruptedException {
		driver.get("https://www.ilovepdf.com/jpg_to_pdf");

		driver.findElement(By.xpath("//span[contains(text(),'Select JPG images')]")).click();

		Runtime.getRuntime().exec("C:\\Users\\AnilY\\images\\fileupload.exe");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("processTask")));
		driver.findElement(By.id("processTask")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pickfiles")));
		driver.findElement(By.id("pickfiles")).click();
		Thread.sleep(5000);
		File f = new File(System.getProperty("user.dir") + "\\ganeshji.pdf");

		if (f.exists()) {
			System.out.println("found");
			if (f.delete()) {
				System.out.println("deleted");
			}
		}

	}
	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}

	@AfterMethod()
	public void teardown() {
		driver.close();
	}
	@Test
	public void titleVerification() {
		driver.get("https://www.youtube.com/");

		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, "YouTub");
	}
}