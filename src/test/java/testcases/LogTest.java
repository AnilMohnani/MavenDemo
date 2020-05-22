package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;
import resources.Base;


public class LogTest extends Base{
	WebDriver driver;

private static Logger log=LogManager.getLogger(LogTest.class.getName());
public WebDriver getDriver() {
	// TODO Auto-generated method stub
	return driver;
}
     
	@Test
	public void testTitle()
	{
		driver = initialisation();
		log.info("Driver initialised");
		driver.get("https://google.com");
		log.debug("Browser launched");
		Assert.assertEquals(driver.getTitle(),"oogle");
		log.error("error occured");
		log.warn("warning");
		driver.close();
	}
	
}
