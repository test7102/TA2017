package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	private WebDriver driver;
	private static final String SEARCH_FIELD_LOCATOR = "//input[@id='gh-ac']";
	private static final String SEARCH_BUTTON_LOCATOR = "//input[@id='gh-btn']";
	private static final String ENGLISH_LOCATOR = "//*[@id='gh-eb-Geo-a-default']";
	
	@FindBy(xpath = SEARCH_FIELD_LOCATOR)
	private WebElement searchField;
	@FindBy(xpath = SEARCH_BUTTON_LOCATOR)
	private WebElement button;
	@FindBy(xpath = ENGLISH_LOCATOR)
	private WebElement language;
	
	public void search(String text) {
		searchField.clear();
		button.sendKeys("");
		searchField.sendKeys(text);
		button.click();
	}
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Method uses JavascriptExecutor to switch language to english
	 */
	public void setLanguageToEnglish () {
			if (!language.getText().contains("English")) {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("document.getElementById('gh-eb-Geo-a-en').click();");
			}
	}
}
