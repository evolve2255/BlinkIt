package blinkitTestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import blinkit.AbstractComponents;
import blinkitPageFactory.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BlinkitBaseTest extends AbstractComponents{
	
	public WebDriver driver;
	public WebDriverWait wait;
	public LandingPage landingPage;
	public Actions action;
	public JavascriptExecutor js;

	
	public WebDriver initializeBrowser() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Browser.properties");
		prop.load(file);
		
		String browserName =System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
//		 prop.getProperty("browser");
		
		if(browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(browserName.contains("headless")) {
			options.addArguments("-headless");
			
			
			}
			
			driver = new ChromeDriver(options);
//			driver.manage().window().setSize(new Dimension(1440, 900));
		}
		
		if(browserName.equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();
		}
		
		if(browserName.contains("firefox")) {
			
			FirefoxOptions options = new FirefoxOptions();
			WebDriverManager.firefoxdriver().setup();
			if(browserName.contains("headless")) {
				options.addArguments("-headless");
			}
			driver = new FirefoxDriver(options);
		}
		
		wait =  new WebDriverWait(driver, Duration.ofSeconds(5));
		action = new Actions(driver);
		js = (JavascriptExecutor) driver;
		
		return driver;
	
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts =(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination =new File(System.getProperty("user.dir")+"//extentReportsDemo//screenShots//"+testCaseName+".png"); 
		FileUtils.copyFile(source, destination);
		return System.getProperty("user.dir")+"//extentReportsDemo//screenShots//"+testCaseName+".png";
	}
	
	
	
	@BeforeMethod
	public void launchApp() throws IOException {
		driver = initializeBrowser();
		landingPage = new LandingPage(driver,wait);
		landingPage.goTo();
	}
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.quit();
	}
}
