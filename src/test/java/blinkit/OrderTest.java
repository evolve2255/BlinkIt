package blinkit;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import blinkitPageFactory.CheckoutPage;
import blinkitPageFactory.LandingPage;
import blinkitPageFactory.ProductPage;
import blinkitPageFactory.SearchPage;
import blinkitTestComponents.BaseTestsDemo;
import blinkitTestComponents.BlinkitBaseTest;

public class OrderTest extends BaseTestsDemo {
	
	
	WebDriver driver;
	@Test
	public void placeOrder() throws AWTException, InterruptedException, IOException {
		
			landingPage.setLocation(wait);
			
			SearchPage searchPage = landingPage.initiateSearch();
			ProductPage prodPage = searchPage.searchItem();
			CheckoutPage checkoutPage = prodPage.addItemToCart();
			String blinkItText = checkoutPage.checkOut();
			Assert.assertEquals(blinkItText, "India's last minute app");


				
	}

}
