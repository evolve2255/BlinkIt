package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNGPractice {
	
	public ExtentReports getExtentReporter() {
		
		String path = System.getProperty("user.dir")+"//extentReportsDemo//demoReport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Observation");
		reporter.config().setReportName("Web Auromation Results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "ejpanilk");
		return extent;
	}

}
