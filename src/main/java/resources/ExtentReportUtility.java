package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {

	public static ExtentReports reporting() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter spark = new ExtentSparkReporter(path);
		spark.config().setReportName("Test Automation Results");
		spark.config().setDocumentTitle("Test Execution Result");
		ExtentReports reporter=new ExtentReports();
		reporter.attachReporter(spark);
		reporter.setSystemInfo("Tester","Anil Kumar");
		return reporter;
	}
}
