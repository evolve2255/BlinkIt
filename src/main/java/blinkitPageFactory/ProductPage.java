package blinkitPageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import blinkit.AbstractComponents;

public class ProductPage extends AbstractComponents {
	
	WebDriver driver;
	WebDriverWait wait;
	public ProductPage(WebDriver driver, WebDriverWait wait) {
		
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css = "[class*='tw-bg-indigo-050']")
	List<WebElement> productTags;
	
	By productDescriptions = By.cssSelector("[class*='tw-line-clamp-2']");
	By addButton = By.xpath(".//div[text()='ADD']");
	
	@FindBy(css = "[class*='CartButton__Button']")
	WebElement cartButton;
	
	public CheckoutPage addItemToCart() {
		waitForAllToAppear(wait, productTags);
		
		System.out.println(productTags.size());
		for(int i=0;i<productTags.size();i++) {
			
			WebElement productDescription = productTags.get(i).findElement(productDescriptions);
			String productText = productDescription.getText();
			System.out.println(productText);
			if(productText.equalsIgnoreCase("Chandan Calcutta Mitha Paan Mouth Freshener")) {
				
				productTags.get(i).findElement(addButton).click();
				break;
			}
		}
		
		cartButton.click();
		CheckoutPage checkoutPage = new CheckoutPage(driver, wait);
		return checkoutPage;
	}

}
