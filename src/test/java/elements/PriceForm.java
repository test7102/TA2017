package elements;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PriceForm {
	private static final String PRICE_LOW_LOCATOR = "//form[@name='price']/input[@class='price'][1]";
	private static final String PRICE_HIGH_LOCATOR = "//form[@name='price']/input[@class='price'][2]";
	private static final String BUTTON_LOCATOR = "//form[@name='price']/input[@type='submit']";
	private WebDriver driver;
	@FindBy(xpath = PRICE_LOW_LOCATOR)
	private WebElement priceLowField;
	@FindBy(xpath = PRICE_HIGH_LOCATOR)
	private WebElement priceHighField;
	@FindBy(xpath = BUTTON_LOCATOR)
	private WebElement button;
	
	public PriceForm(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void click() {
		button.click();
	}
	
	public void setLowPrice(int value) {
		priceLowField.sendKeys(Integer.toString(value));
	}
	
	public void setHighPrice(int value) {
		priceHighField.sendKeys(Integer.toString(value));
	}
}
