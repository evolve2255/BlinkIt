package blinkit;

import org.testng.Assert;
import org.testng.annotations.Test;

import blinkitTestComponents.BlinkitBaseTest;
import blinkitTestComponents.Retry;

public class FooterLinksTest extends BlinkitBaseTest{
	
	
	@Test(retryAnalyzer = Retry.class)
	public void checkFooterLinks() throws InterruptedException {
		
		
		landingPage.setLocation(wait);
		int totalLinks = landingPage.clickFooterLinks(action);
		int totalLinksOpened = landingPage.getLinksTitle();
		Assert.assertEquals(totalLinksOpened, totalLinks);
		
		

	}
	
	

}
