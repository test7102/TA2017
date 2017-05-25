package elements;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class FreeShippingCheckBox {
	public static final String FREESHIPPING = "Free international shipping";
	private static final String FREESHIPPING_LOCATOR = "//div[@id='LeftNavContainer']//span[contains(text(),'" + FREESHIPPING + "')]";
	private static final String ITEMS_FREESHIPPING_LOCATOR = "//div[@id='Results']//span[contains(text(),'"+ FREESHIPPING +"')]";
	private WebDriver driver;
	@FindBy(xpath = FREESHIPPING_LOCATOR)
	private WebElement freeShipingCheck;
	@FindBy(xpath = ITEMS_FREESHIPPING_LOCATOR)
	private List<WebElement> itemsElements;
	private ArrayList<String> elements = new ArrayList();
	
	
	public FreeShippingCheckBox(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void click() {
		freeShipingCheck.click();
	}
	
	public ArrayList<String> getFreeShipingElementsText() {
		for (WebElement itemsElement : itemsElements) {
			elements.add(itemsElement.getText());
		}
		return elements;
	}
	
}
