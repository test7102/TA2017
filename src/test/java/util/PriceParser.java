package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PriceParser {
	private static Pattern pattern = Pattern.compile("([0-9]+(?:,[0-9]+)?(?:\\.[0-9]+)?)");
	private static Matcher matcher;
	private static String price;
	
	public static float getFirstPrice(String text) {
		matcher = pattern.matcher(text);
		if (matcher.find()) {
			price = matcher.group().replace(",","");
		}
		return  Float.parseFloat(price);
	}
	public static float getSecondPrice() {
		if (matcher.find()) {
			price = matcher.group().replace(",","");
		}
		return  Float.parseFloat(price);
	}
	
}

