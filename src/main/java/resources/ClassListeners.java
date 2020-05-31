package resources;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ClassListeners extends Base implements ITestListener  {
	ExtentReports reporter = ExtentReportUtility.reporting();
	ExtentTest test;

	private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		test = reporter.createTest(result.getMethod().getMethodName());
		extTest.set(test);

	}

	public void onTestSuccess(ITestResult result) {
		extTest.get().log(Status.PASS, "Successfull");
	}

	public void onTestFailure(ITestResult result) {
		WebDriver driver2 = null;

		extTest.get().fail(result.getThrowable());
		Object testObject = result.getInstance();

		Class clazz = result.getTestClass().getRealClass();
		//ITestContext context=result.getTestContext();
		//driver2=(WebDriver) context.getAttribute("driver");
        WebDriver webDriver = ((Base) testObject).getDriver();


		try {
			driver2 = (WebDriver)clazz.getDeclaredField("driver").get(testObject);
		} catch (Exception e) {
		}
		try {

			
			extTest.get().addScreenCaptureFromPath(getScreenPath(result.getMethod().getMethodName(),webDriver),
					result.getMethod().getMethodName());

		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

	public void onFinish(ITestContext context) {
		reporter.flush();
	}

	public void onTestSkipped(ITestResult result) {
	}

}



