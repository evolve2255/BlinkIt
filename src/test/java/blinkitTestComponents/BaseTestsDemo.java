package blinkitTestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import blinkitPageFactory.LandingPage;

public class BaseTestsDemo {
	public WebDriver driver;
	public JavascriptExecutor js;
	public WebDriverWait wait;
	public Actions action;
	public LandingPage landingPage;
	
	public WebDriver initializeWebDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Browser.properties");
		prop.load(fis);
		String browswerName = prop.getProperty("browser");
		
		if(browswerName.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
		}
		
		if(browswerName.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
		}
		if(browswerName.equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();
		}
		
		wait =  new WebDriverWait(driver, Duration.ofSeconds(5));
		action = new Actions(driver);
		js = (JavascriptExecutor) driver;

		return driver;
		
		
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"//extentReportsDemo//"+testCaseName+".png");
		FileUtils.copyFile(source, dest);
		return System.getProperty("user.dir")+"//extentReportsDemo//"+testCaseName+".png";
		
	}
	
	@BeforeMethod
	public void launchApplication() throws IOException {
		
		driver = initializeWebDriver();
		landingPage = new LandingPage(driver, wait);
		landingPage.goTo();
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
	}
}
