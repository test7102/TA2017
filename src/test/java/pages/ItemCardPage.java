package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.util.ArrayList;


public class ItemCardPage {
	WebDriver driver;
	private static final String ITEM_CARD_TITLE_LOCATOR = "//h1[@id='itemTitle']";
	@FindBy(xpath = ITEM_CARD_TITLE_LOCATOR)
	private WebElement titleOnItemCard;
	public void checkTitlesOnCards (ArrayList<String> titles,ArrayList<String> titlesLinks) {
			
		String titleTextOnSnippet;
		String titleTextOnItemCard;
		for (int i = 0; i < titles.size() ; i++) {
			driver.get(titlesLinks.get(i));
			titleTextOnSnippet = titles.get(i);
			titleTextOnItemCard = titleOnItemCard.getText();
			System.out.println("Snippet title: " + titleTextOnSnippet+"\n On card: "+titleTextOnItemCard);
			Assert.assertTrue(titleTextOnSnippet.contains(titleTextOnItemCard));
		}
		
	}
	
	public ItemCardPage(WebDriver driver) {
		this.driver = driver;
	}
}
