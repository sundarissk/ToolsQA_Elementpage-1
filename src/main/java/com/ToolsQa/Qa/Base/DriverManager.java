package com.ToolsQa.Qa.Base;


import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager extends ConfigInit {
	public static WebDriver driver;

	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

	public WebDriver SetUpBrowser() {
		String browsername = prop.getProperty("browser");
		if (browsername.equalsIgnoreCase("chrome")) {
			//WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			driver = new ChromeDriver();

		} /*else if (browsername.equalsIgnoreCase("FF")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browsername.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("No Browser value is given");

		}*/
		return getDriver();
	}

	public void SetUpURL() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		driver.get(prop.getProperty("url"));

	}

	public synchronized static WebDriver getDriver() {
		return tdriver.get();
	}

	public String getbroswername() {
		Capabilities browserCap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = browserCap.getBrowserName();
		return browserName;

	}
	public void ClosingDown() {
		driver.close();
		driver.quit();
	}

}
