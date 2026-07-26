package blinkitPageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import blinkit.AbstractComponents;

public class ShoppingPage extends AbstractComponents{
	
	WebDriver driver;
	WebDriverWait wait;
	List<WebElement> footerLinks;
	public ShoppingPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
//		PageFactory.initElements(driver, this);
		
	}
	
	By sidePanelelements = By.cssSelector("[class*='tw-break-words']");
	
//	@FindBy(css = "[class*='tw-break-words']")
//	List<WebElement> sidePanels;
	
	public List<String> getSidepanelElements() {
		
		List<String> actualElements = new ArrayList<String>();
		waitForAllToAppearBy(wait, sidePanelelements);
		List<WebElement>sidePanelElements = driver.findElements(sidePanelelements);
		System.out.println(sidePanelElements.size());
		
//		sidepanelElements.stream().forEach(s->System.out.println(s.getText()));
//		List<String> panelElementsList = Arrays.asList(panelElements);
		
		for(int i=0;i<sidePanelElements.size();i++) {
			
			String elementText = sidePanelElements.get(i).getText().trim();
			System.out.println("Checking element: " + elementText);
			actualElements.add(elementText);
	}
		return actualElements;
	}

}
