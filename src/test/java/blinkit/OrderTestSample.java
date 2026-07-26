package blinkit;

import java.awt.AWTException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class OrderTestSample {
	
	@Test
	public void placeOrder() throws AWTException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://blinkit.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("select-locality")).sendKeys("600096");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Chennai']")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class='LocationDropDown__LocationOverlay-sc-bx29pc-1 bLgtGp']")));
		WebElement fakeSearchField = wait.until(ExpectedConditions.elementToBeClickable(
			    By.className("SearchBar__PlaceholderContainer-sc-16lps2d-0")
			));
			fakeSearchField.click();
			
			WebElement realSearchInput = wait.until(ExpectedConditions.elementToBeClickable(
		    By.xpath("//input[@placeholder='Search for atta dal and more']")
		));

//		 3. Clear any placeholder default text, then type and press Enter
//		realSearchInput.clear(); 
//		realSearchInput.sendKeys("paan" + Keys.ENTER);
		
		WebElement paanCigarrette = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'corner cigarette')]")));
//		paanCigarrette.click();
	
	
	
		
		List<WebElement>productTags = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class*='tw-bg-indigo-050']")));
		System.out.println(productTags.size());
		for(int i=0;i<productTags.size();i++) {
//			
			WebElement productDescription = productTags.get(i).findElement(By.cssSelector("[class*='tw-line-clamp-2']"));
			String productText = productDescription.getText();
			System.out.println(productText);
			if(productText.equalsIgnoreCase("Chandan Calcutta Mitha Paan Mouth Freshener")) {
				
				productTags.get(i).findElement(By.xpath(".//div[text()='ADD']")).click();
				break;
			}
		}
//		
		driver.findElement(By.cssSelector("[class*='CartButton__Button']")).click();
	
	
	
		WebElement proceedToCheckout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='CheckoutStrip__AmountContainer-sc-1fzbdhy-17 ilqCAS']")));
		proceedToCheckout.click();
		WebElement loginBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='login-head__text']")));
		String loginText = loginBox.getText();
		System.out.println(loginText);
		
}


}
