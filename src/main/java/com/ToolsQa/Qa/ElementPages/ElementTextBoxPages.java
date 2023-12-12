package com.ToolsQa.Qa.ElementPages;

import static com.ToolsQa.Qa.Utility.ElementUtil.ClickElement;
import static com.ToolsQa.Qa.Utility.ElementUtil.Element_highlight;
import static com.ToolsQa.Qa.Utility.ElementUtil.SendKeys;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.ToolsQa.Qa.Utility.ElementUtil;

public class ElementTextBoxPages {

	/*
	 * Actions class help in automating and simulating the Keyboard and Mouse
	 * actions. Actions. KeyDown,KeyUp,SendKeys
	 * 
	 * Select the Current Address using CTRL + A actions.keyDown(Keys.CONTROL);
	 * actions.sendKeys("a"); actions.keyUp(Keys.CONTROL);
	 * actions.build().perform();
	 * 
	 * above code can also be written as below
	 * 
	 * handle contiguous Keyboard Actions using Actions Class Select the Current
	 * Address
	 * actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().
	 * perform();
	 */
	WebDriver driver = null;
	Actions actions;

	// 1. Defining Page Element --> OR Object Repository
	static final By fullname = By.xpath("//input[@id='userName']");
	static final By email = By.xpath("//input[@id='userEmail']");
	static final By caddress = By.xpath("//textarea[@id='currentAddress']");
	static final By paddress = By.xpath("//textarea[@id='permanentAddress']");
	static final By submit = By.xpath("//button[@id='submit']");
	static final By outputname = By.xpath("//p[@id='name']");
	static final By outputemail = By.xpath("//p[@id='email']");
	static final By outputcaddress = By.xpath("//p[@id='currentAddress']");
	static final By outputpaddress = By.xpath("//p[@id='permanentAddress']");

	// 2. Initializing Page Object
	public ElementTextBoxPages(WebDriver driver) {
			this.driver = driver;
			actions = new Actions(driver);
		}

	// 3.Actions
	public void Enternameclick() {
		Element_highlight(driver, fullname);
		SendKeys(driver, fullname, "Sun");
	}

	public void Enteremailclick() {
		Element_highlight(driver, email);
		SendKeys(driver, email, "Sun@gmail.com");
	}

	public void Entercaddressclick() {
		Element_highlight(driver, caddress);
		SendKeys(driver, caddress, "12345, capital city, Delhi, TN");
	}

	public void Enterpaddressclick() {
		// Select the Current Address
		actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();

		// Copy the Current Address
		actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();

		// Press the TAB Key to Switch Focus to Permanent Address
		actions.sendKeys(Keys.TAB).build().perform();

		// Paste the Address in the Permanent Address field
		actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

		Element_highlight(driver, paddress);

	}

	public void submitclick() {
		try {
			ElementUtil.ScrollToView(driver, submit);
			Element_highlight(driver, submit);
			ClickElement(driver, submit);

		} catch (Exception e) {
			System.out.println("Error in submitclick :" + e);
		}

	}

	public void outputdetails() {
		try {
			WebElement opname = ElementUtil.LocatorToElement(driver, outputname);
			WebElement opemail = ElementUtil.LocatorToElement(driver, outputemail);
			WebElement opcadd = ElementUtil.LocatorToElement(driver, outputcaddress);
			WebElement oppadd = ElementUtil.LocatorToElement(driver, outputpaddress);
			String name = opname.getText();
			String email = opemail.getText();
			String cdd = opcadd.getText();
			String pdd = oppadd.getText();

			System.out.println("Details Enter in the TextBox:");
			System.out.println(name);
			System.out.println(email);
			System.out.println(cdd);
			System.out.println(pdd);
		} catch (Exception e) {
			System.out.println("Error in outputdetails :" + e);
		}

	}

}
