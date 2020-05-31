package resources;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	WebDriver driver;

	public WebDriver initialisation() {
		String downloadPath = System.getProperty("user.dir");

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

		chromePrefs.put("profile.default_content_settings.popups", 0);

		chromePrefs.put("download.default_directory", downloadPath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		return driver;
	}

	public String getScreenPath(String testname, WebDriver driver2) throws IOException {
		String destPath = System.getProperty("user.dir") + "\\reports\\" + testname + ".png";
		TakesScreenshot ts = (TakesScreenshot)driver2;
		File src = ts.getScreenshotAs(OutputType.FILE);
		// String destPath=System.getProperty("user.dir")+"\\reports\\"+testname+".png";

		File dest = new File(destPath);
		FileUtils.copyFile(src, dest);
		  Reporter.log("<br><img src='"+dest+"' height='300' width='300'/><br>");  
		return destPath;
	}

	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
}
