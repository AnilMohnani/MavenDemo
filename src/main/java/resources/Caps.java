package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Caps {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		WebElement ele=driver.findElement(By.name("q"));
		Actions actions=new Actions(driver);
		actions.moveToElement(ele).keyDown(Keys.SHIFT).sendKeys("anil").build().perform();
		driver.get("https://login.salesforce.com/?locale=eu");
		Thread.sleep(10000);
		//JavascriptExecutor js=(JavascriptExecutor) driver;
	    //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebElement target=driver.findElement(By.id("signup_link"));
		target.sendKeys(Keys.CONTROL,Keys.ENTER);
		String parent=driver.getWindowHandle();
		Set<String> str=driver.getWindowHandles();
		Iterator<String> itr=str.iterator();
		while(itr.hasNext())
		{
			if(itr.next()!=parent)
			{
			driver.switchTo().window(itr.next());
			System.out.println(driver.findElement(By.xpath("//div[contains(text(),'30 DAY FREE TRIAL')]")).getText());
		}
	}
		FileInputStream fis=new FileInputStream("path");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("");
		Row rows=sheet.getRow(0);
		int totRows=sheet.getLastRowNum();
		int totCells=rows.getLastCellNum();
		By ele1=By.cssSelector("");
		WebDriverWait wait=new WebDriverWait(driver,20);	
		wait.until(ExpectedConditions.visibilityOfElementLocated(ele1));
		workbook.close();
		
		
	}
}