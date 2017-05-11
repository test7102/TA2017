import org.apache.xpath.SourceTree;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created   on 10.05.2017.
 */
public class TestSnippetTitle {
	private WebDriver driver;
	
	@BeforeClass
	public void setUP() {
		
		driver = new ChromeDriver();
		
	}
	
	@Test
	public void gget() throws InterruptedException {
		
		driver.get("https://ebay.com/");
		driver.manage().window().maximize();
		
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('gh-eb-Geo-a-en').click();");
		
		
		WebElement element = driver.findElement(By.xpath("//input[@id='gh-ac']"));
		WebElement button = driver.findElement(By.xpath("//input[@id='gh-btn']"));
		button.sendKeys("");
		element.sendKeys("keyboard");
		button.click();
		jse.executeScript("document.querySelector('[title=\"Buy It Now\"]').click();");
		
		String itemTitleOnSnippet = "";
		String itemTitleOnCard = "";
		
		for (int i = 1; i <= 50; i++) {
			String itemsPath = "//*[@id='ListViewInner']/li[" + Integer.toString(i) + "]/h3/a";
			
			
			WebElement item = driver.findElement(By.xpath(itemsPath));
			itemTitleOnSnippet = item.getText();
			System.out.println(itemTitleOnSnippet);
//			new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(item));
			item.click();
			
			WebElement itemPathOnCard = driver.findElement(By.xpath("//h1[@id='itemTitle']"));
			itemTitleOnCard = itemPathOnCard.getText();
			if (itemTitleOnSnippet.equalsIgnoreCase(itemTitleOnCard)) {
				System.out.println("=" + itemTitleOnCard);
			} else {
				System.err.print("!="+itemTitleOnCard);
			}
			System.out.println(i);
			driver.navigate().back();
			
		}
		
		
	}
	
	
}
