package resources;

import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//import org.testng.annotations.BeforeTest;

public class ExtentReporterNG {
	
	
	public ExtentReports getExtentReporterObject() {
		
		String path = System.getProperty("user.dir")+"//extentReportsDemo//report.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("BlinkIt Automation Results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "@ejpanilk");
		return extent;
		
	}

}
