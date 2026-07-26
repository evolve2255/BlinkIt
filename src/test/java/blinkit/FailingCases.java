package blinkit;

import java.net.http.WebSocket;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import blinkitTestComponents.BlinkitBaseTest;
import blinkitTestComponents.Retry;

public class FailingCases extends BlinkitBaseTest{
	
	@Test(retryAnalyzer = Retry.class)
	public void checkCountOfCategoriesHomePage() throws InterruptedException {
		int categoriesCountExpected = 21;
		landingPage.setLocation(wait);
		int categoriesCountActual = landingPage.getCategoriesCountHomePage(js);
		Assert.assertEquals(categoriesCountActual, categoriesCountExpected );
		
		
	}
	
	@Test(retryAnalyzer = Retry.class)
	public void checkLocation() {
		String expectedLocation = "Kochi";
		landingPage.setLocation(wait);
		String locationSelected = landingPage.getLocation();
		Assert.assertEquals(locationSelected, expectedLocation, "The location selected is not the expected location: ");
	}
	

}
