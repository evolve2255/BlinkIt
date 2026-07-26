package blinkitPageFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import blinkit.AbstractComponents;

public class LandingPage extends AbstractComponents {
	
	WebDriver driver;
	WebDriverWait wait;
	List<WebElement> footerLinks;
	public LandingPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="select-locality")
	WebElement localitySelector;
	@FindBy(xpath="//div[text()='Chennai']")
	WebElement chennaiSelector;

	@FindBy(className="SearchBar__PlaceholderContainer-sc-16lps2d-0")
	WebElement fakeSearchBar;
	
	By obstruction = By.cssSelector("div[class='LocationDropDown__LocationOverlay-sc-bx29pc-1 bLgtGp']");

	@FindBy(xpath = "//div[text()='Useful Links']/following-sibling::ul")
	WebElement footerLinksBox;
	
	By links = By.tagName("a"); 
	
	@FindBy(css = "[class*='ProfileButton__Text']")
	WebElement logInButton;
	
	@FindBy(css = "input[placeholder='Enter mobile number']")
	WebElement searchField;
	
	@FindBy(css = "input[placeholder='Enter mobile number']")
	WebElement textInTheField;
	
	@FindBy(css = "div[class='widgets__WidgetContainer-sc-1aj45no-1 cWxNgU']")
	WebElement shopNowButton;
	
	@FindBy(xpath = "//div[@class='MultiImage__Grid-sc-o0ozdb-2 fazwpN']")
	WebElement outerBox;
	
	By categoryElements = By.xpath(".//img");
	
	@FindBy(css = "[class*='LocationBar__Subtitle-sc-x8ezho-10']")
	WebElement location;
	
	
	public SearchPage initiateSearch() {
		
		waitForElementsToBeClickable(wait,fakeSearchBar);
		fakeSearchBar.click();
		SearchPage searchPage = new SearchPage(driver, wait);
		return searchPage;

	}
	
	public void goTo() {
		
		driver.get("https://blinkit.com/");
		driver.manage().window().maximize();
	}
	
	public int clickFooterLinks(Actions action) throws InterruptedException {
		
		footerLinks =  footerLinksBox.findElements(links);
System.out.println(footerLinks.size());
		
		for(int i = 0; i<footerLinks.size();i++) {
			
			action.keyDown(Keys.CONTROL)
		       .click(footerLinks.get(i))
		       .keyUp(Keys.CONTROL)
		       .build()
		       .perform();
			Thread.sleep(1000);
		}
		
		return footerLinks.size();
		
	}
	
	public int getLinksTitle() {
		
		
		Set<String> handles =  driver.getWindowHandles();
		Iterator<String> iter = handles.iterator();
		String parentId = iter.next();
		
		for(int i =0; i<footerLinks.size();i++) {
			
		if(iter.hasNext())	{
			
		String childId = iter.next();
		driver.switchTo().window(childId);
		System.out.println("Title is "+driver.getTitle());
		
		}
		
		}
		
		int totalWindows = handles.size();
		int childWindows = totalWindows-1;
		return childWindows;
	}

	public void clickLogIn() {
		
		logInButton.click();
	}
	
	public String checkTheInput(String text, int num) throws InterruptedException {
		
		searchField.sendKeys(text+num);
		Thread.sleep(2000);
		String InputText = textInTheField.getAttribute("value");
		
		return InputText;
		
	}
	
	public ShoppingPage goToShopping() {
		
		waitForElementsToBeClickable(wait, shopNowButton);
		shopNowButton.click();
		ShoppingPage shoppingPage = new ShoppingPage(driver, wait);
		return shoppingPage;
		
	}
	
	public int getCategoriesCountHomePage(JavascriptExecutor js) throws InterruptedException {
		
		waitForElementToAppear(wait, outerBox);
		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", outerBox);
		Thread.sleep(2000);
		List<WebElement> categoriesActual = outerBox.findElements(categoryElements);
		return categoriesActual.size();
	}
	
	public String getLocation() {
		
		waitForElementToAppear(wait, location);
		String loactionSelected = location.getText();
		String[]locationText = loactionSelected.split(",");
		String actualLocation = locationText[0].trim();
		System.out.println(actualLocation);
		return actualLocation;
	}

}
