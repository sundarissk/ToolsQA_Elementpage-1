package com.ToolsQa.Qa.ElementPages;

import static com.ToolsQa.Qa.Utility.ElementUtil.ClickElement;
import static com.ToolsQa.Qa.Utility.ElementUtil.Element_highlight;
import static com.ToolsQa.Qa.Utility.ElementUtil.ScrollToView;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ToolsQa.Qa.Utility.ElementUtil;

/*

checkbox:
1. Locate : identified by --> ID,Xpath,CSS selector
2. Validate : isSelected(), isDisplayed(), isEnabled

*/
public class ElementCheckBoxPage {

	WebDriver driver = null;

	// 1. 1. Defining Page Element --> OR Object Repository

	static final By plus = By.xpath("//button[@title='Expand all']");
	static final By minus = By.xpath("//button[@title='Collapse all']");

	static final By homebchk = By.xpath("//label[@for ='tree-node-home']//span[@class='rct-checkbox']");
	static final By homeminuscheck = By
			.xpath("//label[@for ='tree-node-home']//*[local-name()='svg' and @class ='rct-icon rct-icon-half-check']");
	static final By homefullcheck = By
			.xpath("//label[@for ='tree-node-home']//*[local-name()='svg' and @class ='rct-icon rct-icon-check']");

	static final By desktop = By.xpath("//label[@for ='tree-node-desktop']//span[@class='rct-checkbox']");

	static final By dsknotes = By.xpath("//label[@for ='tree-node-notes']//span[@class='rct-checkbox']");

	static final By dskcommands = By.xpath("//label[@for ='tree-node-commands']//span[@class='rct-checkbox']");

	static final By document = By.xpath("//label[@for ='tree-node-documents']//span[@class='rct-checkbox']");

	static final By docworkspace = By.xpath("//label[@for ='tree-node-workspace']//span[@class='rct-checkbox']");

	static final By react = By.xpath("//label[@for ='tree-node-react']//span[@class='rct-checkbox']");

	static final By angular = By.xpath("//label[@for ='tree-node-angular']//span[@class='rct-checkbox']");

	static final By veu = By.xpath("//label[@for='tree-node-veu']//span[@class='rct-checkbox']");

	static final By docoffice = By.xpath("//label[@for='tree-node-office']//span[@class='rct-checkbox']");

	static final By publicclick = By.xpath("//label[@for='tree-node-public']//span[@class='rct-checkbox']");

	static final By privateclick = By.xpath("//label[@for ='tree-node-private']//span[@class='rct-checkbox']");

	static final By classified = By.xpath("//label[@for ='tree-node-classified']//span[@class='rct-checkbox']");

	static final By general = By.xpath("//label[@for ='tree-node-general']//span[@class='rct-checkbox']");

	static final By download = By.xpath("//label[@for ='tree-node-downloads']//span[@class='rct-checkbox']");

	static final By dwnworkfile = By.xpath("//label[@for ='tree-node-wordFile']//span[@class='rct-checkbox']");

	static final By dwnexcelfile = By.xpath("//label[@for ='tree-node-excelFile']//span[@class='rct-checkbox']");

	static final By result = By.xpath("//div[@id='result']//span");
	

	// 2. Initializing Page Object
	public ElementCheckBoxPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3.Actions

	public void PlusClick() {
		try {
			Element_highlight(driver, plus);
			ClickElement(driver, plus);
			System.out.println(" Plus Clicked ");
		} catch (Exception e) {
			System.out.println(" Error :" + e);
		}
	}

	public void MinusClick() {
		try {
			Element_highlight(driver, minus);
			ClickElement(driver, minus);
			System.out.println(" Minus Clicked ");
		} catch (Exception e) {
			System.out.println(" Error :" + e);
		}

	}

	public void HomeClick() {
		Element_highlight(driver, homebchk);
		ClickElement(driver, homebchk);
		System.out.println(" Home Clicked ");
	}

	public void DesktopClickCheck(String value) {

		switch (value.toLowerCase()) {
		case "desktop":
			Element_highlight(driver, desktop);
			ClickElement(driver, desktop);
			System.out.println(" Desktop Clicked ");
			break;

		case "notes":
			Element_highlight(driver, dsknotes);
			ClickElement(driver, dsknotes);
			System.out.println(" Desktop-Notes Clicked ");
			break;

		case "commands":
			Element_highlight(driver, dskcommands);
			ClickElement(driver, dskcommands);
			System.out.println(" Desktop-Comments Clicked ");
			break;

		}

	}

	public void DocumentsClick(String value) {
		switch (value.toLowerCase()) {
		case "documents":
			Element_highlight(driver, document);
			ClickElement(driver, document);
			System.out.println(" Documents Clicked ");
			break;

		case "workspace":
			Element_highlight(driver, docworkspace);
			ClickElement(driver, docworkspace);
			System.out.println(" Documents-WorkSpace Clicked ");
			break;

		case "react":
			Element_highlight(driver, react);
			ClickElement(driver, react);
			System.out.println(" Documents-WorkSpace-React Clicked ");
			break;

		case "angular":
			Element_highlight(driver, angular);
			ClickElement(driver, angular);
			System.out.println(" Documents-WorkSpace-Angular Clicked ");
			break;

		case "veu":
			Element_highlight(driver, veu);
			ClickElement(driver, veu);
			System.out.println(" Documents-WorkSpace-Ven Clicked ");
			break;

		case "office":
			Element_highlight(driver, docoffice);
			ClickElement(driver, docoffice);
			System.out.println(" Documents-Office Clicked ");
			break;

		case "public":
			Element_highlight(driver, publicclick);
			ClickElement(driver, publicclick);
			System.out.println(" Documents-Office-Public Clicked ");
			break;

		case "private":
			Element_highlight(driver, privateclick);
			ClickElement(driver, privateclick);
			System.out.println(" Documents-Office-Private Clicked ");
			break;

		case "classified":
			Element_highlight(driver, classified);
			ClickElement(driver, classified);
			System.out.println(" Documents-Office-Classified Clicked ");
			break;

		case "general":
			Element_highlight(driver, general);
			ClickElement(driver, general);
			System.out.println(" Documents-Office-General Clicked ");
			break;

		}

	}

	public void DownloadsClick(String val) {
		switch (val.toLowerCase()) {
		case "download":
			Element_highlight(driver, download);
			ClickElement(driver, download);
			System.out.println(" Download Clicked ");
			break;

		case "workfile":
			ScrollToView(driver, dwnworkfile);
			Element_highlight(driver, dwnworkfile);
			ClickElement(driver, dwnworkfile);
			System.out.println(" Download-WorkFile Clicked ");
			break;

		case "excelfile":
			ScrollToView(driver, dwnexcelfile);
			Element_highlight(driver, dwnexcelfile);
			ClickElement(driver, dwnexcelfile);
			System.out.println(" Download-ExcelFile Clicked ");
			break;
		}

	}

	public void ResultPrinting() {
		List<WebElement> rest = ElementUtil.LocatorToElements(driver, result);
		int count = rest.size();
		System.out.println(count);
		for (int i = 0; i < count; i++) {
			String v = rest.get(i).getText();
			System.out.println(v);
		}

	}
}
