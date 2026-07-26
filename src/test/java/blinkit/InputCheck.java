package blinkit;

import java.awt.Robot;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InputCheck {

	
	@Test
	public void checkInput() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		String text = "textinput";
		int num = 98478;
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://blinkit.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("select-locality")).sendKeys("600096");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Chennai']")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class='LocationDropDown__LocationOverlay-sc-bx29pc-1 bLgtGp']")));

		driver.findElement(By.cssSelector("[class*='ProfileButton__Text']")).click();
		
		driver.findElement(By.cssSelector("input[placeholder='Enter mobile number'] ")).sendKeys(text + num);
		Thread.sleep(2000);
		String InputText = driver.findElement(By.cssSelector("input[placeholder='Enter mobile number'] ")).getAttribute("value");
		String stringOfNum = String.valueOf(num) ;
		
		System.out.println(InputText);
		Assert.assertEquals(InputText, stringOfNum);
	}
}
