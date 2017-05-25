package elements;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShowOnlyCheckBox {
	public static final String CHECKBOX_VALUE = "Sold listings";
	private static final String SOLD_LISTINGS_CHECKBOX_LOCATOR = "//div[@id='LeftNavContainer']//*[contains(text(),'"+CHECKBOX_VALUE+"')]";
	public static final String SOLD_LISTINGS_MESSAGE_ON_ITEM_CARD = "This listing has ended";
	public static final String SOLD_LISTINGS_MESSAGE__ON_ITEM_CARD_2 = "This listing was ended";
	
	private WebDriver driver;
	
	@FindBy(xpath = SOLD_LISTINGS_CHECKBOX_LOCATOR)
	private WebElement showOnlyCheck;
	
	public ShowOnlyCheckBox(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void click() {
		showOnlyCheck.click();
	}
	
}
