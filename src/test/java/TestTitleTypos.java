
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created on 21.11.2016.
 */
public class TestTitleTypos {
	
	private WebDriver driver;
	
	@BeforeClass
	public void setUP() {
		
		
		driver = new ChromeDriver();
		
		
	}
	
	@DataProvider
	public Object[][] dataArray() {
		return new Object[][]{
				{"keybord", "keyboard"},
				{"keybrd", "keyboard"},
				{"kwyboard", "keyboard"},
				{"kkeyboard", "keyboard"},
				{"keibord", "keyboard"},
				{"keyboad", "keyboard"},
			
		};
		
	}
	
	
	@Test(dataProvider = "dataArray")
	public void gget(String typo, String expct) {
		
		driver.get("https://ebay.com/");
		driver.manage().window().maximize();
		
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('gh-eb-Geo-a-en').click();");
		
		
		WebElement element = driver.findElement(By.xpath("//input[@id='gh-ac']"));
		WebElement button = driver.findElement(By.xpath("//input[@id='gh-btn']"));
		button.sendKeys("");
		element.sendKeys(typo);
		button.click();
		
		
		List<WebElement> items = driver.findElements(By.xpath("//*[@id='ListViewInner']/li/h3/a"));
		for (WebElement item : items) {
			
			System.out.println(item.getText().toLowerCase().contains(expct));
		}
		
		
	}
	
	@AfterClass
	public void tearDown() {
//		driver.quit();
		
		
	}
	
}
