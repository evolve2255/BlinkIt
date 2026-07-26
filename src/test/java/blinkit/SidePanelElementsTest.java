package blinkit;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import blinkitPageFactory.ShoppingPage;
import blinkitTestComponents.BlinkitBaseTest;

public class SidePanelElementsTest extends BlinkitBaseTest {
	String[] panelElements = {"Fresh Vegetables", "Fresh Fruits", "Exotics", "Seasonal", "Trusted Organic", "Leafies & Herbs","Eggs", "Milk" };
	@Test
	public void checkSideElements() {
		
		landingPage.setLocation(wait);
		ShoppingPage shoppingPage = landingPage.goToShopping();
		List<String> actualPanelElements = shoppingPage.getSidepanelElements();
		List<String> ExpectedPanelElementsList = Arrays.asList(panelElements);
		Assert.assertEquals(actualPanelElements, ExpectedPanelElementsList);
	}

}
