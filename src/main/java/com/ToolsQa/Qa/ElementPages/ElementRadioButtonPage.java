package com.ToolsQa.Qa.ElementPages;

import static com.ToolsQa.Qa.Utility.ElementUtil.ClickElement;
import static com.ToolsQa.Qa.Utility.ElementUtil.Element_highlight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ToolsQa.Qa.Utility.ElementUtil;

public class ElementRadioButtonPage {
	WebDriver driver = null;
	// 1. 1. Defining Page Element --> OR Object Repository

	static final By yesradio = By.xpath("//label[@class='custom-control-label' and @for ='yesRadio']");
	static final By impressiveRadio = By.xpath("//label[@class='custom-control-label' and @for ='impressiveRadio']");
	static final By noradio = By.xpath("//label[@class='custom-control-label disabled' and @for ='noRadio']");
	static final By resulttitle = By.xpath("//p[@class='mt-3']");
	static final By resultvalue = By.xpath("//span[@class='text-success']");

	// 2. Initializing Page Object
	public ElementRadioButtonPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3.Actions
	public void RadioClick(String value) {
		switch (value.toLowerCase()) {
		case "yes":
			Element_highlight(driver, yesradio);
			ClickElement(driver, yesradio);
			System.out.println("Yes Radio Clicked");
			break;

		case "no":
			Element_highlight(driver, noradio);
			//ClickElement(driver, noradio); No Radio is not enabled to click
			System.out.println("No Radio cant be click : Disabled ");
			break;

		case "impressive":
			Element_highlight(driver, impressiveRadio);
			ClickElement(driver, impressiveRadio);
			System.out.println("Impressive Radio Clicked");
		}
	}

	public void ResultPrinting() {
		WebElement title = ElementUtil.LocatorToElement(driver, resulttitle);
		String tilev = title.getText();
		System.out.println(tilev);

		WebElement value = ElementUtil.LocatorToElement(driver, resultvalue);
		String val = value.getText();
		System.out.println(val);

	}
}
