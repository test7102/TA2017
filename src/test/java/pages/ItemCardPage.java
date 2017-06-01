package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ItemCardPage {
	public static final int FIRST_TEN_ITEMS_ONLY = 10;
	private static final String ITEM_CARD_TITLE_LOCATOR = "//h1[@id='itemTitle']";
	private static final String ITEM_CONDITION_LOCATOR = "//div[@id='vi-itm-cond']";
	private static final String ITEM_STATUS_LOCATOR = "//*[@id='msgPanel']";
	private WebDriver driver;
	@FindBy(xpath = ITEM_CARD_TITLE_LOCATOR)
	private WebElement titleOnItemCard;
	@FindBy(xpath = ITEM_CONDITION_LOCATOR)
	private WebElement itemCondition;
	@FindBy(xpath = ITEM_STATUS_LOCATOR)
	private WebElement itemStatus;
	
	
	public ItemCardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getItemCondition() {
		return itemCondition.getText();
	}
	public String getItemStatus() {
		return itemStatus.getText();
	}
	public void navigateToItemPage (String url) {
			driver.get(url);
	}
}
