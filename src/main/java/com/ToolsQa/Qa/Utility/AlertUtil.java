package com.ToolsQa.Qa.Utility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ToolsQa.Qa.Base.DriverManager;

public class AlertUtil extends DriverManager {

	// only can press ok button
	public static void simple_alert(WebElement element) {
		try {
			// Click the link to activate the alert
			element.click();

			// Wait for the alert to be displayed and store it in a variable
			Alert alert = driver.switchTo().alert();

			// Store the alert text in a variable
			String text = alert.getText();

			System.out.println("Alert text is " + text);

			System.out.println(text);

			// Press the OK button
			alert.accept();
			System.out.println("Unexpected alert accepted");

		} catch (Exception e) {
			System.out.println("unexpected alert not present");
		}

	}

	// Confirm Alert box where user can do either of the action-Accept or Dismiss
	public static void confirm_alert(WebElement element, String action) {

		try {
			// Click the link to activate the alert
			element.click();

			// Store the alert in a variable
			Alert alert = driver.switchTo().alert();

			// Store the alert in a variable for reuse
			String text = alert.getText();

			System.out.println("Alert text is " + text);

			switch (action) {
			case "ok":
				// Press the OK button
				alert.accept();
				System.out.println("Unexpected alert accepted");
				break;
			case "cancel":
				// Press the Cancel button
				alert.dismiss();
				System.out.println("Unexpected alert accepted");
				break;
			}

		} catch (Exception e) {
			System.out.println("unexpected alert not present");
		}
	}

	// only can press ok button : alert appear after particular seconds after clicking the element
	public static void appear_after_seconds_alert(WebElement element, int sec) {

		try {
			// Click the link to activate the alert
			element.click();

			// wait for the seconds for alert display
			WebDriverWait wait = new WebDriverWait(driver, sec);
			wait.until(ExpectedConditions.alertIsPresent());

			// Store the alert in a variable
			Alert alert = driver.switchTo().alert();

			// Store the alert in a variable for reuse
			String text = alert.getText();

			System.out.println("Alert text is " + text);

			// Press the Cancel button
			alert.accept();
			System.out.println("Unexpected alert accepted");

		} catch (Exception e) {
			System.out.println("unexpected alert not present");
		}

	}

	// Prompt Alert box where user will enter the text and can cancel or ok action
	public static void prompt_alert(WebElement element, String text, String action) {
		try {
			// Click the link to activate the alert
			element.click();

			// Store the alert in a variable
			Alert promptAlert = driver.switchTo().alert();

			// Store the alert in a variable for reuse
			String alertText = promptAlert.getText();

			System.out.println("Alert text is " + alertText);
			switch (action) {
			case "ok":
				// Send some text to the alert
				promptAlert.sendKeys(text);

				// Press the OK button
				promptAlert.accept();
				System.out.println("Unexpected alert accepted");
				break;
			case "cancel":
				// Press the Cancel button
				promptAlert.dismiss();
				System.out.println("Unexpected alert accepted");
				break;
			}

		} catch (Exception e) {
			System.out.println("unexpected alert not present");
		}

	}

}
