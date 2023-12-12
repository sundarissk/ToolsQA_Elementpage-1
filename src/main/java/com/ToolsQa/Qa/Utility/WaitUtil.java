package com.ToolsQa.Qa.Utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ToolsQa.Qa.Base.DriverManager;

public class WaitUtil {

	public static void Explicit_wait(WebElement element, int value,WebDriver driver) {
		new WebDriverWait(driver, Duration.ofSeconds(value)).until(ExpectedConditions.elementToBeClickable(element));

	}

	public static void Element_wait_tobeclick(WebElement element, long timeout,WebDriver driver) {
		new WebDriverWait(driver, Duration.ofMinutes(timeout)).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void ElementToBeClick(WebElement element,WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement el = wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
