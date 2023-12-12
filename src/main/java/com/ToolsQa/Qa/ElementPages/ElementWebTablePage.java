package com.ToolsQa.Qa.ElementPages;

import static com.ToolsQa.Qa.Utility.ElementUtil.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ToolsQa.Qa.Utility.ElementUtil;

/* Senario for WebTable :
 1. Finding no of rows
 2. Finding no of column
 3. Finding cell value for specific row and column
 4. Print all content of the Web table
 5. Print header data
 6. Print particular row value
 7. Print paritcular column value
 8. Retrieve cell value whose "cellvalue is"
 9. Print Last/first/nth row data of the table 
 10. Get maximum of all the values in a column
 11. Get minimum of all the values in a column
 12. Get greater value of given values in a column
 13. Get smaller value of given values in a column
 14. Traverse forward direction depending on particular value
 15. Traverse reverse direction depending on particular value
 16. check whether particular value is presented in row
 17. check whether particular value is presented in column
 18. check whether particular value is presented in table
 19. check/count header size/count
 (Pagination)
 20. Checking to no of pages 
 21. Increase row count in a page and check no of rows can be enter
 22. Decrease row count in a page and check the next page option
 23. Previous page and next page option verification
 
 
 */
public class ElementWebTablePage {
	WebDriver driver = null;
	// 1. Defining Page Element --> OR Object Repository

	static final By add = By.xpath("//button[@id='addNewRecordButton']");
	static final By searchtxt = By.xpath("//input[@id='searchBox']");
	static final By searchbut = By.xpath("//span[@id='basic-addon2']");
	static final By edit = By.xpath("//span[@title='Edit']");
	static final By delete = By.xpath("//span[@title='Delete']");
	static final By wholetable = By.xpath("//div[@class='web-tables-wrapper']");

	// individual header cell value
	static final By header = By.xpath("//div[@role='columnheader']");// get column count
	static final By headervalue = By.xpath("//div[@class='rt-resizable-header-content']");

	// total row count
	static final By rowsinpage = By.xpath("//div[@class='rt-tr-group']");

	static final By rowsentry = By.xpath("//div[@class='rt-tr -even' or @class = 'rt-tr -odd']");

	// Even row entry
	static final By evenrow = By.xpath("//div[@class='rt-tr -even' ]");

	// Odd row entry
	static final By oddrow = By.xpath("//div[@class='rt-tr -odd' ]");

	// row value reading //div[@role='rowgroup'][3]
	static final By rowvalue = By.xpath("//div[@role='rowgroup']");

	// column value reading & add [1] ,[2] to access particular column
	// By.xpath("//div[@class='rt-tr-group'][3] (data)//div[@class='rt-td'][3]
	// (column)
	static final By colvalue = By.xpath("//div[@class='rt-td']");

	// Age colume
	static final By age = By.xpath("//div[@class='rt-tr-group'][3]//div[@class='rt-td'][3]");

	// Last name colume
	static final By lname = By.xpath("//div[@class='rt-tr-group'][1]//div[@class='rt-td'][2]");

	// salary colume
	static final By salary = By.xpath("//div[@class='rt-tr-group'][3]//div[@class='rt-td'][5]");

	// cellData
	static final By celldatainpage = By.xpath("//div[@class='rt-tr -odd' ]//div[@class='rt-td']");

	static final By celldataentry = By
			.xpath("//div[@class='rt-tr -even' or @class = 'rt-tr -odd']//div[@class='rt-td']");
	static final By tdata = By.xpath("//div[@role='rowgroup']//div[@class='rt-td']");

	// nth cellvalue by row and cloumn number
	static final By cellvalue = By.xpath("//div[@class='rt-tr-group'][1]//div[@class='rt-td'][1]");

	// Pagination
	// 1. Total no of page according to no of rows
	static final By totalnoofpage = By.xpath("//span[@class='-totalPages']");

	// 2. Rows per page
	static final By rowsperpage = By.xpath("//select[@aria-label]");

	// 3. Previous Button
	static final By previousbtn = By.xpath("//div[@class='-previous']");

	// 4. Next Button
	static final By nextbtn = By.xpath("//div[@class='-next']");

	// static final By = By.xpath("");

	// 2. Initializing Page Object
	public ElementWebTablePage(WebDriver driver) {
		this.driver = driver;
		// actions = new Actions(driver);
	}

	// 3.Actions

//1. Finding no of rows
	public void NoOfRows() {

		try {
			// Finding rows in that page
			List<WebElement> rowcount = LocatorToElements(driver, rowsinpage);
			System.out.println("Finding total no of rows in that page:  " + rowcount.size());
			Assert.assertEquals(rowcount.size(), 10, " Row Count mismatching");

			// Finding rowsentered in that page
			List<WebElement> RowEnter = LocatorToElements(driver, rowsentry);
			System.out.println("Finding Rows entered in that page:  " + RowEnter.size());
			Assert.assertEquals(RowEnter.size(), 3, " Row Count mismatching");

			System.out.println("***********************************************************");
		} catch (Exception e) {
			System.out.println("Error : " + e);
		}

	}

//2. Finding no of column
	public void NoOfColumnheader() {
		try {
			List<WebElement> colcount = LocatorToElements(driver, header);
			System.out.println("Finding total no of column in that table:  " + colcount.size());
			Assert.assertEquals(colcount.size(), 7, "Columncount not matching");

			System.out.println("***********************************************************");
		} catch (Exception e) {
			System.out.println("Error : " + e);
		}

	}

//3. Finding cell data for specific row and column
	public void SpecificCellValue(int i, int j) {
		try {
			String cellvalue = driver
					.findElement(By.xpath("//div[@role='rowgroup'][" + i + "]//div[@class='rt-td'][" + j + "]"))
					.getText();
			System.out.println("Row: " + i + ", Column: " + j + ", CellValue: " + cellvalue);
			System.out.println("***********************************************************");
		} catch (Exception e) {
			System.out.println("Error : " + e);
		}
	}

//4. Print all content of the Web table
	public void AllContentPrint() {
		try {
			List<WebElement> tabledata = LocatorToElements(driver, celldataentry);
			System.out.println("Data in that Table:");
			for (WebElement ele : tabledata) {

				System.out.println(ele.getText());

			}
			System.out.println("***********************************************************");
		} catch (Exception e) {
			System.out.println("Error : " + e);
		}

	}

//5. Verify particular data present in the table entry
	public void DataVerifyInTable() {
		try {
			List<WebElement> tabledata = LocatorToElements(driver, celldataentry);
			System.out.println("Verify Data Present in Table:");
			boolean dverify = false;
			for (WebElement ele : tabledata) {
				String value = ele.getText();
				if (value.contains("2000")) {
					dverify = true;
					System.out.println(value);
					break;
				}

			}
			Assert.assertTrue(dverify, "Record not found");
			System.out.println("Record is present");
			System.out.println("***********************************************************");
		} catch (Exception e) {
			System.out.println("Error : " + e);
		}

	}

//5. Print header data
	public void PrintHeader() {
		try {
			System.out.println("HeaderValue : ");
			List<WebElement> headvalue = LocatorToElements(driver, headervalue);
			for (WebElement ele : headvalue) {
				System.out.println(ele.getText());
			}
			System.out.println("***********************************************************");
		} catch (Exception e) {
			System.out.println("Error : " + e);
		}

	}

//6. Header value present or not
	public void HeaderValueChecking(String data) {
		try {
			System.out.println("HeaderValueChecking : ");
			List<WebElement> headvalue = LocatorToElements(driver, headervalue);
			boolean status = false;
			for (WebElement ele : headvalue) {
				String value = ele.getText();
				// System.out.println(value); it will print the header value untill it reach the
				// contains value
				if (value.contains(data)) { // checking whether the header has paritcular value
					status = true;
					System.out.println(value);
					break;
				}
				// System.out.println(value);
			}
			Assert.assertTrue(status, "Header is not found");
			System.out.println("HeaderValue is present");
			System.out.println("***********************************************************");
		} catch (Exception e) {
			System.out.println("Error : " + e);
		}

	}
//8. Verify paritcular value is present in table and print column and row number of it is present

	public void ValueRowColNumber(String value) {
		try {
			List<WebElement> colcount = LocatorToElements(driver, header);
			int ccount = colcount.size();

			List<WebElement> RowEnter = LocatorToElements(driver, rowsentry);
			int rcount = RowEnter.size();

			boolean flag = false;
			for (int i = 1; i <= rcount; i++) {
				// System.out.println("Row : " +i);
				for (int j = 1; j < ccount; j++) {
					// System.out.println("Column : " +j);
					String actvalue = driver
							.findElement(
									By.xpath("//div[@role='rowgroup'][" + (i) + "]//div[@class='rt-td'][" + j + "]"))
							.getText();
					if (actvalue.equals(value)) {
						System.out.println(value + ", Row: " + i + ", Column: " + j);
						flag = true;
						break;
					}

				}
			}
			if (flag) {
				System.out.println("Value Found");

			} else
				System.out.println("Value not Found");

			System.out.println("***********************************************************");
		} catch (Exception e) {
			System.out.println("Error : " + e);
		}

	}

//7. Print particular row data
	public void PrintParticularRow(int r) {

		if (r <= 3) {

			List<WebElement> rvalue = driver.findElements(By.xpath("//div[@role='rowgroup'][" + r + "]"));

			System.out.println("Row Enter : " + r);

			for (WebElement ele : rvalue) {
				String rowvalue = ele.getText();

				System.out.println(rowvalue);
				System.out.println("*******************************");
			}
		} else {
			System.out.println("Row Enter doesnt exist, Enter right row number");
		}

	}

//8. Print paritcular column data
	public void PrintParticularColumn(int r) {

		if (r <= 6) {

			List<WebElement> cvalue = driver.findElements(By.xpath("//div[@class='rt-td'][" + r + "]"));
			System.out.println("Row Enter : " + r);
			for (WebElement cele : cvalue) {
				String colvalue = cele.getText();
				System.out.println(colvalue);

			}
			System.out.println("*******************************");
		} else {
			System.out.println("Column Enter doesnt exist, Enter right Column number");

		}

	}

//9. Print Last/first/nth row data of the table
	public void PrintRowValue() {

	}

//10. Get maximum of all the values in a column (Age Comparison) can change cell valuse accordingly
	public void PrintMaxColumn() {

		// Finding rowsentered in that page
		List<WebElement> RowEnter = LocatorToElements(driver, rowsentry);
		int rcount = RowEnter.size();
		System.out.println("Finding Rows entered in that page:  " + rcount);
		Assert.assertEquals(RowEnter.size(), 3, " Row Count mismatching");

		ArrayList<Integer> array = new ArrayList<Integer>();

		for (int i = 1; i <= rcount; i++) {
			String v = driver.findElement(By.xpath("//div[@class='rt-tr-group'][" + i + "]//div[@class='rt-td'][3]"))
					.getText();
			System.out.println(v);
			int iva = Integer.parseInt(v);

			array.add(iva);

		}
		Collections.sort(array);

		// System.out.println("Min value : " + array.get(0));
		System.out.println("Max value : " + array.get(array.size() - 1));
		System.out.println("*******************************");
	}

//11. Get minimum of all the values in a salary column
	public void PrintMinColumn() {
		List<WebElement> RowEnter = LocatorToElements(driver, rowsentry);
		int rcount = RowEnter.size();
		System.out.println("Finding Rows entered in that page:  " + rcount);
		Assert.assertEquals(RowEnter.size(), 3, " Row Count mismatching");

		ArrayList<Integer> array = new ArrayList<Integer>();

		for (int i = 1; i <= rcount; i++) {
			String v = driver.findElement(By.xpath("//div[@class='rt-tr-group'][" + i + "]//div[@class='rt-td'][5]"))
					.getText();
			System.out.println(v);
			int iva = Integer.parseInt(v);

			array.add(iva);

		}
		Collections.sort(array);

		System.out.println("Min value : " + array.get(0));
		// System.out.println("Max value : " + array.get(array.size() - 1));
		System.out.println("*******************************");

	}

//12. Traverse forward direction depending on particular value
	public void TraverseForward() {

	}

//13. Traverse reverse direction depending on particular value
	public void TraverseReverse() {

	}

//14. check whether particular value is presented in row & print row number
	public void ValuePresentRow(int r, String d) {

		System.out.println("Verify Data Present in Particular Row:");
		List<WebElement> RowEnter = driver.findElements(By.xpath("//div[@role='rowgroup'][" + r + "]"));

		System.out.println(" Rows entered:  " + r);
		System.out.println(" Data entered:  " + d);
		boolean flag = false;
		for (WebElement wele : RowEnter) {
			String data = wele.getText();
			if (data.contains(d)) {
				System.out.println("Data Present in the Row " + r + "  " + d);

				System.out.println(data);
				flag = true;
				System.out.println("*******************************");
				break;
			}

			else

				System.out.println("Data or Row entered is not found ");
		}

	}

//15. check whether particular value is presented in column & print column number
	public void ValuePresentColumn(int c, String d) {
		System.out.println("Verify Data Present in Particular Column:");

		List<WebElement> RowEnter = LocatorToElements(driver, rowsentry);
		int rcount = RowEnter.size();
		for (int i = 1; i <= rcount; i++) {
			List<WebElement> colenter = driver
					.findElements(By.xpath("//div[@class='rt-tr-group'][" + i + "] //div[@class='rt-td'][" + c + "]"));
			System.out.println(" Column entered:  " + c);
			System.out.println(" Data entered:  " + d);
			boolean flag = false;
			for (WebElement cele : colenter) {
				String cdata = cele.getText();
				System.out.println(cdata);
				if (cdata.contains(d)) {
					System.out.println("Data present in Column " + c + "  " + d);
					// System.out.println(cdata);
					System.out.println("*******************************");
					flag = true;
					break;
				} else
					System.out.println("Data or Column entered is not found");
			}
		}
	}

// 16. Print even row data in table
	public void PrintEvenRowData() {

	}

// 17. Print Odd row data in table
	public void PrintOddRowData() {

	}
}
