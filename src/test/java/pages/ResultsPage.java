package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ResultsPage {
	private WebDriver driver;
	private static final String RESUlTS_LOCATOR = "//*[@id='Results']//li/h3/a";
	private static final String BUYITNOW_LOCATOR = "//a[@title='Buy It Now']";
	private static final String PRICE_LOCATOR = "//li[@class='lvprice prc']/span";
	
	
	@FindBy(xpath = RESUlTS_LOCATOR)
	private List<WebElement> itemsTitlesOnSnippets;
	@FindBy(xpath = BUYITNOW_LOCATOR)
	private WebElement buyitNowButton;
	@FindBy(xpath = PRICE_LOCATOR)
	private List<WebElement> itemsPrices;
	
	public ResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnBuyitnow () {
		if (buyitNowButton.isDisplayed())
		buyitNowButton.click();
	}
	
	/**
	 * Collects items titles on result page.
	 * @return Arraylist of result set item titles.
	 */
	public ArrayList<String> getItemsTitles() {
		ArrayList<String> titles = new ArrayList<String>(50);
		for (WebElement itemTitlesOnSnippet : itemsTitlesOnSnippets) {
			titles.add(itemTitlesOnSnippet.getText());
		}
		return titles;
	}
	
	/**
	 * Collects items links.
	 * @return Arraylist of result set items links.
	 */
	public ArrayList<String> getItemsLinks() {
		ArrayList<String> titlesLinks = new ArrayList<String>(50);
		for (WebElement itemTitlesOnSnippet : itemsTitlesOnSnippets) {
			titlesLinks.add(itemTitlesOnSnippet.getAttribute("href"));
		}
		return titlesLinks;
	}
	
	/**
	 * Collects items prices.
	 * @return Arraylist of result set item prices.
	 */
	public ArrayList<String> getItemsPrices() {
		ArrayList<String> prices = new ArrayList<String>(50);
		for (WebElement itemPrice : itemsPrices) {
			prices.add(itemPrice.getText());
		}
		return prices;
	}
}
