package blinkitPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import blinkit.AbstractComponents;

public class CheckoutPage extends AbstractComponents {
	
	WebDriver driver;
	WebDriverWait wait;
	public CheckoutPage(WebDriver driver, WebDriverWait wait) {
		
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath = "//div[@class='CheckoutStrip__AmountContainer-sc-1fzbdhy-17 ilqCAS']")
	WebElement proceedToCheckOut;
	
	@FindBy(xpath = "//div[@class='login-head__text']")
	WebElement loginBox;
	
	public String checkOut() {
		
		waitForElementToAppear(wait, proceedToCheckOut);
		proceedToCheckOut.click();
		waitForElementToAppear(wait, loginBox);
		String loginText = loginBox.getText();
		System.out.println(loginText);
		return loginText;
		
		
	}

}
