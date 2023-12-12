package com.ToolsQa.Qa.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FunctionUtil {
	public static void switchframesindex(WebDriver driver, int n) {
		driver.switchTo().frame(n);
	}

	public static void switchiframeback(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public static String gettitile(WebDriver driver) {

		return driver.getTitle();

	}

	public static int getcount(WebDriver driver, By locator) {
		int count = driver.findElements(locator).size();
		return count;

	}

	public static String Element_gettext( WebDriver driver, By locator) {
		WebElement ele = driver.findElement(locator);
		return ele.getText();

	}

}
