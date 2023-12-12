package com.ToolsQa.Qa.MainPages;

import static com.ToolsQa.Qa.Utility.ElementUtil.ClickElement;
import static com.ToolsQa.Qa.Utility.ElementUtil.Element_highlight;
import static com.ToolsQa.Qa.Utility.ElementUtil.LocatorToElement;
import static com.ToolsQa.Qa.Utility.FunctionUtil.getcount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ToolsQa.Qa.ElementPages.ElementCheckBoxPage;
import com.ToolsQa.Qa.ElementPages.ElementRadioButtonPage;
import com.ToolsQa.Qa.ElementPages.ElementTextBoxPages;
import com.ToolsQa.Qa.ElementPages.ElementWebTablePage;
import com.ToolsQa.Qa.Utility.ElementUtil;

public class ToolsQAElementPage {

	WebDriver driver = null;

	// 1. Defining Page Element --> OR Object Repository

	static final By elementdrop = By.xpath("//div[@class='element-group'][1]//div[@class='icon']");
	static final By elementlist = By.xpath("//div[@class='element-group'][1]//li");
	static final By txtbox = By.xpath("//span[text()='Text Box']");
	static final By chkbox = By.xpath("//span[text()='Check Box']");
	static final By radiobtn = By.xpath("//span[text()='Radio Button']");
	static final By webtable = By.xpath("//span[text()='Web Tables']");
	static final By button = By.xpath("//span[text()='Buttons']");
	static final By links = By.xpath("//span[text()='Links']");
	static final By brokenlinks = By.xpath("//span[text()='Broken Links - Images']");
	static final By updownload = By.xpath("//span[text()='Upload and Download']");
	static final By dynamicprop = By.xpath("//span[text()='Dynamic Properties']");

	// 2. Initializing Page Object
	public ToolsQAElementPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3.Actions
	public void ElementDropClick() {
		try {
			Element_highlight(driver, elementdrop);

			WebElement elementdrop1 = LocatorToElement(driver, txtbox);
			boolean isDisplayed = elementdrop1.isDisplayed();

			if (isDisplayed == true)
				System.out.println("Element dropdown already selected");

			else {

				ClickElement(driver, elementdrop);
				System.out.println("Element cliked");
			}

		} catch (Exception e) {
			System.out.println("Error : " + e);
		}

	}

	public int ElementCountCheck() {
		int count = getcount(driver, elementlist);
		return count;
	}

	public ElementTextBoxPages TextBoxClick() {
		try {
			Element_highlight(driver, txtbox);
			ClickElement(driver, txtbox);

		} catch (Exception e) {
			System.out.println("Error : " + e);
		}

		return new ElementTextBoxPages(driver);
	}

	public ElementCheckBoxPage ElementCheckBoxCheck() {
		try {

			Element_highlight(driver, chkbox);
			ClickElement(driver, chkbox);
		} catch (Exception e) {
			System.out.println("Error : " + e);
		}
		return new ElementCheckBoxPage(driver);
	}

	public ElementRadioButtonPage ElementRadioButtonCheck() {
		try {
			Element_highlight(driver, radiobtn);
			ClickElement(driver, radiobtn);
		} catch (Exception e) {
			System.out.println("Error : " + e);
		}
		return new ElementRadioButtonPage(driver);
	}

	public ElementWebTablePage ElementWebTablePageCheck() {
		try {
			ElementUtil.ScrollToView(driver, webtable);
			Element_highlight(driver, webtable);
			ClickElement(driver, webtable);
		} catch (Exception e) {
			System.out.println("Error : " + e);
		}
		return new ElementWebTablePage(driver);
	}

}
