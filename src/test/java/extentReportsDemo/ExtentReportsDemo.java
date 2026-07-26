package extentReportsDemo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class ExtentReportsDemo {
	ExtentReports extent;
	@BeforeTest
	public void config() {
		String path = System.getProperty("user.dir")+"//extentReportsDemo//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Web Automation Result");
		reporter.config().setReportName("Test Results");
		
		 extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "@ejpanilk");
	}
	
	@Test
	public void getTitle() throws IOException {
		
		extent.createTest("Title Check");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source =  ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir")+"//extentReportsDemo//screenCaputre.png");
		FileUtils.copyFile(source, destination);
		driver.close();
		
		
		extent.flush();
		
	
	}
	
	@Test
	public void getTitleFail() throws IOException {
		
		ExtentTest test =  extent.createTest("Title Check");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source =  ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir")+"//extentReportsDemo//screenCaputre.png");
		FileUtils.copyFile(source, destination);
		driver.close();
		test.fail("Just Failing");
		
		extent.flush();
		
	
	}

}
