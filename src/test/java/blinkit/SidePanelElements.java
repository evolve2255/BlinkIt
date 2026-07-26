package blinkit;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SidePanelElements {

	
	@Test
	public void checkSidePanelelements() throws InterruptedException {
		
		String[] panelElements = {"Fresh Vegetables", "Fresh Fruits", "Exotics", "Seasonal", "Trusted Organic", "Leafies & Herbs","Eggs", "Milk" };
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(5));
//		Actions action = new Actions(driver);
		driver.get("https://blinkit.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("select-locality")).sendKeys("600096");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Chennai']")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class='LocationDropDown__LocationOverlay-sc-bx29pc-1 bLgtGp']")));
		
		
		WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='widgets__WidgetContainer-sc-1aj45no-1 cWxNgU']")));
		link.click();
		
		List<WebElement>sidepanelElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class*='tw-break-words']")));
		System.out.println(sidepanelElements.size());
		
//		sidepanelElements.stream().forEach(s->System.out.println(s.getText()));
		List<String> panelElementsList = Arrays.asList(panelElements);
		
		for(int i=0;i<sidepanelElements.size();i++) {
			
			String elementText = sidepanelElements.get(i).getText().trim();
			System.out.println("Checking element: " + elementText);
			
			Assert.assertTrue(panelElementsList.contains(elementText), 
			        "Test Failed: Sidepanel element '" + elementText + "' was not found in the expected list!");
			
			
		}
		
		
	}
	
}
