package blinkit;

import org.testng.Assert;
import org.testng.annotations.Test;

import blinkitTestComponents.BlinkitBaseTest;

public class InputCheckTest extends BlinkitBaseTest{
	int num =98478;
	String text = "love";
	@Test
	public void checkInputValue() throws InterruptedException {
		
		landingPage.setLocation(wait);
		landingPage.clickLogIn();
		String valueFromInputBox = landingPage.checkTheInput(text, num);
		
		String stringOfNum = String.valueOf(num) ;
		
		Assert.assertEquals(valueFromInputBox, stringOfNum);
		
		

	}

}
