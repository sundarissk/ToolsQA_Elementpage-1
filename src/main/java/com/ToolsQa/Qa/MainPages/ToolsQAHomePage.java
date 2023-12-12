package com.ToolsQa.Qa.MainPages;

import static com.ToolsQa.Qa.Utility.ElementUtil.ClickElement;
import static com.ToolsQa.Qa.Utility.ElementUtil.Element_highlight;
import static com.ToolsQa.Qa.Utility.ElementUtil.ScrollToView;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ToolsQAHomePage {

	WebDriver driver;
	// 1. Defining Page Element --> OR Object Repository
	static final By elements = By.xpath("//h5[text()='Elements']");
	static final By forms = By.xpath("//h5[text()='Forms']");
	static final By afw = By.xpath("//h5[text()='Alerts, Frame & Windows']");
	static final By widgets = By.xpath("//h5[text()='Widgets']");
	static final By interactions = By.xpath("//h5[text()='Interactions']");
	static final By bookstoreapp = By.xpath("//h5[text()='Book Store Application']");
	static final By iframeclose = By.xpath("//label[@id='cbb']");

	// 2. Initializing Page Object
	public ToolsQAHomePage(WebDriver driver) {
		this.driver = driver;
	}

	// 3.Actions
	public ToolsQAElementPage ElementsClick() {
		try {
			Element_highlight(driver, elements);
			ScrollToView(driver, elements);
			ClickElement(driver, elements);

		} catch (Exception e) {
			System.out.println("Error : " + e);
		}

		return new ToolsQAElementPage(driver);

	}

	public ToolsQAFormsPage FormsClick() {
		Element_highlight(driver, forms);
		ClickElement(driver, forms);
		return new ToolsQAFormsPage();

	}

	public ToolsQAAlrtFrmWinPage AlrtFrmWinClick() {
		Element_highlight(driver, afw);
		ClickElement(driver, afw);
		return new ToolsQAAlrtFrmWinPage();

	}

	public ToolsQAWidgetsPage WidgetsClick() {
		Element_highlight(driver, widgets);
		ClickElement(driver, widgets);
		return new ToolsQAWidgetsPage();
	}

	public ToolsQAInteractionsPage InteractionsClick() {
		Element_highlight(driver, interactions);
		ClickElement(driver, interactions);
		return new ToolsQAInteractionsPage();

	}

	public ToolsQABookStoreAppPage BookStoreAppClick() {
		Element_highlight(driver, bookstoreapp);
		ClickElement(driver, bookstoreapp);
		return new ToolsQABookStoreAppPage();

	}

	public void IframeCloseClick() {
		Element_highlight(driver, iframeclose);
		ClickElement(driver, iframeclose);

	}

}
