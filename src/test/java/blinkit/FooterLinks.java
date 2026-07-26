package blinkit;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FooterLinks {

	
	@Test
	public void CheckFooterLinks() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(5));
		Actions action = new Actions(driver);
		driver.get("https://blinkit.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("select-locality")).sendKeys("600096");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Chennai']")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class='LocationDropDown__LocationOverlay-sc-bx29pc-1 bLgtGp']")));
		
//		WebElement usefulLinks =  driver.findElement(By.xpath("//div[text()='Useful Links']"));
		WebElement footerLinksBox = driver.findElement(By.xpath("//div[text()='Useful Links']/following-sibling::ul"));
		
		List<WebElement> footerLinks =  footerLinksBox.findElements(By.tagName("a"));
		System.out.println(footerLinks.size());
		
		for(int i = 0; i<footerLinks.size();i++) {
			
			action.keyDown(Keys.CONTROL)
		       .click(footerLinks.get(i))
		       .keyUp(Keys.CONTROL)
		       .build()
		       .perform();
			Thread.sleep(1000);
		}
		
		
//		wait.until(ExpectedConditions.numberOfWindowsToBe(footerLinks.size()+1));
		Set<String> handles =  driver.getWindowHandles();
		Iterator<String> iter = handles.iterator();
		String parentId = iter.next();
		
		for(int i =0; i<footerLinks.size();i++) {
			
		if(iter.hasNext())	{
			
		String childId = iter.next();
		driver.switchTo().window(childId);
		System.out.println("Title is "+driver.getTitle());
		
		}
		
		}
		
		int totalWindows = handles.size();
		int childWindows = totalWindows-1;
		Assert.assertEquals(footerLinks.size(), childWindows);
		
	}
}
