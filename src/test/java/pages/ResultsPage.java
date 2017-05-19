package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class ResultsPage {
	WebDriver driver;
	private static final String RESUlTS_LOCATOR = "//*[@id='Results']//li/h3/a";
	public static final int FIRST_TEN_ITEMS = 10;
	@FindBy(xpath = RESUlTS_LOCATOR)
	private List<WebElement> itemsTitlesOnSnippets;
	
	ArrayList<String> titles = new ArrayList();
	ArrayList<String> titlesLinks = new ArrayList();
	
	public ResultsPage(WebDriver driver) {
		this.driver = driver;
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('gh-eb-Geo-a-en').click();");
		jse.executeScript("document.querySelector('[title=\"Buy It Now\"]').click();");
	}
	
	public ArrayList<String> getItemsTitles() {
		for (int i = 0; i <FIRST_TEN_ITEMS ; i++) {
			titles.add(itemsTitlesOnSnippets.get(i).getText());
		}
		return titles;
	}
	public ArrayList<String> getItemsLinks() {
		for (int i = 0; i < FIRST_TEN_ITEMS; i++) {
			titlesLinks.add(itemsTitlesOnSnippets.get(i).getAttribute("href"));
		}
		return titlesLinks;
	}
}
