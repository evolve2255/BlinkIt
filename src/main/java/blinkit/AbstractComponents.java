package blinkit;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	
	public void waitForElementsToDissappear(WebDriverWait wait,By obstruction) {
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(obstruction));

	}
	
public void waitForElementsToBeClickable(WebDriverWait wait,WebElement fakeSearchBar) {
		
		wait.until(ExpectedConditions.elementToBeClickable(fakeSearchBar));

	}

public void waitForAllToAppear(WebDriverWait wait, List<WebElement> elements) {
	
	wait.until(ExpectedConditions.visibilityOfAllElements(elements));
}
	
	public void waitForElementToAppear(WebDriverWait wait,WebElement element) {
		
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void waitForAllToAppearBy(WebDriverWait wait, By ele) {
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ele));
	}
	
	
	
	
	
	@FindBy(name = "select-locality")
	WebElement localitySelector;
	@FindBy(xpath = "//div[text()='Chennai']")
	WebElement locationSet;
	By obstruction = By.cssSelector("div[class='LocationDropDown__LocationOverlay-sc-bx29pc-1 bLgtGp']");
	
	
	public void setLocation(WebDriverWait wait) {
		
		localitySelector.sendKeys("600096");
		waitForElementsToBeClickable(wait, locationSet);
		locationSet.click();
		waitForElementsToDissappear(wait, obstruction);
		
	}
	
}


