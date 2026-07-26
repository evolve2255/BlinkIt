package blinkitPageFactory;

import java.awt.Panel;
import java.awt.print.PageFormat;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import blinkit.AbstractComponents;

public class SearchPage extends AbstractComponents{
	
	WebDriver driver;
	WebDriverWait wait;
	public SearchPage(WebDriver driver, WebDriverWait wait) {
		
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@placeholder='Search for atta dal and more']")
	WebElement realSearchBar;
	@FindBy(xpath = "//span[contains(text(),'corner cigarette')]")
	WebElement paanCigarrette;
	
	
	public ProductPage searchItem() {
		
		waitForElementsToBeClickable(wait, realSearchBar);
		realSearchBar.sendKeys("paan" + Keys.ENTER);
		waitForElementsToBeClickable(wait, paanCigarrette);
		paanCigarrette.click();
		
		ProductPage prodPage = new ProductPage(driver, wait);
		return prodPage;
	}

}
